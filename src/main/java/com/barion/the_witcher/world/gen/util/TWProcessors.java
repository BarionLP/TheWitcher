package com.barion.the_witcher.world.gen.util;

import com.ametrinstudios.ametrin.world.gen.structure.processor.KeepStateRandomBlockSwapProcessor;
import com.barion.the_witcher.util.TWUtil;
import com.barion.the_witcher.world.TWBlocks;
import com.legacy.structure_gel.api.registry.RegistryHelper;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

public class TWProcessors {
    public static final KeepStateRandomBlockSwapProcessor CrackStoneBricks = new KeepStateRandomBlockSwapProcessor(Blocks.STONE_BRICKS, 0.06f, Blocks.CRACKED_STONE_BRICKS);
    public static final KeepStateRandomBlockSwapProcessor CrackFrostedStoneBricks = new KeepStateRandomBlockSwapProcessor(TWBlocks.FrostedStoneBricks.get(), 0.05f, TWBlocks.CrackedFrostedStoneBricks.get());
    public static final KeepStateRandomBlockSwapProcessor CrackFrostedStoneBrickStairs = new KeepStateRandomBlockSwapProcessor(TWBlocks.FrostedStoneBrickStairs.get(), 0.05f, TWBlocks.CrackedFrostedStoneBrickStairs.get());
    public static final KeepStateRandomBlockSwapProcessor CrackFrostedStoneBrickSlab = new KeepStateRandomBlockSwapProcessor(TWBlocks.FrostedStoneBrickSlab.get(), 0.05f, TWBlocks.CrackedFrostedStoneBrickSlab.get());
    public static final KeepStateRandomBlockSwapProcessor CrackFrostedStoneBrickWall = new KeepStateRandomBlockSwapProcessor(TWBlocks.FrostedStoneBrickWall.get(), 0.05f, TWBlocks.CrackedFrostedStoneBrickWall.get());
    public static final KeepStateRandomBlockSwapProcessor CobbleFrostedStoneBricks = new KeepStateRandomBlockSwapProcessor(TWBlocks.FrostedStoneBricks.get(), 0.15f, TWBlocks.FrostedCobblestone.get());

    private static Holder<StructureProcessorList> register(String key, StructureProcessor processor){
        return RegistryHelper.registerProcessor(TWUtil.location(key), processor);
    }
}