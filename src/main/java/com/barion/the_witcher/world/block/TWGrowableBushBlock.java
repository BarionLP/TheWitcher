package com.barion.the_witcher.world.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Random;
import java.util.function.Supplier;

public class TWGrowableBushBlock extends BushBlock implements BonemealableBlock {
    public final int MaxAge = 3;
    public final int GrowRarity;
    public final Supplier<? extends BlockItem> Drop;
    public final int BonusDrop;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
    private static final VoxelShape SAPLING_SHAPE = Block.box(3, 0, 3, 13, 8, 13);
    private static final VoxelShape MID_GROWTH_SHAPE = Block.box(1, 0, 1, 15, 16, 15);

    public TWGrowableBushBlock(Supplier<? extends BlockItem> drop, int bonusDrop, int growRate, BlockBehaviour.Properties properties) {
        super(properties);
        GrowRarity = growRate;
        Drop = drop;
        BonusDrop = bonusDrop;
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
    }
    @Override @ParametersAreNonnullByDefault
    public @NotNull ItemStack getCloneItemStack(BlockGetter level, BlockPos pos, BlockState blockState) {
        return new ItemStack(Items.SWEET_BERRIES);
    }
    @Override @ParametersAreNonnullByDefault
    public @NotNull VoxelShape getShape(BlockState blockState, BlockGetter level, BlockPos pos, CollisionContext context) {
        if (blockState.getValue(AGE) == 0) {
            return SAPLING_SHAPE;
        } else {
            return blockState.getValue(AGE) < MaxAge ? MID_GROWTH_SHAPE : super.getShape(blockState, level, pos, context);
        }
    }

    public boolean isRandomlyTicking(BlockState blockState) {return blockState.getValue(AGE) < MaxAge;}

    @Override @ParametersAreNonnullByDefault
    public void randomTick(BlockState blockState, ServerLevel level, BlockPos pos, Random random) {
        int i = blockState.getValue(AGE);
        if (i < MaxAge && level.getRawBrightness(pos.above(), 0) >= 9 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(level, pos, blockState,random.nextInt(GrowRarity) == 0)) {
            level.setBlock(pos, blockState.setValue(AGE, i + 1), 2);
            net.minecraftforge.common.ForgeHooks.onCropsGrowPost(level, pos, blockState);
        }

    }

    @Override @ParametersAreNonnullByDefault
    public @NotNull InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult blockHitResult) {
        int age = blockState.getValue(AGE);
        boolean isFull = age == MaxAge;
        if (!isFull && player.getItemInHand(hand).is(Items.BONE_MEAL)) {
            return InteractionResult.PASS;
        } else if (isFull) {
            int dropAmount = 1;
            if(BonusDrop > 0){
                dropAmount += level.random.nextInt(BonusDrop);
            }
            popResource(level, blockPos, new ItemStack(Drop.get(), dropAmount));
            level.playSound(null, blockPos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1, 0.8f + level.random.nextFloat() * 0.4f);
            level.setBlock(blockPos, blockState.setValue(AGE, 1), 2);
            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return super.use(blockState, level, blockPos, player, hand, blockHitResult);
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.add(AGE);
    }
    @Override @ParametersAreNonnullByDefault
    public boolean isValidBonemealTarget(BlockGetter level, BlockPos pos, BlockState blockState, boolean bool) {
        return blockState.getValue(AGE) < MaxAge;
    }
    @Override @ParametersAreNonnullByDefault
    public boolean isBonemealSuccess(Level level, Random random, BlockPos pos, BlockState blockState) {
        return true;
    }
    @Override @ParametersAreNonnullByDefault
    public void performBonemeal(ServerLevel level, Random random, BlockPos pos, BlockState blockState) {
        level.setBlock(pos, blockState.setValue(AGE, Math.min(MaxAge, blockState.getValue(AGE) + 1)), 2);
    }
}