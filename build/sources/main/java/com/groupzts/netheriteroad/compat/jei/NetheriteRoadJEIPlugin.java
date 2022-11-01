package com.groupzts.netheriteroad.compat.jei;

import com.groupzts.netheriteroad.common.container.ContainerSmithing;
import com.groupzts.netheriteroad.compat.jei.catgory.SmithingCategory;
import com.groupzts.netheriteroad.compat.jei.recipe.SmithingFactory;
import com.groupzts.netheriteroad.compat.jei.recipe.SmithingRecipe;
import com.groupzts.netheriteroad.compat.jei.recipe.SmithingRecipes;
import com.groupzts.netheriteroad.init.ModBlocks;
import mezz.jei.api.*;
import mezz.jei.api.ingredients.IIngredientRegistry;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import mezz.jei.api.recipe.transfer.IRecipeTransferRegistry;
import net.minecraft.client.gui.GuiRepair;
import net.minecraft.item.ItemStack;

@JEIPlugin
public class NetheriteRoadJEIPlugin implements IModPlugin {
    public static IRecipeRegistry recipeRegistry;

    public NetheriteRoadJEIPlugin(){
    }

    @Override
    public void register(IModRegistry registry) {
        IIngredientRegistry ingredientRegistry = registry.getIngredientRegistry();
        IJeiHelpers jeiHelpers = registry.getJeiHelpers();
        registry.handleRecipes(SmithingRecipe.class, new SmithingFactory(jeiHelpers), SmithingCategory.CATEGORY_UID);
        registry.addRecipes(SmithingRecipes.recipes(), SmithingCategory.CATEGORY_UID);
        registry.addRecipeClickArea(GuiRepair.class, 102, 48, 22, 15, SmithingCategory.CATEGORY_UID);
        IRecipeTransferRegistry recipeTransferRegistry = registry.getRecipeTransferRegistry();
        recipeTransferRegistry.addRecipeTransferHandler(ContainerSmithing.class, SmithingCategory.CATEGORY_UID, 0, 2, 3, 36);
        registry.addRecipeCatalyst(new ItemStack(ModBlocks.SMITHING_TABLE), SmithingCategory.CATEGORY_UID);
    }

    @Override
    public void onRuntimeAvailable(IJeiRuntime jeiRuntime) {
        recipeRegistry = jeiRuntime.getRecipeRegistry();
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) {
        final IJeiHelpers jeiHelpers = registry.getJeiHelpers();
        final IGuiHelper guiHelper = jeiHelpers.getGuiHelper();

        registry.addRecipeCategories(new SmithingCategory(guiHelper));
    }
}
