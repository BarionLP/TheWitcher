package com.barion.the_witcher.util;

import com.ametrinstudios.ametrin.world.gen.util.StructurePieces;
import com.barion.the_witcher.TheWitcher;
import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;

public class TWUtil {
    public static final Logger Logger = LogUtils.getLogger();
    public static StructurePieces.Builder pieceBuilder() {return new StructurePieces.Builder();}
    public static ResourceLocation location(String key) {return new ResourceLocation(TheWitcher.ModID, key);}
}