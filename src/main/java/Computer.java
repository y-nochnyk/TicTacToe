import java.util.Random;

public class Computer extends Player {

    // Implementation of the Player class method 'move()' for its instance Computer
    // The method puts 2 random coordinates in range of 1-3 into the game field
    @Override
    void move(Game game) throws InterruptedException, TicTacToeException {
        Random random = new Random();
        game.printComputerMoveMessage();
        int x, y;
        do {
            x = random.nextInt(Game.ROW);
            y = random.nextInt(Game.COLUMN);
        }while(!game.checkIsMoveValid(x,y));
        Game.gameField[x][y] = Game.O_SYMBOL;
    }
}
