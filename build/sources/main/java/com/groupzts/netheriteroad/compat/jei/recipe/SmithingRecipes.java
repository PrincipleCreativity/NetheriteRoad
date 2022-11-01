package com.groupzts.netheriteroad.compat.jei.recipe;

import com.groupzts.netheriteroad.common.container.ContainerSmithing;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SmithingRecipes {
    private static final ItemStack NETHERITE = new ItemStack(ContainerSmithing.SmithingType.NETHERITE.getSmithingItem());
    private static final ItemStack CUSTOM = new ItemStack(ContainerSmithing.SmithingType.CUSTOM.getSmithingItem());

    public static List<SmithingRecipe> recipes(){
        List<SmithingRecipe> recipes = new ArrayList<>();
        if(ContainerSmithing.SmithingType.NETHERITE.getItemMap() == null) {
            throw new NullPointerException("input is none???");
        }
        for (Map.Entry<Item, Item> entry : ContainerSmithing.SmithingType.NETHERITE.getItemMap().entrySet()) {
            ItemStack input = new ItemStack(entry.getKey());
            ItemStack output = new ItemStack(entry.getValue());
            SmithingRecipe netheriteRecipe = new SmithingRecipe(Ingredient.fromStacks(input), NETHERITE, output);
            recipes.add(netheriteRecipe);
            if(ContainerSmithing.SmithingType.CUSTOM.getItemMap() == null){
                throw new NullPointerException("input is none???");
            }
            for(Map.Entry<Item, Item> customEntry : ContainerSmithing.SmithingType.CUSTOM.getItemMap().entrySet()){
                ItemStack customInput = new ItemStack(entry.getKey());
                ItemStack customOutput = new ItemStack(entry.getValue());
                SmithingRecipe customRecipe = new SmithingRecipe(Ingredient.fromStacks(customInput), CUSTOM, customOutput);
                recipes.add(customRecipe);
                return recipes;
            }
        }
        return recipes;
    }
}
