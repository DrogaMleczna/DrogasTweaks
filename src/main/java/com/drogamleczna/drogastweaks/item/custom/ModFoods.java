package com.drogamleczna.drogastweaks.item.custom;

import net.minecraft.world.food.FoodConstants;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties CRAB_LEG = new FoodProperties.Builder().nutrition(2).saturationMod(0.2f).build();
    public static final FoodProperties COOKED_CRAB_LEG = new FoodProperties.Builder().nutrition(4).saturationMod(0.35f).build();
    public static final FoodProperties RAW_LOBSTER = new FoodProperties.Builder().nutrition(5).saturationMod(2f).build();
    public static final FoodProperties COOKED_LOBSTER = new FoodProperties.Builder().nutrition(10).saturationMod(4f).build();
    public static final FoodProperties PEAR = new FoodProperties.Builder().nutrition(4).saturationMod(0.3F).build();

    public static final FoodProperties RAW_MOUSE = new FoodProperties.Builder().nutrition(2).saturationMod(2f).build();
    public static final FoodProperties COOKED_MOUSE = new FoodProperties.Builder().nutrition(4).saturationMod(4f).build();
}
