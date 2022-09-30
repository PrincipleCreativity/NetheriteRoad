package com.groupzts.netheriteroad.blocks.common;

import com.groupzts.netheriteroad.NetheriteRoad;
import com.groupzts.netheriteroad.blocks.BlockBase;
import com.groupzts.netheriteroad.utils.Reference;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SmithingTable extends BlockBase {


    public SmithingTable(String name, CreativeTabs tab, Material material) {
        super(Reference.MOD_ID, name, tab, material);
        setHardness(2.5F).setResistance(2.5F);
        setHarvestLevel("axe", 0);
        setSoundType(SoundType.WOOD);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        playerIn.openGui(NetheriteRoad.getInstance(), 1, worldIn, pos.getX(), pos.getY(), pos.getZ());
        return true;
    }
}
