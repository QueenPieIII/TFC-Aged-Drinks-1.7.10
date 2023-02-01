package github.QueenPieIII.tfcagedbooze.api.crafting;

import net.minecraftforge.fluids.FluidStack;

import com.bioxx.tfc.api.Crafting.BarrelRecipe;

public class AgedRecipe extends BarrelRecipe
{
    public AgedRecipe(FluidStack inputFluid, FluidStack outputFluid)
    {
        super(null, inputFluid, null, outputFluid, 720);
    }

    public AgedRecipe(FluidStack inputFluid, FluidStack outputFluid, int sealTime)
    {
        super(null, inputFluid, null, outputFluid, sealTime);
    }
}
