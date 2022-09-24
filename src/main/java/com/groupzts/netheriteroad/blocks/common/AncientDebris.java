package com.groupzts.netheriteroad.blocks.common;

import com.groupzts.netheriteroad.blocks.BlockBase;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.oredict.OreDictionary;

public class AncientDebris extends BlockBase {

    public AncientDebris(String name, CreativeTabs tab, Material material) {
        super(name, tab, material);
        setHardness(30F).setResistance(1200F);
        setHarvestLevel("pickaxe", 3);
        OreDictionary.registerOre("debrisAncient", this);
        OreDictionary.registerOre("oreNetherite", this);
    }
}
