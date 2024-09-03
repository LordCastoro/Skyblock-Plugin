package com.example.skyblock.managers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.*;

public class LeaderboardManager {

    private final Map<UUID, Integer> playerScores = new HashMap<>();

    public LeaderboardManager() {
        // Inizializzazione, eventualmente caricando da file
    }

    public void updateScore(Player player, int score) {
        playerScores.put(player.getUniqueId(), score);
    }

    public int getScore(Player player) {
        return playerScores.getOrDefault(player.getUniqueId(), 0);
    }

    public List<Map.Entry<UUID, Integer>> getTopPlayers(int limit) {
        List<Map.Entry<UUID, Integer>> sortedList = new ArrayList<>(playerScores.entrySet());
        sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        return sortedList.subList(0, Math.min(sortedList.size(), limit));
    }

    public void displayLeaderboard(Player player) {
        player.sendMessage("Classifica dei migliori giocatori:");
        List<Map.Entry<UUID, Integer>> topPlayers = getTopPlayers(10);
        for (int i = 0; i < topPlayers.size(); i++) {
            UUID uuid = topPlayers.get(i).getKey();
            int score = topPlayers.get(i).getValue();
            Player topPlayer = Bukkit.getPlayer(uuid);
            player.sendMessage((i + 1) + ". " + (topPlayer != null ? topPlayer.getName() : uuid) + " - " + score + " punti");
        }
    }
}
