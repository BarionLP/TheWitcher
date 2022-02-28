package com.barion.the_witcher.client.model;// Made with Blockbench 4.1.5


import com.barion.the_witcher.world.entity.TWIceGhost;
import com.github.alexthe666.citadel.client.model.AdvancedEntityModel;
import com.github.alexthe666.citadel.client.model.AdvancedModelBox;
import com.github.alexthe666.citadel.client.model.basic.BasicModelPart;
import com.google.common.collect.ImmutableList;

public class TWIceGhostModel extends AdvancedEntityModel<TWIceGhost>{
	public final TWModelBox Root;
	public final TWModelBox Body;
	public final TWModelBox Head;
	public final TWModelBox RightArm;
	public final TWModelBox LeftArm;

	public TWIceGhostModel(){
		Root = new TWModelBox(this, "Root");
		Root.setPos(0, 0, 0);

		Head = new TWModelBox(this, "Head");
		Head.setRotationPoint(0, 21, 0);
		Head.setTextureOffset(0, 19).addBox(-4, -8, -4, 8, 8, 8);
		TWModelBox HeadOverlay = new TWModelBox(this, "HeadOverlay");
		HeadOverlay.setRotationRad(0.1309f, 0, 0).addBox(-4, -4, 0, 8, 8, 11);
		Head.addChild(HeadOverlay);

		Body = new TWModelBox(this, "Body");
		Body.setTextureOffset(28, 31).addBox(-3, 0, -2, 4, 12, 4);
		Body.setRotationPoint(0, 21, 0);
		Body.setRotationRad(0.1745f, 0, 0);

		RightArm = new TWModelBox(this, "RightArm");
		RightArm.setTextureOffset(12, 47).addBox(-3, 0, -2, 4, 12, 4);
		RightArm.setTextureOffset(46, 0).addBox(-3, -2, -2, 4, 12, 4, 0.25f);
		RightArm.setRotationPoint(5, 19, 0);

		LeftArm = new TWModelBox(this, "LeftArm");
		LeftArm.setTextureOffset(0, 35).addBox(-1, -2, -2, 4, 12, 4);
		LeftArm.setTextureOffset(34, 15).addBox(-1, 0, -2, 4, 12, 4, 0.25f);

		Root.addChild(Head);
		Root.addChild(Body);
		Root.addChild(RightArm);
		Root.addChild(LeftArm);
	}


	/*public static void createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0.0F, 27.0F, 0.0F));

		PartDefinition Body = bone.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(28, 31).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 17.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition RightArm = bone.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(12, 47).addBox(-3.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F))
		.texOffs(46, 0).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -22.0F, 0.0F, -1.0472F, 0.0F, 0.0F));

		PartDefinition LeftArm = bone.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(0, 35).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(34, 15).addBox(-1.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(5.0F, -22.0F, 0.0F, -1.0472F, 0.0F, 0.0F));

		PartDefinition Head = bone.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 19).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition HatLayer_r1 = Head.addOrReplaceChild("HatLayer_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, 0.0F, 8.0F, 8.0F, 11.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(0.0F, -4.0F, -4.0F, 0.1309F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}*/

	@Override
	public void setupAnim(TWIceGhost entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public Iterable<AdvancedModelBox> getAllParts() {return ImmutableList.of(Root, Head, Body, RightArm, LeftArm);}

	@Override
	public Iterable<BasicModelPart> parts() {return ImmutableList.of(Root);}
}