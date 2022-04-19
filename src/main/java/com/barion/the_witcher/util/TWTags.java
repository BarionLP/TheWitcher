package com.barion.the_witcher.util;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class TWTags {
    public static final class Blocks{
        public static final TagKey<Block> StorageBlocksSilver = forge("storage_blocks/silver");
        public static final TagKey<Block> StorageBlocksRawSilver = forge("storage_blocks/raw_silver");
        public static final TagKey<Block> SpikesCanPlace = mod("spikes_can_place");

        private static TagKey<Block> forge(String path){return BlockTags.create(new ResourceLocation("forge", path));}
        private static TagKey<Block> mod(String path){return BlockTags.create(TWUtil.location(path));}
    }

    public static final class Items{
        public static final TagKey<Item> StorageBlocksSilver = forge("storage_blocks/silver");
        public static final TagKey<Item> StorageBlocksRawSilver = forge("storage_blocks/raw_silver");
        public static final TagKey<Item> RawMaterialsSilver = forge("raw_materials/raw_silver");
        public static final TagKey<Item> SilverIngots = forge("ingots/silver");
        public static final TagKey<Item> SilverNuggets = forge("nuggets/silver");

        public static final TagKey<Item> SteelIngots = mod("ingots/steel");
        public static final TagKey<Item> SteelNuggets = mod("nuggets/steel");

        private static TagKey<Item> forge(String path) {return ItemTags.create(new ResourceLocation("forge", path));}
        private static TagKey<Item> mod(String path) {return ItemTags.create(TWUtil.location(path));}
    }

    public static final class Entities{
        public static final TagKey<EntityType<?>> MagicMob = forge("magic_mob");

        private static TagKey<EntityType<?>> forge(String path) {return create(new ResourceLocation("forge", path));}
        private static TagKey<EntityType<?>> mod(String path) {return create(TWUtil.location(path));}
        private static TagKey<EntityType<?>> create(ResourceLocation location) {return TagKey.create(Registry.ENTITY_TYPE_REGISTRY, location);}
    }

    public static final class Biomes{
        public static final TagKey<Biome> isWhiteFrost = tw("is_white_frost");
        public static final TagKey<Biome> hasIcyRuin = tw("has/icy_ruin");
        private static TagKey<Biome> tw(String path) {return create(TWUtil.location(path));}
        private static TagKey<Biome> create(ResourceLocation location) {return TagKey.create(Registry.BIOME_REGISTRY, location);}
    }
}