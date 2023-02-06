package github.QueenPieIII.tfcagedbooze;

import net.minecraftforge.client.model.AdvancedModelLoader;

import cpw.mods.fml.client.registry.ClientRegistry;

import github.QueenPieIII.tfcagedbooze.api.objm.ObjmModelLoader;
import github.QueenPieIII.tfcagedbooze.render.*;
import github.QueenPieIII.tfcagedbooze.tile.*;

public class ClientProxy extends CommonProxy
{
    @Override
    public  void registerHandlers()
    {
        AdvancedModelLoader.registerModelHandler(new ObjmModelLoader());
    }

    @Override
    public void registerTileEntities()
    {
        ClientRegistry.registerTileEntity(TileCirno.class, "Cirno", new RenderCirno());
    }

}
