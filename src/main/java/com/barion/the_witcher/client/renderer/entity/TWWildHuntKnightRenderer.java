package com.barion.the_witcher.client.renderer.entity;

import com.barion.the_witcher.util.TWUtil;
import com.barion.the_witcher.world.entity.TWWildHuntKnightEntity;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class TWWildHuntKnightRenderer extends HumanoidMobRenderer<TWWildHuntKnightEntity, HumanoidModel<TWWildHuntKnightEntity>> {
    private static final ResourceLocation Texture = TWUtil.location("textures/entity/wild_hunt_knight.png");
    public static final ModelLayerLocation LayerLocation = new ModelLayerLocation(TWUtil.location("wild_hunt_knight"), "main");
    public static final ModelLayerLocation LayerLocationInnerArmor = new ModelLayerLocation(TWUtil.location("wild_hunt_knight_inner_armor"), "main");
    public static final ModelLayerLocation LayerLocationOuterArmor = new ModelLayerLocation(TWUtil.location("wild_hunt_knight_outer_armor"), "main");

    public TWWildHuntKnightRenderer(EntityRendererProvider.Context context) {
        super(context, new HumanoidModel<>(context.bakeLayer(LayerLocation)), 0.5f);
        addLayer(new HumanoidArmorLayer<>(this, new HumanoidModel<>(context.bakeLayer(LayerLocationInnerArmor)), new HumanoidModel<>(context.bakeLayer(LayerLocationOuterArmor))));
    }

    @Override @Nonnull
    public ResourceLocation getTextureLocation(@NotNull TWWildHuntKnightEntity entity) {return Texture;}
}