package gg.oddysian.adenydd.clienttimechanger.commands;

import gg.oddysian.adenydd.clienttimechanger.enums.TimeTypes;
import gg.oddysian.adenydd.clienttimechanger.listeners.ClientListener;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

public class DayCommand extends CommandBase {

    public String getName() {
        return "day";
    }


    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        ClientListener.TIME_TYPE = TimeTypes.DAY;
        sender.sendMessage(new TextComponentString("§eClient Time set to §bDay."));
    }

    public String getUsage(ICommandSender sender) {
        return "§c/day";
    }


    public int getRequiredPermissionLevel() {
        return 0;
    }

}
