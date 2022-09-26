package com.groupzts.netheriteroad.compat.tinkers;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.TagUtil;

public class TraitNetherite extends AbstractTrait
{
    public TraitNetherite()
    {
        super("super fortified", TextFormatting.DARK_GRAY);
    }

    @Override
    public void onArmorTick(ItemStack tool, World world, EntityPlayer player) {
    }

    @Override
    public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage, boolean isCritical) {
        return 3;
    }

    @Override
    public void applyEffect(NBTTagCompound rootCompound, NBTTagCompound modifierTag) {
        NBTTagCompound toolTag = TagUtil.getToolTag(rootCompound);
        toolTag.setInteger("FreeModifiers", 100);
        TagUtil.setToolTag(rootCompound, toolTag);
    }
}
