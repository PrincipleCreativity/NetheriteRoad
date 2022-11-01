package com.groupzts.netheriteroad.compat.jei.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;

public class Recipe {
    private final Ingredient input;
    private final ItemStack output;
    public Recipe(Ingredient input, ItemStack output){
        this.input = input;
        this.output = output;
    }

    public boolean isSameRecipe(ItemStack input, ItemStack output){
        return this.input.test(input) && doesItemMatch(this.output, output);
    }

    public boolean doesItemMatch(ItemStack item, ItemStack other){
        return other.getItem() == item.getItem() && (item.getMetadata() == 32767 || other.getMetadata() == item.getMetadata()) && other.getCount() >= item.getCount();
    }
}
