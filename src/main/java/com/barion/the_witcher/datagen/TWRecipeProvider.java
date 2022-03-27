package com.barion.the_witcher.datagen;

import com.barion.the_witcher.TWTags;
import com.barion.the_witcher.TheWitcher;
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
import net.minecraft.world.level.block.Block;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Objects;
import java.util.function.Consumer;

public class TWRecipeProvider extends RecipeProvider {
    private Consumer<FinishedRecipe> consumer;

    public TWRecipeProvider(DataGenerator generator){super(generator);}

    @Override @ParametersAreNonnullByDefault
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        this.consumer = consumer;
        recipeOreSmelting(TWBlocks.SilverOre.get(), TWItems.SilverIngot.get(), "_from_silver_ore");
        recipeOreSmelting(TWBlocks.DeepslateSilverOre.get(), TWItems.SilverIngot.get(), "_from_deepslate_silver_ore");
        recipeOreSmelting(TWItems.RawSilver.get(), TWItems.SilverIngot.get());
        recipeShapeless(TWItems.SilverIngot.get(), TWItems.SilverNugget.get(), 9);
        recipeShapeless(TWItems.SilverNugget.get(), 9, TWItems.SilverIngot.get());
        recipeShapeless(TWBlocks.SilverBlock.get(), 1, TWItems.SilverIngot.get(), 9, true);
        recipeShapeless(TWItems.SilverIngot.get(), 9, TWBlocks.SilverBlock.get());
        recipeShapeless(TWBlocks.RawSilverBlock.get(), TWItems.RawSilver.get(), 9);
        recipeShapeless(TWItems.RawSilver.get(), 9, TWBlocks.RawSilverBlock.get());

        recipeShapeless(TWItems.SteelIngot.get(), TWItems.SteelNugget.get(), 9);
        recipeShapeless(TWItems.SteelNugget.get(), 9, TWItems.SteelIngot.get());

        {ShapedRecipeBuilder.shaped(TWItems.SilverSword.get())
                .define('#', TWItems.SilverIngot.get())
                .define('+', TWItems.SteelIngot.get())
                .define('-', Items.STICK)
                .pattern("#")
                .pattern("+")
                .pattern("-")
                .unlockedBy("has_silver_ingot", has(TWItems.SilverIngot.get()))
                .save(consumer);} // Silver Sword
        recipeSword(TWTags.Items.SteelIngots, TWItems.SteelSword.get());

        recipeAll(TWBlocks.FrostedStoneStairs.get(), TWBlocks.FrostedStoneSlab.get(), TWBlocks.FrostedStoneWall.get(), TWBlocks.FrostedStone.get(), true);
        recipeAll(TWBlocks.FrostedCobblestoneStairs.get(), TWBlocks.FrostedCobblestoneSlab.get(), TWBlocks.FrostedCobblestoneWall.get(), TWBlocks.FrostedCobblestone.get(), true, TWBlocks.FrostedStone.get());
        recipeAll(TWBlocks.DeepFrostedStoneStairs.get(), TWBlocks.DeepFrostedStoneSlab.get(), TWBlocks.DeepFrostedStoneWall.get(), TWBlocks.DeepFrostedStone.get(), true);
        recipeAll(TWBlocks.DeepFrostedCobblestoneStairs.get(), TWBlocks.DeepFrostedCobblestoneSlab.get(), TWBlocks.DeepFrostedCobblestoneWall.get(), TWBlocks.DeepFrostedCobblestone.get(), true, TWBlocks.DeepFrostedStone.get());

        recipeShapeless(TWBlocks.FrostedCobblestone.get(), 4, TWBlocks.FrostedStone.get(), 4);
        recipeShapeless(TWBlocks.DeepFrostedCobblestone.get(), 4, TWBlocks.DeepFrostedStone.get(), 4);

