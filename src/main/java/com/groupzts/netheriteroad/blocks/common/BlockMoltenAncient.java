package com.groupzts.netheriteroad.blocks.common;

import com.groupzts.netheriteroad.compat.tinkers.TiCRegister;
import com.groupzts.netheriteroad.init.ModBlocks;
import com.groupzts.netheriteroad.utils.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fluids.BlockFluidClassic;

public class BlockMoltenAncient extends BlockFluidClassic{
    public BlockMoltenAncient() {
        super(TiCRegister.moltenAncient, Material.LAVA);
        setTranslationKey(Reference.MOD_ID + ".molten_ancient");
        setRegistryName(Reference.MOD_ID,"molten_ancient");
        ModBlocks.BLOCKS.add(this);
    }
    @Override
    public boolean canCreatureSpawn(IBlockState state, IBlockAccess world, BlockPos pos, EntityLiving.SpawnPlacementType type) {
        return false;
    }
    @Override
    protected boolean canFlowInto(IBlockAccess world, BlockPos pos) {
        return true;
    }

}
