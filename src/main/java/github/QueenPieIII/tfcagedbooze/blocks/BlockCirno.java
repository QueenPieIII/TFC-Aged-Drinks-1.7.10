package github.QueenPieIII.tfcagedbooze.blocks;

import java.util.Random;

import github.QueenPieIII.tfcagedbooze.TFCAgedBooze;
import github.QueenPieIII.tfcagedbooze.tile.TileCirno;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.util.ChatComponentText;

public class BlockCirno extends BlockContainer
{
    private static String[] spellCards = {
        "Ice Sign \"Icicle Fall\"",
        "Hail Sign \"Hailstorm\"",
        "Hail Sign \"Hailstorm\"",
        "Freeze Sign \"Perfect Freeze\" \"Perfect Freeeeeeeeze!\"",
        "Freeze Sign \"Freeze Actress\"",
        "Frost Sign \"Frost Columns\"",
        "Freeze Sign \"Cold Divinity\"",
        "Freeze Sign \"Minus K\"",
        "Ice Sign \"Icicle Machine Gun\"",
        "Ice Sign \"Fairy Spin\"",
        "Ice Clump \"Cold Sprinkler\"",
        "Cold Body \"Super Ice Kick\"",
        "Ice Sign \"Sword Freezer\"",
        "Freeze Sign \"Freeze Atmosphere\"",
        "Cold Sign \"Insta-Freeze Beam\"",
        "Blowing Ice \"Ice Tornado\"",
        "Ice Clump \"Great Crusher\"",
        "\"Perfect Freeze\"",
        "Ice Sign \"Ultimate Blizzard\"",
        "Ice Sign \"Perfect Glacialist\"",
        "Ice King \"Frost King\"",
        "Ice Sign \"Cool Sunflower\""
    };
/*
        "氷符「アイシクルフォール」 ",
        "雹符「ヘイルストーム」 ",
        "凍符「パーフェクトフリーズ」\n「パーフェクトフリィィィズ！」",
        "雪符「ダイアモンドブリザード」 ",
        "凍符「フリーズアクトレス」 ",
        "霜符「フロストコラムス」 ",
        "凍符「コールドディヴィニティー」 ",
        "凍符「マイナスＫ」 ",
        "氷符「アイシクルマシンガン」 ",
        "氷符「フェアリースピン」 ",
        "氷塊「コールドスプリンクラー」 ",
        "冷体「スーパーアイスキック」 ",
        "氷符「ソードフリーザー」 ",
        "凍符「フリーズアトモスフェア」 ",
        "冷符「瞬間冷凍ビーム」 ",
        "吹氷「アイストルネード」 ",
        "氷塊「グレートクラッシャー」 ",
        "「パーフェクトフリーズ」 ",
        "氷符「アルティメットブリザード」 ",
        "氷符「パーフェクトグレーシャリスト」 ",
        "氷王「フロストキング」 ",
        "氷符「クールサンフラワー」 "
*/
    private static Random rand = new Random();
    public BlockCirno()
    {
        super(Material.cloth);
        setStepSound(soundTypeCloth);
        setBlockName("Cirno");
        setCreativeTab(CreativeTabs.tabMisc);
        setHardness(1);
        setBlockBounds(0.25F, 0.0F, 0.25F, 0.8F, 1.2F, 0.8F);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
    {
        if(!world.isRemote)
            player.addChatMessage(new ChatComponentText(spellCards[rand.nextInt(spellCards.length)]));
        return true;
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public int getRenderType(){
        return -1;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata)
    {
        return new TileCirno();
    }

    @Override
    public void registerBlockIcons(IIconRegister iconReg) {
        blockIcon = iconReg.registerIcon(TFCAgedBooze.MODID + ":Cirno");
    }
}
