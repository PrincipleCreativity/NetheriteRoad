package com.groupzts.netheriteroad.utils.handlers;

import com.groupzts.netheriteroad.client.container.ContainerSmithing;
import com.groupzts.netheriteroad.client.gui.GuiSmithing;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import javax.annotation.Nullable;

public enum GuiHandler implements IGuiHandler {
    INSTANCE;
    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if(ID == GuiSmithing.GUI_ID){
            return new ContainerSmithing(world, x, y, z, player);
        }
        return null;
    }
    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if(ID == GuiSmithing.GUI_ID){
            return new GuiSmithing(world, x, y, z, player);
        }
        return null;
    }
}