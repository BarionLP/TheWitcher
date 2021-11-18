package com.barion.the_witcher.stuff;

import com.barion.the_witcher.TheWitcher;
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

        private static Tags.IOptionalNamedTag<Block> forge(String path){
            return BlockTags.createOptional(new ResourceLocation("forge", path));
        }
        private static Tags.IOptionalNamedTag<Block> mod(String path){
            return BlockTags.createOptional(new ResourceLocation(TheWitcher.ModID, path));
        }
    }

    public static final class Items{
        public static final Tags.IOptionalNamedTag<Item> SilverOres = mod("ores/silver");
        public static final Tags.IOptionalNamedTag<Item> StorageBlocksSilver = mod("storage_blocks/silver");
        public static final Tags.IOptionalNamedTag<Item> SilverIngots = mod("ingots/silver");
        public static final Tags.IOptionalNamedTag<Item> SilverNuggets = mod("nuggets/silver");

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
