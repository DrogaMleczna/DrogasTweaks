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

	private final ModelPart crab;
	private final ModelPart body;
	private final ModelPart legs;
	private final ModelPart claws;

	public CrabModel(ModelPart root) {
		this.crab = root.getChild("crab");
		this.body = crab.getChild("body");
		this.claws = crab.getChild("claws");
		this.legs = crab.getChild("legs");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition crab = partdefinition.addOrReplaceChild("crab", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = crab.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -4.0F, -1.0F, 6.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(18, 12).addBox(-2.0F, -5.0F, -1.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 12).addBox(1.0F, -5.0F, -1.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition legs = crab.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition left = legs.addOrReplaceChild("left", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition l1 = left.addOrReplaceChild("l1", CubeListBuilder.create(), PartPose.offset(3.0F, -2.0F, 0.0F));

		PartDefinition cube_r1 = l1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 10).addBox(0.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.2182F, 0.3491F));

		PartDefinition l2 = left.addOrReplaceChild("l2", CubeListBuilder.create(), PartPose.offset(3.0F, -2.0F, 1.0F));

		PartDefinition cube_r2 = l2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(16, 7).addBox(0.0F, 0.0F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition l3 = left.addOrReplaceChild("l3", CubeListBuilder.create(), PartPose.offset(3.0F, -2.0F, 2.0F));

		PartDefinition cube_r3 = l3.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(8, 7).addBox(0.0F, 0.0F, 0.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.2182F, 0.3491F));

		PartDefinition right = legs.addOrReplaceChild("right", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition r1 = right.addOrReplaceChild("r1", CubeListBuilder.create(), PartPose.offset(-3.0F, -2.0F, 0.0F));

		PartDefinition cube_r4 = r1.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 12).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.2182F, -0.3491F));

		PartDefinition r2 = right.addOrReplaceChild("r2", CubeListBuilder.create(), PartPose.offset(-3.0F, -2.0F, 1.0F));

		PartDefinition cube_r5 = r2.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(16, 10).addBox(-3.0F, 0.0F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition r3 = right.addOrReplaceChild("r3", CubeListBuilder.create(), PartPose.offset(-3.0F, -2.0F, 2.0F));

		PartDefinition cube_r6 = r3.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(8, 10).addBox(-3.0F, 0.0F, 0.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.2182F, -0.3491F));

		PartDefinition claws = crab.addOrReplaceChild("claws", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition left2 = claws.addOrReplaceChild("left2", CubeListBuilder.create().texOffs(0, 15).addBox(-1.0F, 0.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 7).addBox(-4.0F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -2.0F, -1.0F, 0.0F, -0.5672F, 0.0F));

		PartDefinition right2 = claws.addOrReplaceChild("right2", CubeListBuilder.create().texOffs(8, 12).addBox(1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 15).addBox(0.0F, 0.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -2.0F, -1.0F, 0.0F, 0.5672F, 0.0F));

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