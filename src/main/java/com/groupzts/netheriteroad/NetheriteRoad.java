package com.groupzts.netheriteroad;

import com.groupzts.netheriteroad.event.WorldOreGen;
import com.groupzts.netheriteroad.init.ModBlocks;
import com.groupzts.netheriteroad.init.ModItems;
import com.groupzts.netheriteroad.proxy.ServerProxy;
import com.groupzts.netheriteroad.utils.ItemOreRegister;
import com.groupzts.netheriteroad.utils.Reference;
import com.groupzts.netheriteroad.utils.handlers.GuiHandler;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, useMetadata = true)
public enum NetheriteRoad {
    INSTANCE;
    public static final WorldOreGen ORE_GEN = new WorldOreGen();
    @SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY, modId = Reference.MOD_ID)
    public static ServerProxy proxy;
    @Mod.InstanceFactory
    public static NetheriteRoad getInstance(){
        return INSTANCE;
    }
    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event){
        proxy.preInit(event);
        NetworkRegistry.INSTANCE.registerGuiHandler(NetheriteRoad.getInstance(), GuiHandler.INSTANCE);
        GameRegistry.registerWorldGenerator(ORE_GEN, 5);
        GameRegistry.addSmelting(ModBlocks.ANCIENT_DEBRIS , new ItemStack(ModItems.NETHERITE_SCRAP), 2F);
    }
    @Mod.EventHandler
    public static void init(FMLInitializationEvent event){
        proxy.init(event);

    }
    static {
        FluidRegistry.enableUniversalBucket();
    }
}
