package com.barion.the_witcher.datagen;

import com.barion.the_witcher.TWTags;
import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.world.TWItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class TWItemTagsProvider extends ItemTagsProvider {
    public TWItemTagsProvider(DataGenerator generator, BlockTagsProvider blockTags, ExistingFileHelper fileHelper){
        super(generator, blockTags, TheWitcher.ModID, fileHelper);
    }

    @Override
    protected void addTags() {
        copy(Tags.Blocks.ORES, Tags.Items.ORES);
        copy(TWTags.Blocks.SilverOres, TWTags.Items.SilverOres);
        copy(TWTags.Blocks.StorageBlocksSilver, TWTags.Items.StorageBlocksSilver);
        copy(TWTags.Blocks.StorageBlocksRawSilver, TWTags.Items.StorageBlocksRawSilver);
        copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);

        isIngot(TWItems.SilverIngot.get(),
                TWItems.SteelIngot.get());

        isNugget(TWItems.SilverNugget.get(),
                TWItems.SteelNugget.get());

        tag(TWTags.Items.RawMaterialsSilver).add(TWItems.RawSilver.get());
        tag(TWTags.Items.SilverIngots).add(TWItems.SilverIngot.get());
        tag(TWTags.Items.SilverNuggets).add(TWItems.SilverNugget.get());
        tag(TWTags.Items.SteelIngots).add(TWItems.SteelIngot.get());
        tag(TWTags.Items.SteelNuggets).add(TWItems.SteelNugget.get());
        tag(TWTags.Items.SteelNuggets).add(TWItems.SteelNugget.get());

        tag(Tags.Items.RAW_MATERIALS).addTag(TWTags.Items.RawMaterialsSilver);
        tag(ItemTags.BEACON_PAYMENT_ITEMS).add(TWItems.SilverIngot.get(), TWItems.SteelIngot.get());
    }

    @SafeVarargs
    private  <T extends Item> void isIngot(T... items) {tag(Tags.Items.INGOTS).add(items);}
    @SafeVarargs
    private  <T extends Item> void isNugget(T... items) {tag(Tags.Items.NUGGETS).add(items);}
}