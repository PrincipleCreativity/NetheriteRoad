package com.groupzts.netheriteroad.compat.jei.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;

public class SmithingRecipe extends Recipe{

    private final Ingredient input;
    private final ItemStack smithingItem;
    private final ItemStack output;
    public SmithingRecipe(Ingredient input, ItemStack smithingItem, ItemStack output){
        super(input, output);
        this.input = input;
        this.smithingItem = smithingItem;
        this.output = output;
    }

    public Ingredient getInput() {
        return input;
    }

    public ItemStack getSmithingItem() {
        return smithingItem;
    }

    public ItemStack getOutput() {
        return output;
    }
}
