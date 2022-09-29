package com.groupzts.netheriteroad.compat.tinkers;

import com.google.common.collect.Lists;
import com.groupzts.netheriteroad.fluid.FluidMoltenNetherite;
import com.groupzts.netheriteroad.fluid.MoltenAncientDebris;
import com.groupzts.netheriteroad.init.ModItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.client.MaterialRenderInfo;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.smeltery.AlloyRecipe;
import slimeknights.tconstruct.library.smeltery.Cast;
import slimeknights.tconstruct.library.smeltery.CastingRecipe;
import slimeknights.tconstruct.library.smeltery.MeltingRecipe;
import slimeknights.tconstruct.library.tinkering.MaterialItem;
import slimeknights.tconstruct.library.tools.IToolPart;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.shared.TinkerFluids;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;

import java.util.List;

public class TiCRegister {
    public static Fluid moltenNetherite;
    public static Fluid moltenAncient;
    public static final List<Material> materials = Lists.newArrayList();
    public static Material netherite = mat();
    private static Material mat() {
        if (TinkerRegistry.getMaterial("netherite") == TinkerRegistry.getMaterial("unknown")){
            Material mat = new Material("netherite", 3683123);
            materials.add(mat);
            return mat;
        }
        return TinkerRegistry.getMaterial("netherite");
    }
    public static void registerTiC(){

        Fluid MOLTEN_NETHERITE_FLUID = new FluidMoltenNetherite();
        Fluid MOLTEN_ANCIENT = new MoltenAncientDebris();
        moltenAncient = MOLTEN_ANCIENT;
        moltenNetherite = MOLTEN_NETHERITE_FLUID;
        FluidRegistry.registerFluid(MOLTEN_NETHERITE_FLUID);
        FluidRegistry.addBucketForFluid(MOLTEN_NETHERITE_FLUID);
        NBTTagCompound tag = new NBTTagCompound();
        tag.setString("molten_netherite", MOLTEN_NETHERITE_FLUID.getName());
        tag.setString("ore", "molten_netherite");
        tag.setBoolean("toolforge", true);
        FMLInterModComms.sendMessage("tconstruct", "integrateSmeltery", tag);

        FluidRegistry.registerFluid(MOLTEN_ANCIENT);
        FluidRegistry.addBucketForFluid(MOLTEN_ANCIENT);
        NBTTagCompound tag2 = new NBTTagCompound();
        tag.setString("molten_ancient", MOLTEN_NETHERITE_FLUID.getName());
        tag.setString("ore", "molten_ancient");
        tag.setBoolean("toolforge", true);
        FMLInterModComms.sendMessage("tconstruct", "integrateSmeltery", tag2);

        TinkerRegistry.registerMelting(new MeltingRecipe(RecipeMatch.of(ModItems.NETHERITE_BLOCK_ITEM, Material.VALUE_Block),MOLTEN_NETHERITE_FLUID,1000));
        TinkerRegistry.registerMelting(new MeltingRecipe(RecipeMatch.of(ModItems.ANCIENT_DEBRIS_ITEM, Material.VALUE_Ore()),MOLTEN_ANCIENT,600));
        HarvestLevels.harvestLevelNames.put(32, TextFormatting.GRAY + "Netherite");
        netherite.addItemIngot("ingotNetherite");
        netherite.setRepresentativeItem(ModItems.NETHERITE_INGOT);
        netherite.setCastable(true);
        netherite.setFluid(MOLTEN_NETHERITE_FLUID);
        netherite.setCraftable(true);

        netherite.addTrait(new AbstractTrait("superfortified", TextFormatting.DARK_GRAY) {
            @Override
            public void onArmorTick(ItemStack tool, World world, EntityPlayer player) {
            }

            @Override
            public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage, boolean isCritical) {
                return 3;
            }

            @Override
            public void applyEffect(NBTTagCompound rootCompound, NBTTagCompound modifierTag) {
                NBTTagCompound toolTag = TagUtil.getToolTag(rootCompound);
               int modifiers = toolTag.getInteger("FreeModifiers");
                toolTag.setInteger("FreeModifiers",25 + modifiers);
            }
        });
        TinkerRegistry.addMaterialStats(netherite,
                new HeadMaterialStats(2031, 11f, 6.0f, 4),
                new HandleMaterialStats(10.0f, 3042),
                new ExtraMaterialStats(1011));
        new BowMaterialStats(5.0F, 5.0F, 5F);

        TinkerRegistry.registerAlloy(new AlloyRecipe(new FluidStack(MOLTEN_NETHERITE_FLUID, Material.VALUE_Ingot),new FluidStack(MOLTEN_ANCIENT, Material.VALUE_Ingot),new FluidStack(TinkerFluids.gold, Material.VALUE_Ingot)));

        TinkerRegistry.registerMelting(new MeltingRecipe(RecipeMatch.of("ingotNetherite", Material.VALUE_Ingot), MOLTEN_NETHERITE_FLUID, 1000));
        TinkerRegistry.registerMelting(new MeltingRecipe(RecipeMatch.of(ModItems.NETHERITE_HELMET, Material.VALUE_Ingot * 5),MOLTEN_NETHERITE_FLUID,1000));
        TinkerRegistry.registerMelting(new MeltingRecipe(RecipeMatch.of(ModItems.NETHERITE_CHESTPLATE, Material.VALUE_Ingot * 8),MOLTEN_NETHERITE_FLUID,1000));
        TinkerRegistry.registerMelting(new MeltingRecipe(RecipeMatch.of(ModItems.NETHERITE_LEGGINGS, Material.VALUE_Ingot * 7),MOLTEN_NETHERITE_FLUID, 1000));
        TinkerRegistry.registerMelting(new MeltingRecipe(RecipeMatch.of(ModItems.NETHERITE_BOOTS, Material.VALUE_Ingot * 4),MOLTEN_NETHERITE_FLUID, 1000));
        TinkerRegistry.registerBasinCasting(new CastingRecipe(new ItemStack(ModItems.NETHERITE_BLOCK_ITEM), RecipeMatch.of(Blocks.AIR), MOLTEN_NETHERITE_FLUID, Material.VALUE_Block));
        TinkerRegistry.integrate(netherite).preInit();
        registerToolParts(netherite);
    }

    protected static void registerToolParts(Material material)
    {
        Fluid fluid = material.getFluid();

        for(IToolPart toolPart : TinkerRegistry.getToolParts())
        {
            if(!toolPart.canBeCasted())
                continue;

            if(!toolPart.canUseMaterial(material))
                continue;

            if(toolPart instanceof MaterialItem)
            {
                ItemStack stack = toolPart.getItemstackWithMaterial(material);
                ItemStack originCast = Cast.setTagForPart(new ItemStack(TinkerSmeltery.cast), stack.getItem());
                if(fluid != null)
                {
                    TinkerRegistry.registerMelting(stack, fluid, toolPart.getCost());
                    TinkerRegistry.registerTableCasting(stack, originCast, fluid, toolPart.getCost());
                }
            }
        }
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        if (event.getSide().isClient()) {
            registerMaterialRendering();
        }}

    @SideOnly(Side.CLIENT)
    public static void registerMaterialRendering() {
        netherite.setRenderInfo(new MaterialRenderInfo.Metal(0x383333, 0.5f, 0.5f, 0.2f));
    }
}
