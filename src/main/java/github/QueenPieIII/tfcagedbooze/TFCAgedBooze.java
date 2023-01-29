package github.QueenPieIII.tfcagedbooze;

import org.apache.logging.log4j.Logger;

import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.FMLLog;

@Mod(modid = TFCAgedBooze.MODID, useMetadata = true/*version = TFCAgedBooze.VERSION*/)
public class TFCAgedBooze
{
    public static final String MODID = "tfcagedbooze";
    public static Logger Log = FMLLog.getLogger();

    @EventHandler 
    public void preinit(FMLPreInitializationEvent event)
    {
        Log.info("PreInit!!!");
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		// some example code
        System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());
    }
}
