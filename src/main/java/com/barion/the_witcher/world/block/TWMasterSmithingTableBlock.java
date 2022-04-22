package com.barion.the_witcher.world.block;

import com.barion.the_witcher.world.block.entity.TWBlockEntities;
import com.barion.the_witcher.world.block.entity.TWMasterSmithingTableBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;

public class TWMasterSmithingTableBlock extends BaseEntityBlock {
    public TWMasterSmithingTableBlock(Properties properties) {super(properties);}

    @Override
    public @NotNull RenderShape getRenderShape(@NotNull BlockState blockState) {return RenderShape.MODEL;}

    @Override
    public void onRemove(BlockState pState, @NotNull Level level, @NotNull BlockPos pos, BlockState newState, boolean isMoving) {
        if (pState.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof TWMasterSmithingTableBlockEntity) {
                ((TWMasterSmithingTableBlockEntity) blockEntity).drops();
            }
        }
        super.onRemove(pState, level, pos, newState, isMoving);
    }

    @Override @ParametersAreNonnullByDefault
    public @NotNull InteractionResult use(BlockState blockState, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult blockHitResult) {
        if (!level.isClientSide()) {
            BlockEntity entity = level.getBlockEntity(pos);
            if(entity instanceof TWMasterSmithingTableBlockEntity) {
                NetworkHooks.openGui(((ServerPlayer)player), (TWMasterSmithingTableBlockEntity)entity, pos);
            } else {
                throw new IllegalStateException("Our Container provider is missing!");
            }
        }
        return InteractionResult.sidedSuccess(level.isClientSide());
    }

    @Override @ParametersAreNonnullByDefault
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {return new TWMasterSmithingTableBlockEntity(pos, state);}

    @Override @ParametersAreNonnullByDefault
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return createTickerHelper(pBlockEntityType, TWBlockEntities.MasterSmithingTableBlockEntity.get(),
                TWMasterSmithingTableBlockEntity::tick);
    }
}