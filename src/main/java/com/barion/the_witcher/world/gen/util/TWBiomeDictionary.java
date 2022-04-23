package com.barion.the_witcher.world.gen.util;

import com.barion.the_witcher.util.TWUtil;
import com.barion.the_witcher.world.gen.TWBiomes;
import com.legacy.structure_gel.api.biome_dictionary.BiomeDictionary;
import com.legacy.structure_gel.api.biome_dictionary.BiomeType;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

public class TWBiomeDictionary {

    public static final BiomeType WhiteFrost = register("white_frost", TWBiomes.FrostedOcean, TWBiomes.IcyPeaks, TWBiomes.SnowyDesert, TWBiomes.FrozenSpikes);

    @SafeVarargs
    private static BiomeType register(String name, ResourceKey<Biome>... biomes) {
        return BiomeDictionary.register(BiomeType.builder(TWUtil.location(name)).biomes(biomes));
    }
}