package com.barion.the_witcher.world.gen;

import com.barion.the_witcher.util.TWConfig;
import com.barion.the_witcher.util.TWTags;
import com.barion.the_witcher.util.TWUtil;
import com.barion.the_witcher.world.gen.structure.TWIcyRuinStructure;
import com.barion.the_witcher.world.gen.structure.TWWitcherCitadelStructure;
import com.legacy.structure_gel.api.registry.registrar.StructureRegistrar;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class TWStructures {
    public static final StructureRegistrar<NoneFeatureConfiguration, TWWitcherCitadelStructure> WitcherCastle =
            StructureRegistrar.builder(TWUtil.location("witcher_citadel"), TWWitcherCitadelStructure::new)
                    .addPiece(TWWitcherCitadelStructure.Piece::new)
                    .pushConfigured(NoneFeatureConfiguration.INSTANCE)
                            .biomes(TWConfig.COMMON.WitcherCitadelConfig.getConfigured())
                            .dimensions(Level.OVERWORLD)
                            .adaptNoise()
                    .popConfigured().build();

    public static final StructureRegistrar<NoneFeatureConfiguration, TWIcyRuinStructure> IcyRuin =
            StructureRegistrar.builder(TWUtil.location("icy_ruin"), TWIcyRuinStructure::new)
                    .addPiece(TWIcyRuinStructure.Piece::new)
                    .pushConfigured(NoneFeatureConfiguration.INSTANCE)
                            .biomes(TWTags.Biomes.hasIcyRuin)
                            .dimensions(TWLevels.WhiteFrost)
                    .popConfigured().build();

    @SubscribeEvent
    public static void register(final RegistryEvent.Register<StructureFeature<?>> event){
        IForgeRegistry<Structure> registry = event.getRegistry();
        WitcherCastle.handleForge(registry);
        IcyRuin.handleForge(registry);
    }
}