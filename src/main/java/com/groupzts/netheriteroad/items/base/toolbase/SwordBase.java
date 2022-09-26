package com.groupzts.netheriteroad.items.base.toolbase;

import com.groupzts.netheriteroad.NetheriteRoad;
import com.groupzts.netheriteroad.init.ModItems;
import com.groupzts.netheriteroad.items.base.FireImmune;
import com.groupzts.netheriteroad.utils.IHasModel;
import com.groupzts.netheriteroad.utils.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

public class SwordBase extends ItemSword implements IHasModel {
    public SwordBase(String name, ToolMaterial material){
        super(material);
        setRegistryName(Reference.MOD_ID, name);
        setTranslationKey(Reference.MOD_ID + "." + name);
        setCreativeTab(CreativeTabs.COMBAT);
        ModItems.ITEMS.add(this);
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
