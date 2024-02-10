package com.drogamleczna.drogastweaks.event;


import com.drogamleczna.drogastweaks.DrogasTweaks;
import com.drogamleczna.drogastweaks.entity.client.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DrogasTweaks.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(ModModelLayers.CRAB_LAYER, CrabModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.LOBSTER_LAYER, LobsterModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.SCORPION_LAYER, ScorpionModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.SNAIL_LAYER, SnailModel::createBodyLayer);
    }

}
