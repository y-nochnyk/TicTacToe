import java.util.Scanner;

/** This is the project of a simple game Tic-Tac-Toe.
 *  Created using Java SE, designed by SOLID principles.
 *  Made by Yaroslav Nochnyk.
 *  https://github.com/y-nochnyk
 */

public class Application {
    public static void main(String[] args) throws Exception {

        Human human1 = new Human();
        Human human2 = new Human();
        Computer computer = new Computer();
        Game.intro();
        Game.initGameField();
        Game.selectGameTypeInfo();
        Scanner gameTypeScan = new Scanner(System.in);

        int gameType = gameTypeScan.nextInt();

        // The game cycle if it's 'Human-Computer' game type
        if (Game.getGameType(gameType) == 1)
            while (true){
                human1.move();
                Game.printGameField();
                if (Game.checkWinner(Game.X_SYMBOL)){
                    System.out.println("\nYou win! :)");
                    return;
                }if (Game.isFreeSpace()){
                    System.out.println("\nIt's a tie!");
                    return;
                }
                computer.move();
                Game.printGameField();
                if (Game.checkWinner(Game.O_SYMBOL)){
                    System.out.println("\nYou lost! :(");
                    return;
                }if (Game.isFreeSpace()){
                    System.out.println("\nIt's a tie!");
                    return;
                }
            }

        // The game cycle if it's 'Human-Human' game type
        if (Game.getGameType(gameType) == 2)
            while (true){
                human1.move();
                Game.printGameField();
                if (Game.checkWinner(Game.X_SYMBOL)){
                    System.out.println("\nPlayer 1 win! :)");
                    return;
                }if (Game.isFreeSpace()){
                    System.out.println("\nIt's a tie!");
                    return;
                }
                human2.moveWithO();
                Game.printGameField();
                if (Game.checkWinner(Game.O_SYMBOL)){
                    System.out.println("\nPlayer 2 win! :)");
                    return;
                }if (Game.isFreeSpace()){
                    System.out.println("\nIt's a tie!");
                    return;
                }
            }
    }
}
