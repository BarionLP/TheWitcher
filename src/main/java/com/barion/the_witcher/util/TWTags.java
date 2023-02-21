package com.barion.the_witcher.util;

import net.minecraft.core.registries.Registries;
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
        public static final TagKey<Block> SpikesCanPlace = tw("spikes_can_place");
        public static final TagKey<Block> IceGroundReplaceable = tw("replaceable/ice_ground");
        public static final TagKey<Block> WhiteFrostPortalFrame = tw("portal_frame/white_frost");

        private static TagKey<Block> forge(String path){return BlockTags.create(new ResourceLocation("forge", path));}
        private static TagKey<Block> tw(String path){return BlockTags.create(TWUtil.location(path));}
    }

    public static final class Items{
        public static final TagKey<Item> StorageBlocksSilver = forge("storage_blocks/silver");
        public static final TagKey<Item> StorageBlocksRawSilver = forge("storage_blocks/raw_silver");
        public static final TagKey<Item> RawMaterialsSilver = forge("raw_materials/raw_silver");
        public static final TagKey<Item> SilverIngots = forge("ingots/silver");
        public static final TagKey<Item> SilverNuggets = forge("nuggets/silver");

        public static final TagKey<Item> SteelIngots = tw("ingots/steel");
        public static final TagKey<Item> SteelNuggets = tw("nuggets/steel");
        public static final TagKey<Item> BrewBeer = tw("brew_beer");

        private static TagKey<Item> forge(String path) {return ItemTags.create(new ResourceLocation("forge", path));}
        private static TagKey<Item> tw(String path) {return ItemTags.create(TWUtil.location(path));}
    }

    public static final class EntityTypes{
        public static final TagKey<EntityType<?>> MagicMob = forge("magic_mob");
        public static final TagKey<EntityType<?>> WildHunt = tw("wild_hunt");
        public static final TagKey<EntityType<?>> WildHuntIgnore = tw("wild_hunt_ignore");

        private static TagKey<EntityType<?>> forge(String path) {return create(new ResourceLocation("forge", path));}
        private static TagKey<EntityType<?>> tw(String path) {return create(TWUtil.location(path));}
        private static TagKey<EntityType<?>> create(ResourceLocation location) {return TagKey.create(Registries.ENTITY_TYPE, location);}
    }

    public static final class Biomes{
        public static final TagKey<Biome> isWhiteFrost = tw("is/white_frost");
        public static final TagKey<Biome> hasIcyRuin = tw("has/icy_ruin");
        public static final TagKey<Biome> IcicleCanGrowIn = tw("icicle_can_grow_in");
        public static final TagKey<Biome> DealsFreezingDamage = tw("deals_freezing_damage");
        public static final TagKey<Biome> hasWhiteMyrtle = tw("has/white_myrtle");
        private static TagKey<Biome> tw(String path) {return create(TWUtil.location(path));}
        private static TagKey<Biome> create(ResourceLocation location) {return TagKey.create(Registries.BIOME, location);}
    }
}