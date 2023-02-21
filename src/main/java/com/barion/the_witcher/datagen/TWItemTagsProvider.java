package com.barion.the_witcher.datagen;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.util.TWTags;
import com.barion.the_witcher.world.TWBlocks;
import com.barion.the_witcher.world.TWItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nonnull;
import java.util.concurrent.CompletableFuture;

public class TWItemTagsProvider extends ItemTagsProvider {
    public TWItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, TagsProvider<Block> blockTagsProvider, ExistingFileHelper existingFileHelper){
        super(output, lookupProvider, blockTagsProvider, TheWitcher.ModID, existingFileHelper);
    }

    @Override
    protected void addTags(@Nonnull HolderLookup.Provider provider) {
        copy(TWTags.Blocks.StorageBlocksSilver, TWTags.Items.StorageBlocksSilver);
        copy(TWTags.Blocks.StorageBlocksRawSilver, TWTags.Items.StorageBlocksRawSilver);
        copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);
        copy(BlockTags.STAIRS, ItemTags.STAIRS);
        copy(BlockTags.SLABS, ItemTags.SLABS);
        copy(BlockTags.WALLS, ItemTags.WALLS);
        copy(BlockTags.BUTTONS, ItemTags.BUTTONS);

        tag(TWTags.Items.RawMaterialsSilver).add(TWItems.RawSilver.get());
        tag(TWTags.Items.SilverIngots).add(TWItems.SilverIngot.get());
        tag(TWTags.Items.SilverNuggets).add(TWItems.SilverNugget.get());
        tag(TWTags.Items.SteelIngots).add(TWItems.SteelIngot.get());
        tag(TWTags.Items.SteelNuggets).add(TWItems.SteelNugget.get());
        tag(TWTags.Items.SteelNuggets).add(TWItems.SteelNugget.get());

        tag(Tags.Items.INGOTS)
                .addTag(TWTags.Items.SilverIngots)
                .addTag(TWTags.Items.SteelIngots);

        tag(Tags.Items.NUGGETS)
                .addTag(TWTags.Items.SilverNuggets)
                .addTag(TWTags.Items.SteelNuggets);

        tag(ItemTags.STONE_CRAFTING_MATERIALS).add(
                TWBlocks.FrostedStone.get().asItem(),
                TWBlocks.FrostedCobblestone.get().asItem(),
                TWBlocks.DeepFrostedStone.get().asItem(),
                TWBlocks.DeepFrostedCobblestone.get().asItem(),
                TWBlocks.HallucinatedStone.get().asItem()
        );

        tag(ItemTags.FREEZE_IMMUNE_WEARABLES).add(
                TWItems.ReinforcedLeatherHelmet.get(),
                TWItems.ReinforcedLeatherChestplate.get(),
                TWItems.ReinforcedLeatherLeggings.get(),
                TWItems.ReinforcedLeatherBoots.get()
        );

        tag(TWTags.Items.BrewBeer).add(
                Items.WHEAT,
                Items.BROWN_MUSHROOM
        );

        tag(Tags.Items.RAW_MATERIALS).addTag(TWTags.Items.RawMaterialsSilver);
        tag(ItemTags.BEACON_PAYMENT_ITEMS).add(TWItems.SilverIngot.get(), TWItems.SteelIngot.get());
    }
}