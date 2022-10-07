package com.groupzts.netheriteroad.compat.tinkers;

import com.groupzts.netheriteroad.blocks.common.BlockMoltenAncient;
import com.groupzts.netheriteroad.blocks.common.BlockMoltenNetherite;
import com.groupzts.netheriteroad.utils.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;


@Mod.EventBusSubscriber
public class RegistryEvent {
    @SubscribeEvent
    public static void registerFluidBlock(net.minecraftforge.event.RegistryEvent.Register<Block> event){
        if(Loader.isModLoaded("tconstruct")){
            BlockFluidClassic moltenNetherite = new BlockMoltenNetherite();
            BlockFluidClassic moltenAncient = new BlockMoltenAncient();
            event.getRegistry().registerAll(moltenAncient.setDensity(5), moltenNetherite.setDensity(5));
        }
    }
}
