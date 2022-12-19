package com.barion.the_witcher.world.gen;

import com.barion.the_witcher.util.TWConfig;
import com.barion.the_witcher.util.TWTags;
import com.barion.the_witcher.util.TWUtil;
import com.barion.the_witcher.world.gen.structure.TWIcyRuinStructure;
import com.barion.the_witcher.world.gen.structure.TWWildHuntOutpostStructure;
import com.barion.the_witcher.world.gen.structure.TWWitcherCitadelStructure;
import com.legacy.structure_gel.api.registry.registrar.StructureRegistrar;
import com.legacy.structure_gel.api.structure.GridStructurePlacement;
import net.minecraft.util.random.WeightedRandomList;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.structure.StructureSpawnOverride;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;

public class TWStructures {
    private TWStructures() {}

    public static void init() {}

    public static StructureRegistrar<TWIcyRuinStructure> IcyRuin;
    public static StructureRegistrar<TWWitcherCitadelStructure> WitcherCitadel;
    public static StructureRegistrar<TWWildHuntOutpostStructure> WildHuntOutpost;


    static {
        IcyRuin = StructureRegistrar.builder(TWUtil.location("icy_ruin"), () -> ()-> TWIcyRuinStructure.Codec)
                .addPiece(()-> TWIcyRuinStructure.Piece::new)
                .pushStructure(TWIcyRuinStructure::new)
                        .biomes(TWTags.Biomes.hasIcyRuin)
                        .dimensions(TWLevels.WhiteFrost)
                .popStructure()
                .placement(()-> GridStructurePlacement.builder(27, 0.8f).build(IcyRuin.getRegistryName()))
                .build();

        /*WildHuntOutpost = StructureRegistrar.builder(TWUtil.location("wild_hunt_outpost"), ()-> ()-> TWWildHuntOutpostStructure.Codec)
                .addPiece(()-> TWWildHuntOutpostStructure.Piece::new)
                .pushStructure(TWWildHuntOutpostStructure::new)
                        .biomes(TWTags.Biomes.hasIcyRuin)
                        .dimensions(TWLevels.WhiteFrost)
//                        .spawns(MobCategory.MONSTER, StructureSpawnOverride.BoundingBoxType.PIECE,)
                        .terrainAdjustment(TerrainAdjustment.BEARD_BOX)
                .popStructure()
                .placement(()-> GridStructurePlacement.builder(40, 0.7f).build(WildHuntOutpost.getRegistryName()))
                .build();*/

        WitcherCitadel = StructureRegistrar.builder(TWUtil.location("witcher_citadel"), ()-> ()-> TWWitcherCitadelStructure.Codec)
                .addPiece(()-> TWWitcherCitadelStructure.Piece::new)
                .pushStructure(TWWitcherCitadelStructure::new)
                        .config(TWConfig.COMMON.WitcherCitadelConfig::getStructure)
                        .dimensions(Level.OVERWORLD)
                        .terrainAdjustment(TerrainAdjustment.BEARD_THIN)
                .popStructure()
                .placement(()-> GridStructurePlacement.builder(72, 48, 0.9f).allowedNearSpawn(false).build(WitcherCitadel.getRegistryName()))
                .build();
    }
}