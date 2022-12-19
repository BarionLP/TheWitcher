package com.barion.the_witcher.util;

//import com.legacy.structure_gel.api.config.ConfigBuilder;
import com.legacy.structure_gel.api.config.StructureConfig;
import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class TWConfig {
    public static final Common COMMON;
    public static final ForgeConfigSpec CommonSpec;
    public static final Client CLIENT;
    public static final ForgeConfigSpec ClientSpec;
    static {
        Pair<Common, ForgeConfigSpec> commonPair = new ForgeConfigSpec.Builder().configure(Common::new);
        CommonSpec = commonPair.getRight();
        COMMON = commonPair.getLeft();

        Pair<Client, ForgeConfigSpec> clientPair = new ForgeConfigSpec.Builder().configure(Client::new);
        ClientSpec = clientPair.getRight();
        CLIENT = clientPair.getLeft();
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

    public static class Client{
        public final ForgeConfigSpec.BooleanValue AlwaysFoggy;

        protected Client(ForgeConfigSpec.Builder builder){
            builder.push("white_frost");
            AlwaysFoggy = ConfigBuilder.makeBoolean(builder, "always_foggy", "Should the White Frost always have dense fog", false);
            builder.pop();
        }
    }
}