package github.QueenPieIII.tfcagedbooze.register;

import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.bioxx.tfc.api.Crafting.BarrelManager;

import github.QueenPieIII.tfcagedbooze.api.TABAgedFluids;
import github.QueenPieIII.tfcagedbooze.api.crafting.AgedRecipe;

public class registerAgedRecipe
{
    public static void register()
    {
        for(TABAgedFluids fluid : TABAgedFluids.values())
        {
            String fluidName = fluid.name().toLowerCase();
            FluidStack inFluidStack = new FluidStack(FluidRegistry.getFluid(fluidName), 10000);
            FluidStack outFluidStack = new FluidStack(fluid.getFluid(), 10000);
            BarrelManager.getInstance().addRecipe(new AgedRecipe(inFluidStack, 20, 200, outFluidStack, fluid.getSealTime()));
        }      
    }    
}
