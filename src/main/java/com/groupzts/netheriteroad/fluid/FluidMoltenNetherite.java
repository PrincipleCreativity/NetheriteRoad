package com.groupzts.netheriteroad.fluid;

import slimeknights.tconstruct.library.fluid.FluidMolten;

public class FluidMoltenNetherite extends FluidMolten {

    public FluidMoltenNetherite() {
        super("molten_netherite", 0x383333);
        this.setDensity(2000);
        this.setViscosity(10000);
        this.setTemperature(1000);
        this.setLuminosity(10);
    }
}
