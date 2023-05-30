package github.QueenPieIII.tfcagedbooze.config;

public class ConfigProperties
{
    public final boolean isEnabled;
    public final int minSugar;
    public final int maxSugarPrecent;
    public final int effectId;
    public final int effectStrength;
    public final int effectTime;

    public ConfigProperties(boolean isEnabled, int minSugar, int maxSugarPrecent, int effectId, int effectStrength, int effectTime)
    {
        this.isEnabled = isEnabled;
        this.minSugar = minSugar;
        this.maxSugarPrecent = maxSugarPrecent;
        this.effectId = effectId;
        this.effectStrength = effectStrength-1;
        this.effectTime = effectTime;
    }

}
