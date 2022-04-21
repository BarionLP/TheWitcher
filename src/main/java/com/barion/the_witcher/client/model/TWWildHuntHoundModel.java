package com.barion.the_witcher.client.model;
// Made with Blockbench 4.2.2

import com.barion.the_witcher.world.entity.TWWildHuntHoundEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

public class TWWildHuntHoundModel extends EntityModel<TWWildHuntHoundEntity> {
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart leftArm;
	private final ModelPart rightArm;
	private final ModelPart leftLeg;
	private final ModelPart rightLeg;
	private final ModelPart tail;
	private final ModelPart spikes;

	public TWWildHuntHoundModel(ModelPart root) {
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.leftArm = root.getChild("left_arm");
		this.rightArm = root.getChild("right_arm");
		this.leftLeg = root.getChild("left_leg");
		this.rightLeg = root.getChild("right_leg");
		this.tail = root.getChild("tail");
		this.spikes = root.getChild("spikes");
	}

	public static LayerDefinition createMesh() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 34).addBox(-4.0F, -4.0F, -7.0F, 8.0F, 7.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(42, 51).addBox(-2.0F, -1.0F, -11.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 11.0F, -11.0F));
		PartDefinition chin = head.addOrReplaceChild("chin", CubeListBuilder.create().texOffs(30, 41).addBox(-3.0F, -1.0F, -3.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 2.704F, -2.7997F, -0.2182F, 0.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(-1.0F, 8.0F, -1.0F));
		PartDefinition torso = body.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -4.5F, -5.0F, 12.0F, 9.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 1.25F, -6.75F, 0.3054F, 0.0F, 0.0F));
		PartDefinition back_r1 = body.addOrReplaceChild("back_r1", CubeListBuilder.create().texOffs(0, 19).addBox(-6.0F, -3.5F, -4.0F, 12.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -2.5F, 7.75F, 0.0873F, 0.0F, 0.0F));
		PartDefinition middle_r1 = body.addOrReplaceChild("middle_r1", CubeListBuilder.create().texOffs(33, 27).addBox(-6.0F, -3.5F, -3.5F, 12.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -1.5F, 1.5F, 0.2618F, 0.0F, 0.0F));

		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(26, 49).addBox(0.0F, 8.75F, -4.0F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 12.0F, -8.0F));
		PartDefinition middle_r2 = left_arm.addOrReplaceChild("middle_r2", CubeListBuilder.create().texOffs(48, 0).addBox(-1.5F, -4.0F, -2.5F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 6.75F, 3.25F, -0.576F, 0.0F, 0.0F));
		PartDefinition upper_r1 = left_arm.addOrReplaceChild("upper_r1", CubeListBuilder.create().texOffs(55, 56).addBox(-1.5F, -3.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 2.0F, 1.25F, 0.9076F, 0.0F, -0.2618F));

		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(26, 49).addBox(-3.0F, 8.75F, -4.0F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 12.0F, -8.0F));
		PartDefinition middle_r3 = right_arm.addOrReplaceChild("middle_r3", CubeListBuilder.create().texOffs(48, 0).addBox(-1.5F, -4.0F, -2.5F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 6.75F, 3.25F, -0.576F, 0.0F, 0.0F));
		PartDefinition upper_r2 = right_arm.addOrReplaceChild("upper_r2", CubeListBuilder.create().texOffs(55, 56).addBox(-1.5F, -3.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 2.0F, 1.25F, 0.9076F, 0.0F, 0.2618F));

		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(57, 10).addBox(0.5F, 10.0F, -1.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 9.0F, 7.0F));
		PartDefinition middle_r4 = left_leg.addOrReplaceChild("middle_r4", CubeListBuilder.create().texOffs(0, 48).addBox(-1.5F, -5.0F, -1.5F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 7.0F, -2.5F, 0.6545F, 0.0F, -0.1745F));
		PartDefinition upper_r3 = left_leg.addOrReplaceChild("upper_r3", CubeListBuilder.create().texOffs(12, 48).addBox(-1.5F, -3.0F, -2.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 2.0F, -1.0F, -0.9163F, 0.0F, -0.2618F));

		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(57, 10).addBox(-3.5F, 10.0F, -1.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 9.0F, 7.0F));
		PartDefinition middle_r5 = right_leg.addOrReplaceChild("middle_r5", CubeListBuilder.create().texOffs(0, 48).addBox(-1.5F, -5.0F, -1.5F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 7.0F, -2.5F, 0.6545F, 0.0F, 0.1745F));
		PartDefinition upper_r4 = right_leg.addOrReplaceChild("upper_r4", CubeListBuilder.create().texOffs(12, 48).addBox(-1.5F, -3.0F, -2.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 2.0F, -1.0F, -0.9163F, 0.0F, 0.2618F));

		PartDefinition tail = partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 11.0F));
		PartDefinition back_r2 = tail.addOrReplaceChild("back_r2", CubeListBuilder.create().texOffs(32, 21).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 3.25F, 0.6109F, 0.0F, 0.0F));

		PartDefinition spikes = partdefinition.addOrReplaceChild("spikes", CubeListBuilder.create(), PartPose.offset(1.0F, 5.0F, -3.0F));
		PartDefinition spike_lf = spikes.addOrReplaceChild("spike_lf", CubeListBuilder.create().texOffs(32, 7).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -0.75F, -3.25F, 0.3161F, -0.5872F, 1.3915F));
		PartDefinition spike_rf = spikes.addOrReplaceChild("spike_rf", CubeListBuilder.create().texOffs(32, 7).mirror().addBox(-1.0F, -1.0F, -6.0F, 2.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, -0.75F, -3.25F, 0.6109F, -0.2618F, 0.0F));
		PartDefinition spike_lb = spikes.addOrReplaceChild("spike_lb", CubeListBuilder.create().texOffs(46, 41).addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -2.75F, 4.0F, 0.6109F, 0.2618F, 0.0F));
		PartDefinition spike_mf = spikes.addOrReplaceChild("spike_mf", CubeListBuilder.create().texOffs(32, 7).mirror().addBox(-1.0F, -1.0F, -6.0F, 2.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, -0.75F, -4.5F, 0.0F, 0.6109F, -1.5708F));
		PartDefinition spike_rb = spikes.addOrReplaceChild("spike_rb", CubeListBuilder.create().texOffs(46, 41).addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5F, -2.75F, 3.5F, 0.6109F, -0.2618F, 0.0F));
		PartDefinition spike_mb = spikes.addOrReplaceChild("spike_mb", CubeListBuilder.create().texOffs(46, 41).addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -2.5F, 4.0F, 0.6109F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 80, 80);
	}

	@Override
	public void setupAnim(@NotNull TWWildHuntHoundEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw * ((float)Math.PI / 180f);

		float fallMod = 1f;
		if (entity.getFallFlyingTicks() > 4) {
			fallMod = (float)entity.getDeltaMovement().lengthSqr();
			fallMod /= 0.2f;
			fallMod *= fallMod * fallMod;
		}

		if (fallMod < 1) {fallMod = 1f;}

		this.rightArm.xRot = Mth.cos(limbSwing * 0.6662f + (float)Math.PI) * 2f * limbSwingAmount * 0.5f / fallMod;
		this.leftArm.xRot = Mth.cos(limbSwing * 0.6662f) * 2f * limbSwingAmount * 0.5f / fallMod;
		this.rightLeg.xRot = Mth.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount / fallMod;
		this.leftLeg.xRot = Mth.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4F * limbSwingAmount / fallMod;
	}

	@Override
	public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, buffer, packedLight, packedOverlay);
		body.render(poseStack, buffer, packedLight, packedOverlay);
		leftArm.render(poseStack, buffer, packedLight, packedOverlay);
		rightArm.render(poseStack, buffer, packedLight, packedOverlay);
		leftLeg.render(poseStack, buffer, packedLight, packedOverlay);
		rightLeg.render(poseStack, buffer, packedLight, packedOverlay);
		tail.render(poseStack, buffer, packedLight, packedOverlay);
		spikes.render(poseStack, buffer, packedLight, packedOverlay);
	}
}