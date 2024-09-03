package com.example.skyblock.managers;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class IslandManager {

    private final Map<UUID, Location> islands = new HashMap<>();

    public IslandManager() {
        // Inizializzazione
    }

    public void createIsland(Player player) {
        Location islandLocation = new Location(player.getWorld(), 0, 100, 0); // esempio di posizione
        islands.put(player.getUniqueId(), islandLocation);
        player.teleport(islandLocation);
    }

    public void teleportToIsland(Player player) {
        Location islandLocation = islands.get(player.getUniqueId());
        if (islandLocation != null) {
            player.teleport(islandLocation);
        } else {
            player.sendMessage("Non hai un'isola! Creane una con /island create.");
        }
    }

    public boolean hasIsland(Player player) {
        return islands.containsKey(player.getUniqueId());
    }
}
