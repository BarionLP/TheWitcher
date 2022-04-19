package com.barion.the_witcher.client.model;
// Made with Blockbench 4.1.5

import com.barion.the_witcher.world.entity.TWKikimoraEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import org.jetbrains.annotations.NotNull;

public class TWKikimoraModel extends EntityModel<TWKikimoraEntity> {
	private final ModelPart Root;

	public TWKikimoraModel(ModelPart root){
		this.Root = root.getChild("Root");
	}

	public static LayerDefinition createBodyLayer(){
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Root = partdefinition.addOrReplaceChild("Root", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition Head = Root.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offset(0.0F, -28.4107F, 15.5117F));

		PartDefinition Head_r1 = Head.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(54, 53).addBox(-8.0F, -6.0F, -9.0F, 16.0F, 12.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.9107F, 7.9883F, -0.2182F, 0.0F, 0.0F));

		PartDefinition HeadSpikes = Head.addOrReplaceChild("HeadSpikes", CubeListBuilder.create(), PartPose.offset(0.0F, 22.4107F, -28.5117F));

		PartDefinition bone15 = HeadSpikes.addOrReplaceChild("bone15", CubeListBuilder.create(), PartPose.offsetAndRotation(8.3161F, -21.9634F, 41.8263F, -0.0873F, 0.0F, 0.0F));

