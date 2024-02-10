package com.drogamleczna.drogastweaks.entity.client;// Made with Blockbench 4.9.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.drogamleczna.drogastweaks.entity.animations.ModAnimationDefinitions;
import com.drogamleczna.drogastweaks.entity.custom.CrabEntity;
import com.drogamleczna.drogastweaks.entity.custom.ScorpionEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class ScorpionModel<T extends Entity> extends HierarchicalModel<T> {

	private final ModelPart scorpion;
	private final ModelPart tail;
	private final ModelPart claws;
	private final ModelPart legs;

	public ScorpionModel(ModelPart root) {

		this.scorpion = root.getChild("scorpion");
		this.tail = scorpion.getChild("tail");
		this.claws = scorpion.getChild("claws");
		this.legs = scorpion.getChild("legs");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition scorpion = partdefinition.addOrReplaceChild("scorpion", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = scorpion.addOrReplaceChild("body", CubeListBuilder.create().texOffs(14, 0).addBox(-1.5F, -3.0F, -3.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-1.5F, -2.5F, 0.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition claws = scorpion.addOrReplaceChild("claws", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition right = claws.addOrReplaceChild("right", CubeListBuilder.create(), PartPose.offset(1.5F, -2.0F, -3.0F));

		PartDefinition cube_r1 = right.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 15).addBox(0.0F, 0.0F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition cube_r2 = right.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(10, 6).addBox(0.25F, 0.0F, -3.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, -1.0F, 0.0F, 0.1745F, 0.0F));

		PartDefinition left = claws.addOrReplaceChild("left", CubeListBuilder.create(), PartPose.offset(-1.5F, -2.0F, -3.0F));

		PartDefinition cube_r3 = left.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 15).mirror().addBox(-1.0F, 0.0F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.6109F, 0.0F));

		PartDefinition cube_r4 = left.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(10, 6).mirror().addBox(-2.25F, 0.0F, -3.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 0.0F, -1.0F, 0.0F, -0.1745F, 0.0F));

		PartDefinition legs = scorpion.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition group1 = legs.addOrReplaceChild("group1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition right_front = group1.addOrReplaceChild("right_front", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r5 = right_front.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(18, 13).addBox(-1.0F, -0.8F, 0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -1.0F, -2.0F, 0.0F, 0.2618F, 0.3054F));

		PartDefinition right_back = group1.addOrReplaceChild("right_back", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r6 = right_back.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 11).addBox(0.0F, 0.0F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -2.0F, 2.0F, 0.0F, -0.2618F, 0.2182F));

		PartDefinition left_centre = group1.addOrReplaceChild("left_centre", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r7 = left_centre.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(1, 1).mirror().addBox(-3.75F, 0.0F, 0.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, -2.0F, 0.0F, 0.0F, 0.0F, -0.2182F));

		PartDefinition group2 = legs.addOrReplaceChild("group2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition left_front = group2.addOrReplaceChild("left_front", CubeListBuilder.create(), PartPose.offset(-2.0F, -1.0F, -2.0F));

		PartDefinition cube_r8 = left_front.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(18, 13).mirror().addBox(-2.0F, -0.8F, 0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.2618F, -0.3054F));

		PartDefinition left_back = group2.addOrReplaceChild("left_back", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r9 = left_back.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 11).mirror().addBox(-4.0F, 0.0F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, -2.0F, 2.0F, 0.0F, 0.2618F, -0.2182F));

		PartDefinition right_centre = group2.addOrReplaceChild("right_centre", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r10 = right_centre.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(1, 1).addBox(0.75F, 0.0F, 0.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.2182F));

		PartDefinition tail = scorpion.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bone = tail.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r11 = bone.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 6).addBox(-1.0F, -1.5F, 0.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 4.0F, 0.48F, 0.0F, 0.0F));

		PartDefinition bone2 = tail.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(20, 6).addBox(-1.0F, -6.5F, 6.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bone3 = tail.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offset(0.0F, -6.0F, 6.0F));

		PartDefinition cube_r12 = bone3.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(16, 15).addBox(-0.5F, -3.0F, 1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.6981F, 0.0F, 0.0F));

		PartDefinition bone4 = tail.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(6, 15).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, 5.0F));

		PartDefinition bone5 = tail.addOrReplaceChild("bone5", CubeListBuilder.create(), PartPose.offset(0.0F, -8.75F, 3.5F));

		PartDefinition cube_r13 = bone5.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(20, 15).addBox(-0.5F, -0.75F, -0.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.75F, -0.5F, 0.829F, 0.0F, 0.0F));

		PartDefinition bone6 = tail.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(10, 11).addBox(-1.0F, -0.3716F, -0.5074F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 1.5F));

		PartDefinition bone7 = tail.addOrReplaceChild("bone7", CubeListBuilder.create(), PartPose.offset(0.0F, -7.8F, 1.0F));

		PartDefinition cube_r14 = bone7.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(12, 15).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.8F, 1.0F, 0.829F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animateWalk(ModAnimationDefinitions.SCORPION_WALK, limbSwing, limbSwingAmount, 10f, 5f);
		this.animate(((ScorpionEntity) entity).idleAnimationState, ModAnimationDefinitions.SCORPION_IDLE, ageInTicks, 1f);
		this.animate(((ScorpionEntity) entity).attackAnimationState, ModAnimationDefinitions.SCORPION_ATTACK, ageInTicks);

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		scorpion.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return scorpion;
	}
}