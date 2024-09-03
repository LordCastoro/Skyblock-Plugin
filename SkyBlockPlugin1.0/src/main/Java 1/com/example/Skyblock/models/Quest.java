package com.example.skyblock.models;

public class Quest {

    private final String name;
    private final String description;
    private boolean isComplete;

    public Quest(String name, String description) {
        this.name = name;
        this.description = description;
        this.isComplete = false;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void complete() {
        this.isComplete = true;
    }
}
