package com.barion.the_witcher.client;

import com.barion.the_witcher.client.model.TWIceGhostModel;
import com.barion.the_witcher.client.model.render.TWIceGhostRender;
import com.barion.the_witcher.world.TWEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;

@OnlyIn(Dist.CLIENT)
public class TWClient {
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(TWEntities.IceGhost.get(), TWIceGhostRender::new);
    }
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(TWIceGhostModel.LayerLocation, TWIceGhostModel::createBodyLayer);
    }
}