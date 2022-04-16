package com.barion.the_witcher.world.gen.feature.util;

import com.barion.the_witcher.world.gen.feature.configuration.TWLargeSpikeConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.util.valueproviders.FloatProvider;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.Random;

public final class TWLargeSpike{
    private BlockPos root;
    private final boolean pointingUp;
    private int radius;
    private final double bluntness;
    private final double scale;

    public TWLargeSpike(BlockPos root, boolean pointingUp, int radius, double bluntness, double scale){
        this.root = root;
        this.pointingUp = pointingUp;
        this.radius = radius;
        this.bluntness = bluntness;
        this.scale = scale;
    }

    private int getHeight() {
        return this.getHeightAtRadius(0);
    }

    private int getMinY() {
        return this.pointingUp ? this.root.getY() : this.root.getY() - this.getHeight();
    }

    private int getMaxY() {
        return !this.pointingUp ? this.root.getY() : this.root.getY() + this.getHeight();
    }

    public boolean moveBackUntilBaseIsInsideStoneAndShrinkRadiusIfNecessary(WorldGenLevel genLevel, WindOffsetter windOffsetter) {
        while(this.radius > 1) {
            BlockPos.MutableBlockPos mutableBlockPos = this.root.mutable();
            int i = Math.min(10, this.getHeight());

            for(int j = 0; j < i; ++j) {
                if (genLevel.getBlockState(mutableBlockPos).is(Blocks.LAVA)) {return false;}

                if (TWSpikeUtils.isCircleMostlyEmbeddedInStone(genLevel, windOffsetter.offset(mutableBlockPos), this.radius)) {
                    this.root = mutableBlockPos;
                    return true;
                }

                mutableBlockPos.move(this.pointingUp ? Direction.DOWN : Direction.UP);
            }

            this.radius /= 2;
        }

        return false;
    }

    private int getHeightAtRadius(float radius) {
        return (int)TWSpikeUtils.getSpikeHeight(radius, this.radius, this.scale, this.bluntness);
    }

    public void placeBlocks(WorldGenLevel worldGenLevel, Random random, WindOffsetter windOffsetter, BlockStateProvider baseBlock) {
        for(int i1 = -this.radius; i1 <= this.radius; ++i1) {
            for(int j = -this.radius; j <= this.radius; ++j) {
                float f = Mth.sqrt((float)(i1 * i1 + j * j));
                if (!(f > (float)this.radius)) {
                    int k = this.getHeightAtRadius(f);
                    if (k > 0) {
                        if ((double)random.nextFloat() < 0.2d) {
                            k = (int)((float)k * Mth.randomBetween(random, 0.8F, 1.0F));
                        }

                        BlockPos.MutableBlockPos mutableBlockPos = this.root.offset(i1, 0, j).mutable();
                        boolean flag = false;
                        int l = this.pointingUp ? worldGenLevel.getHeight(Heightmap.Types.WORLD_SURFACE_WG, mutableBlockPos.getX(), mutableBlockPos.getZ()) : Integer.MAX_VALUE;

                        for(int i2 = 0; i2 < k /*&& mutableBlockPos.getY() < l*/; ++i2){
                            BlockPos pos = windOffsetter.offset(mutableBlockPos);
                            if (TWSpikeUtils.isEmptyOrWaterOrLava(worldGenLevel, pos)) {
                                flag = true;
                                worldGenLevel.setBlock(pos, baseBlock.getState(random, pos), 2);
                            } else if (flag && !worldGenLevel.getBlockState(pos).isAir()) {
                                break;
                            }

                            mutableBlockPos.move(this.pointingUp ? Direction.UP : Direction.DOWN);
                        }
                    }
                }
            }
        }

    }

    public boolean isSuitableForWind(TWLargeSpikeConfiguration configuration) {
        return this.radius >= configuration.minRadiusForWind && this.bluntness >= (double)configuration.minBluntnessForWind;
    }

    public static final class WindOffsetter {
        private final int originY;
        @Nullable private final Vec3 windSpeed;

        public WindOffsetter(int originY, Random random, FloatProvider amount) {
            this.originY = originY;
            float f = amount.sample(random);
            float f1 = Mth.randomBetween(random, 0, (float)Math.PI);
            this.windSpeed = new Vec3(Mth.cos(f1) * f, 0, Mth.sin(f1) * f);
        }

        private WindOffsetter() {
            this.originY = 0;
            this.windSpeed = null;
        }

        public static WindOffsetter noWind() {return new WindOffsetter();}

        public BlockPos offset(BlockPos current) {
            if (this.windSpeed == null) {return current;}
            else{
                int i = this.originY - current.getY();
                Vec3 vec3 = this.windSpeed.scale(i);
                return current.offset(vec3.x, 0, vec3.z);
            }
        }
    }
}