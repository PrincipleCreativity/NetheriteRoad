package com.groupzts.netheriteroad.compat.conarm.traits;

import c4.conarm.lib.armor.ArmorModifications;
import c4.conarm.lib.traits.AbstractArmorTrait;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class AncientProtect extends AbstractArmorTrait{
    public AncientProtect() {
        super("ancient_protect", TextFormatting.GOLD);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public float onHurt(ItemStack armor, EntityPlayer player, DamageSource source, float damage, float newDamage, LivingHurtEvent evt) {
        if(evt.getSource().isFireDamage())
            newDamage = 0f;
        return super.onHurt(armor, player, source, damage, newDamage, evt);
    }

    @Override
    public ArmorModifications getModifications(EntityPlayer player, ArmorModifications mods, ItemStack armor, DamageSource source, double damage, int slot) {
        if(checkWear(player)) {
            mods.addArmorMod(0.2f);
            mods.addToughnessMod(0.15f);
        }
        return super.getModifications(player, mods, armor, source, damage, slot);
    }

    private boolean checkWear(EntityLivingBase target){
        for(ItemStack armor:target.getArmorInventoryList()){
            if(isToolWithTrait(armor)){
                return true;
            }
        }
        return false;
    }
}
