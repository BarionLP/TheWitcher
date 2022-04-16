package com.barion.the_witcher.world.item;

import com.barion.the_witcher.TWTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class TWTiers {
    public static final ForgeTier Silver = new ForgeTier(2, 1024, 0, 1, 20, BlockTags.NEEDS_IRON_TOOL, ()-> Ingredient.of(TWTags.Items.SilverIngots));
    public static final ForgeTier Steel = new ForgeTier(4, 2048, -2, 9, 20, BlockTags.NEEDS_DIAMOND_TOOL, ()-> Ingredient.of(TWTags.Items.SteelIngots));
}