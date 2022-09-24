package com.groupzts.netheriteroad.client.container;

import com.groupzts.netheriteroad.init.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.inventory.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ContainerSmithing extends Container implements Supplier<Map<Integer, Slot>>  {
    private IInventory internal;
    private World world;
    private EntityPlayer entity;
    private int x, y, z;
    private Map<Integer, Slot> customSlots = new HashMap<>();
    public ContainerSmithing(World world, int x, int y, int z, EntityPlayer player) {
        this.world = world;
        this.entity = player;
        this.x = x;
        this.y = y;
        this.z = z;
        this.internal = new InventoryBasic("", true, 3);
        TileEntity ent = world.getTileEntity(new BlockPos(x, y, z));
        if (ent instanceof IInventory)
            this.internal = (IInventory) ent;
        this.customSlots.put(0, this.addSlotToContainer(new Slot(internal, 0, 27, 47) {
        }));
        this.customSlots.put(1, this.addSlotToContainer(new Slot(internal, 1, 76, 47) {
        }));
        this.customSlots.put(2, this.addSlotToContainer(new Slot(internal, 2, 134, 47) {
            @Override
            public boolean isItemValid(ItemStack stack) {
                return false;
            }
        }));
        int si;
        int sj;
        for (si = 0; si < 3; ++si)
            for (sj = 0; sj < 9; ++sj)
                this.addSlotToContainer(new Slot(player.inventory, sj + (si + 1) * 9, 8 + sj * 18, 84 + si * 18));
        for (si = 0; si < 9; ++si)
            this.addSlotToContainer(new Slot(player.inventory, si, 8 + si * 18, 142));

        Item item1 = getSlot(1).getStack().getItem();
        Item item2 = getSlot(0).getStack().getItem();
        if (item1 == ModItems.NETHERITE_INGOT) {
            if (item2 == Items.DIAMOND_SWORD) {
                {
                    getSlot(1).getStack().shrink(1);
                    getSlot(0).getStack().shrink(1);
                    getSlot(2).putStack(new ItemStack(ModItems.NETHERITE_SWORD));
                }
            }
        }

    }

    public Map<Integer, Slot> get() {
        return customSlots;
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return internal.isUsableByPlayer(player);
    }


    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = (Slot) this.inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if (index < 3) {
                if (!this.mergeItemStack(itemstack1, 3, this.inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
                slot.onSlotChange(itemstack1, itemstack);
            } else if (!this.mergeItemStack(itemstack1, 0, 3, false)) {
                if (index < 3 + 27) {
                    if (!this.mergeItemStack(itemstack1, 3 + 27, this.inventorySlots.size(), true)) {
                        return ItemStack.EMPTY;
                    }
                } else {
                    if (!this.mergeItemStack(itemstack1, 3, 3 + 27, false)) {
                        return ItemStack.EMPTY;
                    }
                }
                return ItemStack.EMPTY;
            }
            if (itemstack1.getCount() == 0) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }
            slot.onTake(playerIn, itemstack1);
        }
        return itemstack;
    }

    protected boolean mergeItemStack(ItemStack stack, int startIndex, int endIndex, boolean reverseDirection) {
        boolean flag = false;
        int i = startIndex;
        if (reverseDirection) {
            i = endIndex - 1;
        }
        if (stack.isStackable()) {
            while (!stack.isEmpty()) {
                if (reverseDirection) {
                    if (i < startIndex) {
                        break;
                    }
                } else if (i >= endIndex) {
                    break;
                }
                Slot slot = this.inventorySlots.get(i);
                ItemStack itemstack = slot.getStack();
                if (slot.isItemValid(itemstack) && !itemstack.isEmpty() && itemstack.getItem() == stack.getItem()
                        && (!stack.getHasSubtypes() || stack.getMetadata() == itemstack.getMetadata())
                        && ItemStack.areItemStackTagsEqual(stack, itemstack)) {
                    int j = itemstack.getCount() + stack.getCount();
                    int maxSize = Math.min(slot.getSlotStackLimit(), stack.getMaxStackSize());
                    if (j <= maxSize) {
                        stack.setCount(0);
                        itemstack.setCount(j);
                        slot.putStack(itemstack);
                        flag = true;
                    } else if (itemstack.getCount() < maxSize) {
                        stack.shrink(maxSize - itemstack.getCount());
                        itemstack.setCount(maxSize);
                        slot.putStack(itemstack);
                        flag = true;
                    }
                }
                if (reverseDirection) {
                    --i;
                } else {
                    ++i;
                }
            }
        }
        if (!stack.isEmpty()) {
            if (reverseDirection) {
                i = endIndex - 1;
            } else {
                i = startIndex;
            }
            while (true) {
                if (reverseDirection) {
                    if (i < startIndex) {
                        break;
                    }
                } else if (i >= endIndex) {
                    break;
                }
                Slot slot1 = this.inventorySlots.get(i);
                ItemStack itemstack1 = slot1.getStack();
                if (itemstack1.isEmpty() && slot1.isItemValid(stack)) {
                    if (stack.getCount() > slot1.getSlotStackLimit()) {
                        slot1.putStack(stack.splitStack(slot1.getSlotStackLimit()));
                    } else {
                        slot1.putStack(stack.splitStack(stack.getCount()));
                    }
                    slot1.onSlotChanged();
                    flag = true;
                    break;
                }
                if (reverseDirection) {
                    --i;
                } else {
                    ++i;
                }
            }
        }
        return flag;
    }

    @Override
    public void onContainerClosed(EntityPlayer playerIn) {
        super.onContainerClosed(playerIn);
        if ((internal instanceof InventoryBasic) && (playerIn instanceof EntityPlayerMP)) {
            this.clearContainer(playerIn, playerIn.world, internal);
        }
    }

}