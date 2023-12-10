package com.drogamleczna.drogastweaks.entity.client;

import com.drogamleczna.drogastweaks.DrogasTweaks;
import com.drogamleczna.drogastweaks.entity.custom.CrabEntity;
import com.drogamleczna.drogastweaks.entity.custom.LobsterEntity;
import com.drogamleczna.drogastweaks.entity.variant.LobsterVariant;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public class LobsterRenderer extends MobRenderer<LobsterEntity, LobsterModel<LobsterEntity>> {

    public static final Map<LobsterVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(LobsterVariant.class), (p_114874_) -> {
                p_114874_.put(LobsterVariant.DEFAULT,
                        new ResourceLocation(DrogasTweaks.MOD_ID, "textures/entity/lobster.png"));
                p_114874_.put(LobsterVariant.BLUE,
                        new ResourceLocation(DrogasTweaks.MOD_ID, "textures/entity/blue_lobster.png"));
            });
    public LobsterRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new LobsterModel<>(pContext.bakeLayer(ModModelLayers.LOBSTER_LAYER)), 0.25f);
    }


    @Override
    public ResourceLocation getTextureLocation(LobsterEntity pEntity) {
        return LOCATION_BY_VARIANT.get(pEntity.getVariant());
    }

    @Override
    public void render(LobsterEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()){
            pMatrixStack.scale(0.3f,0.3f,0.3f);
        }
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
