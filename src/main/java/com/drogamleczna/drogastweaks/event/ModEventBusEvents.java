package com.drogamleczna.drogastweaks.event;

import com.drogamleczna.drogastweaks.DrogasTweaks;
import com.drogamleczna.drogastweaks.entity.ModEntities;
import com.drogamleczna.drogastweaks.entity.custom.*;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
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
        event.put(ModEntities.SCORPION.get(), ScorpionEntity.createAttributes().build());
        event.put(ModEntities.SNAIL.get(), SnailEntity.createAttributes().build());
        event.put(ModEntities.OWL.get(), OwlEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerSpawnPlacements(SpawnPlacementRegisterEvent event){
        event.register(ModEntities.CRAB.get(), SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.WORLD_SURFACE, CrabEntity::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register(ModEntities.LOBSTER.get(), SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.OCEAN_FLOOR, LobsterEntity::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register(ModEntities.SCORPION.get(), SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.WORLD_SURFACE, ScorpionEntity::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register(ModEntities.SNAIL.get(), SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.WORLD_SURFACE, SnailEntity::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register(ModEntities.OWL.get(), SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.WORLD_SURFACE, OwlEntity::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);

    }
}
