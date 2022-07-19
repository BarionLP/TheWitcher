package com.barion.the_witcher.world.gen;

import com.barion.the_witcher.util.TWConfig;
import com.barion.the_witcher.util.TWTags;
import com.barion.the_witcher.util.TWUtil;
import com.barion.the_witcher.world.gen.structure.TWIcyRuinStructure;
import com.barion.the_witcher.world.gen.structure.TWWitcherCitadelStructure;
import com.legacy.structure_gel.api.registry.registrar.StructureRegistrar;
import com.legacy.structure_gel.api.structure.GridStructurePlacement;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;

public class TWStructures {
    private TWStructures() {}

    public static void init() {}

    public static final StructureRegistrar<TWWitcherCitadelStructure> WitcherCitadel;
    public static final StructureRegistrar<TWIcyRuinStructure> IcyRuin;


    static {
        WitcherCitadel = StructureRegistrar.builder(TWUtil.location("witcher_citadel"), ()-> ()-> TWWitcherCitadelStructure.Codec)
                .addPiece(()-> TWWitcherCitadelStructure.Piece::new)
                .pushStructure(TWWitcherCitadelStructure::new)
                        .biomes(()-> TWConfig.COMMON.WitcherCitadelConfig.getStructure().getBiomes())
                        .dimensions(Level.OVERWORLD)
                        .lakeProof(true)
                        .terrainAdjustment(TerrainAdjustment.BEARD_THIN)
                .popStructure()
                .placement(()-> GridStructurePlacement.builder(72, 48).allowedNearSpawn(false).build(TWUtil.location("witcher_citadel")))
                .build();

        IcyRuin = StructureRegistrar.builder(TWUtil.location("icy_ruin"), () -> ()-> TWIcyRuinStructure.Codec)
                .addPiece(()-> TWIcyRuinStructure.Piece::new)
                .pushStructure(TWIcyRuinStructure::new)
                        .biomes(TWTags.Biomes.hasIcyRuin)
                        .dimensions(TWLevels.WhiteFrost)
                        .lakeProof(true)
                .popStructure()
                .placement(()-> GridStructurePlacement.builder(27, 18, 0.8f).build(TWUtil.location("icy_ruin")))
                .build();
    }

}