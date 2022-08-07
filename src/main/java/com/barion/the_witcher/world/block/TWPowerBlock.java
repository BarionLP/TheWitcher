package com.barion.the_witcher.world.block;

import com.barion.the_witcher.capability.TWPlayerSignStrengthProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;

public class TWPowerBlock extends Block {
    public static final BooleanProperty hasPower = BooleanProperty.create("has_power");
    private static final Component needUnlock = Component.translatable("message.the_witcher.sign.need_unlock");

    public TWPowerBlock(Properties properties) {
        super(properties);
        registerDefaultState(getStateDefinition().any().setValue(hasPower, true));
    }

    @Override @ParametersAreNonnullByDefault
    public @NotNull InteractionResult use(BlockState blockState, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if(player instanceof ServerPlayer){
            if(blockState.getValue(hasPower)){
                player.getCapability(TWPlayerSignStrengthProvider.Instance).ifPresent(signStrength-> {
                    if(signStrength.canUpgrade(player, level)){
                        signStrength.increase((ServerPlayer) player);
                        level.setBlock(pos, blockState.setValue(hasPower, false), 2);
                        level.playSound(null, pos, SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.BLOCKS, 1.2f, level.random.nextFloat() * 0.1f + 0.9f);
                        return;
                    }
                    ((ServerPlayer) player).sendSystemMessage(needUnlock, true);
                });

                return InteractionResult.SUCCESS;
            }
        }

        return super.use(blockState, level, pos, player, hand, hitResult);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.add(hasPower);
    }
}