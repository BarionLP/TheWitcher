package com.barion.the_witcher.datagen;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.util.TWTags;
import com.barion.the_witcher.world.gen.TWBiomes;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class TWBiomeTagsProvider extends BiomeTagsProvider {
    public TWBiomeTagsProvider(DataGenerator generator, @Nullable ExistingFileHelper exFileHelper) {
        super(generator, TheWitcher.ModID, exFileHelper);
    }

    @Override
    protected void addTags() {
        tag(TWTags.Biomes.isWhiteFrost).add(
                TWBiomes.FrozenSpikes,
                TWBiomes.IcyPeaks,
                TWBiomes.SnowyDesert,
                TWBiomes.ArcticBoneyard,
                TWBiomes.FrostedOcean
        );
        tag(TWTags.Biomes.hasIcyRuin).add(
                TWBiomes.FrozenSpikes,
                TWBiomes.IcyPeaks,
                TWBiomes.SnowyDesert
        );
        tag(TWTags.Biomes.IcicleCanGrowIn).addTag(TWTags.Biomes.isWhiteFrost).add(
                Biomes.FROZEN_OCEAN,
                Biomes.FROZEN_PEAKS,
                Biomes.FROZEN_RIVER,
                Biomes.DEEP_FROZEN_OCEAN,
                Biomes.SNOWY_BEACH,
                Biomes.SNOWY_PLAINS,
                Biomes.SNOWY_SLOPES,
                Biomes.SNOWY_TAIGA,
                Biomes.ICE_SPIKES
        );
        tag(BiomeTags.HAS_NETHER_FOSSIL).add(
                TWBiomes.ArcticBoneyard
        );
    }
}