package com.groupzts.netheriteroad.items.base;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.item.ItemExpireEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import javax.annotation.Nonnull;

public class FireImmune extends EntityItem {
    public FireImmune(World world, Entity location, ItemStack stack) {
        this(world, location.posX, location.posY, location.posZ, stack);
        this.setPickupDelay(10);
        this.motionX = location.motionX;
        this.motionY = location.motionY;
        this.motionZ = location.motionZ;
        this.setItem(stack);
    }
    public FireImmune(World world, double x, double y, double z, ItemStack itemstack) {
        super(world, x, y, z, itemstack);
        this.setItem(itemstack);
    }

    public FireImmune(World world, double x, double y, double z) {
        super(world, x, y, z);
        this.isImmuneToFire = true;
    }

    public FireImmune(World world) {
        super(world);
        isImmuneToFire = true;
    }


    protected void dealFireDamage(int damage) {
    }

    @Override
    public boolean attackEntityFrom(@Nonnull DamageSource source, float amount) {
        return source.getDamageType().equals(DamageSource.OUT_OF_WORLD.damageType);
        // prevent any damage besides out of world
    }

    public static class EventHandler {

        public static final EventHandler instance = new EventHandler();

        private EventHandler() {
        }

        @SubscribeEvent
        public void onExpire(ItemExpireEvent event) {
            if (event.getEntityItem() instanceof FireImmune) {
                event.setCanceled(true);
            }
        }
    }
}
