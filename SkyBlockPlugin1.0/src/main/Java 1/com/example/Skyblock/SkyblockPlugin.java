package com.example.skyblock;

import com.example.skyblock.commands.IslandCommand;
import com.example.skyblock.commands.QuestCommand;
import com.example.skyblock.commands.BalanceCommand;
import com.example.skyblock.commands.LeaderboardCommand;
import com.example.skyblock.listeners.PlayerJoinListener;
import com.example.skyblock.managers.EconomyManager;
import com.example.skyblock.managers.IslandManager;
import com.example.skyblock.managers.QuestManager;
import com.example.skyblock.managers.LeaderboardManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class SkyblockPlugin extends JavaPlugin {

    private EconomyManager economyManager;
    private IslandManager islandManager;
    private QuestManager questManager;
    private LeaderboardManager leaderboardManager;

    @Override
    public void onEnable() {
        economyManager = new EconomyManager();
        islandManager = new IslandManager(this);
        questManager = new QuestManager();
        leaderboardManager = new LeaderboardManager();

        this.getCommand("island").setExecutor(new IslandCommand(islandManager));
        this.getCommand("quest").setExecutor(new QuestCommand(questManager));
        this.getCommand("balance").setExecutor(new BalanceCommand(economyManager));
        this.getCommand("leaderboard").setExecutor(new LeaderboardCommand(leaderboardManager));

        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(islandManager), this);

        getLogger().info("Skyblock Plugin attivato!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Skyblock Plugin disattivato!");
    }

    public EconomyManager getEconomyManager() {
        return economyManager;
    }

    public IslandManager getIslandManager() {
        return islandManager;
    }

    public QuestManager getQuestManager() {
        return questManager;
    }

    public LeaderboardManager getLeaderboardManager() {
        return leaderboardManager;
    }
}
