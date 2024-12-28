package com.scaler.strategies.impl;

import com.scaler.models.*;
import com.scaler.strategies.GameWinningStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ColWinningStrategy implements GameWinningStrategy {
    List<Map<Player,Integer>> colCount = new ArrayList<>();
    public ColWinningStrategy(int dimension) {
        for(int i=0;i<dimension;i++){
            colCount.add(new HashMap<>());
        }
    }
    @Override
    public boolean checkWinner(Board board, Move lastMove) {
        if(colCount == null){
            colCount = new ArrayList<>();
        }

        int col = lastMove.getCell().getCol();
        Map<Player,Integer> colMap = colCount.get(col);
        if(colMap == null){
            colMap = new HashMap<>();
        }
        if(!colMap.containsKey(lastMove.getPlayer())) {
            colMap.put(lastMove.getPlayer(),0);
        }
        int count = colMap.get(lastMove.getPlayer());
        count++;
        if(count == board.getSize()){
            return true;
        }
        colMap.put(lastMove.getPlayer(),count);
        return false;
    }
}
