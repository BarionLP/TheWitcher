package com.barion.the_witcher.world.gen.util;

import com.ametrinstudios.ametrin.world.gen.structure.processor.KeepStateRandomBlockSwapProcessor;
import com.barion.the_witcher.world.TWBlocks;
import com.legacy.structure_gel.api.structure.processor.RandomBlockSwapProcessor;
import net.minecraft.world.level.block.Blocks;

public class TWProcessors {
    public static final RandomBlockSwapProcessor CrackStoneBricks = new RandomBlockSwapProcessor(Blocks.STONE_BRICKS, 0.06f, Blocks.CRACKED_STONE_BRICKS);
    public static final RandomBlockSwapProcessor CrackFrostedStoneBricks = new RandomBlockSwapProcessor(TWBlocks.FrostedStoneBricks.get(), 0.05f, TWBlocks.CrackedFrostedStoneBricks.get());
    public static final KeepStateRandomBlockSwapProcessor CrackFrostedStoneBrickStairs = new KeepStateRandomBlockSwapProcessor(TWBlocks.FrostedStoneBrickStairs.get(), 0.05f, TWBlocks.CrackedFrostedStoneBrickStairs.get());
    public static final KeepStateRandomBlockSwapProcessor CrackFrostedStoneBrickSlab = new KeepStateRandomBlockSwapProcessor(TWBlocks.FrostedStoneBrickSlab.get(), 0.05f, TWBlocks.CrackedFrostedStoneBrickSlab.get());
    public static final KeepStateRandomBlockSwapProcessor CrackFrostedStoneBrickWall = new KeepStateRandomBlockSwapProcessor(TWBlocks.FrostedStoneBrickWall.get(), 0.05f, TWBlocks.CrackedFrostedStoneBrickWall.get());
    public static final RandomBlockSwapProcessor CobbleFrostedStoneBricks = new RandomBlockSwapProcessor(TWBlocks.FrostedStoneBricks.get(), 0.15f, TWBlocks.FrostedCobblestone.get());

    public static final RandomBlockSwapProcessor CrackDeepFrostedStoneBricks = new RandomBlockSwapProcessor(TWBlocks.DeepFrostedStoneBricks.get(), 0.2f, TWBlocks.CrackedDeepFrostedStoneBricks.get());
    public static final KeepStateRandomBlockSwapProcessor CrackDeepFrostedStoneBrickStairs = new KeepStateRandomBlockSwapProcessor(TWBlocks.DeepFrostedStoneBrickStairs.get(), 0.2f, TWBlocks.CrackedDeepFrostedStoneBrickStairs.get());
    public static final RandomBlockSwapProcessor DamageBattlements = new RandomBlockSwapProcessor(TWBlocks.DeepFrostedStoneBrickWall.get(), 0.15f, Blocks.SNOW);
    public static final RandomBlockSwapProcessor PowderSnow = new RandomBlockSwapProcessor(Blocks.SNOW_BLOCK, 0.15f, Blocks.POWDER_SNOW);
}