package com.barion.the_witcher;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;

public class TWTags {
    public static final class Blocks{
        public static final Tags.IOptionalNamedTag<Block> SilverOres = forge("ores/silver");
        public static final Tags.IOptionalNamedTag<Block> StorageBlocksSilver = forge("storage_blocks/silver");
        public static final Tags.IOptionalNamedTag<Block> StorageBlocksRawSilver = forge("storage_blocks/raw_silver");
        public static final Tags.IOptionalNamedTag<Block> SpikesCanPlace = mod("spikes_can_place");

        private static Tags.IOptionalNamedTag<Block> forge(String path){return BlockTags.createOptional(new ResourceLocation("forge", path));}
        private static Tags.IOptionalNamedTag<Block> mod(String path){return BlockTags.createOptional(new ResourceLocation(TheWitcher.ModID, path));}
    }

    public static final class Items{
        public static final Tags.IOptionalNamedTag<Item> SilverOres = forge("ores/silver");
        public static final Tags.IOptionalNamedTag<Item> StorageBlocksSilver = forge("storage_blocks/silver");
        public static final Tags.IOptionalNamedTag<Item> StorageBlocksRawSilver = forge("storage_blocks/raw_silver");
        public static final Tags.IOptionalNamedTag<Item> RawMaterialsSilver = forge("raw_materials/raw_silver");
        public static final Tags.IOptionalNamedTag<Item> SilverIngots = forge("ingots/silver");
        public static final Tags.IOptionalNamedTag<Item> SilverNuggets = forge("nuggets/silver");

        public static final Tags.IOptionalNamedTag<Item> SteelIngots = mod("ingots/steel");
        public static final Tags.IOptionalNamedTag<Item> SteelNuggets = mod("nuggets/steel");

        private static Tags.IOptionalNamedTag<Item> forge(String path){
            return ItemTags.createOptional(new ResourceLocation("forge", path));
        }
        private static Tags.IOptionalNamedTag<Item> mod(String path){
            return ItemTags.createOptional(new ResourceLocation(TheWitcher.ModID, path));
        }
    }

    public static final class Entities{
        public static final Tags.IOptionalNamedTag<EntityType<?>> MagicMob = forge("magic_mob");

        private static Tags.IOptionalNamedTag<EntityType<?>> forge(String path){
            return EntityTypeTags.createOptional(new ResourceLocation("forge", path));
        }
        private static Tags.IOptionalNamedTag<EntityType<?>> mod(String path){
            return EntityTypeTags.createOptional(new ResourceLocation(TheWitcher.ModID, path));
        }
    }
}