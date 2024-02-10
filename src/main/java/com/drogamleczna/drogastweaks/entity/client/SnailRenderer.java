package com.drogamleczna.drogastweaks.entity.client;

import com.drogamleczna.drogastweaks.DrogasTweaks;
import com.drogamleczna.drogastweaks.entity.custom.CrabEntity;
import com.drogamleczna.drogastweaks.entity.custom.SnailEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SnailRenderer extends MobRenderer<SnailEntity, SnailModel<SnailEntity>> {
    public SnailRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new SnailModel<>(pContext.bakeLayer(ModModelLayers.SNAIL_LAYER)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(SnailEntity pEntity) {
        return new ResourceLocation(DrogasTweaks.MOD_ID, "textures/entity/snail.png");
    }

    @Override
    public void render(SnailEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()){
            pMatrixStack.scale(0.3f,0.3f,0.3f);
        }
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
