package com.groupzts.netheriteroad.init;

import com.groupzts.netheriteroad.blocks.common.AncientDebris;
import com.groupzts.netheriteroad.blocks.common.NetheriteBlock;
import com.groupzts.netheriteroad.blocks.common.SmithingTable;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
    public static final List<Block> BLOCKS = new ArrayList<>();
    public static final Block ANCIENT_DEBRIS = new AncientDebris(Material.ROCK);
    public static final Block SMITHING_TABLE = new SmithingTable("smithing_table", CreativeTabs.DECORATIONS, Material.WOOD);
    public static final Block NETHERITE_BLOCK = new NetheriteBlock(Material.ROCK);
}