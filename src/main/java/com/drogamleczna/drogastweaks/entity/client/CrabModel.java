package com.drogamleczna.drogastweaks.entity.client;// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.drogamleczna.drogastweaks.entity.animations.ModAnimationDefinitions;
import com.drogamleczna.drogastweaks.entity.custom.CrabEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class CrabModel<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	private final ModelPart crab;
	private final ModelPart claw_left;
	private final ModelPart claw_right;

	public CrabModel(ModelPart root) {
		this.crab = root.getChild("crab");
		this.claw_left = root.getChild("crab").getChild("claw_left");
		this.claw_right = root.getChild("crab").getChild("claw_right");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition crab = partdefinition.addOrReplaceChild("crab", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition carpace = crab.addOrReplaceChild("carpace", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = carpace.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 7).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(16, 13).addBox(-2.0F, -4.0F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(16, 16).addBox(1.0F, -4.0F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition claw_right = crab.addOrReplaceChild("claw_right", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r2 = claw_right.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(13, 15).addBox(0.4617F, 0.0F, -0.113F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(6, 11).addBox(1.4617F, -1.0F, -0.113F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -2.0F, -2.0F, -3.1416F, 0.48F, 3.1416F));

		PartDefinition lg3 = crab.addOrReplaceChild("lg3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r3 = lg3.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-0.2257F, -0.9182F, -0.0937F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -2.0F, 3.0F, 2.7578F, 0.2129F, 2.0529F));

		PartDefinition cube_r4 = lg3.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 15).addBox(-0.734F, -0.8484F, -0.0603F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -2.0F, 3.0F, 2.8362F, -0.1719F, -2.0679F));

		PartDefinition lg2 = crab.addOrReplaceChild("lg2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r5 = lg2.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(9, 14).addBox(-0.563F, -0.5522F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -2.0F, 1.0F, 3.1416F, 0.0F, -2.0944F));

		PartDefinition cube_r6 = lg2.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(5, 14).addBox(-0.437F, -0.5522F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -2.0F, 1.0F, -3.1416F, 0.0F, 2.0944F));

		PartDefinition lg1 = crab.addOrReplaceChild("lg1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r7 = lg1.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(14, 7).addBox(-0.4051F, -0.2488F, -0.0603F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -2.0F, -1.0F, -2.8293F, 0.1586F, -2.0257F));

		PartDefinition cube_r8 = lg1.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(12, 11).addBox(-0.6321F, -0.1337F, -0.113F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -2.0F, -1.0F, -2.7008F, -0.1964F, 1.963F));

		PartDefinition claw_left = crab.addOrReplaceChild("claw_left", CubeListBuilder.create(), PartPose.offset(2.0F, -1.0F, 0.0F));

		PartDefinition cube_r9 = claw_left.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 11).addBox(-0.2358F, -1.0F, 0.9635F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(16, 11).addBox(-0.2358F, 0.0F, -0.0365F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -1.0F, -2.0F, -3.1416F, 1.0908F, 3.1416F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animateWalk(ModAnimationDefinitions.CRAB_WALK, limbSwing, limbSwingAmount, 10f, 5f);
		this.animate(((CrabEntity) entity).idleAnimationState, ModAnimationDefinitions.CRAB_IDLE, ageInTicks, 1f);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		crab.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return crab;
	}
}