        recipeFurnance(TWBlocks.FrostedCobblestone.get(), Items.COBBLESTONE, 0, 200);
        recipeFurnance(TWBlocks.FrostedStone.get(), Items.STONE, 0, 200);
        recipeFurnance(TWBlocks.DeepFrostedCobblestone.get().asItem(), Items.COBBLESTONE, 0, 400, true);
        recipeFurnance(TWBlocks.DeepFrostedStone.get().asItem(), Items.STONE, 0, 400, true);
    }

    private void recipeAll(ItemLike stair, ItemLike slab, ItemLike wall, ItemLike material, boolean hasStonecutting){
        recipeStairs(stair, material, hasStonecutting);
        recipeSlab(slab, material, hasStonecutting);
        recipeWall(wall, material, hasStonecutting);
    }
    private void recipeAll(ItemLike stair, ItemLike slab, ItemLike wall, ItemLike material, boolean hasStonecutting, ItemLike... addMats){
        recipeStairs(stair, material, hasStonecutting, addMats);
        recipeSlab(slab, material, addMats);
        recipeWall(wall, material, addMats);
    }

    protected void recipeStairs(ItemLike stair, ItemLike material, boolean hasStonecutting){
        stairBuilder(stair, Ingredient.of(material)).unlockedBy(getHasName(material), has(material)).save(consumer);
        if(hasStonecutting) {recipeStonecutting(stair, material);}
    }
    protected void recipeStairs(ItemLike stairs, ItemLike material, boolean hasStonecutting, ItemLike... addMats){
        recipeStairs(stairs, material, false);
        for (ItemLike item : addMats) {recipeStonecutting(stairs, item, hasStonecutting);}
    }

    protected void recipeSlab(ItemLike slab, ItemLike material, boolean hasStonecutting){
        slab(consumer, slab, material);
        if(hasStonecutting) {recipeStonecutting(slab, material, 2);}
    }
    protected void recipeSlab(ItemLike slab, ItemLike material, ItemLike... addMats){
        recipeSlab(slab, material, true);
        for (ItemLike item : addMats) {recipeStonecutting(slab, item, 2, true);}
    }

    protected void recipeWall(ItemLike wall, ItemLike material, boolean hasStonecutting){
        wall(consumer, wall, material);
        if(hasStonecutting) {recipeStonecutting(wall, material);}
    }
    protected void recipeWall(ItemLike wall, ItemLike material, boolean hasStonecutting, boolean addToID) {
        wallBuilder(wall, Ingredient.of(material)).unlockedBy(getHasName(material), has(material)).save(consumer, getConversionRecipeName(wall, material));
        if(hasStonecutting) {recipeStonecutting(wall, material);}
    }
    protected void recipeWall(ItemLike wall, ItemLike material, ItemLike... addMats) {
        recipeWall(wall, material, true);
        for (ItemLike item : addMats) {recipeStonecutting(wall, item, true);}
    }

    protected void recipeShapeless(ItemLike ingredient, ItemLike result, int amount) {recipeShapeless(ingredient, 1, result, amount);}
    protected void recipeShapeless(ItemLike ingredient, int amount, ItemLike result) {recipeShapeless(ingredient, amount, result, 1);}
    protected void recipeShapeless(ItemLike ingredient, int amountI, ItemLike result, int amountR) {ShapelessRecipeBuilder.shapeless(result, amountR).requires(ingredient, amountI).unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer);}
    protected void recipeShapeless(ItemLike ingredient, int amountI, ItemLike result, int amountR, boolean addToID) {ShapelessRecipeBuilder.shapeless(result, amountR).requires(ingredient, amountI).unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer, getConversionRecipeName(result, ingredient));}

    protected void recipeStonecutting(ItemLike result, ItemLike ingredient) {recipeStonecutting(result, ingredient, 1);}
    protected void recipeStonecutting(ItemLike result, ItemLike ingredient, int amount) {SingleItemRecipeBuilder.stonecutting(Ingredient.of(ingredient), result, amount).unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer, recipeID(result, "_stonecutting"));}
    protected void recipeStonecutting(ItemLike result, ItemLike ingredient, boolean addToID) {recipeStonecutting(result, ingredient, 1, addToID);}
    protected void recipeStonecutting(ItemLike result, ItemLike ingredient, int amount, boolean addToID) {SingleItemRecipeBuilder.stonecutting(Ingredient.of(ingredient), result, amount).unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer, getConversionRecipeName(result, ingredient) + "_stonecutting");}

    protected void recipeOreSmelting(ItemLike ore, ItemLike ingot) {
        recipeFurnance(ore, ingot, 0.7f, 200, "_smelting");
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ore), ingot, 0.7f, 100).unlockedBy(getHasName(ore), has(ore)).save(consumer, recipeID(ingot, "_blasting"));
    }
    protected void recipeOreSmelting(ItemLike ingredient, ItemLike result, String add) {
        recipeFurnance(ingredient, result, 0.7f, 200, "_smelting" + add);
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ingredient), result, 0.7f, 100).unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer, recipeID(result, "_blasting" + add));
    }
    protected void recipeFurnance(ItemLike ingredient, ItemLike result, float xp, int time) {SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient), result, xp, time).unlockedBy("has_item", has(ingredient)).save(consumer);}
    protected void recipeFurnance(ItemLike ingredient, ItemLike result, float xp, int time, boolean add) {recipeFurnance(ingredient, result, xp, time, "_from_" + getName(ingredient));}
    protected void recipeFurnance(ItemLike ingredient, ItemLike result, float xp, int time, String add) {SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient), result, xp, time).unlockedBy("has_item", has(ingredient)).save(consumer, recipeID(result, "_blasting" + add));}

    protected void recipeSword(TagKey<Item> material, ItemLike sword){
        ShapedRecipeBuilder.shaped(sword)
                .define('#', material)
                .define('-', Items.STICK)
                .pattern("#")
                .pattern("#")
                .pattern("-")
                .unlockedBy("has_item", has(material))
                .save(consumer);
    }

    private static ResourceLocation recipeID(ItemLike item) {return new ResourceLocation(TheWitcher.ModID, item.toString());}
    private static ResourceLocation recipeID(ItemLike item, String add) {
        return new ResourceLocation(TheWitcher.ModID, getName(item) + add);
    }

    protected static String getName(ItemLike itemLike){
        if(itemLike instanceof Item) {return Objects.requireNonNull(((Item) itemLike).getRegistryName()).getPath();}
        else if(itemLike instanceof Block) {return Objects.requireNonNull(((Block) itemLike).getRegistryName()).getPath();}
        else{
            TheWitcher.LOGGER.error("undefined recipe behaviour for " + itemLike.getClass());
            return itemLike.toString();
        }
    }
}