package com.scaler.models;

import java.util.Objects;
import java.util.Scanner;

public class Player {
    private String name;
    private String symbol;
    private PlayerType playerType;

    public Player(String name, String symbol, PlayerType playerType) {
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Player player)) return false;
        return Objects.equals(symbol, player.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(symbol);
    }

    public Move decideMove(Board board) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the row to make a move: ");
        int row = scanner.nextInt();
        System.out.println("Enter the col to make a move: ");
        int col = scanner.nextInt();
        return new Move(this,new Cell(row,col));
    }
}
