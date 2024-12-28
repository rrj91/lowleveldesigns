package com.scaler.models;

import com.scaler.strategies.BotPlayingStrategy;
import com.scaler.strategies.impl.EasyBotPlayingStrategy;
import com.scaler.strategies.impl.HardBotPlayingStrategy;
import com.scaler.strategies.impl.MediumBotPlayingStrategy;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;
    public Bot(String botName, String botSymbol, BotDifficultyLevel difficultyLevel) {
        super(botName,botSymbol,PlayerType.BOT);
        this.botDifficultyLevel = difficultyLevel;
        this.botPlayingStrategy = getBotPlayingStrategy(botDifficultyLevel);
    }

    private BotPlayingStrategy getBotPlayingStrategy(BotDifficultyLevel botDifficultyLevel) {
        switch (botDifficultyLevel){
            case EASY -> {
                return new EasyBotPlayingStrategy();
            }
            case MEDIUM -> {
                return new MediumBotPlayingStrategy();
            }
            case HARD -> {
                return new HardBotPlayingStrategy();
            }
        }
        return new EasyBotPlayingStrategy();
    }

    @Override
    public Move decideMove(Board board) {
        return botPlayingStrategy.decideMove(this,board);
    }
}
