package github.QueenPieIII.tfcagedbooze.api;

import net.minecraft.potion.Potion;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

import com.bioxx.tfc.Core.FluidBaseTFC;

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

    private final String niceName;
    private final Fluid fluid;
    private final int color;
    private final Potion effect;
    private final int strength;
    private final int time;
    private final int minSugar;
    private final int maxSugarPrecent;
    private final int sealTime;

    TABAgedFluids(Potion effect, int strength, int time)
    {
        this(effect, strength, time, 20, 200);
    }

    TABAgedFluids(Potion effect, int strength, int time, int sealTime)
    {
        this(effect, strength, time, 20, 200, sealTime);
    }

    TABAgedFluids(Potion effect, int strength, int time, int MinSugar, int maxSugarPrecent)
    {
        this(effect, strength, time, MinSugar, maxSugarPrecent,2160);
    }

    //TODO: Remove sealTime (it is handled globally by the config file) or make it so each fluid can have a specific sealTime
    TABAgedFluids(Potion effect, int strength, int time, int minSugar, int maxSugarPrecent, int sealTime)
    {
        String fluidName = this.name().toLowerCase();
        Fluid regFluid = FluidRegistry.getFluid(fluidName);

        this.niceName = makeName(fluidName);

        this.color = regFluid.getColor();
        this.fluid = new FluidBaseTFC("aged" + fluidName).setBaseColor(this.color);

        this.minSugar = minSugar;
        this.maxSugarPrecent = maxSugarPrecent;

        this.strength = strength;
        this.time = time;
        this.effect = effect;

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

    public Potion getPotion()
    {
        return effect;
    }

    public int getEffectStrength()
    {
        return strength;
    }

    public int getEffectTime() 
    {
        return time;
    }

    public int getMinSugar()
    {
        return minSugar;
    }

    public int getMaxSugarPrecent()
    {
        return maxSugarPrecent;
    }

    public String getNiceName()
    {
        return niceName;
    }
}