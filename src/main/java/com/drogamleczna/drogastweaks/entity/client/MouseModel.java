package com.drogamleczna.drogastweaks.entity.client;

import com.drogamleczna.drogastweaks.entity.custom.MouseEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.Entity;
import com.drogamleczna.drogastweaks.entity.animations.ModAnimationDefinitions;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class MouseModel<T extends Entity> extends HierarchicalModel<T> {
    private final ModelPart mouse;
    private final ModelPart tail;
    private final ModelPart t1;
    private final ModelPart t2;

    public MouseModel(ModelPart root) {

        this.mouse = root.getChild("mouse");
        this.tail = mouse.getChild("tail");
        this.t1 = tail.getChild("t1");
        this.t2 = tail.getChild("t2");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition mouse = partdefinition.addOrReplaceChild("mouse", CubeListBuilder.create().texOffs(0, 7).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-1.5F, -3.0F, -1.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(2, 2).addBox(-2.0F, -3.0F, -2.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(2, 2).addBox(1.0F, -3.0F, -2.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(1, 1).addBox(-1.0F, -2.0F, 3.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition tail = mouse.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, 4.0F));

        PartDefinition t1 = tail.addOrReplaceChild("t1", CubeListBuilder.create().texOffs(0, 11).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition t2 = tail.addOrReplaceChild("t2", CubeListBuilder.create().texOffs(8, 7).addBox(-0.5F, 0.0F, 1.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 16, 16);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.animateWalk(ModAnimationDefinitions.MOUSE_WALK, limbSwing, limbSwingAmount, 10f, 5f);
        this.animate(((MouseEntity) entity).idleAnimationState, ModAnimationDefinitions.MOUSE_IDLE, ageInTicks, 1f);

    }


    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        mouse.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart root() {
        return mouse;
    }
}