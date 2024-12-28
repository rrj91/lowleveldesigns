package com.scaler.models;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;

    public Bot(String botName, String botSymbol, BotDifficultyLevel difficultyLevel) {
        super(botName,botSymbol,PlayerType.BOT);
        this.botDifficultyLevel = difficultyLevel;
    }
}
