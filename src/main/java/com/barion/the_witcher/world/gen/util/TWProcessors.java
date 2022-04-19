package com.barion.the_witcher.world.gen.util;

import com.barion.the_witcher.util.TWUtil;
import com.barion.the_witcher.world.TWBlocks;
import com.legacy.structure_gel.api.registry.RegistryHelper;
import com.legacy.structure_gel.api.structure.processor.RandomBlockSwapProcessor;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

public class TWProcessors {
    public static final RandomBlockSwapProcessor CrackStoneBricks = new RandomBlockSwapProcessor(Blocks.STONE_BRICKS, 0.03f, Blocks.CRACKED_STONE_BRICKS);
    public static final RandomBlockSwapProcessor CobbleFrostedStoneBricks = new RandomBlockSwapProcessor(TWBlocks.FrostedStoneBricks.get(), 0.2f, TWBlocks.FrostedCobblestone.get());

    private static Holder<StructureProcessorList> register(String key, StructureProcessor processor){
        return RegistryHelper.registerProcessor(TWUtil.location(key), processor);
    }
}