package com.skyblockplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class SkyblockPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Skyblock Plugin abilitato!");

        // Registra i comandi
        getCommand("skyblock").setExecutor(new SkyblockCommand(this));

        // Carica le isole esistenti
        getIslandManager().loadIslands();
    }

    @Override
    public void onDisable() {
        getLogger().info("Skyblock Plugin disabilitato!");

        // Salva le isole all'arresto
        getIslandManager().saveToFile();
    }

    private IslandManager islandManager;
    private QuestManager questManager;
    private LeaderboardManager leaderboardManager;

    @Override
    public void onLoad() {
        // Inizializza i manager
        islandManager = new IslandManager(this);
        questManager = new QuestManager(this);
        leaderboardManager = new LeaderboardManager();
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
