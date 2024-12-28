import com.scaler.controllers.GameController;
import com.scaler.exceptions.InvalidMoveException;
import com.scaler.models.*;
import com.scaler.strategies.GameWinningStrategy;

import java.util.*;
import java.util.random.RandomGenerator;

public class TicTacToeGame {
    public static void main(String[] args) {
        System.out.println("Hello, World! Welcome to TicTacToe");
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the dimension of the game");
        int dimension = scanner.nextInt();
        System.out.println("No of players: ");
        int noOfPlayers = scanner.nextInt();

        List<Player> players = new LinkedList<>();
        System.out.println("Will there be any bit? y/n");
        String isBot = scanner.next();
        if(isBot.equals("y")){
            noOfPlayers = noOfPlayers-1;
            System.out.println("Enter the name of the Bot: ");
            String botName = scanner.next();
            System.out.println("Enter the symbol of the Bot: ");
            String botSymbol = scanner.next();
            System.out.println("Enter the bot difficulty level: 1-Easy, 2-Medium, 3-Hard");
            int difficultyLevel = scanner.nextInt();
            players.add(new Bot(botName,botSymbol, BotDifficultyLevel.EASY));
        }
        for(int i=0;i<noOfPlayers;i++){
            System.out.println("Enter the name of the player: ");
            String botName = scanner.next();
            System.out.println("Enter the symbol of the player: ");
            String botSymbol = scanner.next();
            Player player = new Player(botName,botSymbol, PlayerType.HUMAN);
            players.add(player);
        }
        GameController gameController = new GameController();
        Game game = gameController.createGame(dimension,players);
        System.out.println("Lets start the game!!");
        while(gameController.getGameStatus(game) == GameStatus.IN_PROGRESS){
            //display current board
            gameController.displayBoard(game);
            try {
                gameController.executeNextMove(game);
            }catch (InvalidMoveException e) {
                System.out.println("You have mave invalid move please try again!");
            }
            //Decide player order
            //Collections.shuffle(players);
            //Based on order
                //Take a move from player
                //Evaluate that move
//            for(Player player: players){
//                System.out.println("Player: "+player.getName()+" please make your move(row,col)!");
//                int row = scanner.nextInt();
//                int col = scanner.nextInt();
//                Cell cell = new Cell(row,col);
//                cell.setCellState(CellState.FILLED);
//                cell.setPlayer(player);
//                Move move = new Move();
//                move.setCell(cell);
//                move.setPlayer(player);
//                game.getMoves().add(move);
//                for(GameWinningStrategy gameWinningStrategy: game.getGameWinningStrategies()) {
//                    gameWinningStrategy.evaluate(game);
//                }
//                if(gameController.getGameStatus(game) != GameStatus.IN_PROGRESS){
//                    break;
//                }
//            }
           //System.out.println("Player");

           //break;
        }
        if(gameController.getGameStatus(game) == GameStatus.DRAW){
            System.out.println("Game has drawn");
        }else{
            System.out.println("Game has won by: "+gameController.getWinningName(game));
        }

    }
}