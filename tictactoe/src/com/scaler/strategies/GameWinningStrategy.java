package com.scaler.strategies;

import com.scaler.models.Board;
import com.scaler.models.Game;
import com.scaler.models.Move;

public interface GameWinningStrategy {
   boolean checkWinner(Board board, Move move);
}
