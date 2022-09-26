package com.groupzts.netheriteroad.compat.tinkers;

import net.minecraftforge.fluids.FluidStack;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.smeltery.AlloyRecipe;
import slimeknights.tconstruct.shared.TinkerFluids;

public class NetheriteAlloyRecipe extends AlloyRecipe {
    public NetheriteAlloyRecipe() {
        super(new FluidStack(TiCConfig.MOLTEN_NETHERITE_FLUID, Material.VALUE_Ingot),new FluidStack(TiCConfig.MOLTEN_ANCIENT, Material.VALUE_Ingot),new FluidStack(TinkerFluids.gold, Material.VALUE_Ingot));
    }
}
