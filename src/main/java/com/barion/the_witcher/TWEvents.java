package com.barion.the_witcher;

import com.barion.the_witcher.stuff.TWBlocks;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RangeDecoratorConfiguration;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class TWEvents {
    private static BiomeLoadingEvent event;

    @SubscribeEvent
    public static void addOres(final BiomeLoadingEvent event){
        TWEvents.event = event;
        TheWitcher.LOGGER.debug("ores");
        addOre(new TagMatchTest(BlockTags.BASE_STONE_OVERWORLD), TWBlocks.SilverOre.get().defaultBlockState(), 5, 30, 50, 2);
    }

    private static void addOre(RuleTest rule, BlockState state, int veinSize, int minHeight, int maxHeight, int amount){
        event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES,
                Feature.ORE.configured(new OreConfiguration(rule, state, veinSize)).range(new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight)))).squared().count(amount));
    }
}