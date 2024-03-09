package com.drogamleczna.drogastweaks;

import com.drogamleczna.drogastweaks.block.ModBlocks;

import com.drogamleczna.drogastweaks.entity.ModEntities;
import com.drogamleczna.drogastweaks.entity.client.*;
import com.drogamleczna.drogastweaks.item.ModCreativeModTabs;
import com.drogamleczna.drogastweaks.item.ModItems;
import com.drogamleczna.drogastweaks.sound.ModSounds;
import com.drogamleczna.drogastweaks.util.ModPotionBrewing;
import com.drogamleczna.drogastweaks.worldgen.tree.ModFoliagePlacers;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(DrogasTweaks.MOD_ID)
public class DrogasTweaks {
    public static final String MOD_ID = "drogastweaks";
    public static final Logger LOGGER = LogUtils.getLogger();

    public DrogasTweaks() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModCreativeModTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEntities.register(modEventBus);
        modEventBus.addListener(this::commonSetup);
        ModFoliagePlacers.register(modEventBus);
        ModSounds.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        BrewingRecipeRegistry.addRecipe(new ModPotionBrewing(Potions.AWKWARD, ModItems.STINGER.get(), Potions.POISON));
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntities.CRAB.get(), CrabRenderer::new);
            EntityRenderers.register(ModEntities.LOBSTER.get(), LobsterRenderer::new);
            EntityRenderers.register(ModEntities.SCORPION.get(), ScorpionRenderer::new);
            EntityRenderers.register(ModEntities.SNAIL.get(), SnailRenderer::new);
            EntityRenderers.register(ModEntities.OWL.get(), OwlRenderer::new);
            EntityRenderers.register(ModEntities.MOUSE.get(), MouseRenderer::new);

        }
    }
}