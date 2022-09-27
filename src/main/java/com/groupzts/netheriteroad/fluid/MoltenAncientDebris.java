package com.groupzts.netheriteroad.fluid;

import slimeknights.tconstruct.library.fluid.FluidMolten;

public class MoltenAncientDebris extends FluidMolten {
    public MoltenAncientDebris() {
        super("molten_ancient",0x413030);
        this.setDensity(2000);
        this.setViscosity(10000);
        this.setTemperature(1000);
        this.setLuminosity(10);
    }
}
