package com.barion.the_witcher.world.screen;

import com.barion.the_witcher.recipe.TWMasterSmithingRecipe;
import com.barion.the_witcher.world.TWBlocks;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TWMasterSmithingMenu extends AbstractContainerMenu {
    private final Player player;
    private final Level level;
    private final ItemStackHandler itemHandler;
    private final ContainerLevelAccess access;
    private TWMasterSmithingRecipe selectedRecipe;
    private final Map<Integer, Slot> customSlots = new HashMap<>();

    public static final int Slots = 2;
    public static final int ResultSlot = 1;
    public static final int InputSlot = 0;

    public TWMasterSmithingMenu(int id, Inventory inventory, FriendlyByteBuf data) {this(id, inventory, data == null ? ContainerLevelAccess.NULL : ContainerLevelAccess.create(inventory.player.level, data.readBlockPos()));
    }
    public TWMasterSmithingMenu(int id, Inventory inventory, ContainerLevelAccess containerAccess) {
        super(TWMenuTypes.MasterSmithingTableMenu.get(), id);
        player = inventory.player;
        level = inventory.player.level;
        access = containerAccess;
        itemHandler = new ItemStackHandler(Slots){
            @Override
            protected void onContentsChanged(int slot) {
                slotsChanged(getContainer());
            }
        };
        checkContainerSize(inventory, Slots);

        customSlots.put(0, addSlot(new SlotItemHandler(itemHandler, 0, 44, 39)));
        customSlots.put(1, addSlot(new SlotItemHandler(itemHandler, 1, 116, 39){
            @Override
            public boolean mayPlace(@NotNull ItemStack itemStack) {return false;}
            @Override
            public boolean mayPickup(Player player) {
                return TWMasterSmithingMenu.this.mayPickup(player, hasItem());
            }
            @Override @ParametersAreNonnullByDefault
            public void onTake(Player player, ItemStack itemStack) {
                itemStack.onCraftedBy(player.level, player, itemStack.getCount());
                if(!player.getAbilities().instabuild) {
                    player.giveExperienceLevels(-selectedRecipe.getXpCost());
                }
                itemHandler.extractItem(InputSlot, 1, false);
                access.execute((level, pos) -> level.levelEvent(1044, pos, 0));
            }}));

        addPlayerInventory(inventory);
        addPlayerHotbar(inventory);
    }

    protected boolean isValidBlock(BlockState blockState) {
        return blockState.is(TWBlocks.MasterSmithingTable.get());
    }

    protected boolean mayPickup(Player player, boolean p_40269_) {
        return this.selectedRecipe != null && this.selectedRecipe.matches(getContainer(), this.level);
    }

    public void createResult() {
        List<TWMasterSmithingRecipe> list = this.level.getRecipeManager().getRecipesFor(TWMasterSmithingRecipe.Type.Instance, getContainer(), level);
        //TheWitcher.Logger.info(String.valueOf(list));
        if (list.isEmpty()) {
            if(itemHandler.getStackInSlot(ResultSlot) != ItemStack.EMPTY) {
                itemHandler.setStackInSlot(ResultSlot, ItemStack.EMPTY);
                selectedRecipe = null;
            }
        } else {
            selectedRecipe = list.get(0);
            if(!canCraft()) {return;}
            ItemStack resultItem = selectedRecipe.getResultItem();
            if(!itemHandler.getStackInSlot(ResultSlot).is(resultItem.getItem())) {
                resultItem.setTag(itemHandler.getStackInSlot(InputSlot).getTag());
                itemHandler.setStackInSlot(ResultSlot, resultItem);
            }
        }
    }

    @Override
    public boolean stillValid(@NotNull Player player) {
        return access.evaluate((level, pos) -> this.isValidBlock(level.getBlockState(pos)) && player.distanceToSqr((double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D) <= 64.0D, true);
    }
    @Override
    public void slotsChanged(@NotNull Container container) {
        super.slotsChanged(container);
        this.createResult();
    }
    @Override
    public void removed(@NotNull Player player) {
        super.removed(player);
        access.execute((level, pos) -> this.clearContainer(player));
    }

    protected void clearContainer(Player player) {
        if (!player.isAlive() || player instanceof ServerPlayer && ((ServerPlayer)player).hasDisconnected()) {
            player.drop(itemHandler.getStackInSlot(InputSlot), false);
        } else {
            Inventory inventory = player.getInventory();
            if (inventory.player instanceof ServerPlayer) {
                inventory.placeItemBackInInventory(itemHandler.getStackInSlot(InputSlot));
            }
        }
    }

    private SimpleContainer getContainer(){
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }
        return inventory;
    }

    public boolean enoughXP() {return player.experienceLevel >= selectedRecipe.getXpCost() || player.getAbilities().instabuild;}
    public boolean canCraft() {return getSelectedRecipe() != null && enoughXP();}
    public TWMasterSmithingRecipe getSelectedRecipe() {return selectedRecipe;}

    // CREDIT GOES TO: diesieben07 | https://github.com/diesieben07/SevenCommons
    // must assign a slot number to each of the slots used by the GUI.
    // For this container, we can see both the tile inventory's slots as well as the player inventory slots and the hotbar.
    // Each time we add a Slot to the container, it automatically increases the slotIndex, which means
    //  0 - 8 = hotbar slots (which will map to the InventoryPlayer slot numbers 0 - 8)
    //  9 - 35 = player inventory slots (which map to the InventoryPlayer slot numbers 9 - 35)
    //  36 - 44 = TileInventory slots, which map to our TileEntity slot numbers 0 - 8)
    private static final int HotbarSlots = 9;
    private static final int PlayerInventoryRows = 3;
    private static final int PlayerInventoryColums = 9;
    private static final int PlayerInventorySlots = PlayerInventoryColums * PlayerInventoryRows;
    private static final int VanillaSlots = HotbarSlots + PlayerInventorySlots;
    private static final int FirstSlot = 0;
    private static final int TWFirstSlot = FirstSlot + VanillaSlots;

    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player player, int index) {
        Slot sourceSlot = slots.get(index);
        if (sourceSlot == null || !sourceSlot.hasItem()) return ItemStack.EMPTY;  //EMPTY_ITEM
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        // Check if the slot clicked is one of the vanilla container slots
        if (index < FirstSlot + VanillaSlots) {
            // This is a vanilla container slot so merge the stack into the tile inventory
            if (!moveItemStackTo(sourceStack, TWFirstSlot, TWFirstSlot
                    + Slots, false)) {
                return ItemStack.EMPTY;  // EMPTY_ITEM
            }
        } else if (index < TWFirstSlot + Slots) {
            // This is a TE slot so merge the stack into the players inventory
            if (!moveItemStackTo(sourceStack, FirstSlot, FirstSlot + VanillaSlots, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            System.out.println("Invalid slotIndex:" + index);
            return ItemStack.EMPTY;
        }
        // If stack size == 0 (the entire stack was moved) set slot contents to null
        if (sourceStack.getCount() == 0) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }
        sourceSlot.onTake(player, sourceStack);
        return copyOfSourceStack;
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }
}