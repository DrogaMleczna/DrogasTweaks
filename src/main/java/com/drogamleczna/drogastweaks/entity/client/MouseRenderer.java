package com.drogamleczna.drogastweaks.entity.client;

import com.drogamleczna.drogastweaks.DrogasTweaks;
import com.drogamleczna.drogastweaks.entity.custom.MouseEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MouseRenderer extends MobRenderer<MouseEntity, MouseModel<MouseEntity>> {
    public MouseRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new MouseModel<>(pContext.bakeLayer(ModModelLayers.MOUSE_LAYER)), 0.1f);
    }

    @Override
    public ResourceLocation getTextureLocation(MouseEntity pEntity) {
        return new ResourceLocation(DrogasTweaks.MOD_ID, "textures/entity/mouse.png");
    }

    @Override
    public void render(MouseEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()){
            pMatrixStack.scale(0.4f,0.4f,0.4f);
        }
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }


}

