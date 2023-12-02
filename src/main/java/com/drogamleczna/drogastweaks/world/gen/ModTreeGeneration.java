package com.drogamleczna.drogastweaks.world.gen;


import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.function.Supplier;

//public class ModTreeGeneration {
//
//    public static void generateTrees(final BiomeLoadingEvent event){
//        WillowTree willowTree = new WillowTree();
//        DeadTree deadTree = new DeadTree();
//        Random random = new Random();
//
//        RegistryKey<Biome> key = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, event.getName());
//        Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);
//
//        if(types.contains(BiomeDictionary.Type.SWAMP)){
//            List<Supplier<ConfiguredFeature<?, ?>>> base =
//                    event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION);
//
//            base.add(() -> ModConfiguredFeatures.WILLOW.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT
//                    .withPlacement(Placement.COUNT_EXTRA.configure(
//                            new AtSurfaceWithExtraConfig(1,0.15f, 2)
//                    ))));
//        }
//        else if(types.contains(BiomeDictionary.Type.FOREST)){
//            List<Supplier<ConfiguredFeature<?, ?>>> base =
//                    event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION);
//
//            base.add(() -> ModConfiguredFeatures.DEAD_TREE.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT
//                    .withPlacement(Placement.COUNT_EXTRA.configure(
//                            new AtSurfaceWithExtraConfig(1,0.05f, 2)
//                    ))));
//        }
//    }
//
//}
