package com.barion.the_witcher;

import com.barion.the_witcher.stuff.TWBlocks;
import com.barion.the_witcher.stuff.TWItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(TheWitcher.ModID)
public class TheWitcher {
    public static final String ModID = "the_witcher";
    public static final Logger LOGGER = LogManager.getLogger();

    public TheWitcher() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

        TWBlocks.Blocks.register(modBus);
        TWItems.Items.register(modBus);

        final IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        forgeBus.register(this);
        forgeBus.register(TWEvents.class);
    }

}