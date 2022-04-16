package com.barion.the_witcher.datagen;

import com.barion.the_witcher.TWTags;
import com.barion.the_witcher.TWUtil;
import com.barion.the_witcher.world.TWBlocks;
import com.barion.the_witcher.world.TWItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.SlabBlock;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Consumer;

public class TWRecipeProvider extends RecipeProvider {
    protected static Consumer<FinishedRecipe> consumer;

    public TWRecipeProvider(DataGenerator generator){super(generator);}

    @Override @ParametersAreNonnullByDefault
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        TWRecipeProvider.consumer = consumer;
        oreSmelting(TWItems.RawSilver.get(), TWItems.SilverIngot.get());
        nineBlockStorage(TWItems.SilverIngot.get(), TWBlocks.SilverBlock.get());
        nineBlockStorageExtraPackingID(TWItems.SilverNugget.get(), TWItems.SilverIngot.get());
        nineBlockStorage(TWItems.RawSilver.get(), TWBlocks.RawSilverBlock.get());
        nineBlockStorage(TWItems.SteelNugget.get(), TWItems.SteelIngot.get());

        {ShapedRecipeBuilder.shaped(TWItems.SilverSword.get())
                .define('#', TWTags.Items.SilverIngots)
                .define('+', TWTags.Items.SteelIngots)
                .define('-', Items.STICK)
                .pattern("#")
                .pattern("+")
                .pattern("-")
                .unlockedBy("has_silver_ingot", has(TWTags.Items.SilverIngots))
                .save(consumer);} // Silver Sword
        sword(TWTags.Items.SteelIngots, TWItems.SteelSword.get());

        stairSlabWall(TWBlocks.FrostedCobblestoneStairs.get(), TWBlocks.FrostedCobblestoneSlab.get(), TWBlocks.FrostedCobblestoneWall.get(), TWBlocks.FrostedCobblestone.get(), TWBlocks.FrostedStone.get());
        stairSlabWall(TWBlocks.FrostedStoneStairs.get(), TWBlocks.FrostedStoneSlab.get(), TWBlocks.FrostedStoneWall.get(), TWBlocks.FrostedStone.get(), true);
        stairSlabWall(TWBlocks.FrostedStoneBrickStairs.get(), TWBlocks.FrostedStoneBrickSlab.get(), TWBlocks.FrostedStoneBrickWall.get(), TWBlocks.FrostedStoneBricks.get(), TWBlocks.FrostedStone.get(), TWBlocks.FrostedCobblestone.get());
        stairSlabWall(TWBlocks.DeepFrostedCobblestoneStairs.get(), TWBlocks.DeepFrostedCobblestoneSlab.get(), TWBlocks.DeepFrostedCobblestoneWall.get(), TWBlocks.DeepFrostedCobblestone.get(), TWBlocks.DeepFrostedStone.get());
        stairSlabWall(TWBlocks.DeepFrostedStoneStairs.get(), TWBlocks.DeepFrostedStoneSlab.get(), TWBlocks.DeepFrostedStoneWall.get(), TWBlocks.DeepFrostedStone.get(), true);
        stairSlabWall(TWBlocks.DeepFrostedStoneBrickStairs.get(), TWBlocks.DeepFrostedStoneBrickSlab.get(), TWBlocks.DeepFrostedStoneBrickWall.get(), TWBlocks.DeepFrostedStoneBricks.get(), TWBlocks.DeepFrostedCobblestone.get(), TWBlocks.DeepFrostedStone.get());
        stairSlabWall(TWBlocks.DeepFrostedStoneTileStairs.get(), TWBlocks.DeepFrostedStoneTileSlab.get(), TWBlocks.DeepFrostedStoneTileWall.get(), TWBlocks.DeepFrostedStoneTiles.get(), TWBlocks.DeepFrostedCobblestone.get(), TWBlocks.DeepFrostedStone.get(), TWBlocks.DeepFrostedStoneBricks.get());

        shapeless(TWBlocks.FrostedStone.get(), 4, TWBlocks.FrostedCobblestone.get(), 4);
        shapeless(TWBlocks.DeepFrostedStone.get(), 4, TWBlocks.DeepFrostedCobblestone.get(), 4);

