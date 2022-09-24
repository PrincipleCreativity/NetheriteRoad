package com.groupzts.netheriteroad.init;

import com.groupzts.netheriteroad.blocks.common.AncientDebris;
import com.groupzts.netheriteroad.blocks.common.SmithingTable;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
    public static final List<Block> BLOCKS = new ArrayList<>();
    public static final Block ANCIENT_DEBRIS = new AncientDebris("ancient_debris", Material.ROCK);
    public static final Block SMITHING_TABLE = new SmithingTable("smithing_table", Material.WOOD);
}
