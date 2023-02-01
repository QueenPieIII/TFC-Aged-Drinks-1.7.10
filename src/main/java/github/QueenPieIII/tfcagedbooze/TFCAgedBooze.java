package github.QueenPieIII.tfcagedbooze;

import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.FMLLog;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

@Mod(modid = TFCAgedBooze.MODID, useMetadata = true)
public class TFCAgedBooze
{
    public static final String MODID = "tfcagedbooze";
    public static Logger Log = FMLLog.getLogger();

    @EventHandler 
    public void preinit(FMLPreInitializationEvent event)
    {
        ModRegister.registerFluids();
        ModRegister.registerItems();
        ModRegister.registerRecipes();
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		// some example code
        Log.info("Init!!!");
    }

    @EventHandler
    public void serverStating(FMLServerStartingEvent event)
    {
        ModRegister.registerCommands(event);
    }
}
