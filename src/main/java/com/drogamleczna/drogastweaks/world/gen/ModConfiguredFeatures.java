//package com.drogamleczna.drogastweaks.world.gen;

//import com.drogamleczna.drogastweaks.block.ModBlocks;


//public class ModConfiguredFeatures {
    //public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> WILLOW =
    //        register("willow", Feature.TREE.withConfiguration((
    //                new BaseTreeFeatureConfig.Builder(
    //                new SimpleBlockStateProvider(ModBlocks.WILLOW_LOG.get().getDefaultState()),
    //                new SimpleBlockStateProvider(ModBlocks.WILLOW_LEAVES.get().getDefaultState()),
    //                new AcaciaFoliagePlacer(FeatureSpread.create(3), FeatureSpread.create(1)),
    //                new ForkyTrunkPlacer(4, 2, 2),
    //                new TwoLayerFeature(2, 1, 3))).setIgnoreVines().build()));

    //public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> DEAD_TREE =
    //        register("dead_tree", Feature.TREE.withConfiguration((
    //                new BaseTreeFeatureConfig.Builder(
    //                        new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()),
    //                        new SimpleBlockStateProvider(ModBlocks.TWIGS.get().getDefaultState()),
    //                        new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
    //                        new StraightTrunkPlacer(4, 2, 0),
   //                        new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build()));
//
    //private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String key, ConfiguredFeature<FC, ?> configuredFeature) {
    //    return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, key, configuredFeature);
    //}

//}
