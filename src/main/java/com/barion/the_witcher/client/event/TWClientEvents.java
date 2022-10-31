package com.barion.the_witcher.client.event;

import com.barion.the_witcher.TheWitcher;
import com.barion.the_witcher.client.TWGuiOverlay;
import com.barion.the_witcher.client.TWKeyBinding;
import com.barion.the_witcher.client.model.TWIceGhostModel;
import com.barion.the_witcher.client.model.TWWildHuntHoundModel;
import com.barion.the_witcher.client.renderer.TWIceGhostRenderer;
import com.barion.the_witcher.client.renderer.TWWildHuntHoundRenderer;
import com.barion.the_witcher.client.renderer.TWWildHuntKnightRenderer;
import com.barion.the_witcher.client.screen.TWMasterSmithingScreen;
import com.barion.the_witcher.fluid.TWFluids;
import com.barion.the_witcher.world.TWEntityTypes;
import com.barion.the_witcher.world.inventory.TWMenuTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = TheWitcher.ModID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT) @OnlyIn(Dist.CLIENT)
public class TWClientEvents {
    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent event){
        MenuScreens.register(TWMenuTypes.MasterSmithingTableMenu.get(), TWMasterSmithingScreen::new);
        ItemBlockRenderTypes.setRenderLayer(TWFluids.AcidSource.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(TWFluids.AcidFlowing.get(), RenderType.translucent());
    }

    @SubscribeEvent
    public static void registerKeyMappings(RegisterKeyMappingsEvent event){
        event.register(TWKeyBinding.CastSign);
    }

    @SubscribeEvent
    public static void registerGuiOverlays(RegisterGuiOverlaysEvent event){
        event.registerBelow(new ResourceLocation("hotbar"), "energy_level", TWGuiOverlay.EnergyLevel);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(TWEntityTypes.IceGhost.get(), TWIceGhostRenderer::new);
        event.registerEntityRenderer(TWEntityTypes.WildHuntHound.get(), TWWildHuntHoundRenderer::new);
        event.registerEntityRenderer(TWEntityTypes.WildHuntKnight.get(), TWWildHuntKnightRenderer::new);
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