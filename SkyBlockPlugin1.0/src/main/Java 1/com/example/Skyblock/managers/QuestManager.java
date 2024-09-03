package com.example.skyblock.managers;

import com.example.skyblock.models.Quest;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class QuestManager {

    private final Map<UUID, Quest> activeQuests = new HashMap<>();

    public QuestManager() {
        // Inizializzazione delle missioni, eventualmente caricando da file
    }

    public void assignQuest(Player player, Quest quest) {
        activeQuests.put(player.getUniqueId(), quest);
        player.sendMessage("Ti è stata assegnata una nuova missione: " + quest.getName());
    }

    public Quest getActiveQuest(Player player) {
        return activeQuests.get(player.getUniqueId());
    }

    public boolean completeQuest(Player player) {
        Quest quest = activeQuests.get(player.getUniqueId());
        if (quest != null && quest.isComplete()) {
            activeQuests.remove(player.getUniqueId());
            player.sendMessage("Complimenti! Hai completato la missione: " + quest.getName());
            return true;
        }
        player.sendMessage("Non hai completato la missione attuale.");
        return false;
    }
}
