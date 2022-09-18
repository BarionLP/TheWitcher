package com.barion.the_witcher.effect;

import com.ametrinstudios.ametrin.world.effect.ExternalEffect;
import com.barion.the_witcher.TheWitcher;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.awt.*;

public class TWEffects {
    public static final DeferredRegister<MobEffect> Registry = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, TheWitcher.ModID);

    public static final RegistryObject<ExternalEffect> EnergyRegen = Registry.register("energy_regen", ()-> new TWExternalEffect(MobEffectCategory.BENEFICIAL, new Color(255, 255, 155)));
    public static final RegistryObject<ExternalEffect> FrostResistance = Registry.register("frost_resistance", ()-> new TWExternalEffect(MobEffectCategory.BENEFICIAL, new Color(168, 255, 255)));
}