
import java.util.Random;
import java.util.Scanner;

public class Procedural {
    static final int X = 3, Y = 3;
    static final char[][]gameField = new char[X][Y];
    static final char PLAYERS_SYMBOL = 'X';
    static final char AI_SYMBOL = '0';
    static final char EMPTY_SYMBOL = '*';
    static final int WIN = 3;
    static Scanner input = new Scanner(System.in);
    static Random random = new Random();


    static void initGameField(){
        System.out.println();
        for (int i = 0; i < X; i++){
            for (int j = 0; j < Y; j++){
                gameField[i][j] = EMPTY_SYMBOL;
            }
        }
    }

    static void printGameField(){
        System.out.println();
        for (int i = 0; i < X; i++){
            for (int j = 0; j < Y; j++){
                System.out.print(gameField[i][j]);
                if (j != Y-1){
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i != X-1){
                System.out.println("----------");
            }
        }
    }

    static boolean checkIsMoveValid(int x, int y){
        if (x < 0 || x >= X || y < 0 || y >= Y)
            return false;
        if (gameField[x][y] != EMPTY_SYMBOL)
            return false;
        return true;
    }

    static void playersMove(){
        System.out.println("\nYour move:");
        int x, y;
        do {
            x = (input.nextInt() - 1);
            y = (input.nextInt() - 1);
        }while (!checkIsMoveValid(x,y));
        gameField[x][y] = PLAYERS_SYMBOL;
    }

    static void aiMove(){
        int x, y;
        do {
            x = random.nextInt(X);
            y = random.nextInt(Y);
        }while(!checkIsMoveValid(x,y));
        gameField[x][y] = AI_SYMBOL;
    }

    static boolean isFreeSpace() {
        for (int i = 0; i < X; i++){
            for (int j = 0; j < Y; j++){
                if (gameField[i][j] == EMPTY_SYMBOL) return false;}
        }return true;
    }

    static boolean checkWinner(char symbol){
        // FOR ROWS
        for (int i = 0; i < X; i++){
            int result = 0;
            for (int j = 0; j < Y; j++){
                if (gameField[i][j] == symbol){
                    result++;
                }if (result == WIN){
                    return true;
                }
            }
        }
        // FOR COLUMNS
        for (int i = 0; i < X; i++){
            int result = 0;
            for (int j = 0; j < Y; j++){
                if (gameField[j][i] == symbol){
                    result++;
                }if (result == WIN){
                    return true;
                }
            }
        }
        // DIAGONAL LEFT
        int diagonalLeft = 0;
        for (int i = 0; i < X; i++){
            for (int j = 0; j < Y; j++){
                if (i == j && gameField[i][j] == symbol){
                    diagonalLeft++;
                }
            }if (diagonalLeft == WIN){
                return true;
            }
        }
        // DIAGONAL RIGHT
        int diagonalRight = 0;
        for (int i = 0, j = Y-1; i < X && j >= 0; i++, j--){
            if (gameField[i][j] == symbol){
                diagonalRight++;
            }
        }if (diagonalRight == WIN){
            return true;
        }
        return false;
    }

    static void intro(){
        StringBuilder strBuild = new StringBuilder();
        strBuild.append("\n* Hello! Let's play the game 'Tic Tac Toe'! :)").append("\n* Your symbol as a player" +
                " is 'X'. And the computer moves with '0'");
        System.out.println(strBuild);

    }

    static void theGame(){
        while (true){
            playersMove();
            printGameField();
            if (checkWinner(PLAYERS_SYMBOL)){
                System.out.println("\nYou win! :)");
                break;
            }if (isFreeSpace()){
                System.out.println("\nIt's a tie! ;)");
                break;
            }
            aiMove();
            System.out.println();
            System.out.println("The computer moves...");
            printGameField();
            if (checkWinner(AI_SYMBOL)){
                System.out.println("\nYou lost! :(");
                break;
            }if (isFreeSpace()){
                System.out.println("\nIt's a tie! ;)");
                break;
            }
        }
    }

    static void playAgain(){
        Scanner playAgainScan = new Scanner(System.in);
        System.out.println("\nDo you want to play again? ('yes' or 'no')");
        String playAgainString = playAgainScan.nextLine() ;
        if (playAgainString.equals("yes")){
            theGame();
            playAgain();
        }if (playAgainString.equals("no")){
            System.out.println("\nGoodbye! ;)");
            return;
        }else {
            System.err.println("Wrong!");
            playAgain();
        }
    }

    public static void main(String[] args) {
        intro();
        initGameField();
        printGameField();
        theGame();
        playAgain();
    }
}
