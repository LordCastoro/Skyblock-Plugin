package com.example.skyblock.listeners;

import com.example.skyblock.managers.IslandManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    private final IslandManager islandManager;

    public PlayerJoinListener(IslandManager islandManager) {
        this.islandManager = islandManager;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (!islandManager.hasIsland(event.getPlayer())) {
            islandManager.createIsland(event.getPlayer());
            event.getPlayer().sendMessage("Benvenuto! La tua isola è stata creata.");
        }
    }
}
