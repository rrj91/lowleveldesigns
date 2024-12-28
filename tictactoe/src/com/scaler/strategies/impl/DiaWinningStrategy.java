package com.scaler.strategies.impl;

import com.scaler.models.*;
import com.scaler.strategies.GameWinningStrategy;

import java.util.HashMap;
import java.util.Map;

public class DiaWinningStrategy implements GameWinningStrategy {
    Map<Player,Integer> dia1Map = new HashMap<>();
    Map<Player,Integer> dia2Map = new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move lastMove) {
        int row = lastMove.getCell().getRow();
        int col = lastMove.getCell().getCol();
        if(row+col == board.getSize()-1){
            if(dia2Map == null){
                dia2Map = new HashMap<>();
            }else{
                if(!dia2Map.containsKey(lastMove.getPlayer())){
                    dia2Map.put(lastMove.getPlayer(),0);
                }
                int count = dia2Map.get(lastMove.getPlayer());
                count++;
                if(count == board.getSize()){
                    return true;
                }
                dia2Map.put(lastMove.getPlayer(),count);
            }
        }
        if(row-col == 0){
            if(dia1Map == null){
                dia1Map = new HashMap<>();
            }else{
                if(!dia1Map.containsKey(lastMove.getPlayer())){
                    dia1Map.put(lastMove.getPlayer(),0);
                }
                int count = dia1Map.get(lastMove.getPlayer());
                count++;
                if(count == board.getSize()){
                    return true;
                }
                dia1Map.put(lastMove.getPlayer(),count);
            }
        }
        return false;
    }
}
