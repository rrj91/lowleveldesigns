package com.scaler.models;

public enum BotDifficultyLevel {
    EASY(1),
    MEDIUM(2),
    HARD(3);
    private final int value;

    BotDifficultyLevel(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
