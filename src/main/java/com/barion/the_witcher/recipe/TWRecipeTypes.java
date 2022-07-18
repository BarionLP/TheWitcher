package com.barion.the_witcher.recipe;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.util.TWUtil;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = TheWitcher.ModID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TWRecipeTypes {
    public static final DeferredRegister<RecipeSerializer<?>> SerializerRegistry = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, TheWitcher.ModID);

    public static final RegistryObject<RecipeSerializer<TWMasterSmithingRecipe>> MasterSmithing = SerializerRegistry.register("master_smithing", () -> TWMasterSmithingRecipe.Serializer.Instance);

    @SubscribeEvent
    public static void registerRecipeTypes(final RegisterEvent event) {
        event.register(ForgeRegistries.Keys.RECIPE_TYPES, helper ->{
            helper.register(TWUtil.location(TWMasterSmithingRecipe.Type.ID), TWMasterSmithingRecipe.Type.Instance);
        });
    }
}