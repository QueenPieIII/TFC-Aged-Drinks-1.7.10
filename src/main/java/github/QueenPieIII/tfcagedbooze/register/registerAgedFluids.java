package github.QueenPieIII.tfcagedbooze.register;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import cpw.mods.fml.common.registry.GameRegistry;

import com.bioxx.tfc.Core.TFCTabs;
import com.bioxx.tfc.api.TFCItems;
import com.bioxx.tfc.api.Crafting.BarrelManager;

import github.QueenPieIII.tfcagedbooze.api.TABAgedFluids;
import github.QueenPieIII.tfcagedbooze.api.crafting.AgedRecipe;
import github.QueenPieIII.tfcagedbooze.api.item.ItemPotionAlcohol;
import github.QueenPieIII.tfcagedbooze.config.Config;
import github.QueenPieIII.tfcagedbooze.config.ConfigProperties;

public class registerAgedFluids
{
    public static void register()
    {
        for(TABAgedFluids fluid : TABAgedFluids.values())
        {
            ConfigProperties config = Config.getAgedFluidProperties(fluid);

            //register item
            PotionEffect effect = new PotionEffect(config.effectId, config.effectTime, config.effectStrength);
            Item item = new ItemPotionAlcohol(effect).setUnlocalizedName(fluid.getNiceName()).setCreativeTab(TFCTabs.TFC_FOODS);
            GameRegistry.registerItem(item, item.getUnlocalizedName());

            // Register fluid
            FluidRegistry.registerFluid(fluid.getFluid());
            FluidContainerRegistry.registerFluidContainer(new FluidStack(fluid.getFluid(), 250), new ItemStack(item), new ItemStack(TFCItems.glassBottle));
        
            // Register recipe
            if(config.isEnabled)
            {
                String fluidName = fluid.name().toLowerCase();
                FluidStack inFluidStack = new FluidStack(FluidRegistry.getFluid(fluidName), 10000);
                FluidStack outFluidStack = new FluidStack(fluid.getFluid(), 10000);
                BarrelManager.getInstance().addRecipe(new AgedRecipe(inFluidStack, config.minSugar, config.maxSugarPrecent, outFluidStack, Config.sealTimeRequired));
            }
        }     
    }  
}
