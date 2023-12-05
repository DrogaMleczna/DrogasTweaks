package com.drogamleczna.drogastweaks.entity;

import com.drogamleczna.drogastweaks.DrogasTweaks;
import com.drogamleczna.drogastweaks.entity.custom.CrabEntity;
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
    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }


}
