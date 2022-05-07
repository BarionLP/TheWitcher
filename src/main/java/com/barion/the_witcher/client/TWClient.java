package com.barion.the_witcher.client;

import com.barion.the_witcher.client.model.TWIceGhostModel;
import com.barion.the_witcher.client.model.TWWildHuntHoundModel;
import com.barion.the_witcher.client.renderer.TWIceGhostRender;
import com.barion.the_witcher.client.renderer.TWWildHuntHoundRender;
import com.barion.the_witcher.world.TWBlocks;
import com.barion.the_witcher.world.TWEntities;
import com.barion.the_witcher.world.screen.TWMasterSmithingTableScreen;
import com.barion.the_witcher.world.screen.TWMenuTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@OnlyIn(Dist.CLIENT)
public class TWClient {
    public static void clientSetup(final FMLClientSetupEvent event){
        ItemBlockRenderTypes.setRenderLayer(TWBlocks.Icicle.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(TWBlocks.WhiteMyrtleBush.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(TWBlocks.CelandineBush.get(), RenderType.cutout());

        MenuScreens.register(TWMenuTypes.MasterSmithingTableMenu.get(), TWMasterSmithingTableScreen::new);
    }

    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(TWEntities.IceGhost.get(), TWIceGhostRender::new);
        event.registerEntityRenderer(TWEntities.WildHuntHound.get(), TWWildHuntHoundRender::new);
    }
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(TWIceGhostRender.LayerLocation, TWIceGhostModel::createMesh);
        event.registerLayerDefinition(TWWildHuntHoundRender.LayerLocation, TWWildHuntHoundModel::createMesh);
    }
}