package github.QueenPieIII.tfcagedbooze;

import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.GameRegistry;

import github.QueenPieIII.tfcagedbooze.blocks.*;
import github.QueenPieIII.tfcagedbooze.commands.*;
import github.QueenPieIII.tfcagedbooze.item.*;
import github.QueenPieIII.tfcagedbooze.register.*;
import github.QueenPieIII.tfcagedbooze.tile.*;

public class CommonProxy
{
    public  void registerHandlers()
    {
    }

    public  void registerCommands(FMLServerStartingEvent event)
    {
        TFCAgedBooze.Log.info("Registering commands..");
        event.registerServerCommand(new PotencyCommand());
        TFCAgedBooze.Log.info("Successfully registered commands!");
    }

    public void registerFluids()
    {
        TFCAgedBooze.Log.info("Registering fluids...");
        registerAgedFluid.register();
        TFCAgedBooze.Log.info("Successfully registered fluids!");
    }

    public void registerItems()
    {
        TFCAgedBooze.Log.info("Registering items...");
        registerAgedItem.register();
        TFCAgedBooze.Log.info("Successfully registered items!");

    }

    public void registerRecipes()
    {
        TFCAgedBooze.Log.debug("Registering recipes...");
        registerAgedRecipe.register();
        TFCAgedBooze.Log.info("Successfully registered recipes!");
    }

    public void registerTileEntities()
    {
        GameRegistry.registerTileEntity(TileCirno.class, "Cirno");
    }

    public void registerBlocks()
    {
        GameRegistry.registerBlock(new BlockCirno(), ItemCirno.class, "Cirno");
    }
}
