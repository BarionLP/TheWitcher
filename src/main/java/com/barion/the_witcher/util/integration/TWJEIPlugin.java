package com.barion.the_witcher.util.integration;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.recipe.TWMasterSmithingRecipe;
import com.barion.the_witcher.util.TWUtil;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class TWJEIPlugin implements IModPlugin {
    public static final RecipeType<TWMasterSmithingRecipe> MasterSmithing = RecipeType.create(TheWitcher.ModID, "master_smithing", TWMasterSmithingRecipe.class);
    @Override
    public @NotNull ResourceLocation getPluginUid() {return TWUtil.location("jei_plugin");}

    @Override
    public void registerCategories(@NotNull IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new TWMasterSmithingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(@NotNull IRecipeRegistration registration) {
        RecipeManager manager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
        List<TWMasterSmithingRecipe> recipes = manager.getAllRecipesFor(TWMasterSmithingRecipe.Type.Instance);
        registration.addRecipes(new RecipeType<>(TWMasterSmithingRecipeCategory.UID, TWMasterSmithingRecipe.class), recipes);
    }
}