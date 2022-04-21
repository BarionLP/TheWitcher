package com.barion.the_witcher.client.renderer;

import com.barion.the_witcher.client.model.TWIceGhostModel;
import com.barion.the_witcher.util.TWUtil;
import com.barion.the_witcher.world.entity.TWIceGhostEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public class TWIceGhostRender extends MobRenderer<TWIceGhostEntity, TWIceGhostModel>{
    private static final ResourceLocation Texture = TWUtil.location("textures/entity/ice_ghost.png");
    public static final ModelLayerLocation LayerLocation = new ModelLayerLocation(TWUtil.location("ice_ghost"), "main");

    public TWIceGhostRender(EntityRendererProvider.Context renderContext) {
        super(renderContext, new TWIceGhostModel(renderContext.bakeLayer(LayerLocation)), 0.2f);
    }

    @Override @Nonnull @ParametersAreNonnullByDefault
    public ResourceLocation getTextureLocation(TWIceGhostEntity entity) {return Texture;}
}