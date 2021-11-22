package com.barion.the_witcher.data;

import com.barion.the_witcher.TWBlocks;
import com.barion.the_witcher.TWTags;
import com.barion.the_witcher.TheWitcher;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.level.block.Block;
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
                TWBlocks.DeepslateSilverOre.get());
        needsIronTool(TWBlocks.SilverOre.get(),
                TWBlocks.RawSilverBlock.get(),
                TWBlocks.DeepslateSilverOre.get());

        isOre(TWBlocks.SilverOre.get(),
                TWBlocks.DeepslateSilverOre.get());

        custom(TWTags.Blocks.SilverOres, TWBlocks.SilverOre.get(), TWBlocks.DeepslateSilverOre.get());
        custom(BlockTags.BEACON_BASE_BLOCKS, TWBlocks.SilverBlock.get());
        custom(Tags.Blocks.STORAGE_BLOCKS, TWBlocks.SilverBlock.get());
        custom(TWTags.Blocks.StorageBlocksSilver, TWBlocks.SilverBlock.get());
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
    private  <T extends Block> void custom(Tag.Named<Block> tag, T... blocks) {tag(tag).add(blocks);}
    @SafeVarargs
    private <T extends Block> void isOre(T... blocks){tag(Tags.Blocks.ORES).add(blocks);}
}