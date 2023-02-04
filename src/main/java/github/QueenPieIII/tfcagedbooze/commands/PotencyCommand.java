package github.QueenPieIII.tfcagedbooze.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.model.AdvancedModelLoader;

public class PotencyCommand extends CommandBase
{
    @Override
    public String getCommandName()
    {
        return "getsuffixes";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public void processCommand(ICommandSender sender, String[] args)
    {
        String text = "";
        for(String suffix : AdvancedModelLoader.getSupportedSuffixes())
        {
            text += suffix + " ";
        }
        sender.addChatMessage(new ChatComponentText(text));

    }

    @Override
    public String getCommandUsage(ICommandSender usage)
    {
        return "";
    }
}
