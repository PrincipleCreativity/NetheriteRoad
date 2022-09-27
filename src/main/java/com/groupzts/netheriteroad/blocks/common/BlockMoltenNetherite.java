package com.groupzts.netheriteroad.blocks.common;

import com.groupzts.netheriteroad.compat.tinkers.TiCConfig;
import com.groupzts.netheriteroad.compat.tinkers.TiCRegister;
import com.groupzts.netheriteroad.init.ModBlocks;
import com.groupzts.netheriteroad.utils.IHasModel;
import com.groupzts.netheriteroad.utils.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.BlockFluidClassic;

import javax.annotation.Nonnull;

public class BlockMoltenNetherite extends BlockFluidClassic{
    public BlockMoltenNetherite() {
        super(TiCRegister.moltenNetherite, Material.LAVA);
        setTranslationKey(Reference.MOD_ID + ".molten_netherite");
        setRegistryName(Reference.MOD_ID,"molten_netherite");
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
