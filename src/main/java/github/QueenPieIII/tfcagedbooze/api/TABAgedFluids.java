package github.QueenPieIII.tfcagedbooze.api;

import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

import com.bioxx.tfc.Core.FluidBaseTFC;
import com.bioxx.tfc.Core.TFCTabs;

import github.QueenPieIII.tfcagedbooze.api.item.ItemPotionAlcohol;

public enum TABAgedFluids
{
    RUM(Potion.jump, 1, 9600),
    WHISKEY(Potion.digSpeed, 1, 9600),
    RYEWHISKEY(Potion.digSpeed, 1, 9600),
    CORNWHISKEY(Potion.digSpeed, 1, 9600),
    VODKA(Potion.resistance, 0, 9600),
    CIDER(Potion.moveSpeed, 1, 9600),
    BEER(Potion.field_76434_w, 1,9600), // field_76434_w is Health Boost!
    SAKE(Potion.damageBoost, 0, 9600);

    private final Fluid fluid;
    private final Item item;
    private final PotionEffect effect;
    private final int color;
    private final int sealTime;

    TABAgedFluids(Potion effect, int strength, int time)
    {
        this(effect, strength, time, 2160);
    }

    TABAgedFluids(Potion effect, int strength, int time, int sealTime)
    {
        String fluidName = this.name().toLowerCase();
        Fluid regFluid = FluidRegistry.getFluid(fluidName);
        this.color = regFluid.getColor();
        this.fluid = new FluidBaseTFC("aged" + fluidName).setBaseColor(this.color);
        this.effect = new PotionEffect(effect.id, time, strength);
        this.item = new ItemPotionAlcohol(this.effect).setUnlocalizedName(makeName(fluidName)).setCreativeTab(TFCTabs.TFC_FOODS);
        this.sealTime = sealTime;
    }

    public static String makeName(String name)
    {
        char[] ret = ("Aged" + name).toCharArray();
        ret[4] = Character.toUpperCase(ret[4]);
        return new String(ret);
    }

    public int getColor()
    {
        return color;
    }

    public int getSealTime()
    {
        return sealTime;
    }

    public Fluid getFluid()
    {
        return fluid;
    }

    public PotionEffect getPotionEffect()
    {
        return effect;
    }

    public Item getItem()
    {
        return item;
    }
}