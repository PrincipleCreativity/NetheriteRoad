package com.groupzts.netheriteroad.client.container;

import com.groupzts.netheriteroad.init.ModItems;
import com.groupzts.netheriteroad.init.ModSounds;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ContainerSmithing extends Container
{
    private static final Logger LOGGER = LogManager.getLogger();
    private final IInventory outputSlot;
    private final IInventory inputSlots;
    private final World world;
    private final BlockPos selfPosition;
    public int maximumCost;
    public int materialCost;

    @SideOnly(Side.CLIENT)
    public ContainerSmithing(InventoryPlayer playerInventory, World worldIn, EntityPlayer player)
    {
        this(playerInventory, worldIn, BlockPos.ORIGIN, player);
    }

    public ContainerSmithing(InventoryPlayer playerInventory, final World worldIn, final BlockPos blockPosIn, EntityPlayer player)
    {
        this.outputSlot = new InventoryCraftResult();
        this.inputSlots = new InventoryBasic("Repair", true, 2)
        {
            public void markDirty()
            {
                super.markDirty();
                ContainerSmithing.this.onCraftMatrixChanged(this);
            }
        };
        this.selfPosition = blockPosIn;
        this.world = worldIn;
        this.addSlotToContainer(new Slot(this.inputSlots, 0, 27, 47));
        this.addSlotToContainer(new Slot(this.inputSlots, 1, 76, 47){
            @Override
            public boolean isItemValid(ItemStack stack) {
                return stack.getItem() == SmithingType.NETHERITE.getSmithingItem() || stack.getItem() == SmithingType.CUSTOM.getSmithingItem();
            }
        });
        this.addSlotToContainer(new Slot(this.outputSlot, 2, 134, 47)
        {
            public boolean isItemValid(ItemStack stack)
            {
                return false;
            }
            public ItemStack onTake(EntityPlayer thePlayer, ItemStack stack)
            {
                world.playSound(player, player.posX, player.posY, player.posZ, ModSounds.SMITHING_TABLE_SOUND, SoundCategory.PLAYERS, 1, 1);
                if(!getSlot(0).getStack().isEmpty() && !getSlot(1).getStack().isEmpty()){
                    getSlot(1).getStack().shrink(1);
                    getSlot(0).getStack().shrink(1);
                }
                if (!thePlayer.capabilities.isCreativeMode)
                {
                    thePlayer.addExperienceLevel(-ContainerSmithing.this.maximumCost);
                }
                return stack;
            }
        });

        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int k = 0; k < 9; ++k)
        {
            this.addSlotToContainer(new Slot(playerInventory, k, 8 + k * 18, 142));
        }
    }

    public void onCraftMatrixChanged(IInventory inventoryIn)
    {
        super.onCraftMatrixChanged(inventoryIn);

        if (inventoryIn == this.inputSlots)
        {
            this.updateRepairOutput();
        }
    }

    public void updateRepairOutput() {
        Item item1 = getSlot(1).getStack().getItem();
        Item item2 = getSlot(0).getStack().getItem();
        ItemStack stack1 = getSlot(1).getStack();
        ItemStack stack2 = getSlot(0).getStack();

        Map<Enchantment, Integer> map1 = EnchantmentHelper.getEnchantments(stack2);

        if(SmithingType.NETHERITE.getSmithingItem().equals(item1)){
            for(Map.Entry<Item, Item> entry: Objects.requireNonNull(SmithingType.NETHERITE.getItemMap()).entrySet()) {
                ItemStack outputValue = new ItemStack(entry.getValue());
                if (entry.getKey().equals(item2) && SmithingType.NETHERITE.getSmithingItem().equals(item1)) {
                    getSlot(2).putStack(outputValue);
                }
                if (entry.getKey().equals(item2) && item2.isEnchantable(stack2)) {
                    for (Map.Entry<Enchantment, Integer> entryEnchantment : map1.entrySet()) {
                        getSlot(2).putStack(outputValue);
                        outputValue.addEnchantment(entryEnchantment.getKey(), entryEnchantment.getValue());
                    }
                }
            }
            }
        if (stack1.isEmpty() || stack2.isEmpty()) {
            getSlot(2).putStack(ItemStack.EMPTY);
        }
        if(SmithingType.CUSTOM.getSmithingItem() == null || SmithingType.CUSTOM.getItemMap() == null) {
            return;
        }
            if (SmithingType.CUSTOM.getSmithingItem().equals(item1))
                for (Map.Entry<Item, Item> entry : Objects.requireNonNull(SmithingType.CUSTOM.getItemMap()).entrySet()) {
                    ItemStack outputValue = new ItemStack(entry.getValue());
                    if (entry.getKey().equals(item2) && SmithingType.CUSTOM.getSmithingItem().equals(item1)) {
                        getSlot(2).putStack(outputValue);
                    }
                    if (entry.getKey().equals(item2) && item2.isEnchantable(stack2)) {
                        for(Map.Entry<Enchantment, Integer> entryEnchantment: map1.entrySet()) {
                            getSlot(2).putStack(outputValue);
                            outputValue.addEnchantment(entryEnchantment.getKey(), entryEnchantment.getValue());
                        }
                    }
                }
    }

    public void addListener(IContainerListener listener)
    {
        super.addListener(listener);
        listener.sendWindowProperty(this, 0, this.maximumCost);
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data)
    {
        if (id == 0)
        {
            this.maximumCost = data;
        }
    }

    public void onContainerClosed(EntityPlayer playerIn)
    {
        super.onContainerClosed(playerIn);

        if (!this.world.isRemote)
        {
            this.clearContainer(playerIn, this.world, this.inputSlots);
        }
    }

    public boolean canInteractWith(EntityPlayer playerIn)
    {
            return playerIn.getDistanceSq((double)this.selfPosition.getX() + 0.5D, (double)this.selfPosition.getY() + 0.5D, (double)this.selfPosition.getZ() + 0.5D) <= 64.0D;
    }

    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index == 2)
            {
                if (!this.mergeItemStack(itemstack1, 3, 39, true))
                {
                    return ItemStack.EMPTY;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (index != 0 && index != 1)
            {
                if (index < 39 && !this.mergeItemStack(itemstack1, 0, 2, false))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 3, 39, false))
            {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty())
            {
                slot.putStack(ItemStack.EMPTY);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount())
            {
                return ItemStack.EMPTY;
            }

            slot.onTake(playerIn, itemstack1);
        }

        return itemstack;
    }
    public void updateItemName(String newName)
    {

        if (this.getSlot(2).getHasStack())
        {
            ItemStack itemstack = this.getSlot(2).getStack();

            if (StringUtils.isBlank(newName))
            {
                itemstack.clearCustomName();
            }
            else
            {
                itemstack.setStackDisplayName(newName);
            }
        }

        this.updateRepairOutput();
    }
    public enum SmithingType {
        NETHERITE(netheriteMap(), ModItems.NETHERITE_INGOT),
        CUSTOM(getSwitchMap(), getCustomSmithingItem());

        private final Map<Map<Item, Item>, Item> totalMap;
        private final Item smithingItem;
        private static String customName;
        private static Map<Item, Item> switchMap;
        private static Item customSmithingItem;
        private static final Map<String, SmithingType> nameMap = new HashMap<>();

        SmithingType(Map<Item, Item> switchMap, Item smithingItem){
            Map<Map<Item, Item>, Item> totalMap = new HashMap<>();
            totalMap.put(switchMap, smithingItem);
            this.totalMap = totalMap;
            this.smithingItem = smithingItem;
        }

        public Map<Map<Item, Item>, Item> getTotalMap() {
            return totalMap;
        }

        @Nullable
        public Map<Item, Item> getItemMap(){
            for(Map.Entry<Map<Item, Item>, Item> entry: getTotalMap().entrySet()){
                return entry.getKey();
            }
            return null;
        }

        public static SmithingType addCustomType(String customName, Map<Item, Item> switchMap, Item customSmithingItem){
            SmithingType.customName = customName;
            SmithingType.switchMap = switchMap;
            SmithingType.customSmithingItem = customSmithingItem;
            nameMap.put(customName, CUSTOM);
            return CUSTOM;
        }

        private static Map<Item, Item> netheriteMap(){
            Map<Item, Item> netheriteMap = new HashMap<>();
            netheriteMap.put(Items.DIAMOND_SWORD, ModItems.NETHERITE_SWORD);
            netheriteMap.put(Items.DIAMOND_PICKAXE, ModItems.NETHERITE_PICKAXE);
            netheriteMap.put(Items.DIAMOND_AXE, ModItems.NETHERITE_AXE);
            netheriteMap.put(Items.DIAMOND_SHOVEL, ModItems.NETHERITE_SHOVEL);
            netheriteMap.put(Items.DIAMOND_HOE, ModItems.NETHERITE_HOE);
            netheriteMap.put(Items.DIAMOND_HELMET, ModItems.NETHERITE_HELMET);
            netheriteMap.put(Items.DIAMOND_CHESTPLATE, ModItems.NETHERITE_CHESTPLATE);
            netheriteMap.put(Items.DIAMOND_LEGGINGS, ModItems.NETHERITE_LEGGINGS);
            netheriteMap.put(Items.DIAMOND_BOOTS, ModItems.NETHERITE_BOOTS);
            return netheriteMap;
        }

        public Item getSmithingItem() {
            return smithingItem;
        }

        public static Map<Item, Item> getSwitchMap() {
            return switchMap;
        }

        public static String getCustomName() {
            return customName;
        }

        public static Item getCustomSmithingItem() {
            return customSmithingItem;
        }

        public static Map<String, SmithingType> getNameMap() {
            return nameMap;
        }
    }

}

