package com.skyblockplugin;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class QuestManager {
    private final SkyblockPlugin plugin;
    private final Map<UUID, Integer> playerQuests = new HashMap<>();

    public QuestManager(SkyblockPlugin plugin) {
        this.plugin = plugin;
    }

    public void startQuest(Player player) {
        playerQuests.put(player.getUniqueId(), 0);
        player.sendMessage("Missione iniziata!");
    }

    public void completeObjective(Player player) {
        int progress = playerQuests.getOrDefault(player.getUniqueId(), -1);
        if (progress == -1) {
            player.sendMessage("Non hai una missione attiva.");
            return;
        }
        playerQuests.put(player.getUniqueId(), progress + 1);
        player.sendMessage("Obiettivo completato! Progress: " + (progress + 1) + "/10");
        if (progress + 1 >= 10) {
            player.sendMessage("Missione completata!");
            playerQuests.remove(player.getUniqueId());
        }
    }
}
