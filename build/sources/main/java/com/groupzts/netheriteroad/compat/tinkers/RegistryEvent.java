package com.groupzts.netheriteroad.compat.tinkers;

import com.groupzts.netheriteroad.blocks.common.BlockMoltenAncient;
import com.groupzts.netheriteroad.blocks.common.BlockMoltenNetherite;
import net.minecraft.block.Block;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


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
