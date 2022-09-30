package com.groupzts.netheriteroad.items.base;

import com.groupzts.netheriteroad.NetheriteRoad;
import com.groupzts.netheriteroad.init.ModItems;
import com.groupzts.netheriteroad.utils.IHasModel;
import com.groupzts.netheriteroad.utils.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CommonItemBase extends Item implements IHasModel {
    public CommonItemBase(String modId, String name, CreativeTabs tab){
        setRegistryName(modId, name);
        setTranslationKey(modId + "." + name);
        setCreativeTab(tab);
        ModItems.ITEMS.add(this);
    }
    @Override
    public void registerModels() {
        NetheriteRoad.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
