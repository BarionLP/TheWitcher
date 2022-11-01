package com.barion.the_witcher.world.block;

import com.legacy.structure_gel.api.util.VoxelShapeUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FaceAttachedHorizontalDirectionalBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

public class TWLarimar extends FaceAttachedHorizontalDirectionalBlock implements SimpleWaterloggedBlock {
    private static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    private static final VoxelShape FLOOR = Block.box(4, 0, 4, 12, 2, 12);
    private static final VoxelShape CEILING = VoxelShapeUtil.mirror(FLOOR, Direction.Axis.Y);
    private static final VoxelShape NORTH = Block.box(4, 4, 14, 12, 12, 16);
    private static final VoxelShape SOUTH = VoxelShapeUtil.rotate(NORTH, Direction.SOUTH);
    private static final VoxelShape EAST = VoxelShapeUtil.rotate(NORTH, Direction.EAST);
    private static final VoxelShape WEST = VoxelShapeUtil.rotate(NORTH, Direction.WEST);

    public TWLarimar(BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState(getStateDefinition().any().setValue(FACING, Direction.NORTH).setValue(FACE, AttachFace.WALL).setValue(WATERLOGGED, false));
    }

    @Override @ParametersAreNonnullByDefault
    public boolean canSurvive(BlockState blockState, LevelReader level, BlockPos pos) {
        return isValidFace(level, pos, getConnectedDirection(blockState).getOpposite());
    }

    public static boolean isValidFace(LevelReader level, BlockPos pos, Direction direction) {
        BlockPos blockPos = pos.relative(direction);
        return direction.getAxis() == Direction.Axis.Y && (level.getBlockState(blockPos).is(BlockTags.FENCES) || level.getBlockState(blockPos).is(BlockTags.WALLS)) || level.getBlockState(blockPos).isFaceSturdy(level, blockPos, direction.getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACE, FACING, WATERLOGGED);
    }

    @Override @ParametersAreNonnullByDefault
    public @NotNull VoxelShape getShape(BlockState blockState, BlockGetter level, BlockPos pos, CollisionContext context) {
        return switch (blockState.getValue(FACE)) {
            case WALL -> switch (blockState.getValue(FACING)) {
                case NORTH -> NORTH;
                case SOUTH -> SOUTH;
                case EAST -> EAST;
                default -> WEST;
            };
            case CEILING -> CEILING;
            default -> FLOOR;
        };
    }

    @Override
    public @NotNull FluidState getFluidState(BlockState blockState) {
        return blockState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : Fluids.EMPTY.defaultFluidState();
    }

    @Override @ParametersAreNonnullByDefault
    public @NotNull BlockState updateShape(BlockState blockState, Direction facing, BlockState facingState, LevelAccessor level, BlockPos pos, BlockPos facingPos) {
        if (blockState.getValue(WATERLOGGED)) {
            level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        return super.updateShape(blockState, facing, facingState, level, pos, facingPos);
    }

    @Override @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction[] directions = context.getNearestLookingDirections();

        for (Direction direction : directions) {
            BlockState blockState;
            if (direction.getAxis() == Direction.Axis.Y) {
                blockState = defaultBlockState().setValue(FACE, direction == Direction.UP ? AttachFace.CEILING : AttachFace.FLOOR).setValue(FACING, context.getHorizontalDirection());
            } else {
                blockState = defaultBlockState().setValue(FACE, AttachFace.WALL).setValue(FACING, direction.getOpposite());
            }

            if (blockState.canSurvive(context.getLevel(), context.getClickedPos())) {
                return blockState.setValue(WATERLOGGED, context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER);
            }
        }

        return null;
    }
}