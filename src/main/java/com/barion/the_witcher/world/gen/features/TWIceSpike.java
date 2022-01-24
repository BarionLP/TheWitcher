package com.barion.the_witcher.world.gen.features;

import com.barion.the_witcher.world.TWBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.IceSpikeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.Random;

public class TWIceSpike extends IceSpikeFeature {
    public TWIceSpike() {super(NoneFeatureConfiguration.CODEC);}

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        BlockPos blockPos = context.origin();
        Random random = context.random();
        WorldGenLevel worldGen = context.level();

        if (!worldGen.getBlockState(blockPos).is(Blocks.SNOW_BLOCK)) {
            return false;
        } else {
            blockPos = blockPos.above(random.nextInt(4));
            int i = random.nextInt(4) + 7;
            int j = i / 4 + random.nextInt(2);
            if (j > 1 && random.nextInt(60) == 0) {
                blockPos = blockPos.above(10 + random.nextInt(30));
            }

            for (int k = 0; k < i; ++k) {
                float f = (1.0F - (float) k / (float) i) * (float) j;
                int l = Mth.ceil(f);

                for (int i1 = -l; i1 <= l; ++i1) {
                    float f1 = (float) Mth.abs(i1) - 0.25F;

                    for (int j1 = -l; j1 <= l; ++j1) {
                        float f2 = (float) Mth.abs(j1) - 0.25F;
                        if ((i1 == 0 && j1 == 0 || !(f1 * f1 + f2 * f2 > f * f)) && (i1 != -l && i1 != l && j1 != -l && j1 != l || !(random.nextFloat() > 0.75F))) {
                            BlockState blockState = worldGen.getBlockState(blockPos.offset(i1, k, j1));
                            if (blockState.isAir() || blockState.is(TWBlocks.FrostedStone.get()) || blockState.is(Blocks.SNOW_BLOCK) || blockState.is(Blocks.ICE)) {
                                this.setBlock(worldGen, blockPos.offset(i1, k, j1), Blocks.PACKED_ICE.defaultBlockState());
                            }

                            if (k != 0 && l > 1) {
                                blockState = worldGen.getBlockState(blockPos.offset(i1, -k, j1));
                                if (blockState.isAir() || blockState.is(TWBlocks.FrostedStone.get()) || blockState.is(Blocks.SNOW_BLOCK) || blockState.is(Blocks.ICE)) {
                                    this.setBlock(worldGen, blockPos.offset(i1, -k, j1), Blocks.PACKED_ICE.defaultBlockState());
                                }
                            }
                        }
                    }
                }
            }

            int k1 = j - 1;
            if (k1 < 0) {k1 = 0;}
            else if (k1 > 1) {k1 = 1;}

            for (int l1 = -k1; l1 <= k1; ++l1) {
                for (int i2 = -k1; i2 <= k1; ++i2) {
                    BlockPos blockPos1 = blockPos.offset(l1, -1, i2);
                    int j2 = 50;
                    if (Math.abs(l1) == 1 && Math.abs(i2) == 1) {
                        j2 = random.nextInt(5);
                    }

                    while (blockPos1.getY() > 50) {
                        BlockState blockState1 = worldGen.getBlockState(blockPos1);
                        if (!blockState1.isAir() && !blockState1.is(TWBlocks.FrostedStone.get()) && !blockState1.is(Blocks.SNOW_BLOCK) && !blockState1.is(Blocks.ICE) && !blockState1.is(Blocks.PACKED_ICE)) {
                            break;
                        }

                        this.setBlock(worldGen, blockPos1, Blocks.PACKED_ICE.defaultBlockState());
                        blockPos1 = blockPos1.below();
                        --j2;
                        if (j2 <= 0) {
                            blockPos1 = blockPos1.below(random.nextInt(5) + 1);
                            j2 = random.nextInt(5);
                        }
                    }
                }
            }

            return true;
        }
    }
}