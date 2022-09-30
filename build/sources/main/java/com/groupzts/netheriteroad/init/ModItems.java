package com.groupzts.netheriteroad.init;

import com.groupzts.netheriteroad.blocks.BlockItemBase;
import com.groupzts.netheriteroad.items.base.FireImmuneItemBase;
import com.groupzts.netheriteroad.items.base.armorbase.ArmorBase;
import com.groupzts.netheriteroad.items.base.toolbase.*;
import com.groupzts.netheriteroad.utils.ModMaterials;
import com.groupzts.netheriteroad.utils.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ModItems {
    public static final List<Item> ITEMS = new ArrayList<>();
    public static final Item NETHERITE_INGOT = new FireImmuneItemBase(Reference.MOD_ID, "netherite_ingot", CreativeTabs.MISC);
    public static final Item NETHERITE_SCRAP = new FireImmuneItemBase(Reference.MOD_ID, "netherite_scrap", CreativeTabs.MISC);
    public static final Item NETHERITE_SWORD = new SwordBase(Reference.MOD_ID, "netherite_sword", ModMaterials.TOOL_NETHERITE_ALLOY);
    public static final Item NETHERITE_PICKAXE = new PickaxeBase(Reference.MOD_ID, "netherite_pickaxe", ModMaterials.TOOL_NETHERITE_ALLOY);
    public static final Item NETHERITE_AXE = new AxeBase(Reference.MOD_ID, "netherite_axe",  ModMaterials.TOOL_NETHERITE_ALLOY);
    public static final Item NETHERITE_SHOVEL = new ShovelBase(Reference.MOD_ID, "netherite_shovel", ModMaterials.TOOL_NETHERITE_ALLOY);
    public static final Item NETHERITE_HOE = new HoeBase(Reference.MOD_ID, "netherite_hoe", ModMaterials.TOOL_NETHERITE_ALLOY);
    public static final Item NETHERITE_HELMET = new ArmorBase(Reference.MOD_ID, "netherite_helmet", ModMaterials.ARMOR_NETHERITE_ALLOY, EntityEquipmentSlot.HEAD);
    public static final Item NETHERITE_CHESTPLATE = new ArmorBase(Reference.MOD_ID, "netherite_chestplate", ModMaterials.ARMOR_NETHERITE_ALLOY, EntityEquipmentSlot.CHEST);
    public static final Item NETHERITE_LEGGINGS = new ArmorBase(Reference.MOD_ID, "netherite_leggings", ModMaterials.ARMOR_NETHERITE_ALLOY, EntityEquipmentSlot.LEGS);
    public static final Item NETHERITE_BOOTS = new ArmorBase(Reference.MOD_ID, "netherite_boots", ModMaterials.ARMOR_NETHERITE_ALLOY, EntityEquipmentSlot.FEET);

    public static final Item NETHERITE_BLOCK_ITEM = new BlockItemBase(ModBlocks.NETHERITE_BLOCK);
    public static final Item ANCIENT_DEBRIS_ITEM = new BlockItemBase(ModBlocks.ANCIENT_DEBRIS);
}
