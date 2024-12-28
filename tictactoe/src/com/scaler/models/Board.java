package com.scaler.models;


import java.util.LinkedList;
import java.util.List;

public class Board {
    private int size;
    private List<List<Cell>> cells;

    public Board(int size) {
        this.size = size;
        this.cells = new LinkedList<>();
        for(int i=0;i<size;i++){
            this.cells.add(new LinkedList<>());
            for (int j=0;j<size;j++){
                this.cells.get(i).add(new Cell(i,j));
            }
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Cell>> getCells() {
        return cells;
    }

    public void setCells(List<List<Cell>> cells) {
        this.cells = cells;
    }

    public void displayBoard(){
        for(List<Cell> columns: cells){
            for(Cell col: columns){
                if(col.getCellState() == CellState.EMPTY){
                    System.out.print("| |");
                }else {
                    System.out.print("|"+col.getPlayer().getSymbol()+"|");
                }
            }
            System.out.println();
        }
    }

    public void applyMove(Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        this.getCells().get(row).get(col).setCellState(CellState.FILLED);
        this.getCells().get(row).get(col).setPlayer(move.getPlayer());
    }
}
