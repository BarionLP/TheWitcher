// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports


public class Imlerith extends EntityModel<Entity> {
	private final ModelRenderer Head;
	private final ModelRenderer Gems_r1;
	private final ModelRenderer Skull;
	private final ModelRenderer bone_r1;
	private final ModelRenderer bone_r2;
	private final ModelRenderer bone_r3;
	private final ModelRenderer bone_r4;
	private final ModelRenderer bone_r5;
	private final ModelRenderer bone_r6;
	private final ModelRenderer bone_r7;
	private final ModelRenderer bone_r8;
	private final ModelRenderer bone_r9;
	private final ModelRenderer HornSet;
	private final ModelRenderer Horns;
	private final ModelRenderer Horn_r1;
	private final ModelRenderer Horn_r2;
	private final ModelRenderer Horns2;
	private final ModelRenderer Horn_r3;
	private final ModelRenderer Horn_r4;
	private final ModelRenderer Horns3;
	private final ModelRenderer Horn_r5;
	private final ModelRenderer Horn_r6;
	private final ModelRenderer Horns4;
	private final ModelRenderer Horn_r7;
	private final ModelRenderer Horn_r8;
	private final ModelRenderer Horns5;
	private final ModelRenderer Horn_r9;
	private final ModelRenderer Horn_r10;
	private final ModelRenderer Horns6;
	private final ModelRenderer Horn_r11;
	private final ModelRenderer Horn_r12;
	private final ModelRenderer Horns7;
	private final ModelRenderer Horn_r13;
	private final ModelRenderer Horn_r14;
	private final ModelRenderer Horns8;
	private final ModelRenderer Horn_r15;
	private final ModelRenderer Horn_r16;
	private final ModelRenderer Body;
	private final ModelRenderer FrontCape_r1;
	private final ModelRenderer ShoulderCape_r1;
	private final ModelRenderer Gems_r2;
	private final ModelRenderer Gems_r3;
	private final ModelRenderer WholeRibCage2;
	private final ModelRenderer CenterBone_r1;
	private final ModelRenderer RibCage4;
	private final ModelRenderer Ribs13;
	private final ModelRenderer rib_r1;
	private final ModelRenderer rib_r2;
	private final ModelRenderer Ribs14;
	private final ModelRenderer rib_r3;
	private final ModelRenderer rib_r4;
	private final ModelRenderer Ribs15;
	private final ModelRenderer rib_r5;
	private final ModelRenderer rib_r6;
	private final ModelRenderer Ribs16;
	private final ModelRenderer rib_r7;
	private final ModelRenderer rib_r8;
	private final ModelRenderer Ribs18;
	private final ModelRenderer rib_r9;
	private final ModelRenderer rib_r10;
	private final ModelRenderer RibCage3;
	private final ModelRenderer Ribs9;
	private final ModelRenderer rib_r11;
	private final ModelRenderer rib_r12;
	private final ModelRenderer Ribs10;
	private final ModelRenderer rib_r13;
	private final ModelRenderer rib_r14;
	private final ModelRenderer Ribs11;
	private final ModelRenderer rib_r15;
	private final ModelRenderer rib_r16;
	private final ModelRenderer Ribs12;
	private final ModelRenderer rib_r17;
	private final ModelRenderer rib_r18;
	private final ModelRenderer Ribs17;
	private final ModelRenderer rib_r19;
	private final ModelRenderer rib_r20;
	private final ModelRenderer UpperArea;
	private final ModelRenderer CollarBone;
	private final ModelRenderer rib_r21;
	private final ModelRenderer rib_r22;
	private final ModelRenderer CollarBone2;
	private final ModelRenderer rib_r23;
	private final ModelRenderer rib_r24;
	private final ModelRenderer CollarBone3;
	private final ModelRenderer rib_r25;
	private final ModelRenderer rib_r26;
	private final ModelRenderer CollarBone4;
	private final ModelRenderer rib_r27;
	private final ModelRenderer rib_r28;
	private final ModelRenderer WholeRibCage;
	private final ModelRenderer RibCage;
	private final ModelRenderer Ribs;
	private final ModelRenderer rib_r29;
	private final ModelRenderer rib_r30;
	private final ModelRenderer Ribs2;
	private final ModelRenderer rib_r31;
	private final ModelRenderer rib_r32;
	private final ModelRenderer Ribs3;
	private final ModelRenderer rib_r33;
	private final ModelRenderer rib_r34;
	private final ModelRenderer Ribs4;
	private final ModelRenderer rib_r35;
	private final ModelRenderer rib_r36;
	private final ModelRenderer RibCage2;
	private final ModelRenderer Ribs5;
	private final ModelRenderer rib_r37;
	private final ModelRenderer rib_r38;
	private final ModelRenderer Ribs6;
	private final ModelRenderer rib_r39;
	private final ModelRenderer rib_r40;
	private final ModelRenderer Ribs7;
	private final ModelRenderer rib_r41;
	private final ModelRenderer rib_r42;
	private final ModelRenderer Ribs8;
	private final ModelRenderer rib_r43;
	private final ModelRenderer rib_r44;
	private final ModelRenderer Vcut;
	private final ModelRenderer rib_r45;
	private final ModelRenderer rib_r46;
	private final ModelRenderer Vcut2;
	private final ModelRenderer rib_r47;
	private final ModelRenderer rib_r48;
	private final ModelRenderer LeftArm;
	private final ModelRenderer ArmParts2;
	private final ModelRenderer Gems_r4;
	private final ModelRenderer Gems_r5;
	private final ModelRenderer bone4;
	private final ModelRenderer Gems_r6;
	private final ModelRenderer Gems_r7;
	private final ModelRenderer bone5;
	private final ModelRenderer Gems_r8;
	private final ModelRenderer Gems_r9;
	private final ModelRenderer Claws2;
	private final ModelRenderer RightArm;
	private final ModelRenderer ArmParts;
	private final ModelRenderer Gems_r10;
	private final ModelRenderer Gems_r11;
	private final ModelRenderer bone2;
	private final ModelRenderer Gems_r12;
	private final ModelRenderer Gems_r13;
	private final ModelRenderer bone3;
	private final ModelRenderer Gems_r14;
	private final ModelRenderer Gems_r15;
	private final ModelRenderer Claws;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer RightLeg;

