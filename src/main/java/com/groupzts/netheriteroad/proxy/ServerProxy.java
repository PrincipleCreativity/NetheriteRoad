package com.groupzts.netheriteroad.proxy;

import c4.conarm.ConstructsArmory;
import com.groupzts.netheriteroad.compat.conarm.ConarmCompat;
import com.groupzts.netheriteroad.compat.tinkers.TiCConfig;
import com.groupzts.netheriteroad.utils.ItemOreRegister;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

;

public class ServerProxy {
	public void preInit(FMLPreInitializationEvent event) {
		if(Loader.isModLoaded("tconstruct")){
			TiCConfig.setup();
			if(Loader.isModLoaded(ConstructsArmory.MODID)){
				ConarmCompat.register();
			}
		}

		ItemOreRegister.register();
	}
	public void init(FMLInitializationEvent event) {
	}

	public void registerItemRenderer(Item item, int meta, String id ) {
	}
}
