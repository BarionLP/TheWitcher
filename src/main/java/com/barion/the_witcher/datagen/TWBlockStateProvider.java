package com.barion.the_witcher.datagen;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.world.TWBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class TWBlockStateProvider extends BlockStateProvider {
    public TWBlockStateProvider(DataGenerator generator, ExistingFileHelper fileHelper){
        super(generator, TheWitcher.ModID, fileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(TWBlocks.SilverOre.get(),
                TWBlocks.DeepslateSilverOre.get(),
                TWBlocks.SilverBlock.get(),
                TWBlocks.RawSilverBlock.get(),
                TWBlocks.FrostedStone.get(),
                TWBlocks.FrostedCobblestone.get(),
                TWBlocks.DeepFrostedStone.get(),
                TWBlocks.DeepFrostedCobblestone.get());
    }

    @SafeVarargs
    protected final <T extends Block>void simpleBlock(T... blocks){
        for (T block : blocks) {
            simpleBlock(block);
        }
    }
}