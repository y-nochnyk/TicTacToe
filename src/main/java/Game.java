import java.util.Scanner;

public class Game {
    protected static final int ROW = 3, COLUMN = 3;
    protected static final char[][]gameField = new char[ROW][COLUMN];
    protected static final char X_SYMBOL = 'X';
    protected static final char O_SYMBOL = '0';
    protected static final char EMPTY_SYMBOL = '*';
    protected static final int WIN = 3;
    protected static int gameType;
    protected static String spaces = "            ";

    protected void intro(){
        System.out.println("\nHello! Let's play the game 'Tic Tac Toe'! :)");

    }

    protected int selectGameType(){
        StringBuilder strbld = new StringBuilder();
        strbld.append("\nSelect game type:").append("\n1: Human vs Computer").append("\n2: Human vs Human");
        System.out.println(strbld);
        Scanner gameTypeScan = new Scanner(System.in);
        int selectedGameType = gameTypeScan.nextInt();
        return gameType = selectedGameType;
    }

    public static int getGameType() throws TicTacToeException {
        if (gameType == 1 || gameType == 2) {
            return gameType;
        }
        else throw new TicTacToeException("Only '1' or '2' numbers are allowed!");
    }

    protected void initGameField(){
        System.out.println();
        for (int i = 0; i < ROW; i++){
            for (int j = 0; j < COLUMN; j++){
                gameField[i][j] = EMPTY_SYMBOL;
            }
        }
    }

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

    boolean checkIsMoveValid(int x, int y) throws TicTacToeException {
        if (x < 0 || x >= ROW || y < 0 || y >= COLUMN) throw new TicTacToeException("Only numbers in range of 1-3 are allowed!");
        if (gameField[x][y] != EMPTY_SYMBOL)
            return false;
        return true;
    }

    protected void printPlayersMoveMessage(){
        System.out.println("Chose your cell:");
    }

    protected void printComputerMoveMessage() throws InterruptedException {
        System.out.println("\nComputer moves...");
        Thread.sleep(1500);
    }

    protected boolean isFreeSpace() {
        for (int i = 0; i < ROW; i++){
            for (int j = 0; j < COLUMN; j++){
                if (gameField[i][j] == EMPTY_SYMBOL) return false;}
        }return true;
    }

    protected boolean checkWinner(char symbol){

        // FOR ROWS
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
        // FOR COLUMNS
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
        // DIAGONAL LEFT
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
        // DIAGONAL RIGHT
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
