package com.groupzts.netheriteroad.blocks.common;

import com.groupzts.netheriteroad.blocks.BlockBase;
import net.minecraft.block.material.Material;

public class AncientDebris extends BlockBase {
    public AncientDebris(String name, Material material) {
        super(name, material);
        setHardness(30F).setResistance(1200F);
        setHarvestLevel("pickaxe", 3);
    }
}
