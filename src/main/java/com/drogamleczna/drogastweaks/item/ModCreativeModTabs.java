package com.drogamleczna.drogastweaks.item;

import com.drogamleczna.drogastweaks.DrogasTweaks;
import com.drogamleczna.drogastweaks.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DrogasTweaks.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("drogas_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BATON.get()))
                    .title(Component.translatable("creativetab.drogas_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.BATON.get());

                        pOutput.accept(ModItems.CRAB_LEG.get());
                        pOutput.accept(ModItems.COOKED_CRAB_LEG.get());
                        pOutput.accept(ModItems.CRAB_SPAWN_EGG.get());

                        pOutput.accept(ModItems.LOBSTER_SPAWN_EGG.get());
                        pOutput.accept(ModItems.RAW_LOBSTER.get());
                        pOutput.accept(ModItems.COOKED_LOBSTER.get());

                        pOutput.accept(ModItems.PEAR.get());

                        pOutput.accept(ModBlocks.WILLOW_LEAVES.get());
                        pOutput.accept(ModBlocks.WILLOW_LOG.get());
                        pOutput.accept(ModBlocks.WILLOW_WOOD.get());
                        pOutput.accept(ModBlocks.STRIPPED_WILLOW_LOG.get());
                        pOutput.accept(ModBlocks.STRIPPED_WILLOW_WOOD.get());
                        pOutput.accept(ModBlocks.WILLOW_PLANKS.get());
                        pOutput.accept(ModBlocks.WILLOW_SAPLING.get());

                        pOutput.accept(ModBlocks.TWIGS.get());
                        pOutput.accept(ModBlocks.DEAD_TREE_SAPLING.get());

                        pOutput.accept(ModBlocks.FLINT_BLOCK.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}