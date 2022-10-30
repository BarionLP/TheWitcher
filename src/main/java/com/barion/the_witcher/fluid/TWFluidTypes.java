package com.barion.the_witcher.fluid;

import com.ametrinstudios.ametrin.fluid.SimpleFluidType;
import com.barion.the_witcher.TheWitcher;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.awt.*;

public class TWFluidTypes {
    public static final DeferredRegister<FluidType> Registry = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, TheWitcher.ModID);

    public static final RegistryObject<FluidType> Acid = register("acid", FluidType.Properties.create().canConvertToSource(true).lightLevel(5).supportsBoating(true));

    private static RegistryObject<FluidType> register(String name, FluidType.Properties properties) {
        return Registry.register(name, () -> new SimpleFluidType(new Color(136, 255, 0, 209), new Color(136, 255, 0), properties));
    }
}