package com.barion.the_witcher.world.block.entity;

import com.barion.the_witcher.world.TWItems;
import com.barion.the_witcher.world.screen.TWMasterSmithingTableMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;

public class TWMasterSmithingTableBlockEntity extends BlockEntity implements MenuProvider {
    public static final int Slots = 2;
    private static final Component TextComponent = new TranslatableComponent("container.the_witcher.master_smithting");
    private final ItemStackHandler itemHandler = new ItemStackHandler(Slots){
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    public TWMasterSmithingTableBlockEntity(BlockPos pos, BlockState blockState) {
        super(TWBlockEntities.MasterSmithingTableBlockEntity.get(), pos, blockState);
    }

    @Override
    public @NotNull Component getDisplayName() {
        return TextComponent;
    }

    @Override @Nullable
    public AbstractContainerMenu createMenu(int id, @NotNull Inventory inventory, @NotNull Player player) {
        return new TWMasterSmithingTableMenu(id, inventory, this);
    }

    @Override
    public <T> @NotNull LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps()  {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag) {
        tag.put("inventory", itemHandler.serializeNBT());
        super.saveAdditional(tag);
    }

    @Override
    public void load(@NotNull CompoundTag nbt) {
        super.load(nbt);
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        assert this.level != null;
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public static void tick(Level level, BlockPos pos, BlockState blockState, TWMasterSmithingTableBlockEntity blockEntity) {
        if(hasRecipe(blockEntity) && hasNotReachedStackLimit(blockEntity)) {
            craftItem(blockEntity);
        }
    }

    private static void craftItem(TWMasterSmithingTableBlockEntity entity) {
        entity.itemHandler.extractItem(0, 1, false);

        entity.itemHandler.setStackInSlot(1, new ItemStack(TWItems.MasterfulSteelSword.get(), 1));
    }

    private static boolean hasRecipe(TWMasterSmithingTableBlockEntity entity) {
        return entity.itemHandler.getStackInSlot(0).getItem() == TWItems.SteelSword.get();
    }

    private static boolean hasNotReachedStackLimit(TWMasterSmithingTableBlockEntity entity) {
        return entity.itemHandler.getStackInSlot(1).getCount() < entity.itemHandler.getStackInSlot(1).getMaxStackSize();
    }
}