package github.QueenPieIII.tfcagedbooze.item;

import java.util.List;

import com.bioxx.tfc.Items.ItemBlocks.ItemTerraBlock;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemCirno extends ItemTerraBlock
{
    public ItemCirno(Block block)
    {
        super(block);
        setCreativeTab(CreativeTabs.tabMisc);
        setUnlocalizedName("cirno");
    }

    @Override
    public void addInformation(ItemStack is, EntityPlayer player, List arraylist, boolean flag)
    {
        super.addInformation(is, player, arraylist, flag);
        arraylist.add("What a funky!");
    }

    
}
