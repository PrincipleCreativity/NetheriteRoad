package com.groupzts.netheriteroad.init;

import com.groupzts.netheriteroad.blocks.BlockItemBase;
import com.groupzts.netheriteroad.items.base.FireImmuneItemBase;
import com.groupzts.netheriteroad.items.base.armorbase.ArmorBase;
import com.groupzts.netheriteroad.items.base.toolbase.*;
import com.groupzts.netheriteroad.utils.ModMaterials;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ModItems {
    public static final List<Item> ITEMS = new ArrayList<>();
    public static final Item NETHERITE_INGOT = new FireImmuneItemBase("netherite_ingot", CreativeTabs.MISC);
    public static final Item NETHERITE_SCRAP = new FireImmuneItemBase("netherite_scrap", CreativeTabs.MISC);
    public static final Item NETHERITE_SWORD = new SwordBase("netherite_sword", ModMaterials.TOOL_NETHERITE_ALLOY);
    public static final Item NETHERITE_PICKAXE = new PickaxeBase("netherite_pickaxe", ModMaterials.TOOL_NETHERITE_ALLOY);
    public static final Item NETHERITE_AXE = new AxeBase("netherite_axe",  ModMaterials.TOOL_NETHERITE_ALLOY);
    public static final Item NETHERITE_SHOVEL = new ShovelBase("netherite_shovel", ModMaterials.TOOL_NETHERITE_ALLOY);
    public static final Item NETHERITE_HOE = new HoeBase("netherite_hoe", ModMaterials.TOOL_NETHERITE_ALLOY);
    public static final Item NETHERITE_HELMET = new ArmorBase("netherite_helmet", ModMaterials.ARMOR_NETHERITE_ALLOY, EntityEquipmentSlot.HEAD);
    public static final Item NETHERITE_CHESTPLATE = new ArmorBase("netherite_chestplate", ModMaterials.ARMOR_NETHERITE_ALLOY, EntityEquipmentSlot.CHEST);
    public static final Item NETHERITE_LEGGINGS = new ArmorBase("netherite_leggings", ModMaterials.ARMOR_NETHERITE_ALLOY, EntityEquipmentSlot.LEGS);
    public static final Item NETHERITE_BOOTS = new ArmorBase("netherite_boots", ModMaterials.ARMOR_NETHERITE_ALLOY, EntityEquipmentSlot.FEET);

    public static final Item NETHERITE_BLOCK_ITEM = new BlockItemBase(ModBlocks.NETHERITE_BLOCK);
    public static final Item ANCIENT_DEBRIS_ITEM = new BlockItemBase(ModBlocks.ANCIENT_DEBRIS);
}
