package com.commands;

import com.skyblockplugin.SkyblockPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SkyblockCommand implements CommandExecutor {

    private final SkyblockPlugin plugin;

    public SkyblockCommand(SkyblockPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Questo comando può essere usato solo da un giocatore.");
            return false;
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            player.sendMessage("Usa /skyblock <start|complete|leaderboard>");
            return false;
        }

        switch (args[0].toLowerCase()) {
            case "start":
                plugin.getQuestManager().startQuest(player);
                break;
            case "complete":
                plugin.getQuestManager().completeObjective(player);
                break;
            case "leaderboard":
                player.sendMessage("Leaderboard non implementata.");
                break;
            default:
                player.sendMessage("Comando sconosciuto.");
                break;
        }

        return true;
    }
}
