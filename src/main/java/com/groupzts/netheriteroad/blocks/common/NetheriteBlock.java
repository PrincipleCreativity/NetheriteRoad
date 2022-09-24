package com.groupzts.netheriteroad.blocks.common;

import com.groupzts.netheriteroad.blocks.BlockBase;
import com.groupzts.netheriteroad.init.ModSounds;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.oredict.OreDictionary;

public class NetheriteBlock extends BlockBase {
    public static final SoundType NETHERITE_BLOCK_SOUND = new SoundType(1, 1, ModSounds.BREAK_NETHERITE_BLOCK, ModSounds.STEP_NETHERITE_BLOCK, SoundType.METAL.getPlaceSound(), SoundType.METAL.getHitSound(),SoundType.METAL.getFallSound());
    public NetheriteBlock(String name, CreativeTabs tab, Material material) {
        super(name, tab, material);
        setHardness(50).setResistance(1200F);
        setHarvestLevel("pickaxe", 3);
        setSoundType(NETHERITE_BLOCK_SOUND);
        OreDictionary.registerOre("blockNetherite", this);
    }
}
