package com.groupzts.netheriteroad.compat.jei;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.groupzts.netheriteroad.init.ModItems;
import mezz.jei.api.ingredients.IIngredientRegistry;
import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.api.recipe.IVanillaRecipeFactory;
import mezz.jei.util.Log;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ModSmithingMaker {
    private ModSmithingMaker() {
    }

    public static List<IRecipeWrapper> getSmithingRecipes(IVanillaRecipeFactory vanillaRecipeFactory, IIngredientRegistry ingredientRegistry) {
        List<IRecipeWrapper> recipes = new ArrayList<>();
        Stopwatch sw = Stopwatch.createStarted();
        try {
            getRecipes(recipes, vanillaRecipeFactory);
        } catch (RuntimeException e) {
            Log.get().error("Failed to create repair recipes.", e);
        }
        sw.stop();
        Log.get().debug("Registered vanilla repair recipes in {}", sw);
        sw.reset();
        sw.start();
        return recipes;
    }
    public static void getRecipes(List<IRecipeWrapper> recipes, IVanillaRecipeFactory vanillaRecipeFactory){
        Map<List<ItemStack>, ItemStack> items = Maps.newHashMap();
        ItemStack netherite = new ItemStack(ModItems.NETHERITE_INGOT, 1);
        items.put(Lists.newArrayList(
                new ItemStack(ModItems.NETHERITE_SWORD),
                new ItemStack(ModItems.NETHERITE_PICKAXE),
                new ItemStack(ModItems.NETHERITE_AXE),
                new ItemStack(ModItems.NETHERITE_SHOVEL),
                new ItemStack(ModItems.NETHERITE_HOE),
                new ItemStack(ModItems.NETHERITE_HELMET),
                new ItemStack(ModItems.NETHERITE_CHESTPLATE),
                new ItemStack(ModItems.NETHERITE_LEGGINGS),
                new ItemStack(ModItems.NETHERITE_BOOTS)
        ),netherite);
        for (Map.Entry<List<ItemStack>, ItemStack> entry : items.entrySet()) {

            ItemStack repairMaterial = entry.getValue();

            for (ItemStack ingredient : entry.getKey()) {

                ItemStack damaged1 = ingredient.copy();
                damaged1.setItemDamage(damaged1.getMaxDamage());
                ItemStack damaged2 = ingredient.copy();
                damaged2.setItemDamage(damaged2.getMaxDamage() * 3 / 4);
                ItemStack damaged3 = ingredient.copy();
                damaged3.setItemDamage(damaged3.getMaxDamage() * 2 / 4);

                IRecipeWrapper repairWithMaterial = vanillaRecipeFactory.createAnvilRecipe(damaged1, Collections.singletonList(repairMaterial), Collections.singletonList(damaged2));
                IRecipeWrapper repairWithSame = vanillaRecipeFactory.createAnvilRecipe(damaged2, Collections.singletonList(damaged2), Collections.singletonList(damaged3));
                recipes.add(repairWithMaterial);
                recipes.add(repairWithSame);
            }
        }
    }
}
