import java.util.Scanner;

class Human implements Player {

    // Implementation of the Player class method 'move()' for its instance Human if there's a game type 'Human-Computer'
    // Method takes 2 input coordinates and puts it to the game field
    @Override
   public void move() throws TicTacToeException {
        Scanner input = new Scanner(System.in);
        Game.printPlayersMoveMessage();
        int x, y;
        do {
            x = (input.nextInt() - 1);
            y = (input.nextInt() - 1);
        } while (!Game.checkIsMoveValid(x, y));
//        if (!game.checkIsMoveValid(x,y));
        Game.getGameField()[x][y] = Game.X_SYMBOL;
    }

    // Special implementation of the Player class method 'move()' for Human if there's a game type 'Human-Human'
    // The method takes 2 input coordinates and puts it to the game field
    void moveWithO() throws TicTacToeException {
        Scanner input = new Scanner(System.in);
        Game.printPlayersMoveMessage();
        int x, y;
        do {
            x = (input.nextInt() - 1);
            y = (input.nextInt() - 1);
        } while (!Game.checkIsMoveValid(x, y));
//        if (!game.checkIsMoveValid(x,y));
        Game.getGameField()[x][y] = Game.O_SYMBOL;
    }
}
