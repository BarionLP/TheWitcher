// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports


public class MagicianOfTheWildHunt extends EntityModel<Entity> {
	private final ModelRenderer Head;
	private final ModelRenderer Krone;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer Body;
	private final ModelRenderer ArmLeft;
	private final ModelRenderer ArmRight;
	private final ModelRenderer LegLeft;
	private final ModelRenderer LegRight;
	private final ModelRenderer bb_main;
	private final ModelRenderer Cape_r1;

	public MagicianOfTheWildHunt() {
		textureWidth = 64;
		textureHeight = 64;

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 0.0F, 0.0F);
		Head.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		Krone = new ModelRenderer(this);
		Krone.setRotationPoint(0.0F, 0.0F, 0.0F);
		Head.addChild(Krone);
		Krone.setTextureOffset(24, 4).addBox(5.5F, -11.0F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		Krone.setTextureOffset(20, 16).addBox(-6.5F, -11.0F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(4.0F, -14.0F, 0.5F);
		Krone.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, -1.309F);
		cube_r1.setTextureOffset(0, 0).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-3.75F, -14.0F, 0.5F);
		Krone.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, -1.8326F);
		cube_r2.setTextureOffset(3, 3).addBox(-0.5F, -0.25F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(-5.0F, -12.5F, 0.5F);
		Krone.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.0F, -0.9599F);
		cube_r3.setTextureOffset(24, 2).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(5.0F, -12.5F, 0.5F);
		Krone.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 0.0F, 0.9599F);
		cube_r4.setTextureOffset(24, 0).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(-5.0F, -6.5F, 0.5F);
		Krone.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, 0.0F, 0.9599F);
		cube_r5.setTextureOffset(40, 16).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(5.0F, -6.5F, 0.5F);
		Krone.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, 0.0F, -0.9599F);
		cube_r6.setTextureOffset(40, 18).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 6.0F, 0.0F);
		Body.setTextureOffset(20, 16).addBox(-4.0F, -6.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);

		ArmLeft = new ModelRenderer(this);
		ArmLeft.setRotationPoint(4.0F, 1.0F, 0.0F);
		ArmLeft.setTextureOffset(36, 32).addBox(0.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		ArmRight = new ModelRenderer(this);
		ArmRight.setRotationPoint(-4.0F, 1.0F, 0.0F);
		ArmRight.setTextureOffset(20, 32).addBox(-4.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		LegLeft = new ModelRenderer(this);
		LegLeft.setRotationPoint(2.0F, 12.0F, 0.0F);
		LegLeft.setTextureOffset(0, 38).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		LegRight = new ModelRenderer(this);
		LegRight.setRotationPoint(-2.0F, 12.0F, 0.0F);
		LegRight.setTextureOffset(32, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		Cape_r1 = new ModelRenderer(this);
		Cape_r1.setRotationPoint(0.0F, -24.0F, 2.5F);
		bb_main.addChild(Cape_r1);
		setRotationAngle(Cape_r1, 0.0873F, 0.0F, 0.0F);
		Cape_r1.setTextureOffset(0, 16).addBox(-5.0F, 0.0F, -0.5F, 10.0F, 22.0F, 0.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
		ArmLeft.render(matrixStack, buffer, packedLight, packedOverlay);
		ArmRight.render(matrixStack, buffer, packedLight, packedOverlay);
		LegLeft.render(matrixStack, buffer, packedLight, packedOverlay);
		LegRight.render(matrixStack, buffer, packedLight, packedOverlay);
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}