package com.barion.the_witcher.world.gen;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.world.gen.feature.TWLargeDripstoneFeature;
import com.barion.the_witcher.world.gen.feature.TWLargeSpikeFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TWFeatures {
    public static final DeferredRegister<Feature<?>> Registry = DeferredRegister.create(ForgeRegistries.FEATURES, TheWitcher.ModID);

    public static final RegistryObject<TWLargeSpikeFeature> LargeSpike = Registry.register("large_spike", TWLargeSpikeFeature::new);
    public static final RegistryObject<TWLargeDripstoneFeature> LargeDripstone = Registry.register("large_dripstone", TWLargeDripstoneFeature::new);
}