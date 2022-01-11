package com.barion.the_witcher;

import com.barion.the_witcher.datagen.*;
import com.barion.the_witcher.world.TWBlocks;
import com.barion.the_witcher.world.TWItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(TheWitcher.ModID)
public class TheWitcher {
    public static final String ModID = "the_witcher";
    public static final Logger LOGGER = LogManager.getLogger();

    public TheWitcher() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

        Registers.Blocks.register(modBus);
        Registers.Items.register(modBus);
        Registers.Features.register(modBus);

        TWBlocks.init();
        TWItems.init();

        modBus.addListener(this::setup);

        final IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        forgeBus.register(this);
        forgeBus.addListener(TWEvents::onBiomeLoading);
    }

    private void setup(final FMLCommonSetupEvent event){TWEvents.registerOres();}

    @Mod.EventBusSubscriber(modid = TheWitcher.ModID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class DataGenerators {
        private DataGenerators() {}

        @SubscribeEvent
        public static void gatherData(GatherDataEvent event){
            DataGenerator generator = event.getGenerator();
            ExistingFileHelper fileHelper = event.getExistingFileHelper();
            generator.addProvider(new TWBlockModel(generator, fileHelper));
            generator.addProvider(new TWItemModel(generator, fileHelper));
            BlockTagsProvider blockTags = new TWBlockTags(generator, fileHelper);
            generator.addProvider(blockTags);
            generator.addProvider(new TWItemTags(generator, blockTags, fileHelper));
            generator.addProvider(new TWEntityTags(generator, fileHelper));
            generator.addProvider(new TWLootTables(generator));
            generator.addProvider(new TWRecipes(generator));
        }
    }

    public static class Registers{
        public static final DeferredRegister<Block> Blocks = DeferredRegister.create(ForgeRegistries.BLOCKS, ModID);
        public static final DeferredRegister<Item> Items = DeferredRegister.create(ForgeRegistries.ITEMS, ModID);
        public static final DeferredRegister<Feature<?>> Features = DeferredRegister.create(ForgeRegistries.FEATURES, ModID);
    }
}