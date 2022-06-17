package com.barion.the_witcher.world.gen.structure;

import com.barion.the_witcher.util.TWUtil;
import com.barion.the_witcher.world.gen.TWStructures;
import com.barion.the_witcher.world.gen.util.DETerrainAnalyzer;
import com.barion.the_witcher.world.gen.util.TWProcessors;
import com.barion.the_witcher.world.gen.util.TWStructurePiece;
import com.legacy.structure_gel.api.structure.GelStructure;
import com.legacy.structure_gel.api.structure.GelTemplateStructurePiece;
import com.legacy.structure_gel.api.structure.processor.RemoveGelStructureProcessor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.pieces.PieceGenerator;
import net.minecraft.world.level.levelgen.structure.pieces.PieceGeneratorSupplier;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePiecesBuilder;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Random;

import static com.barion.the_witcher.util.TWUtil.pieceBuilder;

public class TWIcyRuinStructure extends GelStructure<NoneFeatureConfiguration> {

    public TWIcyRuinStructure() {
        super(NoneFeatureConfiguration.CODEC, PieceGeneratorSupplier.simple(TWIcyRuinStructure::checkLocation, TWIcyRuinStructure::generatePieces));
    }

    private static void generatePieces(StructurePiecesBuilder piecesBuilder, PieceGenerator.Context<NoneFeatureConfiguration> context) {
        int x = context.chunkPos().getMinBlockX();
        int z = context.chunkPos().getMinBlockZ();
        int y = context.chunkGenerator().getBaseHeight(x, z, Heightmap.Types.WORLD_SURFACE_WG, context.heightAccessor());

        piecesBuilder.addPiece(new Piece(context.structureManager(), TWUtil.getRandomPiece(Piece.StructureFiles, Piece.maxWeight, context.random()), new BlockPos(x, y, z), context.random()));
    }

    private static boolean checkLocation(PieceGeneratorSupplier.Context<? extends FeatureConfiguration> context){
        if(context.validBiomeOnTop(Heightmap.Types.WORLD_SURFACE_WG)){
            return DETerrainAnalyzer.isFlatEnough(context.chunkPos(), context.chunkGenerator(), context.heightAccessor());
        }

        return false;
    }

    public static class Piece extends GelTemplateStructurePiece {
        private static final TWStructurePiece[] StructureFiles = pieceBuilder().offset(-5, 0, -4).add("icy_ruin/small").offset(-7, -4, -6).add("icy_ruin/big").offset(-4, -4, -7).add("icy_tower").build(); //new ResourceLocation[] {TWUtil.location("icy_ruin/small"), TWUtil.location("icy_ruin/small"), TWUtil.location("icy_tower")};
        private static final int maxWeight = TWUtil.getMaxWeight(StructureFiles);
        public Piece(StructureManager structureManager, TWStructurePiece piece, BlockPos pos, Random random){
            super(TWStructures.IcyRuin.getPieceType(), 0, structureManager, piece.Resource, pos.offset(piece.Offset));
            rotation = Rotation.getRandom(random);
            setupPlaceSettings(structureManager);
        }

        public Piece(StructurePieceSerializationContext context, CompoundTag nbt){
            super(TWStructures.IcyRuin.getPieceType(), nbt, context.structureManager());
            setupPlaceSettings(context.structureManager());
        }

        @Override
        protected StructurePlaceSettings getPlaceSettings(StructureManager structureManager) {
            Vec3i size = structureManager.get(this.makeTemplateLocation()).get().getSize();
            BlockPos pivot = new BlockPos(size.getX() / 2, 0, size.getZ() / 2);
            StructurePlaceSettings settings = new StructurePlaceSettings().setKeepLiquids(false).setRotationPivot(pivot);
            settings.addProcessor(BlockIgnoreProcessor.STRUCTURE_AND_AIR).addProcessor(RemoveGelStructureProcessor.INSTANCE);
            settings.addProcessor(TWProcessors.CobbleFrostedStoneBricks)
                    .addProcessor(TWProcessors.CrackFrostedStoneBricks)
                    .addProcessor(TWProcessors.CrackFrostedStoneBrickStairs)
                    .addProcessor(TWProcessors.CrackFrostedStoneBrickSlab)
                    .addProcessor(TWProcessors.CrackFrostedStoneBrickWall);
            return settings;
        }

        @Override @ParametersAreNonnullByDefault
        protected void handleDataMarker(String key, BlockPos pos, ServerLevelAccessor level, Random random, BoundingBox box) {}
    }

    @Override
    public int getSpacing() {return 27;}
    @Override
    public int getOffset() {return getSpacing()/2;}
}