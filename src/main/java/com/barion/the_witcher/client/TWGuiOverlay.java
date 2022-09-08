package com.barion.the_witcher.client;

import com.barion.the_witcher.util.TWUtil;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

public class TWGuiOverlay {
    private static final ResourceLocation SignStrengthInfo = TWUtil.location("textures/gui/sign/info.png");
    private static final ResourceLocation EnergyBar = TWUtil.location("textures/gui/sign/energy.png");

    public static final IGuiOverlay EnergyLevel = ((gui, poseStack, partialTick, width, height)-> {
        if(Minecraft.getInstance().player.isSpectator() || Minecraft.getInstance().player.isCreative()) {return;}

        int x = width/2-92;
        int y = height-30;

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderTexture(0, EnergyBar);
        RenderSystem.setShaderColor(1, 1, 0, 1f);
        GuiComponent.blit(poseStack, x, y, 0, 0, (int) (184*TWPlayerEnergyData.getPercent()), 7, 184, 7);
    });
}