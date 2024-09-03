package com.example.skyblock.managers;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class EconomyManager {

    private final Map<UUID, Double> balances = new HashMap<>();

    public EconomyManager() {
        // Inizializzazione, eventualmente caricando da file
    }

    public double getBalance(UUID playerUUID) {
        return balances.getOrDefault(playerUUID, 0.0);
    }

    public void addBalance(UUID playerUUID, double amount) {
        balances.put(playerUUID, getBalance(playerUUID) + amount);
    }

    public void removeBalance(UUID playerUUID, double amount) {
        balances.put(playerUUID, Math.max(0, getBalance(playerUUID) - amount));
    }
}
