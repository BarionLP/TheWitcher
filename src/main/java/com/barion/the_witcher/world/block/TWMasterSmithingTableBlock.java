package com.barion.the_witcher.world.block;

import com.barion.the_witcher.world.screen.TWMasterSmithingMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CraftingTableBlock;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.ParametersAreNonnullByDefault;

public class TWMasterSmithingTableBlock extends CraftingTableBlock {
    public static final Component TextComponent = Component.translatable("container.the_witcher.master_smithting");
    public TWMasterSmithingTableBlock(Properties properties) {super(properties);}

    @Override @ParametersAreNonnullByDefault
    public MenuProvider getMenuProvider(BlockState blockState, Level level, BlockPos pos) {
        return new SimpleMenuProvider((id, inventory, player) -> new TWMasterSmithingMenu(id, inventory, ContainerLevelAccess.create(level, pos)), TextComponent);
    }
}