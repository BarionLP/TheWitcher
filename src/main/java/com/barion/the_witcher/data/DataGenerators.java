package com.barion.the_witcher.data;

import com.barion.the_witcher.TheWitcher;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = TheWitcher.ModID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
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
        generator.addProvider(new TWLootTables(generator));
        generator.addProvider(new TWRecipes(generator));
        generator.addProvider(new TWEntityTags(generator, fileHelper));
    }
}