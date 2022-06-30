package com.barion.the_witcher.world.gen.util;

import com.barion.the_witcher.util.TWTags;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class TWDripstoneUtils {
    public static double getSpikeHeight(double radius, double maxRadius, double scale, double bluntness) {
        if (radius < bluntness) {
            radius = bluntness;
        }

        double d1 = radius / maxRadius * 0.384d;
        double d2 = 0.75d * Math.pow(d1, 1.33333333d);
        double d3 = Math.pow(d1, 0.66666666d);
        double d4 = 0.33333333d * Math.log(d1);
        double d5 = scale * (d2 - d3 - d4);
        d5 = Math.max(d5, 0);
        return d5 / 0.384d * maxRadius;
    }

    public static boolean isCircleMostlyEmbeddedInStone(WorldGenLevel genLevel, BlockPos pos, int radius) {
        if (isEmptyOrWaterOrLava(genLevel, pos)) {return false;}
        else {
            float f = 6 / (float)radius;

            for(float f2 = 0; f2 < ((float)Math.PI * 2); f2 += f) {
                int i = (int)(Mth.cos(f2) * (float)radius);
                int j = (int)(Mth.sin(f2) * (float)radius);
                if (isEmptyOrWaterOrLava(genLevel, pos.offset(i, 0, j))) {return false;}
            }

            return true;
        }
    }

    protected static boolean isEmptyOrWater(LevelAccessor levelAccessor, BlockPos pos) {return levelAccessor.isStateAtPosition(pos, TWDripstoneUtils::isEmptyOrWater);}

    public static boolean isEmptyOrWaterOrLava(LevelAccessor levelAccessor, BlockPos pos) {return levelAccessor.isStateAtPosition(pos, TWDripstoneUtils::isEmptyOrWaterOrLava);}

    public static boolean isDripstoneBaseOrLava(BlockState blockState) {return isDripstoneBase(blockState) || blockState.is(Blocks.LAVA);}

    public static boolean isDripstoneBase(BlockState blockState) {return blockState.is(TWTags.Blocks.SpikesCanPlace);}

    public static boolean isEmptyOrWater(BlockState blockState) {return blockState.isAir() || blockState.is(Blocks.WATER);}

    public static boolean isEmptyOrWaterOrLava(BlockState blockState) {return blockState.isAir() || blockState.is(Blocks.WATER) || blockState.is(Blocks.LAVA);}
}