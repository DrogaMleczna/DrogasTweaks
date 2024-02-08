package com.drogamleczna.drogastweaks.entity.client;

import com.drogamleczna.drogastweaks.DrogasTweaks;
import com.drogamleczna.drogastweaks.entity.custom.ScorpionEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ScorpionRenderer extends MobRenderer<ScorpionEntity, ScorpionModel<ScorpionEntity>> {
    public ScorpionRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ScorpionModel<>(pContext.bakeLayer(ModModelLayers.SCORPION_LAYER)), 0.4f);
    }

    @Override
    public ResourceLocation getTextureLocation(ScorpionEntity pEntity) {
        return new ResourceLocation(DrogasTweaks.MOD_ID, "textures/entity/scorpion.png");
    }

    @Override
    public void render(ScorpionEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {

        if(pEntity.isBaby()){
            pMatrixStack.scale(0.3f, 0.3f, 0.3f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
