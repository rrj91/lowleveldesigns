package com.scaler.models;

public class Move {
    private Cell cell;
    private Player player;

    public Move(Player player, Cell cell) {
        this.player = player;
        this.cell = cell;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
