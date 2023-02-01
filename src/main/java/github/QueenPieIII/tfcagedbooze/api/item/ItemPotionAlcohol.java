package github.QueenPieIII.tfcagedbooze.api.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

import com.bioxx.tfc.Items.ItemAlcohol;

enum EffectLevel
{
    I,
    II,
    III,
    IV,
    V,
    VI,
    VII,
    VIII,
    IX,
    X;
}

public class ItemPotionAlcohol extends ItemAlcohol
{
    private final PotionEffect effect;
    static final EffectLevel[] effectsList = EffectLevel.values();

    public ItemPotionAlcohol(PotionEffect effect)
    {
        super();
        this.effect = effect;
    }

    @Override
    public ItemStack onEaten(ItemStack is, World world, EntityPlayer player) {
        super.onEaten(is, world, player);
        player.addPotionEffect(effect);
        return is;
    }

    public PotionEffect getEffect()
    {
        return effect;
    }

    @Override
    public void addExtraInformation(ItemStack is, EntityPlayer player, List<String> arraylist)
    {
        String effectName = StatCollector.translateToLocal(((ItemPotionAlcohol)is.getItem()).getEffect().getEffectName());
        int effectStrength = ((ItemPotionAlcohol)is.getItem()).getEffect().getAmplifier();
        String effectLevel = effectStrength < effectsList.length ? effectsList[effectStrength].name() : Integer.toString(effectStrength);
        arraylist.add(effectName + " " + effectLevel);
    }
}
