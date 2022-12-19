package com.barion.the_witcher.world.gen.structure;

import com.barion.the_witcher.util.TWUtil;
import com.barion.the_witcher.world.gen.TWStructures;
import com.barion.the_witcher.world.gen.util.ExperimentalTerrainAnalyzer;
import com.barion.the_witcher.world.gen.util.TWProcessors;
import com.legacy.structure_gel.api.structure.GelTemplateStructurePiece;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Optional;

public class TWWildHuntOutpostStructure extends Structure {
    public static final Codec<TWWildHuntOutpostStructure> Codec = Structure.simpleCodec(TWWildHuntOutpostStructure::new);

    public TWWildHuntOutpostStructure(StructureSettings settings) {
        super(settings);
    }

    @Override
    public @NotNull Optional<GenerationStub> findGenerationPoint(@NotNull GenerationContext context) {
        BlockPos pos = context.chunkPos().getWorldPosition();
        Rotation rotation = Rotation.getRandom(context.random());
        Pair<Boolean, Float> results = ExperimentalTerrainAnalyzer.isFlatEnough(pos, context.structureTemplateManager().getOrCreate(Piece.StructureFile).getSize(rotation), 1, 100, context.chunkGenerator(), context.heightAccessor(), context.randomState());
        if(!results.getFirst()) {return Optional.empty();}
//        TWUtil.Logger.info("Generated at: {} {} {}", pos.getX(), pos.getY(), pos.getZ());
        return Optional.of(new Structure.GenerationStub(pos, (piecesBuilder)-> piecesBuilder.addPiece(new Piece(pos.atY((int) Math.floor(results.getSecond())), context, rotation))));
    }

    @Override
    public @NotNull StructureType<?> type() {return TWStructures.WildHuntOutpost.getType();}

    public static class Piece extends GelTemplateStructurePiece {
        private static final ResourceLocation StructureFile = TWUtil.location("wild_hunt_outpost");

        public Piece(BlockPos pos, GenerationContext context, Rotation rotation){
            super(TWStructures.WildHuntOutpost.getPieceType().get(), 0, context.structureTemplateManager(), StructureFile, pos);
            this.rotation = rotation;
            setupPlaceSettings(context.structureTemplateManager());
        }

        public Piece(StructurePieceSerializationContext context, CompoundTag nbt){
            super(TWStructures.WildHuntOutpost.getPieceType().get(), nbt, context.structureTemplateManager());
            setupPlaceSettings(context.structureTemplateManager());
        }

        @Override
        protected StructurePlaceSettings getPlaceSettings(StructureTemplateManager structureManager) {
            Vec3i size = structureManager.get(makeTemplateLocation()).get().getSize();
            BlockPos pivot = new BlockPos(size.getX() / 2, 0, size.getZ() / 2);
            StructurePlaceSettings settings = new StructurePlaceSettings().setKeepLiquids(false).setRotationPivot(pivot);
            settings.clearProcessors();
            settings.addProcessor(BlockIgnoreProcessor.STRUCTURE_AND_AIR);
            settings.addProcessor(TWProcessors.CrackDeepFrostedStoneBricks)
                    .addProcessor(TWProcessors.CrackDeepFrostedStoneBrickStairs)
                    .addProcessor(TWProcessors.PowderSnow)
                    .addProcessor(TWProcessors.DamageBattlements);
            return settings;
        }

        @Override @ParametersAreNonnullByDefault
        protected void handleDataMarker(String key, BlockPos pos, ServerLevelAccessor level, RandomSource random, BoundingBox box) {}
    }
}