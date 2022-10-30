package com.barion.the_witcher.fluid;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.world.TWBlocks;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TWFluids {
    public static final DeferredRegister<Fluid> Registry = DeferredRegister.create(ForgeRegistries.FLUIDS, TheWitcher.ModID);

    public static final RegistryObject<FlowingFluid> AcidSource = Registry.register("soap_water_fluid",
            () -> new ForgeFlowingFluid.Source(TWFluids.AcidProperties));
    public static final RegistryObject<FlowingFluid> AcidFlowing = Registry.register("flowing_soap_water",
            () -> new ForgeFlowingFluid.Flowing(TWFluids.AcidProperties));

    private static final ForgeFlowingFluid.Properties AcidProperties = new ForgeFlowingFluid.Properties(
            TWFluidTypes.Acid, AcidSource, AcidFlowing)
            .slopeFindDistance(4).levelDecreasePerBlock(1).block(TWBlocks.Acid);
//            .bucket(TWItems.AcidBucket);
}