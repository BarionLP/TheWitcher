package com.barion.the_witcher.world.block;

import com.barion.the_witcher.util.TWTags;
import com.barion.the_witcher.world.TWBlocks;
import com.google.common.annotations.VisibleForTesting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class TWIcicleBlock extends Block implements Fallable, SimpleWaterloggedBlock {
    public static final DirectionProperty TipDirection = BlockStateProperties.VERTICAL_DIRECTION;
    public static final EnumProperty<DripstoneThickness> Thickness = BlockStateProperties.DRIPSTONE_THICKNESS;
    public static final BooleanProperty Waterlogged = BlockStateProperties.WATERLOGGED;
    private static final int MAX_SEARCH_LENGTH_WHEN_CHECKING_DRIP_TYPE = 11;
    private static final int DELAY_BEFORE_FALLING = 2;
    private static final float DRIP_PROBABILITY_PER_ANIMATE_TICK = 0.02F;
    private static final float DRIP_PROBABILITY_PER_ANIMATE_TICK_IF_UNDER_LIQUID_SOURCE = 0.12F;
    private static final int MAX_SEARCH_LENGTH_BETWEEN_STALACTITE_TIP_AND_CAULDRON = 11;
    private static final float WATER_CAULDRON_FILL_PROBABILITY_PER_RANDOM_TICK = 0.17578125F;
    private static final float LAVA_CAULDRON_FILL_PROBABILITY_PER_RANDOM_TICK = 0.05859375F;
    private static final double MIN_TRIDENT_VELOCITY_TO_BREAK_ICICLE = 0.6D;
    private static final float STALACTITE_DAMAGE_PER_FALL_DISTANCE_AND_SIZE = 1.0F;
    private static final int STALACTITE_MAX_DAMAGE = 40;
    private static final int MAX_STALACTITE_HEIGHT_FOR_DAMAGE_CALCULATION = 6;
    private static final float STALAGMITE_FALL_DISTANCE_OFFSET = 2.0F;
    private static final int STALAGMITE_FALL_DAMAGE_MODIFIER = 2;
    private static final float AVERAGE_DAYS_PER_GROWTH = 5.0F;
    private static final float GROWTH_PROBABILITY_PER_RANDOM_TICK = 0.011377778F;
    private static final int MAX_GROWTH_LENGTH = 7;
    private static final int MAX_STALAGMITE_SEARCH_RANGE_WHEN_GROWING = 10;
    private static final float STALACTITE_DRIP_START_PIXEL = 0.6875F;
    private static final VoxelShape TIP_MERGE_SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 16.0D, 11.0D);
    private static final VoxelShape TIP_SHAPE_UP = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 11.0D, 11.0D);
    private static final VoxelShape TIP_SHAPE_DOWN = Block.box(5.0D, 5.0D, 5.0D, 11.0D, 16.0D, 11.0D);
    private static final VoxelShape FRUSTUM_SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);
    private static final VoxelShape MIDDLE_SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 16.0D, 13.0D);
    private static final VoxelShape BASE_SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);
    private static final VoxelShape REQUIRED_SPACE_TO_DRIP_THROUGH_NON_SOLID_BLOCK = Block.box(6.0D, 0.0D, 6.0D, 10.0D, 16.0D, 10.0D);

    public TWIcicleBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(stateDefinition.any().setValue(TipDirection, Direction.UP).setValue(Thickness, DripstoneThickness.TIP).setValue(Waterlogged, Boolean.FALSE));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.add(TipDirection, Thickness, Waterlogged);
    }
    @Override @ParametersAreNonnullByDefault
    public boolean canSurvive(BlockState blockState, LevelReader level, BlockPos pos) {
        return isValidIciclePlacement(level, pos, blockState.getValue(TipDirection));
    }
    @Override @ParametersAreNonnullByDefault
    public @NotNull BlockState updateShape(BlockState blockState, Direction direction, BlockState p_154149_, LevelAccessor level, BlockPos pos, BlockPos p_154152_) {
        if (blockState.getValue(Waterlogged)) {
            level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        if (direction != Direction.UP && direction != Direction.DOWN) {
            return blockState;
        } else {
            Direction tipDirection = blockState.getValue(TipDirection);
            if (tipDirection == Direction.DOWN && level.getBlockTicks().hasScheduledTick(pos, this)) {
                return blockState;
            } else if (direction == tipDirection.getOpposite() && !this.canSurvive(blockState, level, pos)) {
                if (tipDirection == Direction.DOWN) {
                    level.scheduleTick(pos, this, 2);
                } else {
                    level.scheduleTick(pos, this, 1);
                }

                return blockState;
            } else {
                boolean isTipMerge = blockState.getValue(Thickness) == DripstoneThickness.TIP_MERGE;
                DripstoneThickness thickness = calculateIcicleThickness(level, pos, tipDirection, isTipMerge);
                return blockState.setValue(Thickness, thickness);
            }
        }
    }
    @Override @ParametersAreNonnullByDefault
    public void onProjectileHit(Level level, BlockState blockState, BlockHitResult blockHitResult, Projectile projectile) {
        BlockPos blockpos = blockHitResult.getBlockPos();
        if (!level.isClientSide && projectile.mayInteract(level, blockpos) && projectile instanceof ThrownTrident && projectile.getDeltaMovement().length() > 0.6D) {
            level.destroyBlock(blockpos, true);
        }

    }
    @Override @ParametersAreNonnullByDefault
    public void fallOn(Level level, BlockState blockState, BlockPos pos, Entity entity, float damage) {
        if (blockState.getValue(TipDirection) == Direction.UP && blockState.getValue(Thickness) == DripstoneThickness.TIP) {
            entity.causeFallDamage(damage + 2f, 2f, DamageSource.STALAGMITE);
        } else {
            super.fallOn(level, blockState, pos, entity, damage);
        }

    }
    @Override @ParametersAreNonnullByDefault
    public void animateTick(BlockState blockState, Level level, BlockPos pos, RandomSource random) {
        if (canDrip(blockState) && !level.getBiome(pos).is(TWTags.Biomes.IcicleCanGrowIn)) {
            float chance = random.nextFloat();
            if (!(chance > 0.12f)) {
                getFluidAboveStalactite(level, pos, blockState).filter((fluid) -> chance < 0.02f || canFillCauldron(fluid)).ifPresent((fluid) -> {
                    spawnDripParticle(level, pos, blockState, fluid);
                });
            }
        }
    }
    @Override @ParametersAreNonnullByDefault
    public void tick(BlockState blockState, ServerLevel level, BlockPos pos, RandomSource random) {
        if (isStalagmite(blockState) && !canSurvive(blockState, level, pos)) {
            level.destroyBlock(pos, true);
        } else {
            spawnFallingStalactite(blockState, level, pos);
        }
    }

    @Override @ParametersAreNonnullByDefault
    public void randomTick(BlockState blockState, ServerLevel level, BlockPos pos, RandomSource random) {
        if(level.getBiome(pos).is(TWTags.Biomes.IcicleCanGrowIn)) {
            if (random.nextFloat() < 0.011377778F && isStalactiteStartPos(blockState, level, pos)) {
                growStalactiteOrStalagmiteIfPossible(blockState, level, pos, random);
            }
        }else {
            maybeFillCauldron(blockState, level, pos, random.nextFloat());
        }
    }

    @VisibleForTesting
    public static void maybeFillCauldron(BlockState blockState, ServerLevel level, BlockPos pos, float number) {
        if(level.getBiome(pos).is(TWTags.Biomes.IcicleCanGrowIn)) {return;}

        if (!(number > 0.17578125F)) {
            if (isStalactiteStartPos(blockState, level, pos)) {
                Fluid fluid = getCauldronFillFluidType(level, pos);
                float f;
                if (fluid == Fluids.WATER) {
                    f = 0.17578125F;
                } else {
                    if (fluid != Fluids.LAVA) {
                        return;
                    }

                    f = 0.05859375F;
                }

                if (!(number >= f)) {
                    BlockPos tipPos = findTip(blockState, level, pos, 11, false);
                    if (tipPos != null) {
                        BlockPos cauldronPos = findFillableCauldronBelowStalactiteTip(level, tipPos);
                        if (cauldronPos != null) {
                            level.levelEvent(1504, tipPos, 0);
                            int i = tipPos.getY() - cauldronPos.getY();
                            int j = 50 + i;
                            BlockState blockstate = level.getBlockState(cauldronPos);
                            level.scheduleTick(cauldronPos, blockstate.getBlock(), j);
                        }
                    }
                }
            }
        }
    }
    @Override
    public @NotNull PushReaction getPistonPushReaction(@NotNull BlockState blockState) {return PushReaction.DESTROY;}

    @Override @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext placeContext) {
        LevelAccessor levelaccessor = placeContext.getLevel();
        BlockPos clickedPos = placeContext.getClickedPos();
        Direction direction = placeContext.getNearestLookingVerticalDirection().getOpposite();
        Direction tipDirection = calculateTipDirection(levelaccessor, clickedPos, direction);
        if (tipDirection == null) {
            return null;
        } else {
            boolean flag = !placeContext.isSecondaryUseActive();
            DripstoneThickness thickness = calculateIcicleThickness(levelaccessor, clickedPos, tipDirection, flag);
            return thickness == null ? null : this.defaultBlockState().setValue(TipDirection, tipDirection).setValue(Thickness, thickness).setValue(Waterlogged, levelaccessor.getFluidState(clickedPos).getType() == Fluids.WATER);
        }
    }
    @Override
    public @NotNull FluidState getFluidState(BlockState blockState) {
        return blockState.getValue(Waterlogged) ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
    }
    @Override @ParametersAreNonnullByDefault
    public @NotNull VoxelShape getOcclusionShape(BlockState blockState, BlockGetter level, BlockPos pos) {
        return Shapes.empty();
    }
    @Override @ParametersAreNonnullByDefault
    public @NotNull VoxelShape getShape(BlockState blockState, BlockGetter level, BlockPos pos, CollisionContext collisionContext) {
        DripstoneThickness thickness = blockState.getValue(Thickness);
        VoxelShape voxelshape;
        if (thickness == DripstoneThickness.TIP_MERGE) {
            voxelshape = TIP_MERGE_SHAPE;
        } else if (thickness == DripstoneThickness.TIP) {
            if (blockState.getValue(TipDirection) == Direction.DOWN) {
                voxelshape = TIP_SHAPE_DOWN;
            } else {
                voxelshape = TIP_SHAPE_UP;
            }
        } else if (thickness == DripstoneThickness.FRUSTUM) {
            voxelshape = FRUSTUM_SHAPE;
        } else if (thickness == DripstoneThickness.MIDDLE) {
            voxelshape = MIDDLE_SHAPE;
        } else {
            voxelshape = BASE_SHAPE;
        }

        Vec3 vec3 = blockState.getOffset(level, pos);
        return voxelshape.move(vec3.x, 0.0D, vec3.z);
    }
    @Override @ParametersAreNonnullByDefault
    public boolean isCollisionShapeFullBlock(BlockState blockState, BlockGetter level, BlockPos pos) {
        return false;
    }


    public float getMaxHorizontalOffset() {return 0.125f;}
    @Override
    public void onBrokenAfterFall(@NotNull Level level, @NotNull BlockPos pos, FallingBlockEntity fallingBlockEntity) {
        if (!fallingBlockEntity.isSilent()) {
            level.levelEvent(1045, pos, 0);
        }

    }
    @Override
    public @NotNull DamageSource getFallDamageSource() {
        return DamageSource.FALLING_STALACTITE;
    }
    @Override
    public @NotNull Predicate<Entity> getHurtsEntitySelector() {
        return EntitySelector.NO_CREATIVE_OR_SPECTATOR.and(EntitySelector.LIVING_ENTITY_STILL_ALIVE);
    }

    private static void spawnFallingStalactite(BlockState blockState, ServerLevel level, BlockPos pos) {
        BlockPos.MutableBlockPos mutablePos = pos.mutable();

        for(BlockState fallingState = blockState; isStalactite(fallingState); fallingState = level.getBlockState(mutablePos)) {
            FallingBlockEntity fallingblockentity = FallingBlockEntity.fall(level, mutablePos, fallingState);
            if (isTip(fallingState, true)) {
                float damage = (float) Math.max(1 + pos.getY() - mutablePos.getY(), 6);
                fallingblockentity.setHurtsEntities(damage, 40);
                break;
            }

            mutablePos.move(Direction.DOWN);
        }

    }

    @VisibleForTesting
    public static void growStalactiteOrStalagmiteIfPossible(BlockState blockState, ServerLevel level, BlockPos pos, RandomSource random) {
        BlockState baseState = level.getBlockState(pos.above(1));
        BlockState fluidState = level.getBlockState(pos.above(2));
        if (canGrow(baseState, fluidState)) {
            BlockPos tipPos = findTip(blockState, level, pos, 7, false);
            if (tipPos != null) {
                BlockState tip = level.getBlockState(tipPos);
                if (canDrip(tip) && canTipGrow(tip, level, tipPos)) {
                    if (random.nextBoolean()) {
                        grow(level, tipPos, Direction.DOWN);
                    } else {
                        growStalagmiteBelow(level, tipPos);
                    }

                }
            }
        }
    }

    private static void growStalagmiteBelow(ServerLevel level, BlockPos pos) {
        BlockPos.MutableBlockPos mutablePos = pos.mutable();

        for(int i = 0; i < 10; ++i) {
            mutablePos.move(Direction.DOWN);
            BlockState blockstate = level.getBlockState(mutablePos);
            if (!blockstate.getFluidState().isEmpty()) {
                return;
            }

            if (isUnmergedTipWithDirection(blockstate, Direction.UP) && canTipGrow(blockstate, level, mutablePos)) {
                grow(level, mutablePos, Direction.UP);
                return;
            }

            if (isValidIciclePlacement(level, mutablePos, Direction.UP) && !level.isWaterAt(mutablePos.below())) {
                grow(level, mutablePos.below(), Direction.UP);
                return;
            }

            if (!canDripThrough(level, mutablePos, blockstate)) {
                return;
            }
        }

    }

    private static void grow(ServerLevel level, BlockPos pos, Direction direction) {
        BlockPos blockpos = pos.relative(direction);
        BlockState blockstate = level.getBlockState(blockpos);
        if (isUnmergedTipWithDirection(blockstate, direction.getOpposite())) {
            createMergedTips(blockstate, level, blockpos);
        } else if (blockstate.isAir() || blockstate.is(Blocks.WATER)) {
            createIcicle(level, blockpos, direction, DripstoneThickness.TIP);
        }

    }

    private static void createIcicle(LevelAccessor level, BlockPos pos, Direction direction, DripstoneThickness thickness) {
        BlockState blockstate = TWBlocks.Icicle.get().defaultBlockState().setValue(TipDirection, direction).setValue(Thickness, thickness).setValue(Waterlogged, level.getFluidState(pos).getType() == Fluids.WATER);
        level.setBlock(pos, blockstate, 3);
    }

    private static void createMergedTips(BlockState blockState, LevelAccessor level, BlockPos pos) {
        BlockPos mergeDownPos;
        BlockPos mergeUpPos;
        if (blockState.getValue(TipDirection) == Direction.UP) {
            mergeUpPos = pos;
            mergeDownPos = pos.above();
        } else {
            mergeDownPos = pos;
            mergeUpPos = pos.below();
        }

        createIcicle(level, mergeDownPos, Direction.DOWN, DripstoneThickness.TIP_MERGE);
        createIcicle(level, mergeUpPos, Direction.UP, DripstoneThickness.TIP_MERGE);
    }

    private static void spawnDripParticle(Level level, BlockPos pos, BlockState blockState, Fluid startFluid) {
        Vec3 vec3 = blockState.getOffset(level, pos);
        double d1 = (double)pos.getX() + 0.5D + vec3.x;
        double d2 = (double)((float)(pos.getY() + 1) - 0.6875F) - 0.0625D;
        double d3 = (double)pos.getZ() + 0.5D + vec3.z;
        Fluid fluid = getDripFluid(level, startFluid);
        ParticleOptions particleType = ParticleTypes.DRIPPING_DRIPSTONE_WATER;
        level.addParticle(particleType, d1, d2, d3, 0.0D, 0.0D, 0.0D);
    }

    @Nullable
    private static BlockPos findTip(BlockState blockState, LevelAccessor level, BlockPos pos, int steps, boolean includeMerge) {
        if (isTip(blockState, includeMerge)) {
            return pos;
        } else {
            Direction direction = blockState.getValue(TipDirection);
            BiPredicate<BlockPos, BlockState> predicate = (blockPos, state) -> state.is(TWBlocks.Icicle.get()) && state.getValue(TipDirection) == direction;
            return findBlockVertical(level, pos, direction.getAxisDirection(), predicate, (state) -> isTip(state, includeMerge), steps).orElse(null);
        }
    }

    @Nullable
    private static Direction calculateTipDirection(LevelReader level, BlockPos pos, Direction startDir) {
        Direction direction;
        if (isValidIciclePlacement(level, pos, startDir)) {
            direction = startDir;
        } else {
            if (!isValidIciclePlacement(level, pos, startDir.getOpposite())) {
                return null;
            }

            direction = startDir.getOpposite();
        }

        return direction;
    }

    private static DripstoneThickness calculateIcicleThickness(LevelReader level, BlockPos pos, Direction direction, boolean shouldMerge) {
        Direction oppositeDirection = direction.getOpposite();
        BlockState blockState = level.getBlockState(pos.relative(direction));
        if (isIcicleWithDirection(blockState, oppositeDirection)) {
            return !shouldMerge && blockState.getValue(Thickness) != DripstoneThickness.TIP_MERGE ? DripstoneThickness.TIP : DripstoneThickness.TIP_MERGE;
        } else if (!isIcicleWithDirection(blockState, direction)) {
            return DripstoneThickness.TIP;
        } else {
            DripstoneThickness thickness = blockState.getValue(Thickness);
            if (thickness != DripstoneThickness.TIP && thickness != DripstoneThickness.TIP_MERGE) {
                BlockState blockstate1 = level.getBlockState(pos.relative(oppositeDirection));
                return !isIcicleWithDirection(blockstate1, direction) ? DripstoneThickness.BASE : DripstoneThickness.MIDDLE;
            } else {
                return DripstoneThickness.FRUSTUM;
            }
        }
    }

    public static boolean canDrip(BlockState blockState) {
        return isStalactite(blockState) && blockState.getValue(Thickness) == DripstoneThickness.TIP && !blockState.getValue(Waterlogged);
    }

    private static boolean canTipGrow(BlockState blockState, ServerLevel level, BlockPos pos) {
        Direction direction = blockState.getValue(TipDirection);
        BlockPos blockpos = pos.relative(direction);
        BlockState blockstate = level.getBlockState(blockpos);
        if (!blockstate.getFluidState().isEmpty()) {
            return false;
        } else {
            return blockstate.isAir() || isUnmergedTipWithDirection(blockstate, direction.getOpposite());
        }
    }

    private static Optional<BlockPos> findRootBlock(Level level, BlockPos pos, BlockState blockState, int steps) {
        Direction direction = blockState.getValue(TipDirection);
        BiPredicate<BlockPos, BlockState> predicate = (blockPos, state) -> state.is(TWBlocks.Icicle.get()) && state.getValue(TipDirection) == direction;
        return findBlockVertical(level, pos, direction.getOpposite().getAxisDirection(), predicate, (state) -> !state.is(TWBlocks.Icicle.get()), steps);
    }

    private static boolean isValidIciclePlacement(LevelReader level, BlockPos pos, Direction direction) {
        BlockPos blockPos = pos.relative(direction.getOpposite());
        BlockState blockState = level.getBlockState(blockPos);
        return blockState.isFaceSturdy(level, blockPos, direction) || isIcicleWithDirection(blockState, direction);
    }

    private static boolean isTip(BlockState blockState, boolean includeMerge) {
        if (!blockState.is(TWBlocks.Icicle.get())) {
            return false;
        } else {
            DripstoneThickness thickness = blockState.getValue(Thickness);
            return thickness == DripstoneThickness.TIP || includeMerge && thickness == DripstoneThickness.TIP_MERGE;
        }
    }

    private static boolean isUnmergedTipWithDirection(BlockState blockState, Direction direction) {
        return isTip(blockState, false) && blockState.getValue(TipDirection) == direction;
    }

    private static boolean isStalactite(BlockState blockState) {
        return isIcicleWithDirection(blockState, Direction.DOWN);
    }

    private static boolean isStalagmite(BlockState blockState) {
        return isIcicleWithDirection(blockState, Direction.UP);
    }

    private static boolean isStalactiteStartPos(BlockState blockState, LevelReader level, BlockPos pos) {
        return isStalactite(blockState) && !level.getBlockState(pos.above()).is(BlockTags.ICE);
    }
    @Override @ParametersAreNonnullByDefault
    public boolean isPathfindable(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, PathComputationType computationType) {
        return false;
    }

    private static boolean isIcicleWithDirection(BlockState blockState, Direction direction) {
        return blockState.is(TWBlocks.Icicle.get()) && blockState.getValue(TipDirection) == direction;
    }

    @Nullable
    private static BlockPos findFillableCauldronBelowStalactiteTip(Level level, BlockPos pos) {
        Predicate<BlockState> predicate = (blockState) -> blockState.getBlock() instanceof AbstractCauldronBlock;
        BiPredicate<BlockPos, BlockState> biPredicate = (blockPos, blockState) -> canDripThrough(level, blockPos, blockState);
        return findBlockVertical(level, pos, Direction.DOWN.getAxisDirection(), biPredicate, predicate, 11).orElse(null);
    }

    public static Fluid getCauldronFillFluidType(Level level, BlockPos pos) {
        return getFluidAboveStalactite(level, pos, level.getBlockState(pos)).filter(TWIcicleBlock::canFillCauldron).orElse(Fluids.EMPTY);
    }

    private static Optional<Fluid> getFluidAboveStalactite(Level level, BlockPos pos, BlockState blockState) {
        return !isStalactite(blockState) ? Optional.empty() : findRootBlock(level, pos, blockState, 11).map((blockPos) -> level.getFluidState(blockPos.above()).getType());
    }

    private static boolean canFillCauldron(Fluid fluid) {
        return fluid == Fluids.WATER;
    }

    private static boolean canGrow(BlockState baseState, BlockState fluidState) {
        return baseState.is(BlockTags.ICE) && fluidState.is(Blocks.WATER) && fluidState.getFluidState().isSource();
    }

    private static Fluid getDripFluid(Level level, Fluid fluid) {
        if (fluid.isSame(Fluids.EMPTY)) {
            return Fluids.WATER;
        } else {
            return fluid;
        }
    }

    private static Optional<BlockPos> findBlockVertical(LevelAccessor level, BlockPos pos, Direction.AxisDirection axisDirection, BiPredicate<BlockPos, BlockState> posBlockStatePredicate, Predicate<BlockState> blockStatePredicate, int steps) {
        Direction direction = Direction.get(axisDirection, Direction.Axis.Y);
        BlockPos.MutableBlockPos mutableBlockPos = pos.mutable();

        for(int i = 1; i < steps; ++i) {
            mutableBlockPos.move(direction);
            BlockState blockstate = level.getBlockState(mutableBlockPos);
            if (blockStatePredicate.test(blockstate)) {
                return Optional.of(mutableBlockPos.immutable());
            }

            if (level.isOutsideBuildHeight(mutableBlockPos.getY()) || !posBlockStatePredicate.test(mutableBlockPos, blockstate)) {
                return Optional.empty();
            }
        }

        return Optional.empty();
    }

    private static boolean canDripThrough(BlockGetter level, BlockPos pos, BlockState blockState) {
        if (blockState.isAir()) {
            return true;
        } else if (blockState.isSolidRender(level, pos)) {
            return false;
        } else if (!blockState.getFluidState().isEmpty()) {
            return false;
        } else {
            VoxelShape voxelshape = blockState.getCollisionShape(level, pos);
            return !Shapes.joinIsNotEmpty(REQUIRED_SPACE_TO_DRIP_THROUGH_NON_SOLID_BLOCK, voxelshape, BooleanOp.AND);
        }
    }
}