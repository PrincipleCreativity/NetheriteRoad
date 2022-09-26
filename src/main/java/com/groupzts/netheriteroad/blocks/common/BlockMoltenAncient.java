package com.groupzts.netheriteroad.blocks.common;

import com.groupzts.netheriteroad.compat.tinkers.TiCConfig;
import com.groupzts.netheriteroad.init.ModBlocks;
import com.groupzts.netheriteroad.utils.IHasModel;
import com.groupzts.netheriteroad.utils.Reference;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.model.ModelLoader;
import slimeknights.tconstruct.smeltery.block.BlockMolten;

import javax.annotation.Nonnull;

public class BlockMoltenAncient extends BlockMolten implements IHasModel {
    public BlockMoltenAncient() {
        super(TiCConfig.MOLTEN_NETHERITE_FLUID);
        setTranslationKey(Reference.MOD_ID + ".molten_ancient");
        setRegistryName(Reference.MOD_ID,"molten_ancient");


    }
    @Override
    public boolean canCreatureSpawn(IBlockState state, IBlockAccess world, BlockPos pos, EntityLiving.SpawnPlacementType type) {
        return false;
    }

    @Override
    protected boolean canFlowInto(IBlockAccess world, BlockPos pos) {
        return true;
    }

    @Override
    public void registerModels() {
        ModelLoader.setCustomStateMapper(this, new StateMapperBase() {
            @Override
            protected ModelResourceLocation getModelResourceLocation(@Nonnull IBlockState state) {
                return new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID, "molten_ancient"), "molten_ancient");
            }
        });
    }
}
