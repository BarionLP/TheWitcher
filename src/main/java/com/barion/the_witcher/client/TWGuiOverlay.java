package com.barion.the_witcher.client;

import com.barion.the_witcher.util.TWUtil;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

public class TWGuiOverlay {
    private static final ResourceLocation SignStrengthInfo = TWUtil.location("textures/gui/sign/info.png");
    private static final ResourceLocation EnergyBar = TWUtil.location("textures/gui/sign/energy.png");

    public static final IGuiOverlay InfoHUD = ((gui, poseStack, partialTick, width, height)-> {
        int x = width/2;
        int y = height-24;

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(0, 1, 1, 0.7f);
        RenderSystem.setShaderTexture(0, EnergyBar);
        GuiComponent.blit(poseStack, x-91, y, 0, 0, (int) (182*TWPlayerEnergyData.getPercent()), 2, 182, 2);
    });
}