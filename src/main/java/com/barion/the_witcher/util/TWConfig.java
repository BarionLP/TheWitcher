package com.barion.the_witcher.util;

import com.legacy.structure_gel.api.config.StructureConfig;
import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class TWConfig {
    public static final Common COMMON;
    public static final ForgeConfigSpec CommonSpec;
    static {
        Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
        CommonSpec = specPair.getRight();
        COMMON = specPair.getLeft();
    }

    public static class Common{
        public final StructureConfig WitcherCitadelConfig;

        protected Common(ForgeConfigSpec.Builder builder){
            WitcherCitadelConfig = StructureConfig.builder(builder, "witcher_citadel")
                    .pushStructure()
                            .biomes("#minecraft:is_taiga", "#forge:is_plains", "#forge:is_dead", "!#minecraft:is_mountain")
                    .popStructure().build();
        }
    }
}