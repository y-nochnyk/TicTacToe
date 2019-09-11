import java.util.Scanner;

public class Game {

    // Static variables to be used in the Game methods
    protected static final int ROW = 3, COLUMN = 3;
    protected static final char[][]gameField = new char[ROW][COLUMN];
    protected static final char X_SYMBOL = 'X';
    protected static final char O_SYMBOL = '0';
    protected static final char EMPTY_SYMBOL = '*';
    protected static final int WIN = 3;
    protected static int gameType;
    protected static String spaces = "            ";

    // The method which displays 'hello' message to the screen
    protected void intro(){
        System.out.println("\nHello! Let's play the game 'Tic Tac Toe'! :)");

    }

    // The method which takes input '1' or '2' numbers via Scanner specifying what game type 'Human-Computer'
    // or 'Human-Human' you want to choose
    protected int selectGameType(){
        StringBuilder strbld = new StringBuilder();
        strbld.append("\nSelect game type:").append("\n1: Human vs Computer").append("\n2: Human vs Human");
        System.out.println(strbld);
        Scanner gameTypeScan = new Scanner(System.in);
        int selectedGameType = gameTypeScan.nextInt();
        return gameType = selectedGameType;
    }

    // The method which returns 'gameType' variable
    public static int getGameType() throws TicTacToeException {
        if (gameType == 1 || gameType == 2) {
            return gameType;
        }
        else throw new TicTacToeException("Only '1' or '2' numbers are allowed!");
    }

    // Game field initializer. By default the field is fulled by '*'
    protected void initGameField(){
        System.out.println();
        for (int i = 0; i < ROW; i++){
            for (int j = 0; j < COLUMN; j++){
                gameField[i][j] = EMPTY_SYMBOL;
            }
        }
    }

    // The method which prints player's ('X' or '0') symbol and separating lines to the game field
    protected void printGameField(){
        System.out.println();
        for (int i = 0; i < ROW; i++){
            System.out.print(spaces);
            for (int j = 0; j < COLUMN; j++){
                System.out.print(gameField[i][j]);
                if (j != COLUMN-1){
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i != ROW-1){
                System.out.print(spaces);
                System.out.println("---------");
            }
        }
        System.out.println();
    }

    // The method which checks if player's move is valid
    boolean checkIsMoveValid(int x, int y) throws TicTacToeException {
        if (x < 0 || x >= ROW || y < 0 || y >= COLUMN) throw new TicTacToeException("Only numbers in range of 1-3 are allowed!");
        if (gameField[x][y] != EMPTY_SYMBOL)
            return false;
        return true;
    }

    // The method which displays explanation how player should make his move
    protected void printPlayersMoveMessage(){
        System.out.println("Chose the cell you want to move in.\nType the number in range of 1-3 for each of two coordinates");
    }

    // The method which displays info about the computer move
    protected void printComputerMoveMessage() throws InterruptedException {
        System.out.println("\nComputer moves...");
        Thread.sleep(1500);
    }

    // The method which checks if there's a free space in the game field
    protected boolean isFreeSpace() {
        for (int i = 0; i < ROW; i++){
            for (int j = 0; j < COLUMN; j++){
                if (gameField[i][j] == EMPTY_SYMBOL) return false;}
        }return true;
    }

    // The method which returns 'true' if there's one row, column or diagonal full by player's symbols in number of 3
    // Number 3 is specified by the static final variable 'WIN'
    protected boolean checkWinner(char symbol){

        // Returns 'true' if there's one row of the game field full by player's symbols
        for (int i = 0; i < Game.ROW; i++){
            int result = 0;
            for (int j = 0; j < Game.COLUMN; j++){
                if (gameField[i][j] == symbol){
                    result++;
                }if (result == WIN){
                    return true;
                }
            }
        }
        // Returns 'true' if there's one column of the game field full by player's symbols
        for (int i = 0; i < Game.ROW; i++){
            int result = 0;
            for (int j = 0; j < Game.COLUMN; j++){
                if (gameField[j][i] == symbol){
                    result++;
                }if (result == WIN){
                    return true;
                }
            }
        }
        // Returns 'true' if there's a left diagonal (1,1-2,2-3,3) of the game field full by player's symbols
        int diagonalLeft = 0;
        for (int i = 0; i < Game.ROW; i++){
            for (int j = 0; j < Game.COLUMN; j++){
                if (i == j && gameField[i][j] == symbol){
                    diagonalLeft++;
                }
            }if (diagonalLeft == WIN){
                return true;
            }
        }
        // Returns 'true' if there's a right diagonal (1,3-2,2-3,1) of the game field full by player's symbols
        int diagonalRight = 0;
        for (int i = 0, j = Game.COLUMN-1; i < Game.ROW && j >= 0; i++, j--){
            if (gameField[i][j] == symbol){
                diagonalRight++;
            }
        }if (diagonalRight == WIN){
            return true;
        }
        return false;
    }
}
