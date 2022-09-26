package com.groupzts.netheriteroad.blocks.common;

import com.groupzts.netheriteroad.init.ModBlocks;
import com.groupzts.netheriteroad.init.ModSounds;
import com.groupzts.netheriteroad.utils.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.oredict.OreDictionary;

public class NetheriteBlock extends Block{
    public static final SoundType NETHERITE_BLOCK_SOUND = new SoundType(1, 1, ModSounds.BREAK_NETHERITE_BLOCK, ModSounds.STEP_NETHERITE_BLOCK, SoundType.METAL.getPlaceSound(), SoundType.METAL.getHitSound(),SoundType.METAL.getFallSound());
    public NetheriteBlock(Material material) {
        super(material);
        setHardness(50).setResistance(1200F);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        setHarvestLevel("pickaxe", 3);
        setSoundType(NETHERITE_BLOCK_SOUND);
        setTranslationKey(Reference.MOD_ID + ".netherite_block").setRegistryName(Reference.MOD_ID, "netherite_block");
        ModBlocks.BLOCKS.add(this);
        OreDictionary.registerOre("blockNetherite", this);
    }
}
