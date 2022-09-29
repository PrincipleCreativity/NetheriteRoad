package com.groupzts.netheriteroad.compat.jei;

import com.groupzts.netheriteroad.init.ModBlocks;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.ICraftingGridHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.VanillaRecipeCategoryUid;
import mezz.jei.api.recipe.wrapper.ICraftingRecipeWrapper;
import mezz.jei.config.Constants;
import mezz.jei.plugins.vanilla.anvil.AnvilRecipeWrapper;
import mezz.jei.util.Translator;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ModSmithingRecipeCategory implements IRecipeCategory<AnvilRecipeWrapper> {
    private static final int craftOutputSlot = 0;
    private static final int craftInputSlot1 = 1;

    public static final int width = 116;
    public static final int height = 54;

    private final IDrawable background;
    private final IDrawable icon;
    private final String localizedName;

    public ModSmithingRecipeCategory(IGuiHelper guiHelper) {
        ResourceLocation location = Constants.RECIPE_GUI_VANILLA;
        background = guiHelper.createDrawable(location, 0, 60, width, height);
        icon = guiHelper.createDrawableIngredient(new ItemStack(ModBlocks.SMITHING_TABLE));
        localizedName = Translator.translateToLocal("gui.jei.category.smithing_table");
        ICraftingGridHelper craftingGridHelper = guiHelper.createCraftingGridHelper(craftInputSlot1, craftOutputSlot);
    }
    @Override
    public String getUid() {
        return VanillaRecipeCategoryUid.CRAFTING;
    }

    @Override
    public String getTitle() {
        return localizedName;
    }

    @Override
    public String getModName() {
        return Constants.MINECRAFT_NAME;
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, AnvilRecipeWrapper recipeWrapper, IIngredients ingredients) {
        IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();

        guiItemStacks.init(0, true, 0, 0);
        guiItemStacks.init(1, true, 49, 0);
        guiItemStacks.init(2, false, 107, 0);

        guiItemStacks.set(ingredients);
    }

}
