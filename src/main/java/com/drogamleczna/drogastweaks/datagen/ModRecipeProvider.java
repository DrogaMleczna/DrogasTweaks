package com.drogamleczna.drogastweaks.datagen;

import com.drogamleczna.drogastweaks.DrogasTweaks;
import com.drogamleczna.drogastweaks.block.ModBlocks;
import com.drogamleczna.drogastweaks.item.ModItems;
import com.google.gson.JsonObject;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MinecartItem;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.brewing.BrewingRecipe;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> CRAB_COOKABLES = List.of(ModItems.CRAB_LEG.get());
    private static final List<ItemLike> Lobster_COOKABLES = List.of(ModItems.RAW_LOBSTER.get());
    private static final List<ItemLike> MOUSE_COOKABLES = List.of(ModItems.RAW_MOUSE.get());
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.FLINT_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', Items.FLINT)
                .unlockedBy(getHasName(Items.FLINT), has(Items.FLINT))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BATON.get())
                .pattern("S")
                .pattern("S")
                .define('S', Items.STICK)
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.FLINT, 9)
                .requires(ModBlocks.FLINT_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.FLINT_BLOCK.get()), has(ModBlocks.FLINT_BLOCK.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.COMBAT, ModItems.STINGER_ON_A_STICK.get())
                .requires(ModItems.STINGER.get(), 1)
                .requires(ModItems.BATON.get())
                .unlockedBy(getItemName(ModItems.STINGER.get()), has(ModItems.BATON.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BONE_MEAL, 1)
                .requires(ModItems.SNAIL_SHELL.get())
                .unlockedBy(getHasName(ModItems.SNAIL_SHELL.get()), has(ModItems.SNAIL_SHELL.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.NAUTILUS_SHELL, 1)
                .requires(ModItems.SNAIL_SHELL.get())
                .requires(Items.WATER_BUCKET)
                .unlockedBy(getHasName(ModItems.SNAIL_SHELL.get()), has(ModItems.SNAIL_SHELL.get()))
                .unlockedBy(getHasName(Items.NAUTILUS_SHELL), has(Items.NAUTILUS_SHELL))
                .save(pWriter);


        oreSmelting(pWriter, CRAB_COOKABLES, RecipeCategory.FOOD, ModItems.COOKED_CRAB_LEG.get(), 0.25f, 200, "crab");
        oreSmelting(pWriter, Lobster_COOKABLES, RecipeCategory.FOOD, ModItems.COOKED_LOBSTER.get(), 0.25f, 200, "lobster");
        oreSmelting(pWriter, MOUSE_COOKABLES, RecipeCategory.FOOD, ModItems.COOKED_MOUSE.get(), 0.25f, 200, "mouse");

    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, DrogasTweaks.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }

}
