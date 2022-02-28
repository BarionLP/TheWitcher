package com.barion.the_witcher.client.model.render;

import com.barion.the_witcher.TWUtil;
import com.barion.the_witcher.client.model.TWIceGhostModel;
import com.barion.the_witcher.world.entity.TWIceGhost;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public class TWIceGhostRender extends MobRenderer<TWIceGhost, TWIceGhostModel>{
    private static final ResourceLocation TEXTURE = TWUtil.createResourceLocation("textures/entity/ice_ghost.png");

    public TWIceGhostRender(EntityRendererProvider.Context renderContext) {
        super(renderContext, new TWIceGhostModel(), 0.2f);
    }

    @Override @Nonnull @ParametersAreNonnullByDefault
    public ResourceLocation getTextureLocation(TWIceGhost entity) {return TEXTURE;}
}