package com.barion.the_witcher.world.gen.structure;

import com.barion.the_witcher.TWUtil;
import com.barion.the_witcher.world.gen.TWStructures;
import com.barion.the_witcher.world.gen.feature.util.DETerrainAnalyzer;
import com.legacy.structure_gel.api.structure.GelStructure;
import com.legacy.structure_gel.api.structure.GelTemplateStructurePiece;
import com.legacy.structure_gel.api.structure.processor.RemoveGelStructureProcessor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.chunk.ChunkGenerator;
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

public class TWWitcherCitadelStructure extends GelStructure<NoneFeatureConfiguration> {
    private static final ResourceLocation StructureFile = TWUtil.location("witcher_citadel");

    public TWWitcherCitadelStructure() {
        super(NoneFeatureConfiguration.CODEC, PieceGeneratorSupplier.simple(
                (context) -> checkLocation(context, new DETerrainAnalyzer.Settings(1, 4, 5)),
                TWWitcherCitadelStructure::generatePieces));
    }

    private static boolean checkLocation(PieceGeneratorSupplier.Context<? extends FeatureConfiguration> context, DETerrainAnalyzer.Settings checkSettings){
        if(context.validBiomeOnTop(Heightmap.Types.WORLD_SURFACE_WG)){
            return DETerrainAnalyzer.isPositionSuitable(context.chunkPos(), context.chunkGenerator(), DETerrainAnalyzer.GenerationType.onGround, checkSettings, context.heightAccessor());
        }

        return false;
    }

    private static void generatePieces(StructurePiecesBuilder piecesBuilder, PieceGenerator.Context<NoneFeatureConfiguration> context) {
        int x = context.chunkPos().getMinBlockX();
        int z = context.chunkPos().getMinBlockZ();
        ChunkGenerator chunkGen = context.chunkGenerator();
        LevelHeightAccessor heightAccessor = context.heightAccessor();
        int y = chunkGen.getBaseHeight(x, z, Heightmap.Types.WORLD_SURFACE_WG, heightAccessor);

        piecesBuilder.addPiece(new Piece(context.structureManager(), new BlockPos(x, y, z), context.random()));
    }

    public static class Piece extends GelTemplateStructurePiece {
        public Piece(StructureManager structureManager, BlockPos pos, Random random){
            super(TWStructures.WitcherCastle.getPieceType(), 0, structureManager, StructureFile, pos);
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
            return settings;
        }

        @Override @ParametersAreNonnullByDefault
        protected void handleDataMarker(String key, BlockPos pos, ServerLevelAccessor world, Random random, BoundingBox box) {}
    }

    @Override
    public int getSpacing() {return 68;}

    @Override
    public int getOffset() {return getSpacing()/2;}
}
