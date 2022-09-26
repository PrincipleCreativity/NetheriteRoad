package com.groupzts.netheriteroad.compat.tinkers;

import com.google.common.collect.Lists;
import com.groupzts.netheriteroad.fluid.FluidMoltenNetherite;
import com.groupzts.netheriteroad.fluid.MoltenAncientDebris;
import com.groupzts.netheriteroad.init.ModBlocks;
import com.groupzts.netheriteroad.init.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextFormatting;
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
import slimeknights.tconstruct.library.events.TinkerRegisterEvent;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.smeltery.AlloyRecipe;
import slimeknights.tconstruct.library.smeltery.Cast;
import slimeknights.tconstruct.library.smeltery.MeltingRecipe;
import slimeknights.tconstruct.library.tinkering.MaterialItem;
import slimeknights.tconstruct.library.tools.IToolPart;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;

import java.util.List;

public class TiCConfig {
    public static final AbstractTrait netheritetrait = new TraitNetherite();
    public static final List<Material> materials = Lists.newArrayList();
    public static Material netherite = mat("netherite", 0x383333);
    public static final Fluid MOLTEN_NETHERITE_FLUID = new FluidMoltenNetherite();
    public static final Fluid MOLTEN_ANCIENT = new MoltenAncientDebris();
    private static Material mat(String name, int color) {
        if (TinkerRegistry.getMaterial(name) == TinkerRegistry.getMaterial("unknown")){
            Material mat = new Material(name, color);
            materials.add(mat);
            return mat;
        }
        return TinkerRegistry.getMaterial(name);
    }

    public static void setup() {

        FluidRegistry.registerFluid(TiCConfig.MOLTEN_NETHERITE_FLUID);
        FluidRegistry.addBucketForFluid(TiCConfig.MOLTEN_NETHERITE_FLUID);
        NBTTagCompound tag = new NBTTagCompound();
        tag.setString("molten_netherite", TiCConfig.MOLTEN_NETHERITE_FLUID.getName());
        tag.setString("ore", "molten_netherite");
        tag.setBoolean("toolforge", true);
        FMLInterModComms.sendMessage("tconstruct", "integrateSmeltery", tag);

        FluidRegistry.registerFluid(TiCConfig.MOLTEN_ANCIENT);
        FluidRegistry.addBucketForFluid(TiCConfig.MOLTEN_ANCIENT);
        NBTTagCompound tag2 = new NBTTagCompound();
        tag.setString("molten_ancient", TiCConfig.MOLTEN_NETHERITE_FLUID.getName());
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
        netherite.addTrait(netheritetrait);
        TinkerRegistry.addMaterialStats(netherite,
                new HeadMaterialStats(2031, 11f, 6.0f, 4),
                new HandleMaterialStats(10.0f, 3042),
                new ExtraMaterialStats(1011));
        new BowMaterialStats(5.0F, 5.0F, 5F);

        TinkerRegistry.integrate(netherite).preInit();
        registerToolParts(netherite);
        AlloyRecipe recipe = new NetheriteAlloyRecipe();
        TinkerRegistry.registerAlloy(recipe);


        TinkerRegistry.registerMelting(new MeltingRecipe(RecipeMatch.of("ingotNetherite"),new FluidStack(MOLTEN_NETHERITE_FLUID, Material.VALUE_Ingot),1000));

        TinkerRegistry.registerMelting(new MeltingRecipe(RecipeMatch.of(ModItems.NETHERITE_HELMET, Material.VALUE_Ingot * 5),MOLTEN_NETHERITE_FLUID,1000));
        TinkerRegistry.registerMelting(new MeltingRecipe(RecipeMatch.of(ModItems.NETHERITE_CHESTPLATE, Material.VALUE_Ingot * 8),MOLTEN_NETHERITE_FLUID,1000));
        TinkerRegistry.registerMelting(new MeltingRecipe(RecipeMatch.of(ModItems.NETHERITE_LEGGINGS, Material.VALUE_Ingot * 7),MOLTEN_NETHERITE_FLUID, 1000));
        TinkerRegistry.registerMelting(new MeltingRecipe(RecipeMatch.of(ModItems.NETHERITE_BOOTS, Material.VALUE_Ingot * 4),MOLTEN_NETHERITE_FLUID, 1000));

    }
    private static void registerToolParts(Material material)
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
