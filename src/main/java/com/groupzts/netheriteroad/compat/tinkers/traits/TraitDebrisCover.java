package com.groupzts.netheriteroad.compat.tinkers.traits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.player.PlayerEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitDebrisCover extends AbstractTrait {
    public TraitDebrisCover() {
        super("debris_cover", TextFormatting.AQUA);
    }
    @Override
    public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage, boolean isCritical) {
        if(player.isBurning()){
            newDamage  *= 1.1f;
        }
        if(!target.isBurning()) {
            newDamage *= 1.2;
        }
        return super.damage(tool,player,target,damage,newDamage,isCritical);
    }
    @Override
    public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damageDealt, boolean wasCritical, boolean wasHit) {
        super.afterHit(tool, player, target, damageDealt, wasCritical, wasHit);
        target.setFire(5);
    }
    @Override
    public int onToolDamage(ItemStack tool, int damage, int newDamage, EntityLivingBase entity) {
        if(entity.isBurning()) newDamage = 0;
        return super.onToolDamage(tool, damage, newDamage, entity);
    }
    @Override
    public void miningSpeed(ItemStack tool, PlayerEvent.BreakSpeed event) {
        if(event.getEntityPlayer().isBurning()) event.setNewSpeed(event.getNewSpeed() * 6);
        super.miningSpeed(tool, event);
    }

    @Override
    public float knockBack(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float knockback, float newKnockback, boolean isCritical) {
        if(player.isBurning()) newKnockback *= 1.15;
        return super.knockBack(tool, player, target, damage, knockback, newKnockback, isCritical);
    }
}
