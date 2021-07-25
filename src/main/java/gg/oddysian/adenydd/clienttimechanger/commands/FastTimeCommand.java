package gg.oddysian.adenydd.clienttimechanger.commands;

import gg.oddysian.adenydd.clienttimechanger.enums.TimeTypes;
import gg.oddysian.adenydd.clienttimechanger.listeners.ClientListener;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import org.apache.commons.lang3.math.NumberUtils;

public class FastTimeCommand extends CommandBase {

    public String getName() {
        return "fasttime";
    }


    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (args.length == 0) {
            sender.sendMessage((new TextComponentString("§cPlease use /fasttime <multiplier>!")));
            return;
        }
        double multiplier = NumberUtils.toDouble(args[0], -1.0D);
        if (multiplier < 0.0D) {
            sender.sendMessage((new TextComponentString("§4Multiplier can't be 0!")));
            return;
        }
        ClientListener.TIME_TYPE = TimeTypes.FAST;
        ClientListener.fastTimeMultiplier = multiplier;
        sender.sendMessage(new TextComponentString("§eClient Time has been edited §bx " + multiplier));
    }

    public String getUsage(ICommandSender sender) {
        return "§c/fasttime";
    }


    public int getRequiredPermissionLevel() {
        return 0;
    }
}
