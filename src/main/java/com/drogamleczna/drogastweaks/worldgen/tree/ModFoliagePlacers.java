package com.drogamleczna.drogastweaks.worldgen.tree;

import com.drogamleczna.drogastweaks.DrogasTweaks;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;

public class ModFoliagePlacers {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS =
            DeferredRegister.create(Registries.FOLIAGE_PLACER_TYPE, DrogasTweaks.MOD_ID);
    public static void register(IEventBus eventBus){
        FOLIAGE_PLACERS.register(eventBus);
    }
}
