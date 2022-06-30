package com.barion.the_witcher.world.gen.feature.configuration;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.valueproviders.FloatProvider;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class TWLargeDripstoneConfiguration implements FeatureConfiguration {
    public static final Codec<TWLargeDripstoneConfiguration> CODEC = RecordCodecBuilder.create((instance) -> instance.group(
            BlockStateProvider.CODEC.fieldOf("base_block").forGetter((configuration) -> configuration.baseBlock),
            Codec.intRange(0, 512).fieldOf("floor_to_ceiling_search_range").orElse(30).forGetter((configuration) -> configuration.floorToCeilingSearchRange),
            IntProvider.codec(1, 60).fieldOf("column_radius").forGetter((configuration) -> configuration.columnRadius),
            FloatProvider.codec(0, 20).fieldOf("height_scale").forGetter((configuration) -> configuration.heightScale),
            Codec.floatRange(0.1F, 1.0F).fieldOf("max_column_radius_to_cave_height_ratio").forGetter((configuration) -> configuration.maxColumnRadiusToCaveHeightRatio),
            FloatProvider.codec(0.1f, 10).fieldOf("bluntness").forGetter((configuration) -> configuration.bluntness),
            FloatProvider.codec(0, 2).fieldOf("wind_speed").forGetter((configuration) -> configuration.windSpeed),
            Codec.intRange(0, 100).fieldOf("min_radius_for_wind").forGetter((configuration) -> configuration.minRadiusForWind),
            Codec.floatRange(0, 5).fieldOf("min_bluntness_for_wind").forGetter((configuration) -> configuration.minBluntnessForWind))
            .apply(instance, TWLargeDripstoneConfiguration::new));

    public final BlockStateProvider baseBlock;
    public final int floorToCeilingSearchRange;
    public final IntProvider columnRadius;
    public final FloatProvider heightScale;
    public final float maxColumnRadiusToCaveHeightRatio;
    public final FloatProvider bluntness;
    public final FloatProvider windSpeed;
    public final int minRadiusForWind;
    public final float minBluntnessForWind;


    public TWLargeDripstoneConfiguration(BlockStateProvider baseBlock, int floorToCeilingSearchRange, IntProvider columnRadius, FloatProvider heightScale, float maxColumnRadiusToCaveHeightRatio, FloatProvider bluntness, FloatProvider windSpeed, int minRadiusForWind, float minBluntnessForWind){
        this.baseBlock = baseBlock;
        this.floorToCeilingSearchRange = floorToCeilingSearchRange;
        this.columnRadius = columnRadius;
        this.heightScale = heightScale;
        this.maxColumnRadiusToCaveHeightRatio = maxColumnRadiusToCaveHeightRatio;
        this.bluntness = bluntness;
        this.windSpeed = windSpeed;
        this.minRadiusForWind = minRadiusForWind;
        this.minBluntnessForWind = minBluntnessForWind;
    }
}
