package com.barion.the_witcher.world.gen;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.world.gen.features.TWIceSpike;
import com.barion.the_witcher.world.gen.features.TWLargeSpikeFeature;
import net.minecraftforge.registries.RegistryObject;

public class TWFeatures {
    public static final RegistryObject<TWIceSpike> IceSpike = TheWitcher.Registers.Features.register("ice_spike", TWIceSpike::new);
    public static final RegistryObject<TWLargeSpikeFeature> LargeSpike = TheWitcher.Registers.Features.register("large_spike", TWLargeSpikeFeature::new);

    public static void init(){}
}