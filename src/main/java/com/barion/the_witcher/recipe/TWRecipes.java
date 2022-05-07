package com.barion.the_witcher.recipe;

import com.barion.the_witcher.TheWitcher;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = TheWitcher.ModID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TWRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> Registry = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, TheWitcher.ModID);

    public static final RegistryObject<RecipeSerializer<TWMasterSmithingRecipe>> MasterSmithing = Registry.register("master_smithing", () -> TWMasterSmithingRecipe.Serializer.Instance);

    @SubscribeEvent
    public static void registerRecipeTypes(final RegistryEvent.Register<RecipeSerializer<?>> event) {
        net.minecraft.core.Registry.register(net.minecraft.core.Registry.RECIPE_TYPE, TWMasterSmithingRecipe.Type.ID, TWMasterSmithingRecipe.Type.Instance);
    }
}