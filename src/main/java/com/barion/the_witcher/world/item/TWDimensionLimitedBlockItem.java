package com.barion.the_witcher.world.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

// only use if on teleport doesn't work
public class TWDimensionLimitedBlockItem extends BlockItem{
    private static final String msg = "msg.the_witcher.dream_block.wrong_dimension";

    public TWDimensionLimitedBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public @NotNull InteractionResult place(@NotNull BlockPlaceContext context) {
        if(context.getPlayer() != null){
            context.getPlayer().displayClientMessage(Component.translatable(msg), true);
        }
        return InteractionResult.FAIL;
    }
}