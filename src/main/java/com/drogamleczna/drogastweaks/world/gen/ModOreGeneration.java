package com.drogamleczna.drogastweaks.world.gen;


//public class ModOreGeneration {
//    public static void generateOres(final BiomeLoadingEvent event){
//        for (OreType ore : OreType.values()) {
//            OreFeatureConfig oreFeatureConfig = new OreFeatureConfig(
//                    OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
//                    ore.getBlock().get().getDefaultState(), ore.getMaxVeinSize());
//
//            ConfiguredPlacement<TopSolidRangeConfig> configuredPlacement = Placement.RANGE.configure(
//                    new TopSolidRangeConfig(ore.getMinHeight(),ore.getMinHeight(), ore.getMaxHeight()));
//            ConfiguredFeature<?,?> oreFeature = registerOreFeature(ore, oreFeatureConfig, configuredPlacement);
//
//
//
//            event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, oreFeature);
//
//        }
//
//
//    }
//
//    private static ConfiguredFeature<?,?> registerOreFeature(OreType ore, OreFeatureConfig oreFeatureConfig, ConfiguredPlacement configuredPlacement){
//        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, ore.getBlock().get().getRegistryName(),
//                Feature.ORE.withConfiguration(oreFeatureConfig).withPlacement(configuredPlacement)).square().count(ore.getMaxVeinSize());
//    }
//
//}
