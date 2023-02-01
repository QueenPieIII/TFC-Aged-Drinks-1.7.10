package github.QueenPieIII.tfcagedbooze.register;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.bioxx.tfc.api.TFCItems;

import github.QueenPieIII.tfcagedbooze.api.TABAgedFluids;

public final class registerAgedFluid
{
    public static void register()
    {
        for(TABAgedFluids fluid : TABAgedFluids.values())
        {
            FluidRegistry.registerFluid(fluid.getFluid());
            FluidContainerRegistry.registerFluidContainer(new FluidStack(fluid.getFluid(), 250), new ItemStack(fluid.getItem()), new ItemStack(TFCItems.glassBottle));
        }
    }
}
