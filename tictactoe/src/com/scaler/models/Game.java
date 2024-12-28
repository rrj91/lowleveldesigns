package com.scaler.models;

import com.scaler.exceptions.InvalidGameDimensionException;
import com.scaler.exceptions.InvalidMoveException;
import com.scaler.exceptions.InvalidPlayerSizeException;
import com.scaler.strategies.GameWinningStrategy;
import com.scaler.strategies.impl.ColWinningStrategy;
import com.scaler.strategies.impl.DiaWinningStrategy;
import com.scaler.strategies.impl.RowWinningStrategy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameStatus gameStatus;
    private int nextPlayerIndex;

    private List<GameWinningStrategy> gameWinningStrategies;

    public Player getWinningPlayer() {
        return winningPlayer;
    }

    public void setWinningPlayer(Player winningPlayer) {
        this.winningPlayer = winningPlayer;
    }

    private Player winningPlayer;

    public Game(int dimension,List<Player> players) {
        this.board = new Board(dimension);
        this.players = players;
        this.moves = new LinkedList<>();
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.nextPlayerIndex =0;
        this.gameWinningStrategies = new ArrayList<>();
        this.gameWinningStrategies.add(new RowWinningStrategy(board.getSize()));
        this.gameWinningStrategies.add(new ColWinningStrategy(board.getSize()));
        this.gameWinningStrategies.add(new DiaWinningStrategy());
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    public List<GameWinningStrategy> getGameWinningStrategies() {
        return gameWinningStrategies;
    }

    public void setGameWinningStrategies(List<GameWinningStrategy> gameWinningStrategies) {
        this.gameWinningStrategies = gameWinningStrategies;
    }

    public void makeNextMove() throws InvalidMoveException {
        Player playerWhosMoveItIs = players.get(nextPlayerIndex);
        System.out.println("It is "+playerWhosMoveItIs.getName()+"'s turn!");
        Move move = playerWhosMoveItIs.decideMove(board);
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        if(row >= board.getSize() || col >= board.getSize() && !(board.getCells().get(row).get(col).getCellState() == CellState.EMPTY)){
            throw new InvalidMoveException("The cell is not empty!");
        }
        board.applyMove(move);
        moves.add(move);
        //check winner
        for(GameWinningStrategy gameWinningStrategy: this.getGameWinningStrategies()){
            if(gameWinningStrategy.checkWinner(board,move)){
                setGameStatus(GameStatus.ENDED);
                setWinningPlayer(playerWhosMoveItIs);
                break;
            }
        }
        if(moves.size() == board.getSize()*board.getSize()){
            setGameStatus(GameStatus.DRAW);
            return;
        }
        nextPlayerIndex += 1;
        nextPlayerIndex %= players.size();
    }

    public static class Builder{
        private int dimension;
        private List<Player> players;
        public Builder setDimension(int dimension){
            this.dimension = dimension;
            return this;
        }
        public Builder setPlayers(List<Player> players){
            this.players = players;
            return this;
        }
        public Game build(){
           try{
               isValid();
           }catch (InvalidGameDimensionException | InvalidPlayerSizeException e){
                return null;
           }

           return new Game(dimension,players);
        }

        private void isValid() throws InvalidGameDimensionException, InvalidPlayerSizeException {
            if(dimension<3){
                throw new InvalidGameDimensionException("Dimension cannot be less than 3");
            }
            if(players.size() < 2 || players.size() > dimension){
                throw new InvalidPlayerSizeException("Players should not be less than 2 or greater than dimension");
            }
        }
    }
}
