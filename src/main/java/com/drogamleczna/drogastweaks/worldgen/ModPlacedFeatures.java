package com.drogamleczna.drogastweaks.worldgen;

import com.drogamleczna.drogastweaks.DrogasTweaks;
import com.drogamleczna.drogastweaks.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> FLINT_BLOCK_PLACED_KEY = registerKey("flint_block_placed");

    public static final ResourceKey<PlacedFeature> WILLOW_PLACED_KEY = registerKey("willow_placed");
    public static final ResourceKey<PlacedFeature> DEAD_TREE_PLACED_KEY = registerKey("dead_tree_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?,?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        register(context, FLINT_BLOCK_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.FLINT_BLOCK_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(120))));

        register(context, WILLOW_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.WILLOW_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3,0.1f,2), //count, probability of extra, extra count
                        ModBlocks.WILLOW_SAPLING.get()));                                                         // 1/probability has to be int, error otherwise

        register(context, DEAD_TREE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.DEAD_TREE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(0,0.1f,1),
                        ModBlocks.DEAD_TREE_SAPLING.get()));
    }
    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(DrogasTweaks.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?,?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
