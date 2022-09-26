package com.groupzts.netheriteroad.init;

import com.groupzts.netheriteroad.blocks.common.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Loader;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
    public static final List<Block> BLOCKS = new ArrayList<>();
    public static final Block ANCIENT_DEBRIS = new AncientDebris(Material.ROCK);
    public static final Block SMITHING_TABLE = new SmithingTable("smithing_table", CreativeTabs.DECORATIONS, Material.WOOD);
    public static final Block NETHERITE_BLOCK = new NetheriteBlock(Material.ROCK);
        public static Block MOLTEN_NETHERITE;
        public static Block MOLTEN_ANCIENT;

    {
        if(Loader.isModLoaded("tconstruct")) {
            MOLTEN_NETHERITE = new BlockMoltenNetherite().setDensity(5);
            MOLTEN_ANCIENT = new BlockMoltenAncient().setDensity(5);
        }
    }
}