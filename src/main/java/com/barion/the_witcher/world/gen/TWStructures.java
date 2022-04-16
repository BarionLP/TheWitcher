package com.barion.the_witcher.world.gen;

import com.barion.the_witcher.TWConfig;
import com.barion.the_witcher.TWUtil;
import com.barion.the_witcher.world.gen.structure.TWWitcherCitadelStructure;
import com.legacy.structure_gel.api.registry.registrar.StructureRegistrar;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class TWStructures {
    public static final StructureRegistrar<NoneFeatureConfiguration, TWWitcherCitadelStructure> WitcherCastle =
            StructureRegistrar.builder(TWUtil.location("witcher_citadel"), TWWitcherCitadelStructure::new)
                    .addPiece(TWWitcherCitadelStructure.Piece::new)
                    .pushConfigured(NoneFeatureConfiguration.INSTANCE)
                            .biomes(TWConfig.COMMON.WitcherCastleConfig.getConfigured())
                            .adaptNoise()
                    .popConfigured().build();

    @SubscribeEvent
    public static void register(final RegistryEvent.Register<StructureFeature<?>> event){
        IForgeRegistry<StructureFeature<?>> registry = event.getRegistry();
        WitcherCastle.handleForge(registry);
    }
}