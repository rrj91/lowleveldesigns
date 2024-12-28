package com.scaler.strategies.impl;

import com.scaler.models.*;
import com.scaler.strategies.GameWinningStrategy;

import java.util.*;

public class RowWinningStrategy implements GameWinningStrategy {
    List<Map<Player,Integer>> rowCount = new ArrayList<>();

    public RowWinningStrategy(int dimension) {
       for(int i=0;i<dimension;i++){
           rowCount.add(new HashMap<>());
       }
    }

    @Override
    public boolean checkWinner(Board board, Move lastMove) {
        int row = lastMove.getCell().getRow();

        Map<Player,Integer> rowMap = rowCount.get(row);
        if(rowMap == null){
            rowMap = new HashMap<>();
        }
        if(!rowMap.containsKey(lastMove.getPlayer())) {
            rowMap.put(lastMove.getPlayer(),0);
        }
            int count = rowMap.get(lastMove.getPlayer());
            count++;
        if(count == board.getSize()){
            return true;
        }
        rowMap.put(lastMove.getPlayer(),count);
        return false;
    }
}
