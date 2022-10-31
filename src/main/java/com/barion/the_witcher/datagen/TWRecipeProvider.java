package com.barion.the_witcher.datagen;

import com.ametrinstudios.ametrin.datagen.ExtendedRecipeProvider;
import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.util.TWTags;
import com.barion.the_witcher.world.TWBlocks;
import com.barion.the_witcher.world.TWItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Consumer;

public class TWRecipeProvider extends ExtendedRecipeProvider {
    public TWRecipeProvider(DataGenerator generator) {super(generator, TheWitcher.ModID);}

    @Override @ParametersAreNonnullByDefault
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        oreSmelting(consumer, TWItems.SilverIngot.get(), TWItems.RawSilver.get());
        nineBlockStorage(consumer, TWItems.SilverIngot.get(), TWBlocks.SilverBlock.get());
        nineBlockStorage(consumer, TWItems.SilverNugget.get(), TWItems.SilverIngot.get());
        nineBlockStorage(consumer, TWItems.RawSilver.get(), TWBlocks.RawSilverBlock.get());
        nineBlockStorage(consumer, TWItems.SteelNugget.get(), TWItems.SteelIngot.get());

        {ShapedRecipeBuilder.shaped(TWItems.SilverSword.get())
                .define('#', TWTags.Items.SilverIngots)
                .define('+', TWTags.Items.SteelIngots)
                .define('-', Items.STICK)
                .pattern("#")
                .pattern("+")
                .pattern("-")
                .unlockedBy("has_silver_ingot", has(TWTags.Items.SilverIngots))
                .save(consumer);} // Silver Sword
        sword(consumer, TWItems.SteelSword.get(), TWTags.Items.SteelIngots);

        stairSlabWallButton(consumer, TWBlocks.FrostedCobblestoneStairs.get(), TWBlocks.FrostedCobblestoneSlab.get(), TWBlocks.FrostedCobblestoneWall.get(), TWBlocks.FrostedCobblestoneButton.get(), TWBlocks.FrostedCobblestone.get(), TWBlocks.FrostedStone.get());
        stairSlabWallButton(consumer, TWBlocks.FrostedStoneStairs.get(), TWBlocks.FrostedStoneSlab.get(), TWBlocks.FrostedStoneWall.get(), TWBlocks.FrostedStoneButton.get(), TWBlocks.FrostedStone.get(), true);
        stairSlabWallButton(consumer, TWBlocks.FrostedStoneBrickStairs.get(), TWBlocks.FrostedStoneBrickSlab.get(), TWBlocks.FrostedStoneBrickWall.get(), TWBlocks.FrostedStoneBrickButton.get(), TWBlocks.FrostedStoneBricks.get(), TWBlocks.FrostedStone.get(), TWBlocks.FrostedCobblestone.get());
        stairSlabWallButton(consumer, TWBlocks.CrackedFrostedStoneBrickStairs.get(), TWBlocks.CrackedFrostedStoneBrickSlab.get(), TWBlocks.CrackedFrostedStoneBrickWall.get(), TWBlocks.CrackedFrostedStoneBrickButton.get(), TWBlocks.CrackedFrostedStoneBricks.get(), TWBlocks.FrostedStoneBricks.get(), TWBlocks.FrostedStone.get(), TWBlocks.FrostedCobblestone.get());
        stairSlabWallButton(consumer, TWBlocks.DeepFrostedCobblestoneStairs.get(), TWBlocks.DeepFrostedCobblestoneSlab.get(), TWBlocks.DeepFrostedCobblestoneWall.get(), TWBlocks.DeepFrostedCobblestoneButton.get(), TWBlocks.DeepFrostedCobblestone.get(), TWBlocks.DeepFrostedStone.get());
        stairSlabWallButton(consumer, TWBlocks.DeepFrostedStoneStairs.get(), TWBlocks.DeepFrostedStoneSlab.get(), TWBlocks.DeepFrostedStoneWall.get(), TWBlocks.DeepFrostedStoneButton.get(), TWBlocks.DeepFrostedStone.get(), true);
        stairSlabWallButton(consumer, TWBlocks.DeepFrostedStoneBrickStairs.get(), TWBlocks.DeepFrostedStoneBrickSlab.get(), TWBlocks.DeepFrostedStoneBrickWall.get(), TWBlocks.DeepFrostedStoneBrickButton.get(), TWBlocks.DeepFrostedStoneBricks.get(), TWBlocks.DeepFrostedCobblestone.get(), TWBlocks.DeepFrostedStone.get());
        stairSlabWallButton(consumer, TWBlocks.DeepFrostedStoneTileStairs.get(), TWBlocks.DeepFrostedStoneTileSlab.get(), TWBlocks.DeepFrostedStoneTileWall.get(), TWBlocks.DeepFrostedStoneTileButton.get(), TWBlocks.DeepFrostedStoneTiles.get(), TWBlocks.DeepFrostedCobblestone.get(), TWBlocks.DeepFrostedStone.get(), TWBlocks.DeepFrostedStoneBricks.get());

        shapeless(consumer, TWBlocks.FrostedStone.get(), 4, TWBlocks.FrostedCobblestone.get(), 4);
        shapeless(consumer, TWBlocks.DeepFrostedStone.get(), 4, TWBlocks.DeepFrostedCobblestone.get(), 4);

