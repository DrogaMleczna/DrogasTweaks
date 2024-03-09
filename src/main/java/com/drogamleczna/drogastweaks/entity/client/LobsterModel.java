package com.drogamleczna.drogastweaks.entity.client;

import com.drogamleczna.drogastweaks.entity.animations.ModAnimationDefinitions;
import com.drogamleczna.drogastweaks.entity.custom.LobsterEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class LobsterModel<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor

	private final ModelPart body;
	private final ModelPart tail;
	private final ModelPart fin;
	private final ModelPart claw_left;
	private final ModelPart claw_right;
	private final ModelPart legs;
	private final ModelPart lobster;


	public LobsterModel(ModelPart root) {
		this.lobster = root.getChild("lobster");
		this.body = root.getChild("lobster").getChild("body");
		this.tail = root.getChild("lobster").getChild("tail");
		this.fin = root.getChild("lobster").getChild("fin");
		this.claw_left = root.getChild("lobster").getChild("claw_left");
		this.claw_right = root.getChild("lobster").getChild("claw_right");
		this.legs = root.getChild("lobster").getChild("legs");
	}


	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition lobster = partdefinition.addOrReplaceChild("lobster", CubeListBuilder.create(), PartPose.offset(0.0F, 23.0F, 0.0F));

		PartDefinition legs = lobster.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition left_front = legs.addOrReplaceChild("left_front", CubeListBuilder.create(), PartPose.offset(2.0F, -1.0F, -0.5F));

		PartDefinition cube_r1 = left_front.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(21, 18).addBox(-0.6934F, 0.0412F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition left_centre = legs.addOrReplaceChild("left_centre", CubeListBuilder.create(), PartPose.offset(2.0F, -1.0F, 1.5F));

		PartDefinition cube_r2 = left_centre.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(8, 21).addBox(-0.6934F, 0.0412F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition left_back = legs.addOrReplaceChild("left_back", CubeListBuilder.create(), PartPose.offset(2.0F, -1.0F, 3.5F));

		PartDefinition cube_r3 = left_back.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 21).addBox(-0.6934F, 0.0412F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition right_front = legs.addOrReplaceChild("right_front", CubeListBuilder.create(), PartPose.offset(-2.0F, -1.0F, -0.5F));

		PartDefinition cube_r4 = right_front.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(15, 20).addBox(-2.3066F, 0.0412F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition right_centre = legs.addOrReplaceChild("right_centre", CubeListBuilder.create(), PartPose.offset(-2.0F, -1.0F, 1.5F));

		PartDefinition cube_r5 = right_centre.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(13, 18).addBox(-2.3066F, 0.0412F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition right_back = legs.addOrReplaceChild("right_back", CubeListBuilder.create(), PartPose.offset(-2.0F, -1.0F, 3.5F));

		PartDefinition cube_r6 = right_back.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(15, 4).addBox(-2.3066F, 0.0412F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition claw_right = lobster.addOrReplaceChild("claw_right", CubeListBuilder.create().texOffs(15, 0).addBox(-4.5F, -1.0F, -6.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r7 = claw_right.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 17).addBox(0.25F, -1.0F, -1.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 0.0F, -2.0F, 0.0F, 0.6109F, 0.0F));

		PartDefinition claw_left = lobster.addOrReplaceChild("claw_left", CubeListBuilder.create().texOffs(15, 14).addBox(2.75F, -1.0F, -6.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r8 = claw_left.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(8, 17).addBox(-1.0F, -1.0F, -1.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, -2.0F, 0.0F, -0.7418F, 0.0F));

		PartDefinition fin = lobster.addOrReplaceChild("fin", CubeListBuilder.create().texOffs(12, 9).addBox(-3.0F, -1.0F, 1.0F, 6.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(12, 12).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 9.0F));

		PartDefinition tail = lobster.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 9).addBox(-1.5F, -2.0F, 0.0F, 3.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 5.0F));

		PartDefinition body = lobster.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animateWalk(ModAnimationDefinitions.LOBSTER_WALK, limbSwing, limbSwingAmount, 10f, 5f);
		this.animate(((LobsterEntity) entity).idleAnimationState, ModAnimationDefinitions.LOBSTER_IDLE, ageInTicks, 1f);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		lobster.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return lobster;
	}
}