        furnance(Items.COBBLESTONE, TWBlocks.FrostedCobblestone.get(), 0, 200);
        furnance(Items.STONE, TWBlocks.FrostedStone.get(), 0, 200);
        furnanceExtraID(Items.COBBLESTONE, TWBlocks.DeepFrostedCobblestone.get(), 0, 400);
        furnanceExtraID(Items.STONE, TWBlocks.DeepFrostedStone.get(), 0, 400);
    }

    protected static void stairSlabWall(ItemLike stair, ItemLike slab, ItemLike wall, ItemLike material, boolean hasStonecutting){
        stairs(stair, material, hasStonecutting);
        slab(slab, material, hasStonecutting);
        wall(wall, material, hasStonecutting);
    }
    protected static void stairSlabWall(ItemLike stair, ItemLike slab, ItemLike wall, ItemLike material, ItemLike... addMats){
        stairs(stair, material, addMats);
        slab(slab, material, addMats);
        wall(wall, material, addMats);
    }

    protected static void stairs(ItemLike stair, ItemLike material, boolean hasStonecutting){
        stairBuilder(stair, Ingredient.of(material)).unlockedBy(getHasName(material), has(material)).save(consumer);
        if(hasStonecutting) {stonecutting(stair, 1, material);}
    }
    protected static void stairs(ItemLike stairs, ItemLike material, ItemLike... addMats){
        stairs(stairs, material, true);
        for (ItemLike item : addMats) {stonecuttingExtraID(stairs, 1, item);}
    }

    protected static void slab(ItemLike slab, ItemLike material, boolean hasStonecutting){
        slab(consumer, slab, material);
        if(hasStonecutting) {stonecutting(slab, 2, material);}
    }
    protected static void slab(ItemLike slab, ItemLike material, ItemLike... addMats){
        slab(slab, material, true);
        for (ItemLike item : addMats) {stonecuttingExtraID(slab, (item instanceof SlabBlock) ? 1 : 2, item);}
    }

    protected static void wall(ItemLike wall, ItemLike material, boolean hasStonecutting){
        wall(consumer, wall, material);
        if(hasStonecutting) {stonecutting(wall, 1, material);}
    }
    protected static void wall(ItemLike wall, ItemLike material, ItemLike... addMats) {
        wall(wall, material, true);
        for (ItemLike item : addMats) {stonecuttingExtraID(wall, 1, item);}
    }

    protected static void nineBlockStorage(ItemLike unpacked, ItemLike packed) {
        ShapelessRecipeBuilder.shapeless(unpacked, 9).requires(packed).unlockedBy(getHasName(packed), has(packed)).save(consumer);
        ShapedRecipeBuilder.shaped(packed).define('#', unpacked).pattern("###").pattern("###").pattern("###").unlockedBy(getHasName(unpacked), has(unpacked)).save(consumer);
    }
    protected static void nineBlockStorageExtraPackingID(ItemLike unpacked, ItemLike packed) {
        ShapelessRecipeBuilder.shapeless(unpacked, 9).requires(packed).unlockedBy(getHasName(packed), has(packed)).save(consumer);
        ShapedRecipeBuilder.shaped(packed).define('#', unpacked).pattern("###").pattern("###").pattern("###").unlockedBy(getHasName(unpacked), has(unpacked)).save(consumer, recipeID(getConversionRecipeName(packed, unpacked)));
    }

    protected static void shapeless(ItemLike result, int amountR, ItemLike ingredient, int amountI) {ShapelessRecipeBuilder.shapeless(result, amountR).requires(ingredient, amountI).unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer);}

    protected static void stonecutting(ItemLike result, int amount, ItemLike ingredient) {SingleItemRecipeBuilder.stonecutting(Ingredient.of(ingredient), result, amount).unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer, stonecuttingRecipeID(result));}
    protected static void stonecuttingExtraID(ItemLike result, int amount, ItemLike ingredient) {SingleItemRecipeBuilder.stonecutting(Ingredient.of(ingredient), result, amount).unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer, extraStonecuttingRecipeID(result, ingredient));}

    protected static void oreSmelting(ItemLike ore, ItemLike ingot) {
        furnance(ingot, ore, 0.7f, 200);
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ore), ingot, 0.7f, 100).unlockedBy(getHasName(ore), has(ore)).save(consumer, blastingRecipeID(ingot));
    }

    protected static void furnance(ItemLike result, ItemLike ingredient, float xp, int time) {SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient), result, xp, time).unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer, smeltingRecipeID(result));}
    protected static void furnanceExtraID(ItemLike result, ItemLike ingredient, float xp, int time) {SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient), result, xp, time).unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer, extraSmeltingRecipeID(result, ingredient));}
    protected static void sword(TagKey<Item> material, ItemLike sword){
        ShapedRecipeBuilder.shaped(sword)
                .define('#', material)
                .define('-', Items.STICK)
                .pattern("#")
                .pattern("#")
                .pattern("-")
                .unlockedBy("has_item", has(material))
                .save(consumer);
    }
    protected static ResourceLocation recipeID(String path) {return TWUtil.location(path);}
    protected static ResourceLocation stonecuttingRecipeID(ItemLike item) {return TWUtil.location("stonecutting/" + getItemName(item));}
    protected static ResourceLocation extraStonecuttingRecipeID(ItemLike result, ItemLike ingredient) {return TWUtil.location("stonecutting/" + getConversionRecipeName(result, ingredient));}
    protected static ResourceLocation smeltingRecipeID(ItemLike item) {return TWUtil.location("smelting/" + getItemName(item));}
    protected static ResourceLocation extraSmeltingRecipeID(ItemLike result, ItemLike ingredient) {return TWUtil.location("smelting/" + getConversionRecipeName(result, ingredient));}
    protected static ResourceLocation blastingRecipeID(ItemLike item) {return TWUtil.location("blasting/" + getItemName(item));}
}