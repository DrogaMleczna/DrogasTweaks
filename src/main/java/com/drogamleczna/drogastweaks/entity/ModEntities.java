package com.drogamleczna.drogastweaks.entity;

import com.drogamleczna.drogastweaks.DrogasTweaks;
import com.drogamleczna.drogastweaks.entity.custom.CrabEntity;
import com.drogamleczna.drogastweaks.entity.custom.LobsterEntity;
import com.drogamleczna.drogastweaks.entity.custom.ScorpionEntity;
import com.drogamleczna.drogastweaks.entity.custom.SnailEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, DrogasTweaks.MOD_ID);

    public static  final RegistryObject<EntityType<CrabEntity>> CRAB =
            ENTITY_TYPES.register("crab", () -> EntityType.Builder.of(CrabEntity::new, MobCategory.CREATURE)
                    .sized(0.3f,0.3f).build("crab"));
    public static  final RegistryObject<EntityType<LobsterEntity>> LOBSTER =
            ENTITY_TYPES.register("lobster", () -> EntityType.Builder.of(LobsterEntity::new, MobCategory.CREATURE)
                    .sized(0.3f,0.3f).build("lobster"));

    public static  final RegistryObject<EntityType<ScorpionEntity>> SCORPION =
            ENTITY_TYPES.register("scorpion", () -> EntityType.Builder.of(ScorpionEntity::new, MobCategory.CREATURE)
                    .sized(0.3f,0.3f).build("scorpion"));

    public static  final RegistryObject<EntityType<SnailEntity>> SNAIL =
            ENTITY_TYPES.register("snail", () -> EntityType.Builder.of(SnailEntity::new, MobCategory.CREATURE)
                    .sized(0.3f,0.3f).build("snail"));
    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }


}
