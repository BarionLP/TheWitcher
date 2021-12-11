package com.barion.the_witcher;

import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashSet;
import java.util.List;

public class TWEvents {
    private static final HashSet<PlacedFeature> FEATURES = new HashSet<>();

    public static void registerOres(){
        addOre("silver_ore", TWBlocks.SilverOre, TWBlocks.DeepslateSilverOre, 3, -20, 20, 2);
    }


    @SubscribeEvent
    public static void addOres(final BiomeLoadingEvent event){
        if(event.getCategory() != Biome.BiomeCategory.NETHER && event.getCategory() != Biome.BiomeCategory.THEEND)
            for(PlacedFeature feature : FEATURES)
                event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, feature);
    }

    private static void addOre(String name, RegistryObject<Block> ore, RegistryObject<Block> deepOre, int veinSize, int minHeight, int maxHeight, int vinesPerChunk){
        FEATURES.add(PlacementUtils.register(TheWitcher.ModID + ":" + name, FeatureUtils.register(TheWitcher.ModID + ":" + name, Feature.ORE.configured(new OreConfiguration(getOreMatchFor(ore, deepOre), veinSize))).placed(getPlaceSettings(minHeight, maxHeight, vinesPerChunk))));
    }

    private static List<OreConfiguration.TargetBlockState> getOreMatchFor(RegistryObject<Block> ore, RegistryObject<Block> deepOre){
        return List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ore.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, deepOre.get().defaultBlockState()));
    }

    private static List<PlacementModifier> getPlaceSettings(int minHeight, int maxHeight, int vinesPerChunk){
        return List.of(CountPlacement.of(vinesPerChunk), InSquarePlacement.spread(), HeightRangePlacement.triangle(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight)));
    }
}