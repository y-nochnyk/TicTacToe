import java.util.Random;

public class Computer extends Player {
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
