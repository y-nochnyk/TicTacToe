import java.util.Scanner;

public class Human extends Player {
    @Override
    void move(Game game) throws TicTacToeException {
        Scanner input = new Scanner(System.in);
        game.printPlayersMoveMessage();
        int x, y;
        do {
            x = (input.nextInt() - 1);
            y = (input.nextInt() - 1);
        }while (!game.checkIsMoveValid(x,y));
        if (!game.checkIsMoveValid(x,y));
        Game.gameField[x][y] = Game.X_SYMBOL;
    }

    void moveWithO(Game game) throws TicTacToeException{
        Scanner input = new Scanner(System.in);
        game.printPlayersMoveMessage();
        int x, y;
        do {
            x = (input.nextInt() - 1);
            y = (input.nextInt() - 1);
        }while (!game.checkIsMoveValid(x,y));
        if (!game.checkIsMoveValid(x,y));
        Game.gameField[x][y] = Game.O_SYMBOL;
    }
}
