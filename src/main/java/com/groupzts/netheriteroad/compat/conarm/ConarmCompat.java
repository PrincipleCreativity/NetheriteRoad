package com.groupzts.netheriteroad.compat.conarm;

import c4.conarm.common.armor.traits.ArmorTraits;
import c4.conarm.lib.materials.ArmorMaterialType;
import c4.conarm.lib.materials.CoreMaterialStats;
import c4.conarm.lib.materials.PlatesMaterialStats;
import c4.conarm.lib.materials.TrimMaterialStats;
import com.groupzts.netheriteroad.compat.conarm.traits.AncientProtect;
import com.groupzts.netheriteroad.compat.tinkers.TiCRegister;
import slimeknights.tconstruct.library.TinkerRegistry;

public class ConarmCompat {
    public static AncientProtect ancientProtect = new AncientProtect();
    public static void register(){
        TinkerRegistry.addMaterialStats(TiCRegister.netherite,
                new CoreMaterialStats(100, 20),
                new PlatesMaterialStats(0.85f, 20, 8),
                new TrimMaterialStats(40)
        );
        TiCRegister.netherite.addTrait(ancientProtect,ArmorMaterialType.CORE);
        TiCRegister.netherite.addTrait(ArmorTraits.combustible,ArmorMaterialType.CORE);
        TiCRegister.netherite.addTrait(ArmorTraits.superhot,ArmorMaterialType.TRIM);
        TiCRegister.netherite.addTrait(ArmorTraits.heavy,ArmorMaterialType.TRIM);
        TiCRegister.netherite.addTrait(ArmorTraits.superhot,ArmorMaterialType.PLATES);
        TiCRegister.netherite.addTrait(ArmorTraits.heavy,ArmorMaterialType.PLATES);
    }
}
