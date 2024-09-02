package com.skyblockplugin;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class IslandManager {
    private final SkyblockPlugin plugin;
    private final Map<UUID, Location> islandLocations = new HashMap<>();

    public IslandManager(SkyblockPlugin plugin) {
        this.plugin = plugin;
    }

    public void saveIsland(UUID playerUUID, Location location) {
        islandLocations.put(playerUUID, location);
        saveToFile();
    }

    public void saveToFile() {
        File file = new File(plugin.getDataFolder(), "islands.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        for (Map.Entry<UUID, Location> entry : islandLocations.entrySet()) {
            config.set("islands." + entry.getKey(), entry.getValue());
        }

        try {
            config.save(file);
        } catch (IOException e) {
            plugin.getLogger().severe("Errore nel salvare il file delle isole!");
        }
    }

    public void loadIslands() {
        File file = new File(plugin.getDataFolder(), "islands.yml");
        if (!file.exists()) {
            return;
        }

        FileConfiguration config = YamlConfiguration.loadConfiguration(file);
        for (String key : config.getConfigurationSection("islands").getKeys(false)) {
            UUID uuid = UUID.fromString(key);
            Location location = (Location) config.get("islands." + key);
            islandLocations.put(uuid, location);
        }
    }
}
