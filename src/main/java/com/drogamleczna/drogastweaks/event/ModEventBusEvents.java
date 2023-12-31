package com.drogamleczna.drogastweaks.event;

import com.drogamleczna.drogastweaks.DrogasTweaks;
import com.drogamleczna.drogastweaks.entity.ModEntities;
import com.drogamleczna.drogastweaks.entity.custom.CrabEntity;
import com.drogamleczna.drogastweaks.entity.custom.LobsterEntity;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DrogasTweaks.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.CRAB.get(), CrabEntity.createAttributes().build());
        event.put(ModEntities.LOBSTER.get(), LobsterEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerSpawnPlacements(SpawnPlacementRegisterEvent event){
        event.register(ModEntities.CRAB.get(), SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.WORLD_SURFACE, CrabEntity::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register(ModEntities.LOBSTER.get(), SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.OCEAN_FLOOR, LobsterEntity::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);

    }
}
