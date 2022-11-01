package com.groupzts.netheriteroad.compat.jei.recipe;

import com.groupzts.netheriteroad.compat.jei.wrapper.SmithingWrapper;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.api.recipe.IRecipeWrapperFactory;

public class SmithingFactory implements IRecipeWrapperFactory<SmithingRecipe> {

    private final IJeiHelpers jeiHelpers;

    public SmithingFactory(IJeiHelpers jeiHelpers){
        this.jeiHelpers = jeiHelpers;
    }

    @Override
    public IRecipeWrapper getRecipeWrapper(SmithingRecipe recipe) {
        return new SmithingWrapper(jeiHelpers.getStackHelper().toItemStackList(recipe.getInput()), recipe.getSmithingItem(),  jeiHelpers.getStackHelper().toItemStackList(recipe.getOutput()));
    }
}
