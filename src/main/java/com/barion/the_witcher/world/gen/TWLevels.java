package com.barion.the_witcher.world.gen;

import com.barion.the_witcher.util.TWUtil;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;

public class TWLevels {
    public static final ResourceKey<Level> WhiteFrost = ResourceKey.create(Registries.DIMENSION, TWUtil.location("white_frost"));
}