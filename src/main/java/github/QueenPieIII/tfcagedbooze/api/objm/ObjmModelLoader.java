package github.QueenPieIII.tfcagedbooze.api.objm;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModelCustom;
import net.minecraftforge.client.model.IModelCustomLoader;
import net.minecraftforge.client.model.ModelFormatException;

public class ObjmModelLoader implements IModelCustomLoader
{
    @Override
    public String getType()
    {
        return "OBJM model";
    }

    private static final String[] types = { "objm" };
    @Override
    public String[] getSuffixes()
    {
        return types;
    }

    @Override
    public IModelCustom loadInstance(ResourceLocation resource) throws ModelFormatException
    {
        return new CustomModel(resource);
    }
}
