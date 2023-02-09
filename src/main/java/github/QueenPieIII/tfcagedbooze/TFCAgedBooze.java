package github.QueenPieIII.tfcagedbooze;

import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

import github.QueenPieIII.tfcagedbooze.commands.*;
import github.QueenPieIII.tfcagedbooze.config.Config;;

@Mod(modid = TFCAgedBooze.MODID, useMetadata = true)
public class TFCAgedBooze
{
    public static final String MODID = "tfcagedbooze";
    public static Logger Log = FMLLog.getLogger();

    @SidedProxy(serverSide = "github.QueenPieIII.tfcagedbooze.CommonProxy", clientSide = "github.QueenPieIII.tfcagedbooze.ClientProxy")
    private static CommonProxy proxy;

    @SuppressWarnings("method")
    @EventHandler 
    public void preinit(FMLPreInitializationEvent event)
    {
        Config.init(event.getSuggestedConfigurationFile());
        proxy.registerMisc();
        proxy.registerTileEntities();
        proxy.registerBlocks();
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        Log.info("Init!!!");
    }

    @EventHandler
    public void serverStating(FMLServerStartingEvent event)
    {
        event.registerServerCommand(new PotencyCommand());
    }
}
