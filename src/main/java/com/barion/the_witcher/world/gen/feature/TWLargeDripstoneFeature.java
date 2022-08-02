package com.barion.the_witcher.world.gen.feature;

import com.barion.the_witcher.world.gen.feature.configuration.TWLargeDripstoneConfiguration;
import com.barion.the_witcher.world.gen.util.TWDripstoneUtils;
import com.barion.the_witcher.world.gen.util.TWLargeSpike;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.FloatProvider;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.Column;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Optional;

public class TWLargeDripstoneFeature extends Feature<TWLargeDripstoneConfiguration> {
    public TWLargeDripstoneFeature() {super(TWLargeDripstoneConfiguration.CODEC);}

    @Override @ParametersAreNonnullByDefault
    public boolean place(FeaturePlaceContext<TWLargeDripstoneConfiguration> context) {
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();

        if (!TWDripstoneUtils.isEmptyOrWaterOrLava(level, origin)) {return false;}
        TWLargeDripstoneConfiguration configuration = context.config();

        Optional<Column> optional = Column.scan(level, origin, configuration.floorToCeilingSearchRange, TWDripstoneUtils::isEmptyOrWater, TWDripstoneUtils::isDripstoneBaseOrLava);
        if (optional.isEmpty() || !(optional.get() instanceof Column.Range column)) {return false;}

        if (column.height() < 4) {return false;}
        RandomSource random = context.random();
        int i = (int)((float)column.height() * configuration.maxColumnRadiusToCaveHeightRatio);
        int maxRadius = Mth.clamp(i, configuration.columnRadius.getMinValue(), configuration.columnRadius.getMaxValue());
        int radius = Mth.randomBetweenInclusive(random, configuration.columnRadius.getMinValue(), maxRadius);


        final TWLargeSpike stalactite = makeDripstone(origin.atY(column.ceiling() - 1), false, random, radius, configuration.bluntness, configuration.heightScale);
        final TWLargeSpike stalagmite = makeDripstone(origin.atY(column.floor() + 1), true, random, radius, configuration.bluntness, configuration.heightScale);
        TWLargeSpike.WindOffsetter windOffsetter;

        if (stalactite.isSuitableForWind(configuration.minRadiusForWind, configuration.minBluntnessForWind) && stalagmite.isSuitableForWind(configuration.minRadiusForWind, configuration.minBluntnessForWind)){
            windOffsetter = new TWLargeSpike.WindOffsetter(origin.getY(), random, configuration.windSpeed);
        }else{
            windOffsetter = TWLargeSpike.WindOffsetter.noWind();
        }

        boolean placeStalactite = stalactite.moveBackUntilBaseIsInsideStoneAndShrinkRadiusIfNecessary(level, windOffsetter);
        if (placeStalactite) {stalactite.placeBlocks(level, random, windOffsetter, configuration.baseBlock);}

        boolean placeStalagmite = stalagmite.moveBackUntilBaseIsInsideStoneAndShrinkRadiusIfNecessary(level, windOffsetter);
        if (placeStalagmite) {stalagmite.placeBlocks(level, random, windOffsetter, configuration.baseBlock);}
        return placeStalagmite || placeStalactite;
    }

    private static TWLargeSpike makeDripstone(BlockPos pos, boolean pointingUp, RandomSource random, int radius, FloatProvider bluntness, FloatProvider scale) {return new TWLargeSpike(pos, pointingUp, radius, bluntness.sample(random), scale.sample(random));}
}