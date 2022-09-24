package com.groupzts.netheriteroad.proxy;

import com.groupzts.netheriteroad.NetheriteRoad;
import com.groupzts.netheriteroad.utils.handlers.GuiHandler;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

import static com.groupzts.netheriteroad.NetheriteRoad.ORE_GEN;

public class ServerProxy {
	public void preInit(FMLPreInitializationEvent event) {
	}
	public void init(FMLInitializationEvent event) {

	}

	public void registerItemRenderer(Item item, int meta, String id )
	{
	}
}
