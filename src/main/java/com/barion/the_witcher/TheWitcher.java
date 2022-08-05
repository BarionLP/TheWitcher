package com.barion.the_witcher;

import com.barion.the_witcher.datagen.*;
import com.barion.the_witcher.networking.TWMessages;
import com.barion.the_witcher.recipe.TWRecipeTypes;
import com.barion.the_witcher.util.TWConfig;
import com.barion.the_witcher.world.TWBlocks;
import com.barion.the_witcher.world.TWEntities;
import com.barion.the_witcher.world.TWItems;
import com.barion.the_witcher.world.block.entity.TWBlockEntities;
import com.barion.the_witcher.world.gen.TWFeatures;
import com.barion.the_witcher.world.gen.TWStructures;
import com.barion.the_witcher.world.screen.TWMenuTypes;
import com.legacy.structure_gel.api.registry.registrar.RegistrarHandler;
import com.mojang.logging.LogUtils;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(TheWitcher.ModID)
public class TheWitcher {
    public static final String ModID = "the_witcher";
    @Deprecated(forRemoval = true) public static final Logger Logger = LogUtils.getLogger();

    public TheWitcher() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, TWConfig.CommonSpec);

        final IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        TWItems.Registry.register(modBus);
        TWBlocks.Registry.register(modBus);
        TWEntities.Registry.register(modBus);
        TWFeatures.Registry.register(modBus);
        TWBlockEntities.Registry.register(modBus);
        TWMenuTypes.Registry.register(modBus);
        TWRecipeTypes.Registry.register(modBus);

        modBus.addListener(this::setup);
        modBus.addListener(TWRecipeTypes::registerRecipeTypes);
        modBus.addListener(TWEntities::registerAttributes);
        TWStructures.init();

        final IEventBus forgeBus = MinecraftForge.EVENT_BUS;

        RegistrarHandler.registerHandlers(ModID, modBus);
    }

    private void setup(final FMLCommonSetupEvent event){
        event.enqueueWork(()-> {
            TWMessages.register();
        });
    }

    @Mod.EventBusSubscriber(modid = TheWitcher.ModID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class DataGenerators {
        private DataGenerators() {}

        @SubscribeEvent
        public static void gatherData(GatherDataEvent event){
            DataGenerator generator = event.getGenerator();
            ExistingFileHelper exFileHelper = event.getExistingFileHelper();
            generator.addProvider(true, new TWBlockStateProvider(generator, exFileHelper));
            generator.addProvider(true, new TWItemModelProvider(generator, exFileHelper));
            BlockTagsProvider blockTags = new TWBlockTagsProvider(generator, exFileHelper);
            generator.addProvider(true, blockTags);
            generator.addProvider(true, new TWItemTagsProvider(generator, blockTags, exFileHelper));
            generator.addProvider(true, new TWEntityTypeTagsProvider(generator, exFileHelper));
            generator.addProvider(true, new TWBiomeTagsProvider(generator, exFileHelper));
            generator.addProvider(true, new TWLootTableProvider(generator));
            generator.addProvider(true, new TWRecipeProvider(generator));
        }
    }
}