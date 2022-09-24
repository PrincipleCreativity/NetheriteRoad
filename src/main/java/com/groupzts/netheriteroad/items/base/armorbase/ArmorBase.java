package com.groupzts.netheriteroad.items.base.armorbase;

import com.google.common.collect.Multimap;
import com.groupzts.netheriteroad.NetheriteRoad;
import com.groupzts.netheriteroad.init.ModItems;
import com.groupzts.netheriteroad.items.base.FireImmune;
import com.groupzts.netheriteroad.utils.IHasModel;
import com.groupzts.netheriteroad.utils.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.UUID;

public class ArmorBase extends ItemArmor implements IHasModel {
    public ArmorBase(String name, ArmorMaterial materialIn, EntityEquipmentSlot slot) {
        super(materialIn, 0, slot);
        setRegistryName(Reference.MOD_ID, name);
        setUnlocalizedName(Reference.MOD_ID + "." + name);
        setCreativeTab(CreativeTabs.COMBAT);
        ModItems.ITEMS.add(this);
    }
    @Override
    public Multimap<String,AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {
        Multimap<String, AttributeModifier> attrib = super.getAttributeModifiers(slot, stack);
        Item item = stack.getItem();
        UUID uuid = new UUID(slot.toString().hashCode(), 0);
        if (slot == EntityEquipmentSlot.HEAD) {
            if(item == ModItems.NETHERITE_HELMET) {
                attrib.put(SharedMonsterAttributes.KNOCKBACK_RESISTANCE.getName(), new AttributeModifier(uuid,"netherite", 0.1, 0));
            }
        } else if (slot == EntityEquipmentSlot.CHEST) {
            if(item == ModItems.NETHERITE_CHESTPLATE) {
                attrib.put(SharedMonsterAttributes.KNOCKBACK_RESISTANCE.getName(), new AttributeModifier(uuid,"netherite", 0.1, 0));
            }
        } else if (slot == EntityEquipmentSlot.LEGS) {
            if(item == ModItems.NETHERITE_LEGGINGS) {
                attrib.put(SharedMonsterAttributes.KNOCKBACK_RESISTANCE.getName(), new AttributeModifier(uuid,"netherite", 0.1, 0));
            }
        } else if (slot == EntityEquipmentSlot.FEET) {
            if(item == ModItems.NETHERITE_BOOTS) {
                attrib.put(SharedMonsterAttributes.KNOCKBACK_RESISTANCE.getName(), new AttributeModifier(uuid,"netherite", 0.1, 0));
            }
        }
        return attrib;
    }
    @Override
    public void registerModels() {
        NetheriteRoad.proxy.registerItemRenderer(this, 0, "inventory");
    }
    @Override
    @ParametersAreNonnullByDefault
    public boolean hasCustomEntity(ItemStack stack) {
        return true;
    }

    @Nullable
    @Override
    @ParametersAreNonnullByDefault
    public Entity createEntity(World world, Entity location, ItemStack itemstack) {
        return new FireImmune(world,location,itemstack);
    }
}
