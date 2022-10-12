package com.barion.the_witcher.world;

import com.barion.the_witcher.TheWitcher;
import com.google.common.collect.ImmutableSet;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TWPOIs {
    public static final DeferredRegister<PoiType> Registry = DeferredRegister.create(ForgeRegistries.POI_TYPES, TheWitcher.ModID);

    public static final RegistryObject<PoiType> WhiteFrostPortal = Registry.register("white_frost_portal", ()-> new PoiType(ImmutableSet.copyOf(TWBlocks.WhiteFrostPortal.get().getStateDefinition().getPossibleStates()), 0, 1));
}