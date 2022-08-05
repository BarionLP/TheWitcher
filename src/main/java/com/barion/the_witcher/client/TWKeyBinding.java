package com.barion.the_witcher.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class TWKeyBinding {
    private static final String CastSignTranslation = "key.the_witcher.cast_sign";

    public static final KeyMapping CastSign = new KeyMapping(CastSignTranslation, KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_X, KeyMapping.CATEGORY_GAMEPLAY);
}