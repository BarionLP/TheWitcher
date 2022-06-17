package com.barion.the_witcher.world.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class TWPowerBlock extends Block {
    public static final BooleanProperty hasPower = BooleanProperty.create("has_power");

    public TWPowerBlock(Properties properties) {
        super(properties);
        registerDefaultState(getStateDefinition().any().setValue(hasPower, true));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.add(hasPower);
    }
}