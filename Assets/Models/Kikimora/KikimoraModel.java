// Made with Blockbench 4.0.5
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports


public class KikimoraModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "kikimoramodel"), "main");
	private final ModelPart Root;

	public KikimoraModel(ModelPart root) {
		this.Root = root.getChild("Root");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Root = partdefinition.addOrReplaceChild("Root", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition Head = Root.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offset(0.0F, -27.0F, -3.0F));

		PartDefinition Head_r1 = Head.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(54, 53).addBox(-8.0F, -6.0F, -9.0F, 16.0F, 12.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5893F, 26.5117F, -0.2182F, 0.0F, 0.0F));

		PartDefinition Zacken = Head.addOrReplaceChild("Zacken", CubeListBuilder.create(), PartPose.offset(0.0F, 21.0F, -10.0F));

		PartDefinition bone15 = Zacken.addOrReplaceChild("bone15", CubeListBuilder.create(), PartPose.offsetAndRotation(-14.0F, -9.0F, 15.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition cube_r1 = bone15.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(115, 4).addBox(0.6541F, -1.5354F, 19.9201F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(29.0F, -17.0F, 4.0F, 0.0F, 0.0F, -0.9599F));

		PartDefinition cube_r2 = bone15.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(116, 2).addBox(-0.2192F, -2.2055F, 19.9201F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(25.0F, -15.0F, 4.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition cube_r3 = bone15.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(129, 9).addBox(-1.5504F, 7.2544F, 26.9201F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.0F, -24.0F, -3.0F, 0.0F, 0.0F, 0.3054F));

		PartDefinition bone16 = Zacken.addOrReplaceChild("bone16", CubeListBuilder.create(), PartPose.offsetAndRotation(14.0F, -9.0F, 15.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition cube_r4 = bone16.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(115, 3).addBox(-5.6541F, -1.5354F, 19.9201F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-29.0F, -17.0F, 4.0F, 0.0F, 0.0F, 0.9599F));

		PartDefinition cube_r5 = bone16.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(112, 12).addBox(-5.7808F, -2.2055F, 19.9201F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-25.0F, -15.0F, 4.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition cube_r6 = bone16.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(123, 3).addBox(-2.4496F, 7.2544F, 26.9201F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-26.0F, -24.0F, -3.0F, 0.0F, 0.0F, -0.3054F));

		PartDefinition bone17 = Zacken.addOrReplaceChild("bone17", CubeListBuilder.create(), PartPose.offsetAndRotation(14.0F, -9.0F, 7.0F, -0.0873F, 0.0F, 0.0873F));

		PartDefinition cube_r7 = bone17.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(126, 14).addBox(-5.6541F, -1.5354F, 19.9201F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-29.0F, -17.0F, 4.0F, 0.0F, 0.0F, 0.9599F));

		PartDefinition cube_r8 = bone17.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(119, 5).addBox(-5.7808F, -2.2055F, 19.9201F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-25.0F, -15.0F, 4.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition cube_r9 = bone17.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(119, 10).addBox(-2.4496F, 7.2544F, 26.9201F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-26.0F, -24.0F, -3.0F, 0.0F, 0.0F, -0.3054F));

		PartDefinition bone18 = Zacken.addOrReplaceChild("bone18", CubeListBuilder.create(), PartPose.offsetAndRotation(-14.0F, -9.0F, 7.0F, -0.0873F, 0.0F, -0.0873F));

		PartDefinition cube_r10 = bone18.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(121, 6).addBox(0.6541F, -1.5354F, 19.9201F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(29.0F, -17.0F, 4.0F, 0.0F, 0.0F, -0.9599F));

		PartDefinition cube_r11 = bone18.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(119, 5).addBox(-0.2192F, -2.2055F, 19.9201F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(25.0F, -15.0F, 4.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition cube_r12 = bone18.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(123, 6).addBox(-1.5504F, 7.2544F, 26.9201F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.0F, -24.0F, -3.0F, 0.0F, 0.0F, 0.3054F));

		PartDefinition Zahne = Head.addOrReplaceChild("Zahne", CubeListBuilder.create(), PartPose.offset(0.0F, 21.0F, -10.0F));

		PartDefinition bone31 = Zahne.addOrReplaceChild("bone31", CubeListBuilder.create(), PartPose.offsetAndRotation(2.0F, -24.0F, 25.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition cube_r13 = bone31.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(127, 3).addBox(-0.5F, -12.5451F, 14.7022F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 3.4987F, 6.1788F, -0.9599F, 0.0F, 0.0F));

		PartDefinition cube_r14 = bone31.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(122, 6).addBox(0.0F, -1.5144F, 20.1548F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.725F, 0.3987F, -0.3491F, 0.0F, 0.0F));

		PartDefinition bone32 = Zahne.addOrReplaceChild("bone32", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, -29.0F, -3.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition cube_r15 = bone32.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(119, 2).addBox(-1.0F, -12.1507F, 16.4802F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 16.091F, 30.0834F, -0.9599F, 0.0F, 0.0F));

		PartDefinition cube_r16 = bone32.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(121, 2).addBox(-1.0F, -1.5144F, 20.1548F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 15.0F, 25.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition bone13 = Zahne.addOrReplaceChild("bone13", CubeListBuilder.create(), PartPose.offsetAndRotation(-6.9136F, -21.4126F, 24.8659F, -0.1309F, -0.3491F, 0.0F));

		PartDefinition cube_r17 = bone13.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(114, 7).addBox(-1.4567F, -3.5757F, 19.9962F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8389F, 0.42F, 2.8943F, 0.0F, 0.3491F, 0.0F));

		PartDefinition cube_r18 = bone13.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(130, 2).addBox(1.7332F, -10.5757F, 15.4994F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.8389F, 7.42F, 3.8943F, 0.0F, -0.3054F, 0.0F));

		PartDefinition bone14 = Zahne.addOrReplaceChild("bone14", CubeListBuilder.create(), PartPose.offsetAndRotation(7.0F, -21.0F, 24.0F, -0.1745F, 0.3491F, 0.0F));

		PartDefinition cube_r19 = bone14.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(119, 3).addBox(0.4119F, -4.4267F, 19.8731F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.6624F, 0.2364F, 3.1831F, 0.0F, -0.3491F, 0.0F));

		PartDefinition cube_r20 = bone14.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(118, 9).addBox(-2.6938F, -11.4267F, 15.3745F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.6624F, 7.2364F, 4.1831F, 0.0F, 0.3054F, 0.0F));

		PartDefinition bone11 = Zahne.addOrReplaceChild("bone11", CubeListBuilder.create(), PartPose.offsetAndRotation(2.0F, -14.0F, 24.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition cube_r21 = bone11.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(124, 5).addBox(0.0F, 7.142F, 18.6795F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0449F, 7.2205F, 0.9599F, 0.0F, 0.0F));

		PartDefinition cube_r22 = bone11.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(121, 5).addBox(0.0F, -4.0308F, 19.657F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.9539F, 2.1372F, 0.3491F, 0.0F, 0.0F));

		PartDefinition cube_r23 = bone11.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(125, 5).addBox(7.0F, -6.0869F, 12.4985F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -9.9539F, 3.1372F, -0.3054F, 0.0F, 0.0F));

		PartDefinition bone4 = Zahne.addOrReplaceChild("bone4", CubeListBuilder.create(), PartPose.offsetAndRotation(8.0F, -15.0F, 24.0F, -0.3491F, -0.1745F, -1.5708F));

		PartDefinition cube_r24 = bone4.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(116, 8).addBox(3.6466F, 10.9677F, 16.2189F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0449F, 7.2205F, 0.9599F, 0.0F, 0.0F));

		PartDefinition cube_r25 = bone4.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(129, 1).addBox(3.6466F, 0.5144F, 19.8358F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.9539F, 2.1372F, 0.3491F, 0.0F, 0.0F));

		PartDefinition cube_r26 = bone4.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(125, 6).addBox(10.6466F, -2.5898F, 15.4073F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -9.9539F, 3.1372F, -0.3054F, 0.0F, 0.0F));

		PartDefinition bone7 = Zahne.addOrReplaceChild("bone7", CubeListBuilder.create(), PartPose.offsetAndRotation(-7.0F, -17.0F, 24.0F, -0.3491F, 0.1745F, 1.5708F));

		PartDefinition cube_r27 = bone7.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(119, 3).addBox(-3.6466F, 10.9677F, 16.2189F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0449F, 7.2205F, 0.9599F, 0.0F, 0.0F));

		PartDefinition cube_r28 = bone7.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(116, 8).addBox(-3.6466F, 0.5144F, 19.8358F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.9539F, 2.1372F, 0.3491F, 0.0F, 0.0F));

		PartDefinition cube_r29 = bone7.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(126, 6).addBox(3.3534F, -2.5898F, 15.4073F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -9.9539F, 3.1372F, -0.3054F, 0.0F, 0.0F));

		PartDefinition bone12 = Zahne.addOrReplaceChild("bone12", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.0F, -14.0F, 24.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition cube_r30 = bone12.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(129, 2).addBox(-1.0F, 8.5508F, 18.5563F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -2.9539F, 6.1372F, 0.9599F, 0.0F, 0.0F));

		PartDefinition cube_r31 = bone12.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(124, 3).addBox(-1.0F, -4.0308F, 19.657F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -0.9539F, 2.1372F, 0.3491F, 0.0F, 0.0F));

		PartDefinition cube_r32 = bone12.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(123, 9).addBox(-8.0F, -6.0869F, 12.4985F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, -9.9539F, 3.1372F, -0.3054F, 0.0F, 0.0F));

		PartDefinition bone9 = Head.addOrReplaceChild("bone9", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Body = Root.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 37).addBox(-9.0F, -9.0377F, 21.2437F, 18.0F, 16.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -25.9623F, -21.2437F));

		PartDefinition cube_r33 = Body.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(0, 0).addBox(-8.5F, 0.0F, -17.0F, 17.0F, 12.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0377F, 14.2437F, 0.3054F, 0.0F, 0.0F));

		PartDefinition bone20 = Body.addOrReplaceChild("bone20", CubeListBuilder.create(), PartPose.offsetAndRotation(-12.0F, 10.9623F, 10.2437F, -0.0873F, 0.0F, -0.1745F));

		PartDefinition cube_r34 = bone20.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(115, 2).addBox(0.6541F, -1.5354F, 19.9201F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(29.0F, -17.0F, 4.0F, 0.0F, 0.0F, -0.9599F));

		PartDefinition cube_r35 = bone20.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(120, 6).addBox(-0.2192F, -2.2055F, 19.9201F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(25.0F, -15.0F, 4.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition cube_r36 = bone20.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(123, 4).addBox(-1.5504F, 7.2544F, 26.9201F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.0F, -24.0F, -3.0F, 0.0F, 0.0F, 0.3054F));

		PartDefinition bone21 = Body.addOrReplaceChild("bone21", CubeListBuilder.create(), PartPose.offsetAndRotation(14.0F, 10.9623F, -3.7563F, -0.0873F, 0.0F, 0.2182F));

		PartDefinition cube_r37 = bone21.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(115, 0).addBox(-5.7808F, -2.2055F, 19.9201F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-25.0F, -15.0F, 4.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition bone22 = Body.addOrReplaceChild("bone22", CubeListBuilder.create(), PartPose.offsetAndRotation(-14.0F, 10.9623F, -3.7563F, -0.0873F, 0.0F, -0.2182F));

		PartDefinition cube_r38 = bone22.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(119, 10).addBox(-0.2192F, -2.2055F, 19.9201F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(25.0F, -15.0F, 4.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition bone28 = Body.addOrReplaceChild("bone28", CubeListBuilder.create(), PartPose.offsetAndRotation(-9.0F, -2.0377F, -2.7563F, 0.0873F, 0.0F, 0.0F));

		PartDefinition cube_r39 = bone28.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(115, 5).addBox(-10.5417F, -1.5098F, 19.5715F, 10.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 2.5303F, -0.757F, 0.0F, 0.0F, -0.8727F));

		PartDefinition cube_r40 = bone28.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(121, 3).addBox(-5.7808F, -0.7945F, 19.9201F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.5303F, -0.757F, 0.0F, 0.0F, -0.3491F));

		PartDefinition cube_r41 = bone28.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(129, 3).addBox(-2.4496F, -10.2544F, 26.9201F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 9.5303F, -7.757F, 0.0F, 0.0F, 0.3054F));

		PartDefinition bone27 = Body.addOrReplaceChild("bone27", CubeListBuilder.create(), PartPose.offsetAndRotation(9.0F, -4.0377F, -3.7563F, 0.0873F, 0.0F, 0.0F));

		PartDefinition cube_r42 = bone27.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(116, 7).addBox(0.5417F, -1.5098F, 19.5715F, 10.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 3.5265F, -0.8441F, 0.0F, 0.0F, 0.8727F));

		PartDefinition cube_r43 = bone27.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(120, 6).addBox(-0.2192F, -0.7945F, 19.9201F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 1.5265F, -0.8441F, 0.0F, 0.0F, 0.3491F));

		PartDefinition cube_r44 = bone27.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(131, 5).addBox(-1.5504F, -10.2544F, 26.9201F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 10.5265F, -7.8441F, 0.0F, 0.0F, -0.3054F));

		PartDefinition bone19 = Body.addOrReplaceChild("bone19", CubeListBuilder.create(), PartPose.offsetAndRotation(12.0F, 10.9623F, 10.2437F, -0.0873F, 0.0F, 0.1745F));

		PartDefinition cube_r45 = bone19.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(117, 6).addBox(-5.6541F, -1.5354F, 19.9201F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-29.0F, -17.0F, 4.0F, 0.0F, 0.0F, 0.9599F));

		PartDefinition cube_r46 = bone19.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(121, 0).addBox(-5.7808F, -2.2055F, 19.9201F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-25.0F, -15.0F, 4.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition cube_r47 = bone19.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(131, 6).addBox(-2.4496F, 7.2544F, 26.9201F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-26.0F, -24.0F, -3.0F, 0.0F, 0.0F, -0.3054F));

		PartDefinition Tail = Root.addOrReplaceChild("Tail", CubeListBuilder.create(), PartPose.offset(0.0F, -22.0F, -39.0F));

		PartDefinition cube_r48 = Tail.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(67, 20).addBox(-8.0F, 0.0F, -17.0F, 16.0F, 12.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 24.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition bone24 = Tail.addOrReplaceChild("bone24", CubeListBuilder.create(), PartPose.offsetAndRotation(14.0F, 10.0F, -9.0F, -0.0873F, 0.0F, 0.0436F));

		PartDefinition cube_r49 = bone24.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(111, 0).addBox(-5.2382F, -3.5083F, 19.8292F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-24.001F, -15.0435F, 3.9962F, 0.0F, 0.0F, 0.3491F));

		PartDefinition bone26 = Tail.addOrReplaceChild("bone26", CubeListBuilder.create(), PartPose.offsetAndRotation(-14.0F, 10.0F, -9.0F, -0.0873F, 0.0F, -0.0436F));

		PartDefinition cube_r50 = bone26.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(123, 12).addBox(-1.6857F, -3.8908F, 19.8254F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(25.0F, -15.0F, 4.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition bone33 = Tail.addOrReplaceChild("bone33", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0F, -1.0F, -16.0F, 1.0908F, 0.0F, 0.0F));

		PartDefinition cube_r51 = bone33.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(113, 0).addBox(34.6514F, 43.5782F, -30.5627F, 5.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-37.0F, 6.2829F, 57.9306F, -0.8727F, 0.0F, 0.0F));

		PartDefinition cube_r52 = bone33.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(114, 2).addBox(35.0F, 22.7006F, -49.7005F, 5.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-37.0F, 4.2829F, 53.9306F, -0.3491F, 0.0F, 0.0F));

		PartDefinition cube_r53 = bone33.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(116, 5).addBox(42.0F, -21.4197F, -59.5703F, 5.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-44.0F, 13.2829F, 54.9306F, 0.3054F, 0.0F, 0.0F));

		PartDefinition bone29 = Tail.addOrReplaceChild("bone29", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0F, -7.0F, -14.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition cube_r54 = bone29.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(115, 1).addBox(34.6514F, 27.7497F, -33.3537F, 5.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-37.0F, 6.26F, 58.1922F, -0.8727F, 0.0F, 0.0F));

		PartDefinition cube_r55 = bone29.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(115, 2).addBox(35.0F, 7.5972F, -44.2033F, 5.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-37.0F, 4.26F, 54.1922F, -0.3491F, 0.0F, 0.0F));

		PartDefinition cube_r56 = bone29.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(115, 4).addBox(42.0F, -30.0556F, -46.0148F, 5.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-44.0F, 13.26F, 55.1922F, 0.3054F, 0.0F, 0.0F));

		PartDefinition LegLeftFront = Root.addOrReplaceChild("LegLeftFront", CubeListBuilder.create(), PartPose.offset(-8.0F, -34.0F, 12.0F));

		PartDefinition Lower_r1 = LegLeftFront.addOrReplaceChild("Lower_r1", CubeListBuilder.create().texOffs(0, 93).addBox(-19.0F, -0.5F, -3.25F, 20.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-22.5061F, 15.5F, 5.8492F, -0.9163F, 0.0F, -1.5708F));

		PartDefinition Middle_r1 = LegLeftFront.addOrReplaceChild("Middle_r1", CubeListBuilder.create().texOffs(52, 94).addBox(-19.8691F, -3.6085F, -3.1262F, 20.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.0F, 0.5F, -6.0F, -0.7559F, 0.4924F, -1.1043F));

		PartDefinition Upper_r1 = LegLeftFront.addOrReplaceChild("Upper_r1", CubeListBuilder.create().texOffs(44, 105).addBox(-13.5F, -2.5F, -2.5F, 15.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 0.5F, -0.5F, 0.0F, -0.4363F, 0.0F));

		PartDefinition LegRightFront = Root.addOrReplaceChild("LegRightFront", CubeListBuilder.create(), PartPose.offset(8.0F, -34.0F, 12.0F));

		PartDefinition Lower_r2 = LegRightFront.addOrReplaceChild("Lower_r2", CubeListBuilder.create().texOffs(59, 0).addBox(-2.0F, -2.5F, -3.0F, 20.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(21.0F, 17.5F, 3.0F, -0.9163F, 0.0F, 1.5708F));

		PartDefinition Middle_r2 = LegRightFront.addOrReplaceChild("Middle_r2", CubeListBuilder.create().texOffs(0, 71).addBox(0.0F, -2.5F, -3.0F, 20.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.0F, 0.5F, -6.0F, -0.7557F, -0.4922F, 1.103F));

		PartDefinition Upper_r2 = LegRightFront.addOrReplaceChild("Upper_r2", CubeListBuilder.create().texOffs(104, 49).addBox(0.0774F, -2.5F, -1.5937F, 15.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.5F, -0.5F, 0.0F, 0.4363F, 0.0F));

		PartDefinition LegLeftBack = Root.addOrReplaceChild("LegLeftBack", CubeListBuilder.create(), PartPose.offset(-7.0F, -28.0F, -10.0F));

		PartDefinition Leg3 = LegLeftBack.addOrReplaceChild("Leg3", CubeListBuilder.create().texOffs(0, 104).addBox(-5.5F, -3.0F, 16.1865F, 17.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -22.0F, 0.0F, -0.5236F, 0.0F));

		PartDefinition bone8 = Leg3.addOrReplaceChild("bone8", CubeListBuilder.create(), PartPose.offsetAndRotation(-14.3177F, 0.0F, 0.0562F, 0.0436F, 0.9163F, -0.0436F));

		PartDefinition cube_r57 = bone8.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(98, 99).addBox(-8.4559F, -11.7704F, 15.8633F, 16.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.9924F, 17.5712F, -2.3345F, -0.0873F, -0.1309F, -1.5708F));

		PartDefinition cube_r58 = bone8.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(52, 83).addBox(-13.573F, -7.8803F, 17.0016F, 20.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.6983F, 6.0573F, -1.0632F, 0.0F, -0.1309F, -0.8727F));

		PartDefinition LegRightBack = Root.addOrReplaceChild("LegRightBack", CubeListBuilder.create(), PartPose.offset(7.0F, -28.0F, -11.0F));

		PartDefinition Leg4 = LegRightBack.addOrReplaceChild("Leg4", CubeListBuilder.create().texOffs(104, 59).addBox(-11.5F, -3.0F, 16.1865F, 15.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -21.0F, 0.0F, 0.5236F, 0.0F));

		PartDefinition bone10 = Leg4.addOrReplaceChild("bone10", CubeListBuilder.create(), PartPose.offsetAndRotation(14.3177F, 0.0F, 0.0562F, 0.0436F, -0.9163F, 0.0436F));

		PartDefinition cube_r59 = bone10.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(98, 88).addBox(-9.234F, -12.1991F, 15.585F, 16.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.4539F, 19.408F, -1.3296F, -0.0873F, 0.1309F, 1.5708F));

		PartDefinition cube_r60 = bone10.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(0, 82).addBox(-6.62F, -7.6194F, 16.9523F, 20.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.8913F, 5.7964F, -0.0139F, 0.0F, 0.1309F, 0.8727F));

		return LayerDefinition.create(meshdefinition, 200, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Root.render(poseStack, buffer, packedLight, packedOverlay);
	}
}