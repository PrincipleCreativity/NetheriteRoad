package com.groupzts.netheriteroad.utils;

import com.groupzts.netheriteroad.init.ModItems;
import net.minecraftforge.oredict.OreDictionary;

public class ItemOreRegister {
    public static void register(){
        OreDictionary.registerOre("ingotNetherite", ModItems.NETHERITE_INGOT);
        OreDictionary.registerOre("NetheriteIngot", ModItems.NETHERITE_INGOT);
        OreDictionary.registerOre("scrapNetherite", ModItems.NETHERITE_SCRAP);
    }
}
