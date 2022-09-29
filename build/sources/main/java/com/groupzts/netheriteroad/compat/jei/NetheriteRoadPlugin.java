package com.groupzts.netheriteroad.compat.jei;

import mezz.jei.Internal;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.ingredients.IIngredientRegistry;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import mezz.jei.api.recipe.IVanillaRecipeFactory;
import mezz.jei.api.recipe.VanillaRecipeCategoryUid;
import mezz.jei.gui.GuiHelper;
import mezz.jei.runtime.JeiHelpers;

import javax.annotation.Nullable;

@JEIPlugin
public class NetheriteRoadPlugin implements IModPlugin {
    @Nullable
    private ModSmithingRecipeCategory recipeCategory;

    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) {
        JeiHelpers jeiHelpers = Internal.getHelpers();
        GuiHelper guiHelper = jeiHelpers.getGuiHelper();
        registry.addRecipeCategories(new ModSmithingRecipeCategory(guiHelper));
    }

    @Override
    public void register(IModRegistry registry) {
        IIngredientRegistry ingredientRegistry = registry.getIngredientRegistry();
        IJeiHelpers jeiHelpers = registry.getJeiHelpers();
        IVanillaRecipeFactory vanillaRecipeFactory = jeiHelpers.getVanillaRecipeFactory();
        registry.addRecipes(ModSmithingMaker.getSmithingRecipes(vanillaRecipeFactory, ingredientRegistry), VanillaRecipeCategoryUid.ANVIL);
    }
}
