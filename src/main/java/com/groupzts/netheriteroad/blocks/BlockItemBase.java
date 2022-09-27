package com.groupzts.netheriteroad.blocks;

import com.groupzts.netheriteroad.NetheriteRoad;
import com.groupzts.netheriteroad.init.ModItems;
import com.groupzts.netheriteroad.items.base.FireImmune;
import com.groupzts.netheriteroad.utils.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Objects;


public class BlockItemBase extends ItemBlock implements IHasModel {
    public BlockItemBase(Block block) {
        super(block);
        ModItems.ITEMS.add(this);
        setRegistryName(Objects.requireNonNull(block.getRegistryName()));
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
    @Override
    public void registerModels() {
        NetheriteRoad.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
