package com.barion.the_witcher.client;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.client.model.TWIceGhostModel;
import com.barion.the_witcher.client.model.TWWildHuntHoundModel;
import com.barion.the_witcher.client.renderer.TWIceGhostRenderer;
import com.barion.the_witcher.client.renderer.TWWildHuntHoundRenderer;
import com.barion.the_witcher.client.renderer.TWWildHuntKnightRenderer;
import com.barion.the_witcher.world.TWBlocks;
import com.barion.the_witcher.world.TWEntities;
import com.barion.the_witcher.world.screen.TWMasterSmithingScreen;
import com.barion.the_witcher.world.screen.TWMenuTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@OnlyIn(Dist.CLIENT) @Mod.EventBusSubscriber(modid = TheWitcher.ModID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TWClient {
    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent event){
        ItemBlockRenderTypes.setRenderLayer(TWBlocks.Icicle.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(TWBlocks.WhiteMyrtleBush.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(TWBlocks.CelandineBush.get(), RenderType.cutout());

        MenuScreens.register(TWMenuTypes.MasterSmithingTableMenu.get(), TWMasterSmithingScreen::new);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(TWEntities.IceGhost.get(), TWIceGhostRenderer::new);
        event.registerEntityRenderer(TWEntities.WildHuntHound.get(), TWWildHuntHoundRenderer::new);
        event.registerEntityRenderer(TWEntities.WildHuntKnight.get(), TWWildHuntKnightRenderer::new);
    }
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(TWIceGhostRenderer.LayerLocation, TWIceGhostModel::createMesh);
        event.registerLayerDefinition(TWWildHuntHoundRenderer.LayerLocation, TWWildHuntHoundModel::createMesh);
        event.registerLayerDefinition(TWWildHuntKnightRenderer.LayerLocation, ()-> LayerDefinition.create(HumanoidModel.createMesh(CubeDeformation.NONE, 0), 64, 32));
        event.registerLayerDefinition(TWWildHuntKnightRenderer.LayerLocationOuterArmor, ()-> LayerDefinition.create(HumanoidModel.createMesh(new CubeDeformation(1), 0), 64, 32));
        event.registerLayerDefinition(TWWildHuntKnightRenderer.LayerLocationInnerArmor, ()-> LayerDefinition.create(HumanoidModel.createMesh(new CubeDeformation(0.5f), 0), 64, 32));
    }
}