package com.barion.the_witcher.data;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.stuff.TWItems;
import com.barion.the_witcher.stuff.TWTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class TWItemTags extends ItemTagsProvider {
    public TWItemTags(DataGenerator generator, BlockTagsProvider blockTags, ExistingFileHelper fileHelper){
        super(generator, blockTags, TheWitcher.ModID, fileHelper);
    }

    @Override
    protected void addTags() {
        copy(Tags.Blocks.ORES, Tags.Items.ORES);
        copy(TWTags.Blocks.SilverOres, TWTags.Items.SilverOres);
        copy(TWTags.Blocks.StorageBlocksSilver, TWTags.Items.StorageBlocksSilver);

        isIngot(TWItems.SilverIngot.get(),
                TWItems.SteelIngot.get());

        isNugget(TWItems.SilverNugget.get(),
                TWItems.SteelNugget.get());

        custom(TWTags.Items.SilverIngots, TWItems.SilverIngot.get());
        custom(TWTags.Items.SilverNuggets, TWItems.SilverNugget.get());
        custom(TWTags.Items.SteelIngots, TWItems.SteelIngot.get());
        custom(TWTags.Items.SteelNuggets, TWItems.SteelNugget.get());
        custom(ItemTags.BEACON_PAYMENT_ITEMS, TWItems.SilverIngot.get(), TWItems.SteelIngot.get());
    }

    @SafeVarargs
    private  <T extends Item> void isIngot(T... items) {tag(Tags.Items.INGOTS).add(items);}
    @SafeVarargs
    private  <T extends Item> void isNugget(T... items) {tag(Tags.Items.NUGGETS).add(items);}
    @SafeVarargs
    private  <T extends Item> void custom(Tag.Named<Item> tag, T... items) {tag(tag).add(items);}
}
