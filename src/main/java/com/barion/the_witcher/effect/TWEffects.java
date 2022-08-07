package com.barion.the_witcher.effect;

import com.barion.the_witcher.TheWitcher;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TWEffects {
    public static final DeferredRegister<MobEffect> Registry = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, TheWitcher.ModID);

    public static final RegistryObject<TWEnergyRegenEffect> EnergyRegen = Registry.register("energy_regen", TWEnergyRegenEffect::new);
}