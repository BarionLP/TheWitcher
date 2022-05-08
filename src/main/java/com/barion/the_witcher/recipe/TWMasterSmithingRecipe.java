package com.barion.the_witcher.recipe;

import com.barion.the_witcher.util.TWUtil;
import com.barion.the_witcher.world.TWBlocks;
import com.barion.the_witcher.world.screen.TWMasterSmithingMenu;
import com.google.gson.JsonObject;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

public class TWMasterSmithingRecipe implements Recipe<Container> {
    private final ResourceLocation id;
    private final ItemStack output;
    private final Ingredient ingredient;
    private final int xpCost;

    public TWMasterSmithingRecipe(ResourceLocation id, ItemStack output, Ingredient ingredient, int xpCost) {
        this.id = id;
        this.output = output;
        this.ingredient = ingredient;
        this.xpCost = xpCost;
    }

    @Override @ParametersAreNonnullByDefault
    public boolean matches(Container container, Level level) {
        return ingredient.test(container.getItem(TWMasterSmithingMenu.InputSlot));
    }

    @Override
    public @NotNull ItemStack assemble(@NotNull Container container) {return output;}
    @Override
    public boolean canCraftInDimensions(int width, int height) {return true;}
    @Override
    public @NotNull ItemStack getResultItem() {return output.copy();}
    public int getXpCost() {return xpCost;}
    @Override
    public @NotNull ResourceLocation getId() {return id;}

    @Override
    public @NotNull ItemStack getToastSymbol() {return TWBlocks.MasterSmithingTable.get().asItem().getDefaultInstance();}

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {return Serializer.Instance;}
    public Ingredient getIngredient() {return ingredient;}
    @Override
    public @NotNull RecipeType<?> getType() {return Type.Instance;}

    public static class Type implements RecipeType<TWMasterSmithingRecipe> {
        private Type() { }
        public static final Type Instance = new Type();
        public static final String ID = "master_smithing";
    }

    public static class Serializer implements RecipeSerializer<TWMasterSmithingRecipe> {
        public static final Serializer Instance = new Serializer();
        public static final ResourceLocation ID = TWUtil.location("master_smithing");

        @Override @ParametersAreNonnullByDefault
        public @NotNull TWMasterSmithingRecipe fromJson(ResourceLocation id, JsonObject json) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "output"));
            Ingredient input = Ingredient.fromJson(GsonHelper.getAsJsonObject(json, "ingredient"));
            int xpCost = GsonHelper.getAsInt(json, "xp");

            return new TWMasterSmithingRecipe(id, output, input, xpCost);
        }

        @Override @ParametersAreNonnullByDefault
        public TWMasterSmithingRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            Ingredient input = Ingredient.fromNetwork(buf);
            ItemStack output = buf.readItem();
            int xpCost = buf.readInt();
            return new TWMasterSmithingRecipe(id, output, input, xpCost);
        }

        @Override
        public void toNetwork(@NotNull FriendlyByteBuf buf, TWMasterSmithingRecipe recipe) {
            recipe.getIngredient().toNetwork(buf);
            buf.writeItemStack(recipe.getResultItem(), false);
            buf.writeInt(recipe.getXpCost());
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
