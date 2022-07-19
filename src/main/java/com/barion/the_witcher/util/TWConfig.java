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
            WitcherCitadelConfig = StructureConfig.builder(builder, "Witcher Citadel")
                    .pushStructure()
                        .biomes("##structure_gel:plains", "##structure_gel:cold", "##structure_gel:snowy", "!##structure_gel:mountain", "!##structure_gel:beach")
                    .popStructure().build();
        }
    }
}