package com.barion.the_witcher.data;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.stuff.TWBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class TWBlockModel extends BlockStateProvider {
    public TWBlockModel(DataGenerator generator, ExistingFileHelper fileHelper){
        super(generator, TheWitcher.ModID, fileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlocks(TWBlocks.SilverOre.get(),
                TWBlocks.DeepslateSilverOre.get(),
                TWBlocks.SilverBlock.get(),
                TWBlocks.RawSilverBlock.get());
    }

    protected <T extends Block>void simpleBlocks(T... blocks){
        for (T block : blocks) {
            simpleBlock(block);
        }
    }
}
