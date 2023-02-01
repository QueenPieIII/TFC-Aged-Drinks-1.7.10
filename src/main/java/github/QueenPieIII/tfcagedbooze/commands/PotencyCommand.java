package github.QueenPieIII.tfcagedbooze.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.util.ChatComponentText;

public class PotencyCommand extends CommandBase
{
    @Override
    public String getCommandName()
    {
        return "getpotency";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public void processCommand(ICommandSender sender, String[] args)
    {
        EntityPlayerMP player = getCommandSenderAsPlayer(sender);
        Item heldItem = player.inventory.getCurrentItem().getItem();
        sender.addChatMessage(new ChatComponentText(heldItem.getUnlocalizedName()));
        sender.addChatMessage(new ChatComponentText(heldItem.getUnlocalizedName().substring(5)));
    }

    @Override
    public String getCommandUsage(ICommandSender usage)
    {
        return "";
    }
}
