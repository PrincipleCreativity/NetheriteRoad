package com.groupzts.netheriteroad.blocks;

import com.groupzts.netheriteroad.NetheriteRoad;
import com.groupzts.netheriteroad.init.ModItems;
import com.groupzts.netheriteroad.utils.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

import java.util.Objects;


public class BlockItemBase extends ItemBlock implements IHasModel {
    public BlockItemBase(Block block) {
        super(block);
        ModItems.ITEMS.add(this);
        setRegistryName(Objects.requireNonNull(block.getRegistryName()));
    }

    @Override
    public void registerModels() {
        NetheriteRoad.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
