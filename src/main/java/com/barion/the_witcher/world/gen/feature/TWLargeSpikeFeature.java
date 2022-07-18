package com.barion.the_witcher.world.gen.feature;

import com.barion.the_witcher.world.gen.feature.configuration.TWLargeSpikeConfiguration;
import com.barion.the_witcher.world.gen.util.TWDripstoneUtils;
import com.barion.the_witcher.world.gen.util.TWLargeSpike;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.FloatProvider;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

import javax.annotation.ParametersAreNonnullByDefault;

public class TWLargeSpikeFeature extends Feature<TWLargeSpikeConfiguration> {
    public TWLargeSpikeFeature() {super(TWLargeSpikeConfiguration.CODEC);}

    @Override @ParametersAreNonnullByDefault
    public boolean place(FeaturePlaceContext<TWLargeSpikeConfiguration> context) {
        WorldGenLevel genLevel = context.level();
        BlockPos origin = context.origin();

        if (!TWDripstoneUtils.isEmptyOrWaterOrLava(genLevel, origin)) {return false;}

        RandomSource random = context.random();
        TWLargeSpikeConfiguration configuration = context.config();

        int k = Mth.randomBetweenInclusive(random, configuration.columnRadius.getMinValue(), configuration.columnRadius.getMaxValue());
        TWLargeSpike spike = makeSpike(origin.atY(genLevel.getHeight(Heightmap.Types.MOTION_BLOCKING, origin.getX(), origin.getZ())), random, k, configuration.bluntness, configuration.heightScale);

        TWLargeSpike.WindOffsetter windOffsetter;
        if (spike.isSuitableForWind(configuration.minRadiusForWind, configuration.minBluntnessForWind)) {windOffsetter = new TWLargeSpike.WindOffsetter(origin.getY(), random, configuration.windSpeed);}
        else {windOffsetter = TWLargeSpike.WindOffsetter.noWind();}

        boolean flag = spike.moveBackUntilBaseIsInsideStoneAndShrinkRadiusIfNecessary(genLevel, windOffsetter);
        if (flag) {spike.placeBlocks(genLevel, random, windOffsetter, configuration.baseBlock);}
        return flag;
    }

    private static TWLargeSpike makeSpike(BlockPos pos, RandomSource random, int radius, FloatProvider bluntness, FloatProvider scale) {return new TWLargeSpike(pos, true, radius, bluntness.sample(random), scale.sample(random));}
}