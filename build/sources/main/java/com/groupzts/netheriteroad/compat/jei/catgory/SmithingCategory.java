package com.groupzts.netheriteroad.compat.jei.catgory;

import com.groupzts.netheriteroad.compat.jei.wrapper.SmithingWrapper;
import com.groupzts.netheriteroad.init.ModBlocks;
import com.groupzts.netheriteroad.utils.Reference;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.util.Locale;

public class SmithingCategory implements IRecipeCategory<SmithingWrapper> {
    public static final String RESOURCE_DOMAIN = Reference.MOD_ID.toLowerCase(Locale.ENGLISH);
    public static final String TEXTURE_GUI_PATH = "textures/gui/";
    public static final String TEXTURE_GUI_VANILLA = TEXTURE_GUI_PATH + "gui_vanilla.png";
    public static final ResourceLocation RECIPE_GUI_VANILLA = new ResourceLocation(RESOURCE_DOMAIN, TEXTURE_GUI_VANILLA);
    public static final String CATEGORY_UID = "container.jei.netheriteroad.smithing.name";
    private final IDrawable background;
    private final IDrawable icon;

    public SmithingCategory(IGuiHelper guiHelper) {
        background = guiHelper.drawableBuilder(RECIPE_GUI_VANILLA, 0, 168, 125, 18)
                .addPadding(0, 20, 0, 0)
                .build();
        icon = guiHelper.createDrawableIngredient(new ItemStack(ModBlocks.SMITHING_TABLE));
    }

    @Override
    public String getUid() {
        return CATEGORY_UID;
    }

    @Override
    public String getTitle() {
        return ModBlocks.SMITHING_TABLE.getLocalizedName();
    }

    @Override
    public String getModName() {
        return Reference.MOD_NAME;
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
    public void setRecipe(IRecipeLayout recipeLayout, SmithingWrapper recipeWrapper, IIngredients ingredients) {
        IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();

        guiItemStacks.init(0, true, 0, 0);
        guiItemStacks.init(1, true, 49, 0);
        guiItemStacks.init(2, false, 107, 0);

    }
}
