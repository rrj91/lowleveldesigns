package com.scaler.strategies;

import com.scaler.models.Board;
import com.scaler.models.Move;
import com.scaler.models.Player;

public interface BotPlayingStrategy {
    Move decideMove(Player player, Board board);
}
