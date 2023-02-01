package github.QueenPieIII.tfcagedbooze;

import cpw.mods.fml.common.event.FMLServerStartingEvent;

import github.QueenPieIII.tfcagedbooze.commands.*;
import github.QueenPieIII.tfcagedbooze.register.*;



public final class ModRegister
{
    public static void registerCommands(FMLServerStartingEvent event)
    {
        TFCAgedBooze.Log.info("Registering commands..");
        event.registerServerCommand(new PotencyCommand());
        TFCAgedBooze.Log.info("Successfully registered commands!");
    }

    public static void registerFluids()
    {
        TFCAgedBooze.Log.info("Registering fluids...");
        registerAgedFluid.register();
        TFCAgedBooze.Log.info("Successfully registered fluids!");
    }

    public static void registerItems()
    {
        TFCAgedBooze.Log.info("Registering items...");
        registerAgedItem.register();
        TFCAgedBooze.Log.info("Successfully registered items!");
    }

    public static void registerRecipes()
    {
        TFCAgedBooze.Log.debug("Registering recipes...");
        registerAgedRecipe.register();
        TFCAgedBooze.Log.info("Successfully registered recipes!");
    }
}