	public Imlerith() {
		textureWidth = 64;
		textureHeight = 64;

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 0.0F, 0.0F);
		Head.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		Gems_r1 = new ModelRenderer(this);
		Gems_r1.setRotationPoint(0.0F, -6.0F, -5.0F);
		Head.addChild(Gems_r1);
		setRotationAngle(Gems_r1, -0.6981F, -0.6545F, -2.6616F);
		Gems_r1.setTextureOffset(36, 35).addBox(0.6F, -0.99F, 0.6F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		Skull = new ModelRenderer(this);
		Skull.setRotationPoint(0.0F, 24.0F, 0.0F);
		Head.addChild(Skull);
		

		bone_r1 = new ModelRenderer(this);
		bone_r1.setRotationPoint(-3.0F, -29.0F, -4.0F);
		Skull.addChild(bone_r1);
		setRotationAngle(bone_r1, -0.7854F, 0.0436F, -1.3526F);
		bone_r1.setTextureOffset(33, 35).addBox(-1.0F, -1.0F, -0.1142F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		bone_r2 = new ModelRenderer(this);
		bone_r2.setRotationPoint(1.0F, -25.0F, -4.0F);
		Skull.addChild(bone_r2);
		setRotationAngle(bone_r2, -0.7854F, -0.0873F, 1.5708F);
		bone_r2.setTextureOffset(34, 36).addBox(-1.0F, -1.0F, -0.1142F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		bone_r3 = new ModelRenderer(this);
		bone_r3.setRotationPoint(0.0F, -25.0F, -4.0F);
		Skull.addChild(bone_r3);
		setRotationAngle(bone_r3, -0.7854F, -0.0873F, 1.5708F);
		bone_r3.setTextureOffset(33, 35).addBox(-2.0F, -1.0F, -0.1142F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		bone_r4 = new ModelRenderer(this);
		bone_r4.setRotationPoint(-1.0F, -25.0F, -4.0F);
		Skull.addChild(bone_r4);
		setRotationAngle(bone_r4, -0.7854F, -0.0873F, 1.5708F);
		bone_r4.setTextureOffset(33, 33).addBox(-1.0F, -1.0F, -0.1142F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		bone_r5 = new ModelRenderer(this);
		bone_r5.setRotationPoint(3.0F, -29.0F, -4.0F);
		Skull.addChild(bone_r5);
		setRotationAngle(bone_r5, -0.7854F, -0.0436F, 1.3526F);
		bone_r5.setTextureOffset(33, 33).addBox(-2.0F, -1.0F, -0.1142F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		bone_r6 = new ModelRenderer(this);
		bone_r6.setRotationPoint(3.0F, -28.0F, -4.0F);
		Skull.addChild(bone_r6);
		setRotationAngle(bone_r6, -0.7854F, 0.0436F, -0.6109F);
		bone_r6.setTextureOffset(34, 36).addBox(-2.169F, -0.6157F, 0.1843F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		bone_r7 = new ModelRenderer(this);
		bone_r7.setRotationPoint(-3.0F, -28.0F, -4.0F);
		Skull.addChild(bone_r7);
		setRotationAngle(bone_r7, -0.7854F, -0.0436F, 0.6109F);
		bone_r7.setTextureOffset(33, 35).addBox(0.169F, -0.6157F, 0.1843F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		bone_r8 = new ModelRenderer(this);
		bone_r8.setRotationPoint(2.0F, -31.0F, -4.0F);
		Skull.addChild(bone_r8);
		setRotationAngle(bone_r8, -0.7854F, 0.0873F, -0.2182F);
		bone_r8.setTextureOffset(33, 34).addBox(-2.169F, -0.6157F, 0.1843F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		bone_r9 = new ModelRenderer(this);
		bone_r9.setRotationPoint(-2.0F, -31.0F, -4.0F);
		Skull.addChild(bone_r9);
		setRotationAngle(bone_r9, -0.7854F, -0.0873F, 0.2182F);
		bone_r9.setTextureOffset(33, 35).addBox(0.169F, -0.6157F, 0.1843F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		HornSet = new ModelRenderer(this);
		HornSet.setRotationPoint(0.0F, 24.0F, 0.0F);
		Head.addChild(HornSet);
		

		Horns = new ModelRenderer(this);
		Horns.setRotationPoint(0.0F, -33.0F, -4.0F);
		HornSet.addChild(Horns);
		

		Horn_r1 = new ModelRenderer(this);
		Horn_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Horns.addChild(Horn_r1);
		setRotationAngle(Horn_r1, -0.2182F, -0.7854F, -2.9671F);
		Horn_r1.setTextureOffset(1, 3).addBox(-0.9839F, -0.1697F, -0.9703F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		Horn_r2 = new ModelRenderer(this);
		Horn_r2.setRotationPoint(0.0F, 1.0F, -2.0F);
		Horns.addChild(Horn_r2);
		setRotationAngle(Horn_r2, -0.6981F, -0.6545F, -2.6616F);
		Horn_r2.setTextureOffset(2, 2).addBox(0.6F, -2.99F, 0.6F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		Horns2 = new ModelRenderer(this);
		Horns2.setRotationPoint(-4.0F, -30.0F, -4.0F);
		HornSet.addChild(Horns2);
		setRotationAngle(Horns2, 0.0F, 0.6981F, 0.0F);
		

		Horn_r3 = new ModelRenderer(this);
		Horn_r3.setRotationPoint(0.0F, -2.0F, 0.0F);
		Horns2.addChild(Horn_r3);
		setRotationAngle(Horn_r3, -0.2182F, -0.7854F, -2.9671F);
		Horn_r3.setTextureOffset(3, 2).addBox(-0.9839F, -0.1697F, -0.9703F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		Horn_r4 = new ModelRenderer(this);
		Horn_r4.setRotationPoint(0.0F, -1.0F, -2.0F);
		Horns2.addChild(Horn_r4);
		setRotationAngle(Horn_r4, -0.6981F, -0.6545F, -2.6616F);
		Horn_r4.setTextureOffset(0, 2).addBox(0.6F, -2.99F, 0.6F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		Horns3 = new ModelRenderer(this);
		Horns3.setRotationPoint(4.0F, -30.0F, -4.0F);
		HornSet.addChild(Horns3);
		setRotationAngle(Horns3, 0.0F, -0.6981F, 0.0F);
		

		Horn_r5 = new ModelRenderer(this);
		Horn_r5.setRotationPoint(0.0F, -2.0F, 0.0F);
		Horns3.addChild(Horn_r5);
		setRotationAngle(Horn_r5, -0.2182F, 0.7854F, 2.9671F);
		Horn_r5.setTextureOffset(0, 1).addBox(-0.0161F, -0.1697F, -0.9703F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		Horn_r6 = new ModelRenderer(this);
		Horn_r6.setRotationPoint(0.0F, -1.0F, -2.0F);
		Horns3.addChild(Horn_r6);
		setRotationAngle(Horn_r6, -0.6981F, 0.6545F, 2.6616F);
		Horn_r6.setTextureOffset(3, 2).addBox(-1.6F, -2.99F, 0.6F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		Horns4 = new ModelRenderer(this);
		Horns4.setRotationPoint(0.0F, -33.0F, 4.0F);
		HornSet.addChild(Horns4);
		

		Horn_r7 = new ModelRenderer(this);
		Horn_r7.setRotationPoint(0.0F, 0.0F, 0.0F);
		Horns4.addChild(Horn_r7);
		setRotationAngle(Horn_r7, 0.2182F, 0.7854F, -2.9671F);
		Horn_r7.setTextureOffset(0, 1).addBox(-0.9839F, -0.1697F, -0.0297F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		Horn_r8 = new ModelRenderer(this);
		Horn_r8.setRotationPoint(0.0F, 1.0F, 2.0F);
		Horns4.addChild(Horn_r8);
		setRotationAngle(Horn_r8, 0.6981F, 0.6545F, -2.6616F);
		Horn_r8.setTextureOffset(1, 1).addBox(0.6F, -2.99F, -1.6F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		Horns5 = new ModelRenderer(this);
		Horns5.setRotationPoint(-4.0F, -30.0F, 4.0F);
		HornSet.addChild(Horns5);
		setRotationAngle(Horns5, 0.0F, -0.6981F, 0.0F);
		

		Horn_r9 = new ModelRenderer(this);
		Horn_r9.setRotationPoint(0.0F, -2.0F, 0.0F);
		Horns5.addChild(Horn_r9);
		setRotationAngle(Horn_r9, 0.2182F, 0.7854F, -2.9671F);
		Horn_r9.setTextureOffset(0, 2).addBox(-0.9839F, -0.1697F, -0.0297F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		Horn_r10 = new ModelRenderer(this);
		Horn_r10.setRotationPoint(0.0F, -1.0F, 2.0F);
		Horns5.addChild(Horn_r10);
		setRotationAngle(Horn_r10, 0.6981F, 0.6545F, -2.6616F);
		Horn_r10.setTextureOffset(0, 0).addBox(0.6F, -2.99F, -1.6F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		Horns6 = new ModelRenderer(this);
		Horns6.setRotationPoint(4.0F, -30.0F, 4.0F);
		HornSet.addChild(Horns6);
		setRotationAngle(Horns6, 0.0F, 0.6981F, 0.0F);
		

		Horn_r11 = new ModelRenderer(this);
		Horn_r11.setRotationPoint(0.0F, -2.0F, 0.0F);
		Horns6.addChild(Horn_r11);
		setRotationAngle(Horn_r11, 0.2182F, -0.7854F, 2.9671F);
		Horn_r11.setTextureOffset(2, 1).addBox(-0.0161F, -0.1697F, -0.0297F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		Horn_r12 = new ModelRenderer(this);
		Horn_r12.setRotationPoint(0.0F, -1.0F, 2.0F);
		Horns6.addChild(Horn_r12);
		setRotationAngle(Horn_r12, 0.6981F, -0.6545F, 2.6616F);
		Horn_r12.setTextureOffset(0, 1).addBox(-1.6F, -2.99F, -1.6F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		Horns7 = new ModelRenderer(this);
		Horns7.setRotationPoint(-4.0F, -33.0F, 0.0F);
		HornSet.addChild(Horns7);
		setRotationAngle(Horns7, 0.0F, 1.5708F, 0.0F);
		

		Horn_r13 = new ModelRenderer(this);
		Horn_r13.setRotationPoint(0.0F, 0.0F, 0.0F);
		Horns7.addChild(Horn_r13);
		setRotationAngle(Horn_r13, -0.2182F, -0.7854F, -2.9671F);
		Horn_r13.setTextureOffset(1, 1).addBox(-0.9839F, -0.1697F, -0.9703F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		Horn_r14 = new ModelRenderer(this);
		Horn_r14.setRotationPoint(0.0F, 1.0F, -2.0F);
		Horns7.addChild(Horn_r14);
		setRotationAngle(Horn_r14, -0.6981F, -0.6545F, -2.6616F);
		Horn_r14.setTextureOffset(3, 2).addBox(0.6F, -2.99F, 0.6F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		Horns8 = new ModelRenderer(this);
		Horns8.setRotationPoint(4.0F, -33.0F, 0.0F);
		HornSet.addChild(Horns8);
		setRotationAngle(Horns8, 0.0F, -1.5708F, 0.0F);
		

		Horn_r15 = new ModelRenderer(this);
		Horn_r15.setRotationPoint(0.0F, 0.0F, 0.0F);
		Horns8.addChild(Horn_r15);
		setRotationAngle(Horn_r15, -0.2182F, 0.7854F, 2.9671F);
		Horn_r15.setTextureOffset(0, 1).addBox(-0.0161F, -0.1697F, -0.9703F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		Horn_r16 = new ModelRenderer(this);
		Horn_r16.setRotationPoint(0.0F, 1.0F, -2.0F);
		Horns8.addChild(Horn_r16);
		setRotationAngle(Horn_r16, -0.6981F, 0.6545F, 2.6616F);
		Horn_r16.setTextureOffset(1, 2).addBox(-1.6F, -2.99F, 0.6F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.setTextureOffset(0, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);

		FrontCape_r1 = new ModelRenderer(this);
		FrontCape_r1.setRotationPoint(0.0F, 12.0F, -2.0F);
		Body.addChild(FrontCape_r1);
		setRotationAngle(FrontCape_r1, -0.0436F, 0.0F, 0.0F);
		FrontCape_r1.setTextureOffset(40, 16).addBox(-2.5F, 0.0F, 0.0F, 5.0F, 7.0F, 0.0F, 0.0F, false);

		ShoulderCape_r1 = new ModelRenderer(this);
		ShoulderCape_r1.setRotationPoint(-4.0F, 0.0F, 2.0F);
		Body.addChild(ShoulderCape_r1);
		setRotationAngle(ShoulderCape_r1, 0.1745F, 0.0F, 0.0F);
		ShoulderCape_r1.setTextureOffset(40, 23).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 8.0F, 0.0F, 0.0F, false);

		Gems_r2 = new ModelRenderer(this);
		Gems_r2.setRotationPoint(0.0F, 11.0F, -3.0F);
		Body.addChild(Gems_r2);
		setRotationAngle(Gems_r2, -0.6981F, -0.6545F, -2.6616F);
		Gems_r2.setTextureOffset(4, 50).addBox(0.6F, -0.99F, 0.6F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		Gems_r3 = new ModelRenderer(this);
		Gems_r3.setRotationPoint(0.0F, 2.0F, -3.0F);
		Body.addChild(Gems_r3);
		setRotationAngle(Gems_r3, -0.6981F, -0.6545F, -2.6616F);
		Gems_r3.setTextureOffset(24, 49).addBox(0.6F, -0.99F, 0.6F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		WholeRibCage2 = new ModelRenderer(this);
		WholeRibCage2.setRotationPoint(0.0F, 20.0F, 3.0F);
		Body.addChild(WholeRibCage2);
		

		CenterBone_r1 = new ModelRenderer(this);
		CenterBone_r1.setRotationPoint(0.0F, -17.0F, -1.0F);
		WholeRibCage2.addChild(CenterBone_r1);
		setRotationAngle(CenterBone_r1, 0.0F, -0.8727F, 0.0F);
		CenterBone_r1.setTextureOffset(32, 46).addBox(-0.8F, -2.9692F, -0.7F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		RibCage4 = new ModelRenderer(this);
		RibCage4.setRotationPoint(0.0F, -18.0F, 0.0F);
		WholeRibCage2.addChild(RibCage4);
		

		Ribs13 = new ModelRenderer(this);
		Ribs13.setRotationPoint(0.0F, 18.9952F, -0.2181F);
		RibCage4.addChild(Ribs13);
		

		rib_r1 = new ModelRenderer(this);
		rib_r1.setRotationPoint(2.0F, -19.0F, -2.0F);
		Ribs13.addChild(rib_r1);
		setRotationAngle(rib_r1, -0.7854F, 0.0436F, 0.2618F);
		rib_r1.setTextureOffset(18, 48).addBox(-2.0F, -1.0F, -0.1142F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		rib_r2 = new ModelRenderer(this);
		rib_r2.setRotationPoint(2.0F, -19.0F, -2.0F);
		Ribs13.addChild(rib_r2);
		setRotationAngle(rib_r2, -0.7854F, 0.0436F, 0.0F);
		rib_r2.setTextureOffset(6, 51).addBox(0.0F, -1.0F, -0.1142F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		Ribs14 = new ModelRenderer(this);
		Ribs14.setRotationPoint(0.0F, 20.9952F, -0.2181F);
		RibCage4.addChild(Ribs14);
		

		rib_r3 = new ModelRenderer(this);
		rib_r3.setRotationPoint(2.0F, -19.0F, -2.0F);
		Ribs14.addChild(rib_r3);
		setRotationAngle(rib_r3, -0.7854F, 0.0436F, 0.2618F);
		rib_r3.setTextureOffset(4, 50).addBox(-2.0F, -1.0F, -0.1142F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		rib_r4 = new ModelRenderer(this);
		rib_r4.setRotationPoint(2.0F, -19.0F, -2.0F);
		Ribs14.addChild(rib_r4);
		setRotationAngle(rib_r4, -0.7854F, 0.0436F, 0.0F);
		rib_r4.setTextureOffset(3, 49).addBox(0.0F, -1.0F, -0.1142F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		Ribs15 = new ModelRenderer(this);
		Ribs15.setRotationPoint(0.0F, 22.9952F, -0.2181F);
		RibCage4.addChild(Ribs15);
		

		rib_r5 = new ModelRenderer(this);
		rib_r5.setRotationPoint(2.0F, -19.0F, -2.0F);
		Ribs15.addChild(rib_r5);
		setRotationAngle(rib_r5, -0.7854F, 0.0436F, 0.2618F);
		rib_r5.setTextureOffset(1, 50).addBox(-2.0F, -1.0F, -0.1142F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		rib_r6 = new ModelRenderer(this);
		rib_r6.setRotationPoint(2.0F, -19.0F, -2.0F);
		Ribs15.addChild(rib_r6);
		setRotationAngle(rib_r6, -0.7854F, 0.0436F, 0.0F);
		rib_r6.setTextureOffset(8, 49).addBox(0.0F, -1.0F, -0.1142F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		Ribs16 = new ModelRenderer(this);
		Ribs16.setRotationPoint(4.0F, 5.9952F, -2.2181F);
		RibCage4.addChild(Ribs16);
		setRotationAngle(Ribs16, 0.0F, 0.0F, 0.0873F);
		

		rib_r7 = new ModelRenderer(this);
		rib_r7.setRotationPoint(-2.0F, 0.0F, 0.0F);
		Ribs16.addChild(rib_r7);
		setRotationAngle(rib_r7, -0.7854F, 0.0436F, 0.5236F);
		rib_r7.setTextureOffset(13, 50).addBox(-2.0F, -1.0F, -0.1142F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		rib_r8 = new ModelRenderer(this);
		rib_r8.setRotationPoint(-2.0F, 0.0F, 0.0F);
		Ribs16.addChild(rib_r8);
		setRotationAngle(rib_r8, -0.7854F, 0.0436F, 0.0F);
		rib_r8.setTextureOffset(3, 50).addBox(0.0F, -1.0F, -0.1142F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		Ribs18 = new ModelRenderer(this);
		Ribs18.setRotationPoint(3.0F, 8.0048F, -2.2181F);
		RibCage4.addChild(Ribs18);
		setRotationAngle(Ribs18, 0.0F, -0.1309F, -0.0873F);
		

		rib_r9 = new ModelRenderer(this);
		rib_r9.setRotationPoint(-0.9959F, 0.0872F, 0.1812F);
		Ribs18.addChild(rib_r9);
		setRotationAngle(rib_r9, 0.7854F, 0.0436F, -0.5236F);
		rib_r9.setTextureOffset(4, 50).addBox(-2.0F, 0.0F, -0.1142F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		rib_r10 = new ModelRenderer(this);
		rib_r10.setRotationPoint(-0.9959F, 0.0872F, 0.1812F);
		Ribs18.addChild(rib_r10);
		setRotationAngle(rib_r10, 0.7854F, 0.0436F, 0.0F);
		rib_r10.setTextureOffset(3, 49).addBox(0.0F, 0.0F, -0.1142F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		RibCage3 = new ModelRenderer(this);
		RibCage3.setRotationPoint(0.0F, -18.0F, 0.0F);
		WholeRibCage2.addChild(RibCage3);
		

		Ribs9 = new ModelRenderer(this);
		Ribs9.setRotationPoint(0.0F, 18.9952F, -0.2181F);
		RibCage3.addChild(Ribs9);
		

		rib_r11 = new ModelRenderer(this);
		rib_r11.setRotationPoint(-2.0F, -19.0F, -2.0F);
		Ribs9.addChild(rib_r11);
		setRotationAngle(rib_r11, -0.7854F, -0.0436F, -0.2618F);
		rib_r11.setTextureOffset(15, 50).addBox(0.0F, -1.0F, -0.1142F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		rib_r12 = new ModelRenderer(this);
		rib_r12.setRotationPoint(-2.0F, -19.0F, -2.0F);
		Ribs9.addChild(rib_r12);
		setRotationAngle(rib_r12, -0.7854F, -0.0436F, 0.0F);
		rib_r12.setTextureOffset(6, 48).addBox(-2.0F, -1.0F, -0.1142F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		Ribs10 = new ModelRenderer(this);
		Ribs10.setRotationPoint(0.0F, 20.9952F, -0.2181F);
		RibCage3.addChild(Ribs10);
		

		rib_r13 = new ModelRenderer(this);
		rib_r13.setRotationPoint(-2.0F, -19.0F, -2.0F);
		Ribs10.addChild(rib_r13);
		setRotationAngle(rib_r13, -0.7854F, -0.0436F, -0.2618F);
		rib_r13.setTextureOffset(10, 49).addBox(0.0F, -1.0F, -0.1142F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		rib_r14 = new ModelRenderer(this);
		rib_r14.setRotationPoint(-2.0F, -19.0F, -2.0F);
		Ribs10.addChild(rib_r14);
		setRotationAngle(rib_r14, -0.7854F, -0.0436F, 0.0F);
		rib_r14.setTextureOffset(1, 51).addBox(-2.0F, -1.0F, -0.1142F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		Ribs11 = new ModelRenderer(this);
		Ribs11.setRotationPoint(0.0F, 22.9952F, -0.2181F);
		RibCage3.addChild(Ribs11);
		

		rib_r15 = new ModelRenderer(this);
		rib_r15.setRotationPoint(-2.0F, -19.0F, -2.0F);
		Ribs11.addChild(rib_r15);
		setRotationAngle(rib_r15, -0.7854F, -0.0436F, -0.2618F);
		rib_r15.setTextureOffset(3, 50).addBox(0.0F, -1.0F, -0.1142F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		rib_r16 = new ModelRenderer(this);
		rib_r16.setRotationPoint(-2.0F, -19.0F, -2.0F);
		Ribs11.addChild(rib_r16);
		setRotationAngle(rib_r16, -0.7854F, -0.0436F, 0.0F);
		rib_r16.setTextureOffset(0, 48).addBox(-2.0F, -1.0F, -0.1142F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		Ribs12 = new ModelRenderer(this);
		Ribs12.setRotationPoint(-4.0F, 5.9952F, -2.2181F);
		RibCage3.addChild(Ribs12);
		setRotationAngle(Ribs12, 0.0F, 0.0F, -0.0873F);
		

		rib_r17 = new ModelRenderer(this);
		rib_r17.setRotationPoint(2.0F, 0.0F, 0.0F);
		Ribs12.addChild(rib_r17);
		setRotationAngle(rib_r17, -0.7854F, -0.0436F, -0.5236F);
		rib_r17.setTextureOffset(19, 50).addBox(0.0F, -1.0F, -0.1142F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		rib_r18 = new ModelRenderer(this);
		rib_r18.setRotationPoint(2.0F, 0.0F, 0.0F);
		Ribs12.addChild(rib_r18);
		setRotationAngle(rib_r18, -0.7854F, -0.0436F, 0.0F);
		rib_r18.setTextureOffset(3, 50).addBox(-2.0F, -1.0F, -0.1142F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		Ribs17 = new ModelRenderer(this);
		Ribs17.setRotationPoint(-3.0F, 8.0048F, -2.2181F);
		RibCage3.addChild(Ribs17);
		setRotationAngle(Ribs17, 0.0F, 0.1309F, 0.0873F);
		

		rib_r19 = new ModelRenderer(this);
		rib_r19.setRotationPoint(0.9959F, 0.0872F, 0.1812F);
		Ribs17.addChild(rib_r19);
		setRotationAngle(rib_r19, 0.7854F, -0.0436F, 0.5236F);
		rib_r19.setTextureOffset(19, 50).addBox(0.0F, 0.0F, -0.1142F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		rib_r20 = new ModelRenderer(this);
		rib_r20.setRotationPoint(0.9959F, 0.0872F, 0.1812F);
		Ribs17.addChild(rib_r20);
		setRotationAngle(rib_r20, 0.7854F, -0.0436F, 0.0F);
		rib_r20.setTextureOffset(3, 50).addBox(-2.0F, 0.0F, -0.1142F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		UpperArea = new ModelRenderer(this);
		UpperArea.setRotationPoint(0.0F, 24.0F, 0.0F);
		Body.addChild(UpperArea);
		

		CollarBone = new ModelRenderer(this);
		CollarBone.setRotationPoint(-4.0F, -23.0F, -2.0F);
		UpperArea.addChild(CollarBone);
		setRotationAngle(CollarBone, 0.0F, 0.0F, -0.1745F);
		

		rib_r21 = new ModelRenderer(this);
		rib_r21.setRotationPoint(2.0F, 0.0F, 0.0F);
		CollarBone.addChild(rib_r21);
		setRotationAngle(rib_r21, 0.7854F, -0.0436F, 0.6109F);
		rib_r21.setTextureOffset(3, 50).addBox(0.0F, 0.0F, -0.1142F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		rib_r22 = new ModelRenderer(this);
		rib_r22.setRotationPoint(2.0F, 0.0F, 0.0F);
		CollarBone.addChild(rib_r22);
		setRotationAngle(rib_r22, 0.7854F, -0.0436F, 0.0F);
		rib_r22.setTextureOffset(1, 50).addBox(-2.0F, 0.0F, -0.1142F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		CollarBone2 = new ModelRenderer(this);
		CollarBone2.setRotationPoint(4.0F, -23.0F, -2.0F);
		UpperArea.addChild(CollarBone2);
		setRotationAngle(CollarBone2, 0.0F, 0.0F, 0.1745F);
		

		rib_r23 = new ModelRenderer(this);
		rib_r23.setRotationPoint(-2.0F, 0.0F, 0.0F);
		CollarBone2.addChild(rib_r23);
		setRotationAngle(rib_r23, 0.7854F, 0.0436F, -0.6109F);
		rib_r23.setTextureOffset(18, 50).addBox(-2.0F, 0.0F, -0.1142F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		rib_r24 = new ModelRenderer(this);
		rib_r24.setRotationPoint(-2.0F, 0.0F, 0.0F);
		CollarBone2.addChild(rib_r24);
		setRotationAngle(rib_r24, 0.7854F, 0.0436F, 0.0F);
		rib_r24.setTextureOffset(0, 50).addBox(0.0F, 0.0F, -0.1142F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		CollarBone3 = new ModelRenderer(this);
		CollarBone3.setRotationPoint(4.0F, -20.0F, -2.0F);
		UpperArea.addChild(CollarBone3);
		setRotationAngle(CollarBone3, 0.0F, 0.0F, -0.1745F);
		

		rib_r25 = new ModelRenderer(this);
		rib_r25.setRotationPoint(-2.0F, 0.0F, 0.0F);
		CollarBone3.addChild(rib_r25);
		setRotationAngle(rib_r25, -0.7854F, 0.0436F, 0.6109F);
		rib_r25.setTextureOffset(28, 49).addBox(-2.0F, -1.0F, -0.1142F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		rib_r26 = new ModelRenderer(this);
		rib_r26.setRotationPoint(-2.0F, 0.0F, 0.0F);
		CollarBone3.addChild(rib_r26);
		setRotationAngle(rib_r26, -0.7854F, 0.0436F, 0.0F);
		rib_r26.setTextureOffset(6, 49).addBox(0.0F, -1.0F, -0.1142F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		CollarBone4 = new ModelRenderer(this);
		CollarBone4.setRotationPoint(-4.0F, -20.0F, -2.0F);
		UpperArea.addChild(CollarBone4);
		setRotationAngle(CollarBone4, 0.0F, 0.0F, 0.1745F);
		

		rib_r27 = new ModelRenderer(this);
		rib_r27.setRotationPoint(2.0F, 0.0F, 0.0F);
		CollarBone4.addChild(rib_r27);
		setRotationAngle(rib_r27, -0.7854F, -0.0436F, -0.6109F);
		rib_r27.setTextureOffset(2, 50).addBox(0.0F, -1.0F, -0.1142F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		rib_r28 = new ModelRenderer(this);
		rib_r28.setRotationPoint(2.0F, 0.0F, 0.0F);
		CollarBone4.addChild(rib_r28);
		setRotationAngle(rib_r28, -0.7854F, -0.0436F, 0.0F);
		rib_r28.setTextureOffset(3, 49).addBox(-2.0F, -1.0F, -0.1142F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		WholeRibCage = new ModelRenderer(this);
		WholeRibCage.setRotationPoint(0.0F, 24.0F, 0.0F);
		Body.addChild(WholeRibCage);
		

		RibCage = new ModelRenderer(this);
		RibCage.setRotationPoint(0.0F, 0.0F, 0.0F);
		WholeRibCage.addChild(RibCage);
		

		Ribs = new ModelRenderer(this);
		Ribs.setRotationPoint(0.0F, 0.0F, 0.0F);
		RibCage.addChild(Ribs);
		

		rib_r29 = new ModelRenderer(this);
		rib_r29.setRotationPoint(-2.0F, -19.0F, -2.0F);
		Ribs.addChild(rib_r29);
		setRotationAngle(rib_r29, -0.7854F, -0.0436F, -0.2618F);
		rib_r29.setTextureOffset(1, 50).addBox(0.0F, -1.0F, -0.1142F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		rib_r30 = new ModelRenderer(this);
		rib_r30.setRotationPoint(-2.0F, -19.0F, -2.0F);
		Ribs.addChild(rib_r30);
		setRotationAngle(rib_r30, -0.7854F, -0.0436F, 0.0F);
		rib_r30.setTextureOffset(3, 50).addBox(-2.0F, -1.0F, -0.1142F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		Ribs2 = new ModelRenderer(this);
		Ribs2.setRotationPoint(0.0F, 1.0F, 0.0F);
		RibCage.addChild(Ribs2);
		

		rib_r31 = new ModelRenderer(this);
		rib_r31.setRotationPoint(-2.0F, -19.0F, -2.0F);
		Ribs2.addChild(rib_r31);
		setRotationAngle(rib_r31, -0.7854F, -0.0436F, -0.2618F);
		rib_r31.setTextureOffset(27, 49).addBox(0.0F, -1.0F, -0.1142F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		rib_r32 = new ModelRenderer(this);
		rib_r32.setRotationPoint(-2.0F, -19.0F, -2.0F);
		Ribs2.addChild(rib_r32);
		setRotationAngle(rib_r32, -0.7854F, -0.0436F, 0.0F);
		rib_r32.setTextureOffset(2, 50).addBox(-2.0F, -1.0F, -0.1142F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		Ribs3 = new ModelRenderer(this);
		Ribs3.setRotationPoint(0.0F, 2.0F, 0.0F);
		RibCage.addChild(Ribs3);
		

		rib_r33 = new ModelRenderer(this);
		rib_r33.setRotationPoint(-2.0F, -19.0F, -2.0F);
		Ribs3.addChild(rib_r33);
		setRotationAngle(rib_r33, -0.7854F, -0.0436F, -0.2618F);
		rib_r33.setTextureOffset(12, 49).addBox(0.0F, -1.0F, -0.1142F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		rib_r34 = new ModelRenderer(this);
		rib_r34.setRotationPoint(-2.0F, -19.0F, -2.0F);
		Ribs3.addChild(rib_r34);
		setRotationAngle(rib_r34, -0.7854F, -0.0436F, 0.0F);
		rib_r34.setTextureOffset(2, 50).addBox(-2.0F, -1.0F, -0.1142F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		Ribs4 = new ModelRenderer(this);
		Ribs4.setRotationPoint(-4.0F, -15.0F, -2.0F);
		RibCage.addChild(Ribs4);
		setRotationAngle(Ribs4, 0.0F, 0.0F, -0.0873F);
		

		rib_r35 = new ModelRenderer(this);
		rib_r35.setRotationPoint(2.0F, 0.0F, 0.0F);
		Ribs4.addChild(rib_r35);
		setRotationAngle(rib_r35, -0.7854F, -0.0436F, -0.5236F);
		rib_r35.setTextureOffset(30, 52).addBox(0.0F, -1.0F, -0.1142F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		rib_r36 = new ModelRenderer(this);
		rib_r36.setRotationPoint(2.0F, 0.0F, 0.0F);
		Ribs4.addChild(rib_r36);
		setRotationAngle(rib_r36, -0.7854F, -0.0436F, 0.0F);
		rib_r36.setTextureOffset(1, 50).addBox(-2.0F, -1.0F, -0.1142F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		RibCage2 = new ModelRenderer(this);
		RibCage2.setRotationPoint(0.0F, 0.0F, 0.0F);
		WholeRibCage.addChild(RibCage2);
		

		Ribs5 = new ModelRenderer(this);
		Ribs5.setRotationPoint(0.0F, 0.0F, 0.0F);
		RibCage2.addChild(Ribs5);
		

		rib_r37 = new ModelRenderer(this);
		rib_r37.setRotationPoint(2.0F, -19.0F, -2.0F);
		Ribs5.addChild(rib_r37);
		setRotationAngle(rib_r37, -0.7854F, 0.0436F, 0.2618F);
		rib_r37.setTextureOffset(14, 50).addBox(-2.0F, -1.0F, -0.1142F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		rib_r38 = new ModelRenderer(this);
		rib_r38.setRotationPoint(2.0F, -19.0F, -2.0F);
		Ribs5.addChild(rib_r38);
		setRotationAngle(rib_r38, -0.7854F, 0.0436F, 0.0F);
		rib_r38.setTextureOffset(2, 50).addBox(0.0F, -1.0F, -0.1142F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		Ribs6 = new ModelRenderer(this);
		Ribs6.setRotationPoint(0.0F, 1.0F, 0.0F);
		RibCage2.addChild(Ribs6);
		

		rib_r39 = new ModelRenderer(this);
		rib_r39.setRotationPoint(2.0F, -19.0F, -2.0F);
		Ribs6.addChild(rib_r39);
		setRotationAngle(rib_r39, -0.7854F, 0.0436F, 0.2618F);
		rib_r39.setTextureOffset(6, 50).addBox(-2.0F, -1.0F, -0.1142F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		rib_r40 = new ModelRenderer(this);
		rib_r40.setRotationPoint(2.0F, -19.0F, -2.0F);
		Ribs6.addChild(rib_r40);
		setRotationAngle(rib_r40, -0.7854F, 0.0436F, 0.0F);
		rib_r40.setTextureOffset(0, 52).addBox(0.0F, -1.0F, -0.1142F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		Ribs7 = new ModelRenderer(this);
		Ribs7.setRotationPoint(0.0F, 2.0F, 0.0F);
		RibCage2.addChild(Ribs7);
		

		rib_r41 = new ModelRenderer(this);
		rib_r41.setRotationPoint(2.0F, -19.0F, -2.0F);
		Ribs7.addChild(rib_r41);
		setRotationAngle(rib_r41, -0.7854F, 0.0436F, 0.2618F);
		rib_r41.setTextureOffset(25, 49).addBox(-2.0F, -1.0F, -0.1142F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		rib_r42 = new ModelRenderer(this);
		rib_r42.setRotationPoint(2.0F, -19.0F, -2.0F);
		Ribs7.addChild(rib_r42);
		setRotationAngle(rib_r42, -0.7854F, 0.0436F, 0.0F);
		rib_r42.setTextureOffset(0, 50).addBox(0.0F, -1.0F, -0.1142F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		Ribs8 = new ModelRenderer(this);
		Ribs8.setRotationPoint(4.0F, -15.0F, -2.0F);
		RibCage2.addChild(Ribs8);
		setRotationAngle(Ribs8, 0.0F, 0.0F, 0.0873F);
		

		rib_r43 = new ModelRenderer(this);
		rib_r43.setRotationPoint(-2.0F, 0.0F, 0.0F);
		Ribs8.addChild(rib_r43);
		setRotationAngle(rib_r43, -0.7854F, 0.0436F, 0.5236F);
		rib_r43.setTextureOffset(2, 50).addBox(-2.0F, -1.0F, -0.1142F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		rib_r44 = new ModelRenderer(this);
		rib_r44.setRotationPoint(-2.0F, 0.0F, 0.0F);
		Ribs8.addChild(rib_r44);
		setRotationAngle(rib_r44, -0.7854F, 0.0436F, 0.0F);
		rib_r44.setTextureOffset(1, 50).addBox(0.0F, -1.0F, -0.1142F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		Vcut = new ModelRenderer(this);
		Vcut.setRotationPoint(-4.0F, 10.0F, -2.0F);
		Body.addChild(Vcut);
		setRotationAngle(Vcut, 0.0F, 0.0F, -0.0873F);
		

		rib_r45 = new ModelRenderer(this);
		rib_r45.setRotationPoint(2.0F, 0.0F, 0.0F);
		Vcut.addChild(rib_r45);
		setRotationAngle(rib_r45, 0.7854F, -0.0436F, 0.6109F);
		rib_r45.setTextureOffset(0, 50).addBox(0.0F, 0.0F, -0.1142F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		rib_r46 = new ModelRenderer(this);
		rib_r46.setRotationPoint(2.0F, 0.0F, 0.0F);
		Vcut.addChild(rib_r46);
		setRotationAngle(rib_r46, 0.7854F, -0.0436F, 0.0F);
		rib_r46.setTextureOffset(3, 50).addBox(-2.0F, 0.0F, -0.1142F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		Vcut2 = new ModelRenderer(this);
		Vcut2.setRotationPoint(4.0F, 10.0F, -2.0F);
		Body.addChild(Vcut2);
		setRotationAngle(Vcut2, 0.0F, 0.0F, 0.0873F);
		

		rib_r47 = new ModelRenderer(this);
		rib_r47.setRotationPoint(-2.0F, 0.0F, 0.0F);
		Vcut2.addChild(rib_r47);
		setRotationAngle(rib_r47, 0.7854F, 0.0436F, -0.6109F);
		rib_r47.setTextureOffset(3, 51).addBox(-2.0F, 0.0F, -0.1142F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		rib_r48 = new ModelRenderer(this);
		rib_r48.setRotationPoint(-2.0F, 0.0F, 0.0F);
		Vcut2.addChild(rib_r48);
		setRotationAngle(rib_r48, 0.7854F, 0.0436F, 0.0F);
		rib_r48.setTextureOffset(0, 50).addBox(0.0F, 0.0F, -0.1142F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(4.0F, 1.0F, 0.0F);
		LeftArm.setTextureOffset(0, 32).addBox(0.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		ArmParts2 = new ModelRenderer(this);
		ArmParts2.setRotationPoint(-4.0F, 23.0F, 0.0F);
		LeftArm.addChild(ArmParts2);
		

		Gems_r4 = new ModelRenderer(this);
		Gems_r4.setRotationPoint(6.0F, -13.0F, 2.0F);
		ArmParts2.addChild(Gems_r4);
		setRotationAngle(Gems_r4, 1.0472F, 3.1416F, -1.0036F);
		Gems_r4.setTextureOffset(22, 52).addBox(-1.6F, 0.6F, -0.99F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		Gems_r5 = new ModelRenderer(this);
		Gems_r5.setRotationPoint(6.0F, -13.0F, -2.0F);
		ArmParts2.addChild(Gems_r5);
		setRotationAngle(Gems_r5, -1.0472F, -3.1416F, -1.0036F);
		Gems_r5.setTextureOffset(26, 52).addBox(-1.6F, 0.6F, -0.01F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(6.0F, -13.0F, -1.0F);
		ArmParts2.addChild(bone4);
		

		Gems_r6 = new ModelRenderer(this);
		Gems_r6.setRotationPoint(0.0F, 0.0F, 2.0F);
		bone4.addChild(Gems_r6);
		setRotationAngle(Gems_r6, 1.0908F, -3.098F, -1.0036F);
		Gems_r6.setTextureOffset(14, 52).addBox(-1.6F, 0.6F, -0.99F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		Gems_r7 = new ModelRenderer(this);
		Gems_r7.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone4.addChild(Gems_r7);
		setRotationAngle(Gems_r7, -1.0908F, 3.098F, -1.0036F);
		Gems_r7.setTextureOffset(18, 52).addBox(-1.6F, 0.6F, -0.01F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(6.0F, -14.0F, -1.0F);
		ArmParts2.addChild(bone5);
		

		Gems_r8 = new ModelRenderer(this);
		Gems_r8.setRotationPoint(0.0F, 0.0F, 2.0F);
		bone5.addChild(Gems_r8);
		setRotationAngle(Gems_r8, -1.0908F, -3.098F, 1.0036F);
		Gems_r8.setTextureOffset(6, 52).addBox(-1.6F, -1.6F, -0.99F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		Gems_r9 = new ModelRenderer(this);
		Gems_r9.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone5.addChild(Gems_r9);
		setRotationAngle(Gems_r9, 1.0908F, 3.098F, 1.0036F);
		Gems_r9.setTextureOffset(10, 52).addBox(-1.6F, -1.6F, -0.01F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		Claws2 = new ModelRenderer(this);
		Claws2.setRotationPoint(-4.0F, 23.0F, 0.0F);
		LeftArm.addChild(Claws2);
		Claws2.setTextureOffset(23, 51).addBox(7.0F, -12.0F, -1.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		Claws2.setTextureOffset(25, 51).addBox(7.0F, -12.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		Claws2.setTextureOffset(16, 49).addBox(4.0F, -12.0F, -1.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		Claws2.setTextureOffset(19, 50).addBox(7.0F, -12.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(-4.0F, 1.0F, 0.0F);
		RightArm.setTextureOffset(24, 16).addBox(-4.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		ArmParts = new ModelRenderer(this);
		ArmParts.setRotationPoint(4.0F, 23.0F, 0.0F);
		RightArm.addChild(ArmParts);
		

		Gems_r10 = new ModelRenderer(this);
		Gems_r10.setRotationPoint(-6.0F, -13.0F, 2.0F);
		ArmParts.addChild(Gems_r10);
		setRotationAngle(Gems_r10, 1.0472F, -3.1416F, 1.0036F);
		Gems_r10.setTextureOffset(18, 51).addBox(0.6F, 0.6F, -0.99F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		Gems_r11 = new ModelRenderer(this);
		Gems_r11.setRotationPoint(-6.0F, -13.0F, -2.0F);
		ArmParts.addChild(Gems_r11);
		setRotationAngle(Gems_r11, -1.0472F, 3.1416F, 1.0036F);
		Gems_r11.setTextureOffset(4, 51).addBox(0.6F, 0.6F, -0.01F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(-6.0F, -13.0F, -1.0F);
		ArmParts.addChild(bone2);
		

		Gems_r12 = new ModelRenderer(this);
		Gems_r12.setRotationPoint(0.0F, 0.0F, 2.0F);
		bone2.addChild(Gems_r12);
		setRotationAngle(Gems_r12, 1.0908F, 3.098F, 1.0036F);
		Gems_r12.setTextureOffset(19, 50).addBox(0.6F, 0.6F, -0.99F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		Gems_r13 = new ModelRenderer(this);
		Gems_r13.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone2.addChild(Gems_r13);
		setRotationAngle(Gems_r13, -1.0908F, -3.098F, 1.0036F);
		Gems_r13.setTextureOffset(0, 52).addBox(0.6F, 0.6F, -0.01F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(-6.0F, -14.0F, -1.0F);
		ArmParts.addChild(bone3);
		

		Gems_r14 = new ModelRenderer(this);
		Gems_r14.setRotationPoint(0.0F, 0.0F, 2.0F);
		bone3.addChild(Gems_r14);
		setRotationAngle(Gems_r14, -1.0908F, 3.098F, -1.0036F);
		Gems_r14.setTextureOffset(28, 49).addBox(0.6F, -1.6F, -0.99F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		Gems_r15 = new ModelRenderer(this);
		Gems_r15.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone3.addChild(Gems_r15);
		setRotationAngle(Gems_r15, 1.0908F, -3.098F, -1.0036F);
		Gems_r15.setTextureOffset(12, 51).addBox(0.6F, -1.6F, -0.01F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		Claws = new ModelRenderer(this);
		Claws.setRotationPoint(4.0F, 23.0F, 0.0F);
		RightArm.addChild(Claws);
		Claws.setTextureOffset(27, 51).addBox(-8.0F, -12.0F, -1.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		Claws.setTextureOffset(16, 49).addBox(-8.0F, -12.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		Claws.setTextureOffset(26, 49).addBox(-5.0F, -12.0F, -1.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		Claws.setTextureOffset(21, 51).addBox(-8.0F, -12.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
		LeftLeg.setTextureOffset(16, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
		RightLeg.setTextureOffset(32, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftArm.render(matrixStack, buffer, packedLight, packedOverlay);
		RightArm.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		RightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}