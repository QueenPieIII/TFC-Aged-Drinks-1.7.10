package github.QueenPieIII.tfcagedbooze.config;

import java.io.File;
import java.util.HashMap;

import net.minecraftforge.common.config.Configuration;

import github.QueenPieIII.tfcagedbooze.api.TABAgedFluids;
import github.QueenPieIII.tfcagedbooze.TFCAgedBooze;

public class Config
{
    private static Configuration config;

    public static boolean isSugarAgingEnabled;
    public static int sealTimeRequired;

    private static HashMap<TABAgedFluids, ConfigProperties> agedFluidMap = new HashMap<TABAgedFluids, ConfigProperties>();

    public static void init(File configFile)
    {
        if(config != null)
        {
            throw new IllegalStateException("init should be called once!");
        }
        config = new Configuration(configFile);
        TFCAgedBooze.Log.info("Loading config file...");
        config.load();
        for(TABAgedFluids fluid : TABAgedFluids.values())
        {
            String name = fluid.getNiceName();
            int MaxSugarPrecent = config.get(Configuration.CATEGORY_GENERAL, name+"MaxSugarPrecent", fluid.getMaxSugarPrecent(), "This number dictates the maximum precent of bonus sugar allowed to be inside the barrel until the recipe is invalid. \nThis does not do anything if ageWithSugar is disabled").getInt();
            int minSugar = config.get(Configuration.CATEGORY_GENERAL, name+"MinSugarPerBarrel", fluid.getMinSugar(), "This number represents the minimum oz of sugar needed for one barrel and it is used when calculating the sugar to barrel ratio. \nThis does not do anything if ageWithSugar is disabled").getInt();
            int effectTime = config.get(Configuration.CATEGORY_GENERAL, name+"EffectTime", fluid.getEffectTime(), "This number represents how much the given effect will last").getInt();
            int effectStrength = config.get(Configuration.CATEGORY_GENERAL, name+"EffectStrength", fluid.getEffectStrength(), "This number represents the strength of the given effect").getInt();
            int effectId = config.get(Configuration.CATEGORY_GENERAL, name+"EffectId", fluid.getPotion().getId(), "This number represents the ID of the effect given when "+name+" is consumed").getInt();
            boolean isEnabled = config.get(Configuration.CATEGORY_GENERAL, name+"RecipeEnabled", true, "Set this to false to disable the recipe for "+name).getBoolean();
            agedFluidMap.put(fluid, new ConfigProperties(isEnabled, minSugar, MaxSugarPrecent, effectId, effectStrength, effectTime));
        }
        sealTimeRequired = config.get(Configuration.CATEGORY_GENERAL, "sealTimeRequired", 2160, "This number represents how many hours a drink should be sealed until it becomes aged").getInt();
        isSugarAgingEnabled = config.get(Configuration.CATEGORY_GENERAL, "ageWithSugar", true, "Set this to false to disable the need of sugar when aging").getBoolean();
        if (config.hasChanged())
        {
            TFCAgedBooze.Log.info("Saving config file...");
            config.save();
        }
    }

    public static ConfigProperties getAgedFluidProperties(TABAgedFluids fluid)
    {
        return agedFluidMap.get(fluid);
    }
}
