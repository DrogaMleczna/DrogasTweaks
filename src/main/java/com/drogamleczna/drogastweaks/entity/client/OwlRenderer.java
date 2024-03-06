package com.drogamleczna.drogastweaks.entity.client;

import com.drogamleczna.drogastweaks.DrogasTweaks;
import com.drogamleczna.drogastweaks.entity.custom.CrabEntity;
import com.drogamleczna.drogastweaks.entity.custom.OwlEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class OwlRenderer extends MobRenderer<OwlEntity, OwlModel<OwlEntity>> {
    public OwlRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new OwlModel<>(pContext.bakeLayer(ModModelLayers.OWL_LAYER)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(OwlEntity pEntity) {
        return new ResourceLocation(DrogasTweaks.MOD_ID, "textures/entity/owl.png");
    }

    @Override
    public void render(OwlEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()){
            pMatrixStack.scale(0.4f,0.4f,0.4f);
        }
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}

