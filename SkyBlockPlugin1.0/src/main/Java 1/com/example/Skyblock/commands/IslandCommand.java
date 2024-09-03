package com.example.skyblock.commands;

import com.example.skyblock.managers.IslandManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class IslandCommand implements CommandExecutor {

    private final IslandManager islandManager;

    public IslandCommand(IslandManager islandManager) {
        this.islandManager = islandManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length > 0) {
                switch (args[0].toLowerCase()) {
                    case "create":
                        islandManager.createIsland(player);
                        player.sendMessage("Isola creata!");
                        break;
                    case "home":
                        islandManager.teleportToIsland(player);
                        break;
                    default:
                        player.sendMessage("Comando sconosciuto.");
                        break;
                }
            } else {
                player.sendMessage("Usa /island <comando>.");
            }
            return true;
        }
        return false;
    }
}
s