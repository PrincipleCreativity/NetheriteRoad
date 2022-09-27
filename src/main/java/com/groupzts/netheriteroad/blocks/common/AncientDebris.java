package com.groupzts.netheriteroad.blocks.common;

import com.groupzts.netheriteroad.init.ModBlocks;
import com.groupzts.netheriteroad.utils.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.oredict.OreDictionary;

public class AncientDebris extends Block {

    public AncientDebris(Material material) {
        super(material);
        setHardness(30F).setResistance(1200F);
        setHarvestLevel("pickaxe", 3);
        setTranslationKey(Reference.MOD_ID + ".ancient_debris").setRegistryName(Reference.MOD_ID, "ancient_debris");
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        ModBlocks.BLOCKS.add(this);
        OreDictionary.registerOre("debrisAncient", this);
        OreDictionary.registerOre("oreNetherite", this);
    }
}
