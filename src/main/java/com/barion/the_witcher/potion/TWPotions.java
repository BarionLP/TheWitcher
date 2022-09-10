package com.barion.the_witcher.potion;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.effect.TWEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TWPotions {
    public static final DeferredRegister<Potion> Registry = DeferredRegister.create(ForgeRegistries.POTIONS, TheWitcher.ModID);

    public static final RegistryObject<Potion> EnergyRegenPotion = Registry.register("energy_regen_potion", ()-> new Potion(new MobEffectInstance(TWEffects.EnergyRegen.get(), 6000, 0)));
    public static final RegistryObject<Potion> LongEnergyRegenPotion = Registry.register("long_energy_regen_potion", ()-> new Potion("energy_regen_potion", new MobEffectInstance(TWEffects.EnergyRegen.get(), 9000, 0)));
    public static final RegistryObject<Potion> StrongEnergyRegenPotion = Registry.register("strong_energy_regen_potion", ()-> new Potion("energy_regen_potion", new MobEffectInstance(TWEffects.EnergyRegen.get(), 6000, 1)));

    public static final RegistryObject<Potion> FrostResistancePotion = Registry.register("frost_resistance_potion", ()-> new Potion(new MobEffectInstance(TWEffects.FrostResistance.get(), 6000, 0)));
    public static final RegistryObject<Potion> LongFrostResistancePotion = Registry.register("long_frost_resistance_potion", ()-> new Potion("frost_resistance_potion", new MobEffectInstance(TWEffects.FrostResistance.get(), 9000, 0)));
}