package com.barion.the_witcher.client.model.render;

import com.barion.the_witcher.client.model.TWKikimoraModel;
import com.barion.the_witcher.world.entity.TWKikimora;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public class TWKikimoraRender extends MobRenderer<TWKikimora, TWKikimoraModel> {
    public TWKikimoraRender(EntityRendererProvider.Context rendererContext) {
        super(rendererContext, new TWKikimoraModel(), 0.2f);
    }

    @Override @ParametersAreNonnullByDefault @Nonnull
    public ResourceLocation getTextureLocation(TWKikimora entity) {
        return null;
    }
}