		PartDefinition cube_r1 = bone15.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(115, 4).addBox(-2.5F, -1.5F, -1.5F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.4339F, -4.2866F, -0.0763F, 0.0F, 0.0F, -0.9599F));

		PartDefinition cube_r2 = bone15.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(116, 2).addBox(-3.0F, -1.5F, -1.5F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.9339F, -1.2866F, -0.0763F, 0.0F, 0.0F, -0.3491F));

		PartDefinition cube_r3 = bone15.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(129, 9).addBox(-2.0F, -1.5F, -1.5F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4339F, -0.2866F, -0.0763F, 0.0F, 0.0F, 0.3054F));

		PartDefinition bone16 = HeadSpikes.addOrReplaceChild("bone16", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.3161F, -22.9634F, 41.8263F, -0.0873F, 0.0F, 0.0F));

		PartDefinition cube_r4 = bone16.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(115, 3).addBox(-2.5F, -1.5F, -1.5F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.4339F, -3.2866F, -0.0763F, 0.0F, 0.0F, 0.9599F));

		PartDefinition cube_r5 = bone16.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(112, 12).addBox(-3.0F, -1.5F, -1.5F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.9339F, -0.2866F, -0.0763F, 0.0F, 0.0F, 0.3491F));

		PartDefinition cube_r6 = bone16.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(123, 3).addBox(-2.0F, -1.5F, -1.5F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4339F, 0.7134F, -0.0763F, 0.0F, 0.0F, -0.3054F));

		PartDefinition bone17 = HeadSpikes.addOrReplaceChild("bone17", CubeListBuilder.create(), PartPose.offsetAndRotation(-7.908F, -24.2872F, 33.8263F, -0.0873F, 0.0F, 0.0873F));

		PartDefinition cube_r7 = bone17.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(126, 14).addBox(-2.5F, -1.5F, -1.5F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.592F, -3.9628F, -0.0763F, 0.0F, 0.0F, 0.9599F));

		PartDefinition cube_r8 = bone17.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(119, 5).addBox(-3.0F, -1.5F, -1.5F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.092F, -0.9628F, -0.0763F, 0.0F, 0.0F, 0.3491F));

		PartDefinition cube_r9 = bone17.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(119, 10).addBox(-2.0F, -1.5F, -1.5F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.592F, 0.0372F, -0.0763F, 0.0F, 0.0F, -0.3054F));

		PartDefinition bone18 = HeadSpikes.addOrReplaceChild("bone18", CubeListBuilder.create(), PartPose.offsetAndRotation(7.908F, -24.2872F, 33.8263F, -0.0873F, 0.0F, -0.0873F));

		PartDefinition cube_r10 = bone18.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(121, 6).addBox(-2.5F, -1.5F, -1.5F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.592F, -3.9628F, -0.0763F, 0.0F, 0.0F, -0.9599F));

		PartDefinition cube_r11 = bone18.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(119, 5).addBox(-3.0F, -1.5F, -1.5F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.092F, -0.9628F, -0.0763F, 0.0F, 0.0F, -0.3491F));

		PartDefinition cube_r12 = bone18.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(123, 6).addBox(-2.0F, -1.5F, -1.5F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.592F, 0.0372F, -0.0763F, 0.0F, 0.0F, 0.3054F));

		PartDefinition Tooths = Head.addOrReplaceChild("Tooths", CubeListBuilder.create(), PartPose.offset(0.0F, 22.4107F, -28.5117F));

		PartDefinition UpperRightTooth = Tooths.addOrReplaceChild("UpperRightTooth", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, -24.1928F, 44.7467F, 0.3491F, 0.0F, 0.0F));

		PartDefinition cube_r13 = UpperRightTooth.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(127, 3).addBox(-1.0F, -1.0F, -2.5F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.4428F, 7.0033F, -0.9599F, 0.0F, 0.0F));

		PartDefinition cube_r14 = UpperRightTooth.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(122, 6).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.6928F, 3.7533F, -0.3491F, 0.0F, 0.0F));

		PartDefinition UpperLeftTooth = Tooths.addOrReplaceChild("UpperLeftTooth", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.0F, -23.1928F, 45.7467F, 0.3491F, 0.0F, 0.0F));

		PartDefinition cube_r15 = UpperLeftTooth.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(119, 2).addBox(-1.0F, -1.0F, -2.5F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.1928F, 6.2533F, -0.9599F, 0.0F, 0.0F));

		PartDefinition cube_r16 = UpperLeftTooth.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(121, 2).addBox(-1.0F, -1.5F, 20.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0572F, -18.7467F, -0.3491F, 0.0F, 0.0F));

		PartDefinition LeftUpperTooth = Tooths.addOrReplaceChild("LeftUpperTooth", CubeListBuilder.create(), PartPose.offsetAndRotation(-6.5571F, -20.5436F, 45.2324F, -0.1309F, -0.3491F, 0.0F));

		PartDefinition cube_r17 = LeftUpperTooth.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(114, 7).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0571F, -0.4564F, 5.7676F, 0.0F, 0.3491F, 0.0F));

		PartDefinition cube_r18 = LeftUpperTooth.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(130, 2).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1929F, -0.4564F, 2.5176F, 0.0F, -0.3054F, 0.0F));

		PartDefinition RightUpperTooth = Tooths.addOrReplaceChild("RightUpperTooth", CubeListBuilder.create(), PartPose.offsetAndRotation(5.8604F, -20.1112F, 45.602F, -0.1745F, 0.3491F, 0.0F));

		PartDefinition cube_r19 = RightUpperTooth.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(119, 3).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3896F, -0.6388F, 5.398F, 0.0F, -0.3491F, 0.0F));

		PartDefinition cube_r20 = RightUpperTooth.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(118, 9).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3896F, -0.6388F, 1.398F, 0.0F, 0.3054F, 0.0F));

		PartDefinition LowerRightTooth = Tooths.addOrReplaceChild("LowerRightTooth", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, -13.3373F, 44.391F, -0.5672F, 0.0F, 0.0F));

		PartDefinition cube_r21 = LowerRightTooth.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(124, 5).addBox(-1.0F, -1.0F, -2.5F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.4127F, 8.609F, 0.9599F, 0.0F, 0.0F));

		PartDefinition cube_r22 = LowerRightTooth.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(121, 5).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.1627F, 4.859F, 0.3491F, 0.0F, 0.0F));

		PartDefinition cube_r23 = LowerRightTooth.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(125, 5).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.1627F, 0.859F, -0.3054F, 0.0F, 0.0F));

		PartDefinition LightLowerTooth = Tooths.addOrReplaceChild("LightLowerTooth", CubeListBuilder.create(), PartPose.offsetAndRotation(8.6729F, -16.1779F, 43.7498F, -0.3491F, -0.1745F, -1.5708F));

		PartDefinition cube_r24 = LightLowerTooth.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(116, 8).addBox(-1.0F, -1.0F, -2.5F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0771F, -4.5721F, 9.5002F, 0.9599F, 0.0F, 0.0F));

		PartDefinition cube_r25 = LightLowerTooth.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(129, 1).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0771F, -1.3221F, 5.7502F, 0.3491F, 0.0F, 0.0F));

		PartDefinition cube_r26 = LightLowerTooth.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(125, 6).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0771F, -0.3221F, 2.0002F, -0.3054F, 0.0F, 0.0F));

		PartDefinition LeftLowerTooth = Tooths.addOrReplaceChild("LeftLowerTooth", CubeListBuilder.create(), PartPose.offsetAndRotation(-6.6729F, -16.2083F, 43.4025F, -0.3491F, 0.1745F, 1.5708F));

		PartDefinition cube_r27 = LeftLowerTooth.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(119, 3).addBox(-1.0F, -1.0F, -2.5F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0771F, -3.5417F, 9.8475F, 0.9599F, 0.0F, 0.0F));

		PartDefinition cube_r28 = LeftLowerTooth.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(116, 8).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0771F, -0.5417F, 6.0975F, 0.3491F, 0.0F, 0.0F));

		PartDefinition cube_r29 = LeftLowerTooth.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(126, 6).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0771F, 0.7083F, 2.3475F, -0.3054F, 0.0F, 0.0F));

		PartDefinition LowerLeftTooth = Tooths.addOrReplaceChild("LowerLeftTooth", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.0F, -14.3373F, 44.391F, -0.5672F, 0.0F, 0.0F));

		PartDefinition cube_r30 = LowerLeftTooth.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(129, 2).addBox(-1.0F, -1.0F, -2.5F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.4127F, 9.109F, 0.9599F, 0.0F, 0.0F));

		PartDefinition cube_r31 = LowerLeftTooth.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(124, 3).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.4127F, 5.359F, 0.3491F, 0.0F, 0.0F));

		PartDefinition cube_r32 = LowerLeftTooth.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(123, 9).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.8373F, 1.359F, -0.3054F, 0.0F, 0.0F));

		PartDefinition Body = Root.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 37).addBox(-9.0F, -9.0377F, 0.2437F, 18.0F, 16.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -25.9623F, -0.2437F));

		PartDefinition back_r1 = Body.addOrReplaceChild("back_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-8.5F, -6.0F, -12.5F, 17.0F, 12.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.9623F, -9.2563F, 0.3054F, 0.0F, 0.0F));

		PartDefinition Spikes = Body.addOrReplaceChild("Spikes", CubeListBuilder.create(), PartPose.offset(0.0F, 25.9623F, 0.2437F));

		PartDefinition FrontLeftSpike = Spikes.addOrReplaceChild("FrontLeftSpike", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.3027F, -31.4794F, 15.8263F, -0.0873F, 0.0F, 0.1745F));

		PartDefinition cube_r33 = FrontLeftSpike.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(117, 6).addBox(-2.5F, -1.5F, -1.5F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.9473F, -4.5206F, -0.0763F, 0.0F, 0.0F, 0.9599F));

		PartDefinition cube_r34 = FrontLeftSpike.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(121, 0).addBox(-3.0F, -1.5F, -1.5F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.4473F, -1.5206F, -0.0763F, 0.0F, 0.0F, 0.3491F));

		PartDefinition cube_r35 = FrontLeftSpike.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(131, 6).addBox(-2.0F, -1.5F, -1.5F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9473F, -0.5206F, -0.0763F, 0.0F, 0.0F, -0.3054F));

		PartDefinition FrontRightSpike = Spikes.addOrReplaceChild("FrontRightSpike", CubeListBuilder.create(), PartPose.offsetAndRotation(8.3027F, -32.4794F, 15.8263F, -0.0873F, 0.0F, -0.1745F));

		PartDefinition cube_r36 = FrontRightSpike.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(115, 2).addBox(-2.5F, -1.5F, -1.5F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.6973F, -3.5206F, -0.0763F, 0.0F, 0.0F, -0.9599F));

		PartDefinition cube_r37 = FrontRightSpike.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(120, 6).addBox(-3.0F, -1.5F, -1.5F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4473F, -0.5206F, -0.0763F, 0.0F, 0.0F, -0.3491F));

		PartDefinition cube_r38 = FrontRightSpike.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(123, 4).addBox(-2.0F, -1.5F, -1.5F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6973F, 0.4794F, -0.0763F, 0.0F, 0.0F, 0.3054F));

		PartDefinition LeftMiddleSpike = Spikes.addOrReplaceChild("LeftMiddleSpike", CubeListBuilder.create(), PartPose.offsetAndRotation(-7.6203F, -33.9198F, 1.7714F, -0.0873F, 0.0F, 0.2182F));

		PartDefinition cube_r39 = LeftMiddleSpike.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(115, 0).addBox(-3.0F, -1.5F, -1.5F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1297F, -0.5802F, -0.0214F, 0.0F, 0.0F, 0.3491F));

		PartDefinition LeftRightSpike = Spikes.addOrReplaceChild("LeftRightSpike", CubeListBuilder.create(), PartPose.offsetAndRotation(7.6203F, -33.9198F, 1.7714F, -0.0873F, 0.0F, -0.2182F));

		PartDefinition cube_r40 = LeftRightSpike.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(119, 10).addBox(-3.0F, -1.5F, -1.5F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1297F, -0.5802F, -0.0214F, 0.0F, 0.0F, -0.3491F));

		PartDefinition LeftBackSpike = Spikes.addOrReplaceChild("LeftBackSpike", CubeListBuilder.create(), PartPose.offsetAndRotation(-7.9126F, -28.4836F, -3.242F, 0.0873F, 0.0F, 0.0F));

		PartDefinition cube_r41 = LeftBackSpike.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(115, 5).addBox(-5.0F, -1.5F, -1.5F, 10.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.5874F, 5.4836F, -0.508F, 0.0F, 0.0F, -0.8727F));

		PartDefinition cube_r42 = LeftBackSpike.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(121, 3).addBox(-3.0F, -1.5F, -1.5F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.3374F, 0.7336F, -0.008F, 0.0F, 0.0F, -0.3491F));

		PartDefinition cube_r43 = LeftBackSpike.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(129, 3).addBox(-2.0F, -1.5F, -1.5F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8374F, -0.2664F, -0.008F, 0.0F, 0.0F, 0.3054F));

		PartDefinition RightBackSpike = Spikes.addOrReplaceChild("RightBackSpike", CubeListBuilder.create(), PartPose.offsetAndRotation(7.9126F, -28.4836F, -4.242F, 0.0873F, 0.0F, 0.0F));

		PartDefinition cube_r44 = RightBackSpike.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(116, 7).addBox(-5.0F, -1.5F, -1.5F, 10.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.5874F, 4.4836F, -0.258F, 0.0F, 0.0F, 0.8727F));

		PartDefinition cube_r45 = RightBackSpike.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(120, 6).addBox(-3.0F, -1.5F, -1.5F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.3374F, -0.2664F, -0.008F, 0.0F, 0.0F, 0.3491F));

		PartDefinition cube_r46 = RightBackSpike.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(131, 5).addBox(-2.0F, -1.5F, -1.5F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.8374F, -1.2664F, -0.008F, 0.0F, 0.0F, -0.3054F));

		PartDefinition Tail = Root.addOrReplaceChild("Tail", CubeListBuilder.create(), PartPose.offset(0.0F, -19.7095F, -18.1491F));

		PartDefinition main_r1 = Tail.addOrReplaceChild("main_r1", CubeListBuilder.create().texOffs(67, 20).addBox(-8.0F, -6.0F, -8.5F, 16.0F, 12.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0405F, -7.1009F, -0.3927F, 0.0F, 0.0F));

		PartDefinition LeftSpike = Tail.addOrReplaceChild("LeftSpike", CubeListBuilder.create(), PartPose.offsetAndRotation(-7.7205F, -7.806F, -3.0796F, -0.0873F, 0.0F, 0.0436F));

		PartDefinition cube_r47 = LeftSpike.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(111, 0).addBox(-3.0F, -1.5F, -1.5F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0295F, -0.9844F, -0.0214F, 0.0F, 0.0F, 0.3491F));

		PartDefinition RightSpike = Tail.addOrReplaceChild("RightSpike", CubeListBuilder.create(), PartPose.offsetAndRotation(7.7205F, -7.806F, -3.0796F, -0.0873F, 0.0F, -0.0436F));

		PartDefinition cube_r48 = RightSpike.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(123, 12).addBox(-3.0F, -1.5F, -1.5F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0295F, -0.9844F, -0.0214F, 0.0F, 0.0F, -0.3491F));

		PartDefinition LowerTail = Tail.addOrReplaceChild("LowerTail", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.6162F, -2.8676F, -16.9771F, 1.0908F, 0.0F, 0.0F));

		PartDefinition cube_r49 = LowerTail.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(113, 0).addBox(-2.5F, -1.5F, -5.0F, 5.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1338F, -2.1729F, -1.8739F, -0.8727F, 0.0F, 0.0F));

		PartDefinition cube_r50 = LowerTail.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(114, 2).addBox(-2.5F, -1.5F, -3.0F, 5.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1162F, -6.6729F, -7.1239F, -0.3491F, 0.0F, 0.0F));

		PartDefinition cube_r51 = LowerTail.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(116, 5).addBox(-2.5F, -1.5F, -4.0F, 5.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1162F, -6.9229F, -12.8739F, 0.3054F, 0.0F, 0.0F));

		PartDefinition UpperTail = Tail.addOrReplaceChild("UpperTail", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.6162F, -8.7167F, -13.1889F, 0.3054F, 0.0F, 0.0F));

		PartDefinition cube_r52 = UpperTail.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(115, 1).addBox(-2.5F, -1.5F, -5.0F, 5.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1338F, -3.8238F, -2.912F, -0.8727F, 0.0F, 0.0F));

		PartDefinition cube_r53 = UpperTail.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(115, 2).addBox(-2.5F, -1.5F, -3.0F, 5.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1162F, -8.3238F, -8.162F, -0.3491F, 0.0F, 0.0F));

		PartDefinition cube_r54 = UpperTail.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(115, 4).addBox(-2.5F, -1.5F, -4.0F, 5.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1162F, -8.3238F, -13.912F, 0.3054F, 0.0F, 0.0F));

		PartDefinition LeftArm = Root.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offset(-8.0F, -34.0F, 12.0F));

		PartDefinition Lower_r1 = LeftArm.addOrReplaceChild("Lower_r1", CubeListBuilder.create().texOffs(0, 93).addBox(-10.0F, -2.5F, -3.0F, 20.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-21.5F, 24.5F, 4.0F, -0.9163F, 0.0F, -1.5708F));

		PartDefinition Middle_r1 = LeftArm.addOrReplaceChild("Middle_r1", CubeListBuilder.create().texOffs(52, 94).addBox(-10.0F, -2.5F, -3.0F, 20.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 7.5F, -0.75F, -0.7549F, 0.4931F, -1.1039F));

		PartDefinition Upper_r1 = LeftArm.addOrReplaceChild("Upper_r1", CubeListBuilder.create().texOffs(44, 105).addBox(-13.5F, -2.5F, -2.5F, 15.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 0.5F, -0.5F, 0.0F, -0.4363F, 0.0F));

		PartDefinition RightArm = Root.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.offset(8.0F, -34.0F, 12.0F));

		PartDefinition Lower_r2 = RightArm.addOrReplaceChild("Lower_r2", CubeListBuilder.create().texOffs(59, 0).addBox(-10.0F, -2.5F, -3.0F, 20.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(21.0F, 25.5F, 3.0F, -0.9163F, 0.0F, 1.5708F));

		PartDefinition Middle_r2 = RightArm.addOrReplaceChild("Middle_r2", CubeListBuilder.create().texOffs(0, 71).addBox(-10.0F, -2.5F, -3.0F, 20.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(17.0F, 8.25F, -1.25F, -0.7549F, -0.4931F, 1.1039F));

		PartDefinition Upper_r2 = RightArm.addOrReplaceChild("Upper_r2", CubeListBuilder.create().texOffs(104, 49).addBox(-7.5F, -2.5F, -2.5F, 15.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.75F, 0.5F, -3.0F, 0.0F, 0.4363F, 0.0F));

		PartDefinition LeftLeg = Root.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(0, 104).addBox(-15.5F, -3.0F, -1.25F, 17.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -28.0F, -12.0F, 0.0F, -0.5236F, 0.0F));

		PartDefinition bone8 = LeftLeg.addOrReplaceChild("bone8", CubeListBuilder.create(), PartPose.offsetAndRotation(-13.8177F, 0.0F, 0.9222F, 0.0436F, 0.9163F, -0.0436F));

		PartDefinition cube_r55 = bone8.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(98, 99).addBox(-8.0F, -2.5F, -3.0F, 16.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.4323F, 19.25F, -2.4222F, -0.0873F, -0.1309F, -1.5708F));

		PartDefinition Middle_r3 = bone8.addOrReplaceChild("Middle_r3", CubeListBuilder.create().texOffs(52, 83).addBox(-10.0F, -2.5F, -3.0F, 20.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.6823F, 6.0F, -1.1722F, 0.0F, -0.1309F, -0.8727F));

		PartDefinition RightLeg = Root.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(104, 59).addBox(-0.5F, -3.0F, -2.8026F, 15.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -28.0F, -10.0F, 0.0F, 0.5236F, 0.0F));

		PartDefinition bone10 = RightLeg.addOrReplaceChild("bone10", CubeListBuilder.create(), PartPose.offsetAndRotation(20.4485F, 12.8462F, 7.0671F, 0.0436F, -0.9163F, 0.0436F));

		PartDefinition cube_r56 = bone10.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(98, 88).addBox(-8.0F, -2.5F, -3.0F, 16.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.375F, 6.875F, -0.75F, -0.0873F, 0.1309F, 1.5708F));

		PartDefinition cube_r57 = bone10.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(0, 82).addBox(-10.0F, -2.5F, -3.0F, 20.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.375F, -6.875F, 0.75F, 0.0F, 0.1309F, 0.8727F));

		return LayerDefinition.create(meshdefinition, 200, 128);
	}

	@Override
	public void setupAnim(@NotNull TWKikimoraEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Root.render(poseStack, buffer, packedLight, packedOverlay);
	}
}