package com.drogamleczna.drogastweaks.item;

import com.drogamleczna.drogastweaks.DrogasTweaks;
import com.drogamleczna.drogastweaks.entity.ModEntities;
import com.drogamleczna.drogastweaks.item.custom.ModFoods;
import com.drogamleczna.drogastweaks.item.custom.StingerStickItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;

import static net.minecraft.world.item.Tiers.WOOD;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DrogasTweaks.MOD_ID);

    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BATON = ITEMS.register("baton",
            () -> new SwordItem(WOOD, 4, -3,
                    new Item.Properties().durability(256)));

    public static final RegistryObject<Item> CRAB_LEG = ITEMS.register("crab_leg",
            () -> new Item(new Item.Properties().food(ModFoods.CRAB_LEG)));
    public static final RegistryObject<Item> COOKED_CRAB_LEG = ITEMS.register("cooked_crab_leg",
            () -> new Item(new Item.Properties().food(ModFoods.COOKED_CRAB_LEG)));
    public static final RegistryObject<Item> PEAR = ITEMS.register("pear",
            () -> new Item(new Item.Properties().food(ModFoods.PEAR)));

    public static final RegistryObject<Item> CRAB_SPAWN_EGG = ITEMS.register("crab_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.CRAB, 0xC54600, 0xFF8100, new Item.Properties()));

    public static final RegistryObject<Item> LOBSTER_SPAWN_EGG = ITEMS.register("lobster_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.LOBSTER, 0x113247, 0x07293f, new Item.Properties()));

    public static final RegistryObject<Item> RAW_LOBSTER = ITEMS.register("raw_lobster",
            () -> new Item(new Item.Properties().food(ModFoods.RAW_LOBSTER)));
    public static final RegistryObject<Item> COOKED_LOBSTER = ITEMS.register("cooked_lobster",
            () -> new Item(new Item.Properties().food(ModFoods.COOKED_LOBSTER)));

    public static final RegistryObject<Item> SCORPION_SPAWN_EGG = ITEMS.register("scorpion_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.SCORPION, 0xb27e19, 0x79530a, new Item.Properties()));

    public static final RegistryObject<Item> STINGER = ITEMS.register("stinger",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STINGER_ON_A_STICK = ITEMS.register("stinger_on_a_stick",
            () -> new StingerStickItem(WOOD, 5, -3,
                    new Item.Properties().durability(128)));

    public static final RegistryObject<Item> SNAIL_SPAWN_EGG = ITEMS.register("snail_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.SNAIL, 0x757b57, 0x6b5139, new Item.Properties()));

    public static final RegistryObject<Item> SNAIL_SHELL = ITEMS.register("snail_shell",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> OWL_SPAWN_EGG = ITEMS.register("owl_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.OWL, 0x6a582c, 0x988d74, new Item.Properties()));

    public static final RegistryObject<Item> MOUSE_SPAWN_EGG = ITEMS.register("mouse_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.MOUSE, 0x60616d, 0x3d3d42, new Item.Properties()));

    public static final RegistryObject<Item> RAW_MOUSE = ITEMS.register("raw_mouse",
            () -> new Item(new Item.Properties().food(ModFoods.RAW_MOUSE)));
    public static final RegistryObject<Item> COOKED_MOUSE = ITEMS.register("cooked_mouse",
            () -> new Item(new Item.Properties().food(ModFoods.COOKED_MOUSE)));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }


}
