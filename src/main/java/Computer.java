import java.util.Random;

class Computer implements Player {

    /**
     * Implementation of the Player class method 'move()' for its instance Computer
     * // The method puts 2 random coordinates in range of 1-3 into the game field
     *
     * @throws InterruptedException,TicTacToeException fuck this
     */
    @Override
    public void move() throws InterruptedException, TicTacToeException {
        Random random = new Random();
        Game.printComputerMoveMessage();
        int x, y;
        do {
            x = random.nextInt(Game.ROW);
            y = random.nextInt(Game.COLUMN);
        } while (!Game.checkIsMoveValid(x, y));
        Game.getGameField()[x][y] = Game.O_SYMBOL;
    }
}
