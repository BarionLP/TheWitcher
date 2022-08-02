package com.barion.the_witcher.world.gen.structure;

import com.barion.the_witcher.util.TWUtil;
import com.barion.the_witcher.world.gen.TWStructures;
import com.barion.the_witcher.world.gen.util.TWProcessors;
import com.legacy.structure_gel.api.structure.GelTemplateStructurePiece;
import com.legacy.structure_gel.api.structure.processor.RemoveGelStructureProcessor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePiecesBuilder;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Optional;

public class TWWitcherCitadelStructure extends Structure {
    private static final ResourceLocation StructureFile = TWUtil.location("witcher_citadel");
    public static final com.mojang.serialization.Codec<TWWitcherCitadelStructure> Codec = Structure.simpleCodec(TWWitcherCitadelStructure::new);

    public TWWitcherCitadelStructure(StructureSettings settings) {super(settings);}

    @Override
    public @NotNull Optional<GenerationStub> findGenerationPoint(@NotNull GenerationContext context) {
        return onTopOfChunkCenter(context, Heightmap.Types.WORLD_SURFACE_WG, (builder)-> generatePieces(builder, context));
    }

    @Override
    public @NotNull StructureType<?> type() {return TWStructures.WitcherCitadel.getType();}

    private static void generatePieces(StructurePiecesBuilder piecesBuilder, GenerationContext context) {
        int x = context.chunkPos().getMinBlockX();
        int z = context.chunkPos().getMinBlockZ();
        ChunkGenerator chunkGen = context.chunkGenerator();
        LevelHeightAccessor heightAccessor = context.heightAccessor();
        int y = chunkGen.getBaseHeight(x, z, Heightmap.Types.WORLD_SURFACE_WG, heightAccessor, context.randomState());

        piecesBuilder.addPiece(new Piece(context.structureTemplateManager(), new BlockPos(x, y, z), context.random()));
    }

    public static class Piece extends GelTemplateStructurePiece {
        public Piece(StructureTemplateManager structureManager, BlockPos pos, RandomSource random){
            super(TWStructures.WitcherCitadel.getPieceType().get(), 0, structureManager, StructureFile, pos);
            rotation = Rotation.getRandom(random);
            setupPlaceSettings(structureManager);
        }

        public Piece(StructurePieceSerializationContext context, CompoundTag nbt){
            super(TWStructures.WitcherCitadel.getPieceType().get(), nbt, context.structureTemplateManager());
            setupPlaceSettings(context.structureTemplateManager());
        }

        @Override
        protected StructurePlaceSettings getPlaceSettings(StructureTemplateManager structureManager) {
            Vec3i size = structureManager.get(makeTemplateLocation()).get().getSize();
            BlockPos pivot = new BlockPos(size.getX() / 2, 0, size.getZ() / 2);
            StructurePlaceSettings settings = new StructurePlaceSettings().setKeepLiquids(false).setRotationPivot(pivot);
            settings.addProcessor(BlockIgnoreProcessor.STRUCTURE_AND_AIR).addProcessor(RemoveGelStructureProcessor.INSTANCE);
            settings.addProcessor(TWProcessors.CrackStoneBricks);
            return settings;
        }

        @Override @ParametersAreNonnullByDefault
        protected void handleDataMarker(String key, BlockPos pos, ServerLevelAccessor world, RandomSource random, BoundingBox box) {}
    }
}
