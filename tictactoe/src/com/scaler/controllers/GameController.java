package com.scaler.controllers;

import com.scaler.exceptions.InvalidMoveException;
import com.scaler.models.Game;
import com.scaler.models.GameStatus;
import com.scaler.models.Player;
import com.scaler.strategies.GameWinningStrategy;

import java.util.List;

public class GameController {
    public Game createGame(int dimension, List<Player> players){
        return  Game.getBuilder()
                .setDimension(dimension)
                .setPlayers(players)
                .build();

    }

    public GameStatus getGameStatus(Game game){
        return game.getGameStatus();
    }

    public String getWinningName(Game game){
        return game.getWinningPlayer().getName();
    }

    public void displayBoard(Game game){
        game.getBoard().displayBoard();
    }

    public void executeNextMove(Game game) throws InvalidMoveException {
        game.makeNextMove();
    }


}
