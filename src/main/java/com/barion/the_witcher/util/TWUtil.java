package com.barion.the_witcher.util;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.world.TWBlocks;
import com.barion.the_witcher.world.TWItems;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nonnull;

public class TWUtil {
    public static final CreativeModeTab TheWitcherTab = new TheWitcherTab();

    public static boolean shouldAppendS(String name) {return ((name.contains("brick") && !name.contains("bricks")) || (name.contains("tile") && !name.contains("tiles")));}
    public static boolean isWood(String name) {return (name.contains("wood") || name.contains("hyphae"));}
    public static boolean isLog(String name) {return (name.contains("log") || name.contains("stem"));}
    public static boolean isWooden(String name) {return isLog(name) || isWood(name) || name.contains("plank");}

    private static class TheWitcherTab extends CreativeModeTab {
        public TheWitcherTab() {super("the_witcher");}

        @Override
        public void fillItemList(NonNullList<ItemStack> items) {
            items.add(TWBlocks.RawSilverBlock.get().asItem().getDefaultInstance());
            items.add(TWItems.RawSilver.get().getDefaultInstance());
            items.add(TWBlocks.SilverBlock.get().asItem().getDefaultInstance());
            items.add(TWItems.SilverIngot.get().getDefaultInstance());
            items.add(TWItems.SilverNugget.get().getDefaultInstance());
            items.add(TWItems.SilverSword.get().getDefaultInstance());
            items.add(TWItems.MasterfulSilverSword.get().getDefaultInstance());

            items.add(TWItems.SteelIngot.get().getDefaultInstance());
            items.add(TWItems.SteelNugget.get().getDefaultInstance());
            items.add(TWItems.SteelSword.get().getDefaultInstance());
            items.add(TWItems.MasterfulSteelSword.get().getDefaultInstance());
            items.add(TWItems.ReinforcedLeatherHelmet.get().getDefaultInstance());
            items.add(TWItems.ReinforcedLeatherChestplate.get().getDefaultInstance());
            items.add(TWItems.ReinforcedLeatherLeggings.get().getDefaultInstance());
            items.add(TWItems.ReinforcedLeatherBoots.get().getDefaultInstance());
            items.add(TWBlocks.MasterSmithingTable.get().asItem().getDefaultInstance());

            items.add(TWBlocks.FrostedCobblestone.get().asItem().getDefaultInstance());
            items.add(TWBlocks.FrostedCobblestoneStairs.get().asItem().getDefaultInstance());
            items.add(TWBlocks.FrostedCobblestoneSlab.get().asItem().getDefaultInstance());
            items.add(TWBlocks.FrostedCobblestoneWall.get().asItem().getDefaultInstance());
            items.add(TWBlocks.FrostedStone.get().asItem().getDefaultInstance());
            items.add(TWBlocks.FrostedStoneStairs.get().asItem().getDefaultInstance());
            items.add(TWBlocks.FrostedStoneSlab.get().asItem().getDefaultInstance());
            items.add(TWBlocks.FrostedStoneWall.get().asItem().getDefaultInstance());
            items.add(TWBlocks.FrostedStoneBricks.get().asItem().getDefaultInstance());
            items.add(TWBlocks.FrostedStoneBrickStairs.get().asItem().getDefaultInstance());
            items.add(TWBlocks.FrostedStoneBrickSlab.get().asItem().getDefaultInstance());
            items.add(TWBlocks.FrostedStoneBrickWall.get().asItem().getDefaultInstance());
            items.add(TWBlocks.FrostedStoneBrickButton.get().asItem().getDefaultInstance());

            items.add(TWBlocks.DeepFrostedCobblestone.get().asItem().getDefaultInstance());
            items.add(TWBlocks.DeepFrostedCobblestoneStairs.get().asItem().getDefaultInstance());
            items.add(TWBlocks.DeepFrostedCobblestoneSlab.get().asItem().getDefaultInstance());
            items.add(TWBlocks.DeepFrostedCobblestoneWall.get().asItem().getDefaultInstance());
            items.add(TWBlocks.DeepFrostedStone.get().asItem().getDefaultInstance());
            items.add(TWBlocks.DeepFrostedStoneStairs.get().asItem().getDefaultInstance());
            items.add(TWBlocks.DeepFrostedStoneSlab.get().asItem().getDefaultInstance());
            items.add(TWBlocks.DeepFrostedStoneWall.get().asItem().getDefaultInstance());
            items.add(TWBlocks.DeepFrostedStoneBricks.get().asItem().getDefaultInstance());
            items.add(TWBlocks.DeepFrostedStoneBrickStairs.get().asItem().getDefaultInstance());
            items.add(TWBlocks.DeepFrostedStoneBrickSlab.get().asItem().getDefaultInstance());
            items.add(TWBlocks.DeepFrostedStoneBrickWall.get().asItem().getDefaultInstance());
            items.add(TWBlocks.DeepFrostedStoneBrickButton.get().asItem().getDefaultInstance());
            items.add(TWBlocks.DeepFrostedStoneTiles.get().asItem().getDefaultInstance());
            items.add(TWBlocks.DeepFrostedStoneTileStairs.get().asItem().getDefaultInstance());
            items.add(TWBlocks.DeepFrostedStoneTileSlab.get().asItem().getDefaultInstance());
            items.add(TWBlocks.DeepFrostedStoneTileWall.get().asItem().getDefaultInstance());
            items.add(TWBlocks.Icicle.get().asItem().getDefaultInstance());

            items.add(TWItems.Celandine.get().getDefaultInstance());
            items.add(TWItems.WhiteMyrtle.get().getDefaultInstance());
            items.add(TWItems.KikimoraTooth.get().getDefaultInstance());
        }

        @Override @Nonnull
        public ItemStack makeIcon() {return TWItems.TabLogo.get().getDefaultInstance();}
    }

    public static ResourceLocation location(String key) {return new ResourceLocation(TheWitcher.ModID, key);}
}