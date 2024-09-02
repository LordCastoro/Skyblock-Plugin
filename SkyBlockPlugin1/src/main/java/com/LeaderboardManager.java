package com.skyblockplugin;

import java.util.*;

public class LeaderboardManager {
    private final Map<UUID, Integer> playerScores = new HashMap<>();

    public void addScore(UUID playerUUID, int score) {
        playerScores.put(playerUUID, playerScores.getOrDefault(playerUUID, 0) + score);
    }

    public List<Map.Entry<UUID, Integer>> getTopPlayers(int limit) {
        List<Map.Entry<UUID, Integer>> sortedList = new ArrayList<>(playerScores.entrySet());
        sortedList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        return sortedList.subList(0, Math.min(limit, sortedList.size()));
    }
}
