package com.groupzts.netheriteroad.compat.jei.wrapper;

import com.google.common.collect.ImmutableList;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.item.ItemStack;

import java.util.Collections;
import java.util.List;

public class SmithingWrapper implements IRecipeWrapper {
    private final List<List<ItemStack>> switchItem;
    private final List<ItemStack> output;

    public SmithingWrapper(List<ItemStack> leftInput, ItemStack smithingItem, List<ItemStack> outputs) {
        this.switchItem = ImmutableList.of(leftInput, outputs);
        this.output = Collections.singletonList(smithingItem);
    }

    @Override
    public void getIngredients(IIngredients ingredients) {
        ingredients.setInputLists(VanillaTypes.ITEM, switchItem);
        ingredients.setOutputs(VanillaTypes.ITEM, output);
    }


}
