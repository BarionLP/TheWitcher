package com.barion.the_witcher;

import com.barion.the_witcher.world.TWBlocks;
import com.barion.the_witcher.world.TWItems;
import com.barion.the_witcher.world.item.TWBaseArmorMaterial;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import javax.annotation.Nonnull;

public class TWUtil {
    public static final CreativeModeTab TheWitcherTab = new TheWitcherTab();

    public static class ArmorMaterials{
        public static final TWBaseArmorMaterial ReinforcedLeather = new TWBaseArmorMaterial("reinforced_leather_armor", 45, new int[] {4, 7, 9, 4}, 0.1f, 3, 20, SoundEvents.ARMOR_EQUIP_LEATHER, Ingredient.of(TWTags.Items.SteelIngots));
    }

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

            items.add(TWBlocks.FrostedStone.get().asItem().getDefaultInstance());
            items.add(TWBlocks.FrostedStoneStairs.get().asItem().getDefaultInstance());
            items.add(TWBlocks.FrostedStoneSlab.get().asItem().getDefaultInstance());
            items.add(TWBlocks.FrostedStoneWall.get().asItem().getDefaultInstance());
            items.add(TWBlocks.FrostedCobblestone.get().asItem().getDefaultInstance());
            items.add(TWBlocks.FrostedCobblestoneStairs.get().asItem().getDefaultInstance());
            items.add(TWBlocks.FrostedCobblestoneSlab.get().asItem().getDefaultInstance());
            items.add(TWBlocks.FrostedCobblestoneWall.get().asItem().getDefaultInstance());
            items.add(TWBlocks.DeepFrostedStone.get().asItem().getDefaultInstance());
            items.add(TWBlocks.DeepFrostedStoneStairs.get().asItem().getDefaultInstance());
            items.add(TWBlocks.DeepFrostedStoneSlab.get().asItem().getDefaultInstance());
            items.add(TWBlocks.DeepFrostedStoneWall.get().asItem().getDefaultInstance());
            items.add(TWBlocks.DeepFrostedCobblestone.get().asItem().getDefaultInstance());
            items.add(TWBlocks.DeepFrostedCobblestoneStairs.get().asItem().getDefaultInstance());
            items.add(TWBlocks.DeepFrostedCobblestoneSlab.get().asItem().getDefaultInstance());
            items.add(TWBlocks.DeepFrostedCobblestoneWall.get().asItem().getDefaultInstance());
        }

        @Override @Nonnull
        public ItemStack makeIcon() {return TWItems.TabLogo.get().getDefaultInstance();}
    }

    public static ResourceLocation location(String key){
        return new ResourceLocation(TheWitcher.ModID, key);
    }
}