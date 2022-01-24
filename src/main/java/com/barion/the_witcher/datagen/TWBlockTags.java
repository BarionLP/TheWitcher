package com.barion.the_witcher.datagen;

import com.barion.the_witcher.TWTags;
import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.world.TWBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class TWBlockTags extends BlockTagsProvider {
    public TWBlockTags(DataGenerator generator, ExistingFileHelper fileHelper){
        super(generator, TheWitcher.ModID, fileHelper);
    }

    @Override
    protected void addTags() {
        needsPickaxe(TWBlocks.SilverOre.get(),
                TWBlocks.RawSilverBlock.get(),
                TWBlocks.DeepslateSilverOre.get(),
                TWBlocks.FrostedStone.get(),
                TWBlocks.DeepFrostedStone.get());

        needsIronTool(TWBlocks.SilverOre.get(),
                TWBlocks.RawSilverBlock.get(),
                TWBlocks.DeepslateSilverOre.get());

        isOre(TWBlocks.SilverOre.get(),
                TWBlocks.DeepslateSilverOre.get());

        tag(TWTags.Blocks.SilverOres).add(TWBlocks.SilverOre.get(), TWBlocks.DeepslateSilverOre.get());
        tag(BlockTags.BEACON_BASE_BLOCKS).add(TWBlocks.SilverBlock.get());
        tag(TWTags.Blocks.StorageBlocksSilver).add(TWBlocks.SilverBlock.get());
        tag(TWTags.Blocks.StorageBlocksRawSilver).add(TWBlocks.RawSilverBlock.get());
        tag(TWTags.Blocks.SpikesCanPlace).add(TWBlocks.FrostedStone.get(), TWBlocks.DeepFrostedStone.get(), Blocks.STONE);
        tag(Tags.Blocks.STORAGE_BLOCKS).addTags(TWTags.Blocks.StorageBlocksSilver, TWTags.Blocks.StorageBlocksRawSilver);
    }

    @SafeVarargs
    private <T extends Block> void needsAxe(T... blocks) {
        tag(BlockTags.MINEABLE_WITH_AXE).add(blocks);
    }
    @SafeVarargs
    private  <T extends Block> void needsPickaxe(T... blocks) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(blocks);
    }
    @SafeVarargs
    private  <T extends Block> void needsIronTool(T... blocks) {tag(BlockTags.NEEDS_IRON_TOOL).add(blocks);}
    @SafeVarargs
    private <T extends Block> void isOre(T... blocks){tag(Tags.Blocks.ORES).add(blocks);}
}