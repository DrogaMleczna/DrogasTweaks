package com.drogamleczna.drogastweaks.worldgen.tree;

import com.drogamleczna.drogastweaks.DrogasTweaks;
import com.drogamleczna.drogastweaks.worldgen.tree.custom.WillowFoliagePlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModFoliagePlacers {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS =
            DeferredRegister.create(Registries.FOLIAGE_PLACER_TYPE, DrogasTweaks.MOD_ID);

    public static final RegistryObject<FoliagePlacerType<WillowFoliagePlacer>> WILLOW_FOLIAGE_PLACER =
            FOLIAGE_PLACERS.register("willow_foliage_placer", () -> new FoliagePlacerType<>(WillowFoliagePlacer.CODEC));

    public static void register(IEventBus eventBus){
        FOLIAGE_PLACERS.register(eventBus);
    }
}
