package com.barion.the_witcher.data;

import com.barion.the_witcher.TWBlocks;
import com.barion.the_witcher.TWItems;
import com.barion.the_witcher.TWTags;
import com.barion.the_witcher.TheWitcher;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Consumer;

public class TWRecipes extends RecipeProvider {
    private Consumer<FinishedRecipe> consumer;

    public TWRecipes(DataGenerator generator){super(generator);}

    @Override @ParametersAreNonnullByDefault
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        this.consumer = consumer;
        recipeOreSmelting(TWBlocks.SilverOre.get().asItem(), TWItems.SilverIngot.get(), "_from_silver_ore");
        recipeOreSmelting(TWBlocks.DeepslateSilverOre.get().asItem(), TWItems.SilverIngot.get(), "_from_deepslate_silver_ore");
        recipeOreSmelting(TWItems.RawSilver.get(), TWItems.SilverIngot.get());
        recipeShapeless(TWItems.SilverIngot.get(), TWItems.SilverNugget.get(), 9);
        recipeShapeless(TWItems.SilverNugget.get(), 9, TWItems.SilverIngot.get());
        recipeShapeless(TWBlocks.SilverBlock.get().asItem(), TWItems.SilverIngot.get(), 9, "_from_silver_block");
        recipeShapeless(TWItems.SilverIngot.get(), 9, TWBlocks.SilverBlock.get().asItem());
        recipeShapeless(TWBlocks.RawSilverBlock.get().asItem(), TWItems.RawSilver.get(), 9);
        recipeShapeless(TWItems.RawSilver.get(), 9, TWBlocks.RawSilverBlock.get().asItem());
        ShapedRecipeBuilder.shaped(TWItems.SilverSword.get())
                .define('#', TWItems.SilverIngot.get())
                .define('+', TWItems.SteelIngot.get())
                .define('-', Items.STICK)
                .pattern("#")
                .pattern("+")
                .pattern("-")
                .unlockedBy("has_item", has(TWItems.SilverIngot.get()))
                .save(consumer);

        recipeShapeless(TWItems.SteelIngot.get(), TWItems.SteelNugget.get(), 9);
        recipeShapeless(TWItems.SteelNugget.get(), 9, TWItems.SteelIngot.get());
        recipeSword(TWTags.Items.SteelIngots, TWItems.SteelSword.get());
    }

    protected void recipeShapeless(Item ingredient, Item result, int amount){
        ShapelessRecipeBuilder.shapeless(result, amount).requires(ingredient).unlockedBy("has_item", has(ingredient)).save(consumer);
    }
    protected void recipeShapeless(Item ingredient, int amount, Item result){
        ShapelessRecipeBuilder.shapeless(result).requires(ingredient, amount).unlockedBy("has_item", has(ingredient)).save(consumer);
    }
    protected void recipeShapeless(Item ingredient, Item result, int amount, String add){
        ShapelessRecipeBuilder.shapeless(result, amount).requires(ingredient).unlockedBy("has_item", has(ingredient)).save(consumer, recipeID(result, add));
    }
    protected void recipeShapeless(Item ingredient, int amount, Item result, String add){
        ShapelessRecipeBuilder.shapeless(result).requires(ingredient, amount).unlockedBy("has_item", has(ingredient)).save(consumer, recipeID(result, add));
    }
    protected void recipeOreSmelting(Item ingredient, Item result) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient), result, 0.7f, 200).unlockedBy("has_item", has(ingredient)).save(consumer, recipeID(result, "_smelting"));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ingredient), result, 0.7f, 100).unlockedBy("has_item", has(ingredient)).save(consumer, recipeID(result, "_blasting"));
    }
    protected void recipeOreSmelting(Item ingredient, Item result, String add) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient), result, 1F, 200).unlockedBy("has_item", has(ingredient)).save(consumer, recipeID(result, "_smelting" + add));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ingredient), result, 1F, 100).unlockedBy("has_item", has(ingredient)).save(consumer, recipeID(result, "_blasting" + add));
    }
    protected void recipeSword(Tag.Named<Item> material, Item sword){
        ShapedRecipeBuilder.shaped(sword)
                .define('#', material)
                .define('-', Items.STICK)
                .pattern("#")
                .pattern("#")
                .pattern("-")
                .unlockedBy("has_item", has(material))
                .save(consumer);
    }


    private static ResourceLocation recipeID(Item item) { return new ResourceLocation(TheWitcher.ModID, item.toString());}
    private static ResourceLocation recipeID(Item item, String add) { return new ResourceLocation(TheWitcher.ModID, item.toString() + add);}
}