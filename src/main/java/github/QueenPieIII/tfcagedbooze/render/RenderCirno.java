package github.QueenPieIII.tfcagedbooze.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class RenderCirno extends TileEntitySpecialRenderer
{
    static ResourceLocation texture = new ResourceLocation("tfcagedbooze:models/block/cirno_low_u1_v1.png");
    static IModelCustom model = AdvancedModelLoader.loadModel(new ResourceLocation("tfcagedbooze:models/block/cirno.objm"));
    public RenderCirno()
    {
        //texture = new ResourceLocation("tfcagedbooze:models/block/cirno_low_u1_v1.png");
        //model = (CustomModel) AdvancedModelLoader.loadModel(new ResourceLocation("tfcagedbooze:models/block/cirno_low.objm"));
    }
    public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float f)
    {
        GL11.glPushMatrix();
        int bright = tile.getWorldObj().getLightBrightnessForSkyBlocks(tile.xCoord, tile.yCoord + 2, tile.zCoord,0);
		int brightX = bright % 65536;
		int brightY = bright / 65536;
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, brightX, brightY);
        GL11.glTranslated(x + 0.5D, y, z + 0.5D);
        bindTexture(texture);
        GL11.glScalef(0.04F, 0.04F, 0.04F);
        GL11.glPushMatrix();
        model.renderAll();
        GL11.glPopMatrix();
        GL11.glPopMatrix();
        return;
    }
}
