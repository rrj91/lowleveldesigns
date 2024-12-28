package com.scaler.strategies.impl;

import com.scaler.models.*;
import com.scaler.strategies.BotPlayingStrategy;

public class HardBotPlayingStrategy implements BotPlayingStrategy {
    @Override
    public Move decideMove(Player player, Board board) {
        for (int i=0;i<board.getCells().size();i++){
            for(int j=0;j<board.getCells().size();j++){
                if(board.getCells().get(i).get(j).getCellState() == CellState.EMPTY){
                    return new Move(player,new Cell(i,j));
                }
            }
        }
        return null;
    }
}
