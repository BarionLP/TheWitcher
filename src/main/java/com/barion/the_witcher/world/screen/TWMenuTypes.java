package com.barion.the_witcher.world.screen;

import com.barion.the_witcher.TheWitcher;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TWMenuTypes {
    public static final DeferredRegister<MenuType<?>> Registry = DeferredRegister.create(ForgeRegistries.CONTAINERS, TheWitcher.ModID);

    public static final RegistryObject<MenuType<TWMasterSmithingTableMenu>> MasterSmithingTableMenu = register("master_smithing_table_menu", TWMasterSmithingTableMenu::new);

    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> register(String name, IContainerFactory<T> factory) {
        return Registry.register(name, () -> IForgeMenuType.create(factory));
    }
}