package com.barion.the_witcher.recipe;

import com.barion.the_witcher.util.TWUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

public class TWMasterSmithingTableRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    private final ItemStack output;
    private final NonNullList<Ingredient> recipeItems;

    public TWMasterSmithingTableRecipe(ResourceLocation id, ItemStack output, NonNullList<Ingredient> recipeItems) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
    }

    @Override @ParametersAreNonnullByDefault
    public boolean matches(SimpleContainer container, Level level) {
        return recipeItems.get(0).test(container.getItem(0));
    }

    @Override
    public @NotNull ItemStack assemble(@NotNull SimpleContainer container) {return output;}

    @Override
    public boolean canCraftInDimensions(int width, int height) {return true;}

    @Override
    public @NotNull ItemStack getResultItem() {return output.copy();}

    @Override
    public @NotNull ResourceLocation getId() {return id;}

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {return Serializer.Instance;}

    @Override
    public @NotNull RecipeType<?> getType() {return Type.Instance;}

    public static class Type implements RecipeType<TWMasterSmithingTableRecipe> {
        private Type() { }
        public static final Type Instance = new Type();
        public static final String ID = "master_smithing";
    }

    public static class Serializer implements RecipeSerializer<TWMasterSmithingTableRecipe> {
        public static final Serializer Instance = new Serializer();
        public static final ResourceLocation ID = TWUtil.location("master_smithing");

        @Override @ParametersAreNonnullByDefault
        public @NotNull TWMasterSmithingTableRecipe fromJson(ResourceLocation id, JsonObject json) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "output"));

            JsonArray ingredients = GsonHelper.getAsJsonArray(json, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(1, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new TWMasterSmithingTableRecipe(id, output, inputs);
        }

        @Override
        public TWMasterSmithingTableRecipe fromNetwork(@NotNull ResourceLocation id, FriendlyByteBuf buf) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(buf));
            }

            ItemStack output = buf.readItem();
            return new TWMasterSmithingTableRecipe(id, output, inputs);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, TWMasterSmithingTableRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());
            for (Ingredient ingredient : recipe.getIngredients()) {
                ingredient.toNetwork(buf);
            }
            buf.writeItemStack(recipe.getResultItem(), false);
        }

        @Override
        public RecipeSerializer<?> setRegistryName(ResourceLocation name) {return Instance;}

        @Override @Nullable
        public ResourceLocation getRegistryName() {return ID;}

        @Override
        public Class<RecipeSerializer<?>> getRegistryType() {
            return Serializer.castClass(RecipeSerializer.class);
        }

        @SuppressWarnings("unchecked") // Need this wrapper, because generics
        private static <G> Class<G> castClass(Class<?> cls) {
            return (Class<G>)cls;
        }
    }
}
