package com.drogamleczna.drogastweaks.util;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraftforge.common.brewing.IBrewingRecipe;

public class ModPotionBrewing implements IBrewingRecipe {
    private final Potion inputPotion;
    private final Item ingredient;
    private final Potion outputPotion;
    public ModPotionBrewing(Potion input, Item ingredient, Potion output) {
        this.inputPotion = input;
        this.ingredient = ingredient;
        this.outputPotion = output;
    }

    @Override
    public boolean isInput(ItemStack input) {
        return PotionUtils.getPotion(input) == this.inputPotion;
    }

    @Override
    public boolean isIngredient(ItemStack ingredient) {
        return ingredient.getItem() == this.ingredient;
    }

    @Override
    public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
        if(!this.isInput(input) || !this.isIngredient(ingredient)) {
            return ItemStack.EMPTY;
        }

        ItemStack itemStack = new ItemStack(input.getItem());
        itemStack.setTag(new CompoundTag());
        PotionUtils.setPotion(itemStack, this.outputPotion);
        return itemStack;
    }
}
