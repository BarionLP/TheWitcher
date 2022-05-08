package com.barion.the_witcher.world.screen;

import com.barion.the_witcher.util.TWUtil;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.NotNull;

public class TWMasterSmithingTableScreen extends AbstractContainerScreen<TWMasterSmithingMenu> {
    public static final ResourceLocation Texture = TWUtil.location("textures/gui/master_smithing_table.png");

    public TWMasterSmithingTableScreen(TWMasterSmithingMenu menu, Inventory playerInventory, Component tile) {
        super(menu, playerInventory, tile);
    }

    @Override
    protected void renderBg(@NotNull PoseStack poseStack, float partialTick, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, Texture);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        blit(poseStack, x, y, 0, 0, imageWidth, imageHeight);

        if(menu.getSlot(0).hasItem() && (menu.getSelectedRecipe() == null || !menu.enoughXP())){
            blit(poseStack, x + 74, y + 37, imageWidth, 0, 28, 20);
        }
    }

    @Override
    public void render(@NotNull PoseStack poseStack, int mouseX, int mouseY, float delta) {
        renderBackground(poseStack);
        super.render(poseStack, mouseX, mouseY, delta);
        renderTooltip(poseStack, mouseX, mouseY);
    }

    @Override
    protected void renderLabels(@NotNull PoseStack poseStack, int mouseX, int mouseY) {
        super.renderLabels(poseStack, mouseX, mouseY);
        if(menu.getSelectedRecipe() != null){
            font.draw(poseStack, menu.getSelectedRecipe().getXpCost() + " XP",77,56, menu.enoughXP() ? 4210752 : 16711680);
        }
    }
}