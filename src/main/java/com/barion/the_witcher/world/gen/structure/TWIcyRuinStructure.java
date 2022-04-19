package com.barion.the_witcher.world.gen.structure;

import com.barion.the_witcher.util.TWUtil;
import com.barion.the_witcher.world.gen.TWStructures;
import com.barion.the_witcher.world.gen.util.DETerrainAnalyzer;
import com.barion.the_witcher.world.gen.util.TWProcessors;
import com.legacy.structure_gel.api.structure.GelStructure;
import com.legacy.structure_gel.api.structure.GelTemplateStructurePiece;
import com.legacy.structure_gel.api.structure.processor.RemoveGelStructureProcessor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
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

public class TWIcyRuinStructure extends GelStructure<NoneFeatureConfiguration> {

    public TWIcyRuinStructure() {
        super(NoneFeatureConfiguration.CODEC, PieceGeneratorSupplier.simple(TWIcyRuinStructure::checkLocation, TWIcyRuinStructure::generatePieces));
    }

    private static void generatePieces(StructurePiecesBuilder piecesBuilder, PieceGenerator.Context<NoneFeatureConfiguration> context) {
        int x = context.chunkPos().getMinBlockX();
        int z = context.chunkPos().getMinBlockZ();
        int y = context.chunkGenerator().getBaseHeight(x, z, Heightmap.Types.WORLD_SURFACE_WG, context.heightAccessor());

        piecesBuilder.addPiece(new TWWitcherCitadelStructure.Piece(context.structureManager(), new BlockPos(x, y, z), context.random()));
    }

    private static boolean checkLocation(PieceGeneratorSupplier.Context<? extends FeatureConfiguration> context){
        if(context.validBiomeOnTop(Heightmap.Types.WORLD_SURFACE_WG)){
            return DETerrainAnalyzer.isPositionSuitable(context.chunkPos(), context.chunkGenerator(), DETerrainAnalyzer.GenerationType.onGround, context.heightAccessor());
        }

        return false;
    }

    public static class Piece extends GelTemplateStructurePiece {
        private static final ResourceLocation[] StructureFiles = new ResourceLocation[] {TWUtil.location("icy_ruins/small"), TWUtil.location("icy_ruins/small")};

        public Piece(StructureManager structureManager, BlockPos pos, Random random){
            super(TWStructures.WitcherCastle.getPieceType(), 0, structureManager, StructureFiles[random.nextInt(StructureFiles.length)], pos);
            rotation = Rotation.getRandom(random);
            setupPlaceSettings(structureManager);
        }

        public Piece(StructurePieceSerializationContext context, CompoundTag nbt){
            super(TWStructures.WitcherCastle.getPieceType(), nbt, context.structureManager());
            setupPlaceSettings(context.structureManager());
        }

        @Override
        protected StructurePlaceSettings getPlaceSettings(StructureManager structureManager) {
            Vec3i size = structureManager.get(this.makeTemplateLocation()).get().getSize();
            BlockPos pivot = new BlockPos(size.getX() / 2, 0, size.getZ() / 2);
            StructurePlaceSettings settings = new StructurePlaceSettings().setKeepLiquids(false).setRotationPivot(pivot);
            settings.addProcessor(BlockIgnoreProcessor.STRUCTURE_AND_AIR).addProcessor(RemoveGelStructureProcessor.INSTANCE);
            settings.addProcessor(TWProcessors.CobbleFrostedStoneBricks);
            return settings;
        }

        @Override @ParametersAreNonnullByDefault
        protected void handleDataMarker(String key, BlockPos pos, ServerLevelAccessor world, Random random, BoundingBox box) {}
    }

    @Override
    public int getSpacing() {return 27;}
    @Override
    public int getOffset() {return getSpacing()/2;}
}