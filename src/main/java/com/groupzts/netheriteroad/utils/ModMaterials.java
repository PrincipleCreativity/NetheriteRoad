package com.groupzts.netheriteroad.utils;

import com.groupzts.netheriteroad.init.ModItems;
import com.groupzts.netheriteroad.init.ModSounds;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.EnumHelper;

import java.util.Objects;

public class ModMaterials {
    public static final Item.ToolMaterial TOOL_NETHERITE_ALLOY = Objects.requireNonNull(EnumHelper.addToolMaterial("tool_netherite_alloy", 4, 2031, 9F, 4F, 15)).setRepairItem(new ItemStack(ModItems.NETHERITE_INGOT));
    public static final ItemArmor.ArmorMaterial ARMOR_NETHERITE_ALLOY = Objects.requireNonNull(EnumHelper.addArmorMaterial("armor_netherite_alloy", "netheriteroad:netherite", 37, new int[]{3, 8, 6, 3}, 15, ModSounds.NETHERITE_ARMOR_SOUND, 3)).setRepairItem(new ItemStack(ModItems.NETHERITE_INGOT));
}
