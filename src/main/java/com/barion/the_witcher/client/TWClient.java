package com.barion.the_witcher.client;

import com.barion.the_witcher.client.model.TWIceGhostModel;
import com.barion.the_witcher.client.model.TWWildHuntHoundModel;
import com.barion.the_witcher.client.renderer.TWIceGhostRender;
import com.barion.the_witcher.client.renderer.TWWildHuntHoundRender;
import com.barion.the_witcher.world.TWEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;

@OnlyIn(Dist.CLIENT)
public class TWClient {
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(TWEntities.IceGhost.get(), TWIceGhostRender::new);
        event.registerEntityRenderer(TWEntities.WildHuntHound.get(), TWWildHuntHoundRender::new);
    }
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(TWIceGhostRender.LayerLocation, TWIceGhostModel::createMesh);
        event.registerLayerDefinition(TWWildHuntHoundRender.LayerLocation, TWWildHuntHoundModel::createMesh);
    }
}