package github.QueenPieIII.tfcagedbooze;

//import cpw.mods.fml.common.registry.GameRegistry;

//import github.QueenPieIII.tfcagedbooze.blocks.*;
//import github.QueenPieIII.tfcagedbooze.item.*;
import github.QueenPieIII.tfcagedbooze.register.*;
//import github.QueenPieIII.tfcagedbooze.tile.*;

public class CommonProxy
{

    public void registerMisc()
    {
        registerAgedFluids.register();
    }

    public void registerTileEntities()
    {
        //GameRegistry.registerTileEntity(TileCirno.class, "Cirno");
    }

    public void registerBlocks()
    {
        //GameRegistry.registerBlock(new BlockCirno(), ItemCirno.class, "Cirno");
    }
}
