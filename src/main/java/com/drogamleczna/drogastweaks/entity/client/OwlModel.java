package com.drogamleczna.drogastweaks.entity.client;

// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.drogamleczna.drogastweaks.entity.animations.ModAnimationDefinitions;
import com.drogamleczna.drogastweaks.entity.custom.CrabEntity;
import com.drogamleczna.drogastweaks.entity.custom.OwlEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class OwlModel<T extends Entity> extends HierarchicalModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "owlmodel"), "main");
    private final ModelPart owl;
    private final ModelPart body;
    private final ModelPart wings;
    private final ModelPart left;
    private final ModelPart right;
    private final ModelPart tail;
    private final ModelPart head;

    public OwlModel(ModelPart root) {
        this.owl = root.getChild("owl");
        this.body = owl.getChild("body");
        this.head = owl.getChild("head");
        this.wings = owl.getChild("wings");
        this.left = wings.getChild("left");
        this.right = wings.getChild("right");
        this.tail = body.getChild("tail");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition owl = partdefinition.addOrReplaceChild("owl", CubeListBuilder.create(), PartPose.offset(0.0F, 22.0F, 0.0F));

        PartDefinition body = owl.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -4.0F, -3.0F, 6.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

        PartDefinition legs = body.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(-1.5F, 2.0F, -0.5F));

        PartDefinition left2 = legs.addOrReplaceChild("left2", CubeListBuilder.create().texOffs(21, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -2.0F, 0.0F));

        PartDefinition cube_r2 = left2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(13, 13).addBox(-0.5F, 0.0F, -1.5F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 15).addBox(-0.5F, 0.0F, -0.5F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

        PartDefinition right2 = legs.addOrReplaceChild("right2", CubeListBuilder.create().texOffs(17, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

        PartDefinition cube_r3 = right2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 4).addBox(-1.5F, 0.0F, -0.5F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-0.5F, 0.0F, -1.5F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r4 = tail.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -0.75F, 0.5F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 5.0F, -0.0436F, 0.0F, 0.0F));

        PartDefinition cube_r5 = tail.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(22, 19).addBox(-1.5F, 0.0F, -0.5F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 5.0F, -0.3491F, 0.0F, 0.0F));

        PartDefinition cube_r6 = tail.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(20, 16).addBox(-2.0F, 0.3927F, -0.2456F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 4.0F, -0.5236F, 0.0F, 0.0F));

        PartDefinition cube_r7 = tail.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(15, 13).addBox(-2.5F, -1.0F, 0.0F, 5.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 2.0F, -0.7418F, 0.0F, 0.0F));

        PartDefinition head = owl.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 13).addBox(-2.5F, -5.25F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(0, 23).addBox(-0.5F, -2.0F, -3.1F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, -1.5F));

        PartDefinition cube_r8 = head.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 15).addBox(0.0F, -1.0F, 1.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(0.0F, -2.0F, -1.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -5.0F, -1.5F, 0.0F, 0.0F, -0.8727F));

        PartDefinition cube_r9 = head.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.0F, 1.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 11).addBox(0.0F, -2.0F, -1.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -5.0F, -1.5F, 0.0F, 0.0F, 0.8727F));

        PartDefinition wings = owl.addOrReplaceChild("wings", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition left = wings.addOrReplaceChild("left", CubeListBuilder.create(), PartPose.offset(3.0F, -7.0F, 0.0F));

        PartDefinition cube_r10 = left.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 5.25F, -1.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.2618F, 0.0F, 0.0F));

        PartDefinition cube_r11 = left.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(22, 0).addBox(0.0F, -4.5F, -1.5F, 1.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, -1.0F, 0.2618F, 0.0F, 0.0F));

        PartDefinition right = wings.addOrReplaceChild("right", CubeListBuilder.create(), PartPose.offset(-3.0F, -7.0F, -2.0F));

        PartDefinition cube_r12 = right.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -0.75F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, 2.0F, 0.2618F, 0.0F, 0.0F));

        PartDefinition cube_r13 = right.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(16, 19).addBox(0.0F, -4.5F, -1.5F, 1.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 4.0F, 1.0F, 0.2618F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.animateWalk(ModAnimationDefinitions.OWL_WALK, limbSwing, limbSwingAmount, 10f, 5f);
        this.animate(((OwlEntity) entity).idleAnimationState, ModAnimationDefinitions.OWL_IDLE, ageInTicks, 1f);
        this.animate(((OwlEntity) entity).flyAnimationState, ModAnimationDefinitions.OWL_FLIGHT, ageInTicks, 1f);
        this.animate(((OwlEntity) entity).flyTransitionState, ModAnimationDefinitions.OWL_FLIGHT_TRANSITION, ageInTicks, 1f);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        owl.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart root() {
        return owl;
    }
}