        float xp = 0.1f;
        int time = 200;

        smelting(consumer, Items.COBBLESTONE, TWBlocks.FrostedCobblestone.get(), xp, time);
        smelting(consumer, Items.COBBLESTONE_STAIRS, TWBlocks.FrostedCobblestoneStairs.get(), xp, time);
        smelting(consumer, Items.COBBLESTONE_SLAB, TWBlocks.FrostedCobblestoneSlab.get(), xp/2, time);
        smelting(consumer, Items.COBBLESTONE_WALL, TWBlocks.FrostedCobblestoneWall.get(), xp, time);
        smelting(consumer, Items.STONE, TWBlocks.FrostedStone.get(), xp, time);
        smelting(consumer, Items.STONE_STAIRS, TWBlocks.FrostedStoneStairs.get(), xp, time);
        smelting(consumer, Items.STONE_SLAB, TWBlocks.FrostedStoneSlab.get(), xp/2, time);
        smelting(consumer, Items.STONE_BUTTON, TWBlocks.FrostedStoneButton.get(), xp, time);
        smelting(consumer, Items.STONE_BRICKS, TWBlocks.FrostedStoneBricks.get(), xp, time);
        smelting(consumer, Items.STONE_BRICK_STAIRS, TWBlocks.FrostedStoneBrickStairs.get(), xp, time);
        smelting(consumer, Items.STONE_BRICK_SLAB, TWBlocks.FrostedStoneBrickSlab.get(), xp/2, time);
        smelting(consumer, Items.STONE_BRICK_WALL, TWBlocks.FrostedStoneBrickWall.get(), xp, time);
        smelting(consumer, Items.CRACKED_STONE_BRICKS, TWBlocks.CrackedFrostedStoneBricks.get(), xp, time);

        smelting(consumer, Items.COBBLED_DEEPSLATE, TWBlocks.DeepFrostedCobblestone.get(), xp*2, time*2);
        smelting(consumer, Items.COBBLED_DEEPSLATE_STAIRS, TWBlocks.DeepFrostedCobblestoneStairs.get(), xp*2, time*2);
        smelting(consumer, Items.COBBLED_DEEPSLATE_SLAB, TWBlocks.DeepFrostedCobblestoneSlab.get(), xp, time*2);
        smelting(consumer, Items.COBBLED_DEEPSLATE_WALL, TWBlocks.DeepFrostedCobblestoneWall.get(), xp*2, time*2);
        smelting(consumer, Items.DEEPSLATE, TWBlocks.DeepFrostedStone.get(), xp*2, time*2);
        smelting(consumer, Items.DEEPSLATE_BRICKS, TWBlocks.DeepFrostedStoneBricks.get(), xp*2, time*2);
        smelting(consumer, Items.DEEPSLATE_BRICK_STAIRS, TWBlocks.DeepFrostedStoneBrickStairs.get(), xp*2, time*2);
        smelting(consumer, Items.DEEPSLATE_BRICK_SLAB, TWBlocks.DeepFrostedStoneBrickSlab.get(), xp, time*2);
        smelting(consumer, Items.DEEPSLATE_BRICK_WALL, TWBlocks.DeepFrostedStoneBrickWall.get(), xp*2, time*2);
        smelting(consumer, Items.CRACKED_DEEPSLATE_BRICKS, TWBlocks.CrackedDeepFrostedStoneBricks.get(), xp*2, time*2);
        smelting(consumer, Items.DEEPSLATE_TILES, TWBlocks.DeepFrostedStoneTiles.get(), xp*2, time*2);
        smelting(consumer, Items.DEEPSLATE_TILE_STAIRS, TWBlocks.DeepFrostedStoneTileStairs.get(), xp*2, time*2);
        smelting(consumer, Items.DEEPSLATE_TILE_SLAB, TWBlocks.DeepFrostedStoneTileSlab.get(), xp, time*2);
        smelting(consumer, Items.DEEPSLATE_TILE_WALL, TWBlocks.DeepFrostedStoneTileWall.get(), xp*2, time*2);
        smelting(consumer, Items.CRACKED_DEEPSLATE_TILES, TWBlocks.CrackedDeepFrostedStoneTiles.get(), xp*2, time*2);

        ShapelessRecipeBuilder.shapeless(TWItems.Beer.get())
                .requires(Ingredient.of(TWTags.Items.BrewBeer), 4)
                .requires(Ingredient.of(TWItems.HotWaterBottle.get()))
                .unlockedBy(getHasName(TWItems.HotWaterBottle.get()), has(TWItems.HotWaterBottle.get()))
                .save(consumer, recipeID(TWItems.Beer.get(), TWItems.HotWaterBottle.get()));

        smelting(consumer, TWItems.HotWaterBottle.get(), Items.POTION, 0.1f, 200);
        smoking(consumer, TWItems.HotWaterBottle.get(), Items.POTION, 0.1f, 200);

        stairSlabWallButton(consumer, TWBlocks.HallucinatedStoneStairs.get(), TWBlocks.HallucinatedStoneSlab.get(), TWBlocks.HallucinatedStoneWall.get(), TWBlocks.HallucinatedStoneButton.get(), TWBlocks.HallucinatedStoneStairs.get());
    }
}