package github.QueenPieIII.tfcagedbooze.api.crafting;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;

import com.bioxx.tfc.Food.ItemFoodTFC;
import com.bioxx.tfc.api.Food;
import com.bioxx.tfc.api.TFCItems;
import com.bioxx.tfc.api.Crafting.BarrelRecipe;
import com.bioxx.tfc.api.Interfaces.IFood;

public class AgedRecipe extends BarrelRecipe
{  
    private float requiredPrecent;
    private float variedPrecent;
    public AgedRecipe(FluidStack inputFluid, float sugarWeight, float sugarBonus, FluidStack outputFluid)
    {
        this(inputFluid, sugarWeight, sugarBonus, outputFluid, 2160);
    }

    public AgedRecipe(FluidStack inputFluid, float sugarWeight, float sugarBonus, FluidStack outputFluid, int sealTime)
    {
        super(ItemFoodTFC.createTag(new ItemStack(TFCItems.sugar), sugarWeight), inputFluid, null, outputFluid);
        this.requiredPrecent = sugarWeight/(160f * (inputFluid.amount/10000f));
        this.variedPrecent = requiredPrecent * (sugarBonus/100 + 1);
        this.sealTime = sealTime;
    }

    @Override
    public Boolean matches(ItemStack item, FluidStack fluid)
    {
        if(item == null || !recipeFluid.isFluidEqual(fluid))
        {
            return false;
        }
        if(item.hasTagCompound() && item.getItem() instanceof IFood)
        {
            float precent = Food.getWeight(item)/(160f * (fluid.amount/10000f));
            if(precent < requiredPrecent || precent > variedPrecent)
            {   
                return false;
            }
        }
        return OreDictionary.itemMatches(recipeIS, item, false);
        
    }
}
