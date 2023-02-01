package github.QueenPieIII.tfcagedbooze.register;

import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

import github.QueenPieIII.tfcagedbooze.api.TABAgedFluids;

public class registerAgedItem
{
    public static void register()
    {
        for(TABAgedFluids fluid : TABAgedFluids.values())
        {
            Item item = fluid.getItem();
            GameRegistry.registerItem(item, item.getUnlocalizedName());
        }
    }
}
