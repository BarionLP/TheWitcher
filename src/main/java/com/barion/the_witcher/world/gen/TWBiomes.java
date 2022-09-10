package com.barion.the_witcher.world.gen;

import com.barion.the_witcher.util.TWUtil;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.registries.ForgeRegistries;

public class TWBiomes {
    public static final ResourceKey<Biome> SnowyDesert = ResourceKey.create(ForgeRegistries.BIOMES.getRegistryKey(), TWUtil.location("snowy_desert"));
    public static final ResourceKey<Biome> IcyPeaks = ResourceKey.create(ForgeRegistries.BIOMES.getRegistryKey(), TWUtil.location("icy_peaks"));
    public static final ResourceKey<Biome> FrozenSpikes = ResourceKey.create(ForgeRegistries.BIOMES.getRegistryKey(), TWUtil.location("frozen_spikes"));
    public static final ResourceKey<Biome> FrostedOcean = ResourceKey.create(ForgeRegistries.BIOMES.getRegistryKey(), TWUtil.location("frosted_ocean"));
    public static final ResourceKey<Biome> ArcticBoneyard = ResourceKey.create(ForgeRegistries.BIOMES.getRegistryKey(), TWUtil.location("arctic_boneyard"));
    public static final ResourceKey<Biome> IceboundDepths = ResourceKey.create(ForgeRegistries.BIOMES.getRegistryKey(), TWUtil.location("icebound_depths"));
}