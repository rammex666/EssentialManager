package fr.rammex.essentialManager.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandManager implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String arg, String[] args) {
        Player player  = (Player) sender;

        if (args.length == 0) {
            player.sendMessage("§cEssentialManager §7- §c1.0");
            player.sendMessage("§7By §c.rammex");
            player.sendMessage("§7Use §c/em help §7for help");
        }

        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("help")) {
                player.sendMessage("§cEssentialManager §7- §c1.0");
                player.sendMessage("§7By §c.rammex");
                player.sendMessage("§7Commands:");
                player.sendMessage("§c/em reload §7- §cReload the plugin");
            }
            if (args[0].equalsIgnoreCase("reload")) {
                player.sendMessage("§cEssentialManager §7- §c1.0");
                player.sendMessage("§7By §c.rammex");
                player.sendMessage("§7Plugin reloaded");
            }
        }


        return false;
    }
}
