package com.barion.the_witcher.client.renderer;

import com.barion.the_witcher.client.model.TWKikimoraModel;
import com.barion.the_witcher.util.TWUtil;
import com.barion.the_witcher.world.entity.TWKikimoraEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public class TWKikimoraRender extends MobRenderer<TWKikimoraEntity, TWKikimoraModel>{
    public static final ModelLayerLocation LayerLocation = new ModelLayerLocation(TWUtil.location("kikimora"), "main");
    private static final ResourceLocation Texture = TWUtil.location("textures/entity/kikimora.png");

    public TWKikimoraRender(EntityRendererProvider.Context rendererContext) {
        super(rendererContext, new TWKikimoraModel(rendererContext.bakeLayer(LayerLocation)), 0.2f);
    }

    @Override @ParametersAreNonnullByDefault @Nonnull
    public ResourceLocation getTextureLocation(TWKikimoraEntity entity) {return Texture;}
}
