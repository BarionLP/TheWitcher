package com.barion.the_witcher.datagen;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.util.TWTags;
import com.barion.the_witcher.world.gen.TWBiomes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class TWBiomeTagsProvider extends BiomeTagsProvider {
    public TWBiomeTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TheWitcher.ModID, existingFileHelper);
    }

    @Override
    protected void addTags(@NotNull HolderLookup.Provider lookupProvider) {
        tag(TWTags.Biomes.isWhiteFrost).add(
                TWBiomes.FrozenSpikes,
                TWBiomes.IcyPeaks,
                TWBiomes.SnowyDesert,
                TWBiomes.ArcticBoneyard,
                TWBiomes.FrostedOcean,
                TWBiomes.IceboundDepths
        );
        tag(TWTags.Biomes.hasIcyRuin).add(
                TWBiomes.FrozenSpikes,
                TWBiomes.IcyPeaks,
                TWBiomes.SnowyDesert,
                TWBiomes.ArcticBoneyard
        );

        tag(TWTags.Biomes.IcicleCanGrowIn).addTag(TWTags.Biomes.isWhiteFrost).addTag(Tags.Biomes.IS_COLD);
        tag(TWTags.Biomes.DealsFreezingDamage).addTag(TWTags.Biomes.isWhiteFrost);

        tag(BiomeTags.HAS_NETHER_FOSSIL).add(
                TWBiomes.ArcticBoneyard
        );

        tag(TWTags.Biomes.hasWhiteMyrtle).add(
                Biomes.FLOWER_FOREST,
                Biomes.BIRCH_FOREST,
                Biomes.OLD_GROWTH_BIRCH_FOREST
        );
    }
}