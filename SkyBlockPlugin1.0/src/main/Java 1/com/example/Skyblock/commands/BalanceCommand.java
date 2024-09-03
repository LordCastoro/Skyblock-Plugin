package com.example.skyblock.commands;

import com.example.skyblock.managers.EconomyManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BalanceCommand implements CommandExecutor {

    private final EconomyManager economyManager;

    public BalanceCommand(EconomyManager economyManager) {
        this.economyManager = economyManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            double balance = economyManager.getBalance(player.getUniqueId());
            player.sendMessage("Il tuo saldo è: " + balance);
            return true;
        }
        return false;
    }
}
