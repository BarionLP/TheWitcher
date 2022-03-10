package com.barion.the_witcher.datagen;

import com.barion.the_witcher.TWTags;
import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.world.TWBlocks;
import com.barion.the_witcher.world.TWItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

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
        recipeShapeless(TWBlocks.SilverBlock.get(), TWItems.SilverIngot.get(), 9, "_from_silver_block");
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
                .unlockedBy("has_item", has(TWItems.SilverIngot.get()))
                .save(consumer);} // Silver Sword
        recipeSword(TWTags.Items.SteelIngots, TWItems.SteelSword.get());

        recipeShapeless(TWBlocks.FrostedCobblestone.get(), 4, TWBlocks.FrostedStone.get(), 4);
        recipeShapeless(TWBlocks.DeepFrostedCobblestone.get(), 4, TWBlocks.DeepFrostedStone.get(), 4);

        recipeFurnance(TWBlocks.FrostedCobblestone.get(), Items.COBBLESTONE, 0, 200);
        recipeFurnance(TWBlocks.FrostedStone.get(), Items.STONE, 0, 200);
        recipeFurnance(TWBlocks.DeepFrostedCobblestone.get().asItem(), Items.COBBLESTONE, 0, 400, true);
        recipeFurnance(TWBlocks.DeepFrostedStone.get().asItem(), Items.STONE, 0, 400, true);
    }

    protected void recipeShapeless(ItemLike ingredient, ItemLike result, int amount){
        ShapelessRecipeBuilder.shapeless(result, amount).requires(ingredient).unlockedBy("has_item", has(ingredient)).save(consumer);
    }
    protected void recipeShapeless(ItemLike ingredient, int amount, ItemLike result){
        ShapelessRecipeBuilder.shapeless(result).requires(ingredient, amount).unlockedBy("has_item", has(ingredient)).save(consumer);
    }
    protected void recipeShapeless(ItemLike ingredient, int amountI, ItemLike result, int amountR){
        ShapelessRecipeBuilder.shapeless(result, amountR).requires(ingredient, amountI).unlockedBy("has_item", has(ingredient)).save(consumer);
    }
    protected void recipeShapeless(ItemLike ingredient, ItemLike result, int amount, String add){
        ShapelessRecipeBuilder.shapeless(result, amount).requires(ingredient).unlockedBy("has_item", has(ingredient)).save(consumer, recipeID(result, add));
    }
    protected void recipeShapeless(ItemLike ingredient, int amount, ItemLike result, String add){
        ShapelessRecipeBuilder.shapeless(result).requires(ingredient, amount).unlockedBy("has_item", has(ingredient)).save(consumer, recipeID(result, add));
    }
    protected void recipeOreSmelting(ItemLike ore, ItemLike ingot) {
        recipeFurnance(ore, ingot, 0.7f, 200, "_smelting");
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ore), ingot, 0.7f, 100).unlockedBy("has_item", has(ore)).save(consumer, recipeID(ingot, "_blasting"));
    }
    protected void recipeOreSmelting(ItemLike ingredient, ItemLike result, String add) {
        recipeFurnance(ingredient, result, 0.7f, 200, "_smelting" + add);
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ingredient), result, 0.7f, 100).unlockedBy("has_item", has(ingredient)).save(consumer, recipeID(result, "_blasting" + add));
    }

    protected void recipeFurnance(ItemLike ingredient, ItemLike result, float xp, int time){
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient), result, xp, time).unlockedBy("has_item", has(ingredient)).save(consumer);
    }
    protected void recipeFurnance(Item ingredient, ItemLike result, float xp, int time, boolean add){
        recipeFurnance(ingredient, result, xp, time, "_from_" + Objects.requireNonNull(ingredient.getRegistryName()).getPath());
    }
    protected void recipeFurnance(ItemLike ingredient, ItemLike result, float xp, int time, String add){
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient), result, xp, time).unlockedBy("has_item", has(ingredient)).save(consumer, recipeID(result, "_blasting" + add));
    }

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
    private static ResourceLocation recipeID(ItemLike item, String add) {return new ResourceLocation(TheWitcher.ModID, item.toString() + add);}

    private static InventoryChangeTrigger.TriggerInstance has(TagKey<Item> tag) {
        return inventoryTrigger(ItemPredicate.Builder.item().of(tag).build());
    }
}