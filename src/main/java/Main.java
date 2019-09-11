/** This is the project of a simple game Tic-Tac-Toe.
 *  Created using Java SE, designed by SOLID principles.
 *  Made by Yaroslav Nochnyk.
 *  https://github.com/y-nochnyk
 */

public class Main {
    public static void main(String[] args) throws Exception {
        Game game = new Game();
        Human human1 = new Human();
        Human human2 = new Human();
        Computer computer = new Computer();
        game.intro();
        game.selectGameType();
        game.initGameField();

        // The game cycle if it's 'Human-Computer' game type
        if (game.getGameType() == 1)
            while (true){
                human1.move(game);
                game.printGameField();
                if (game.checkWinner(Game.X_SYMBOL)){
                    System.out.println("\nYou win! :)");
                    return;
                }if (game.isFreeSpace()){
                    System.out.println("\nIt's a tie!");
                    return;
                }
                computer.move(game);
                game.printGameField();
                if (game.checkWinner(Game.O_SYMBOL)){
                    System.out.println("\nYou lost! :(");
                    return;
                }if (game.isFreeSpace()){
                    System.out.println("\nIt's a tie!");
                    return;
                }
            }

        // The game cycle if it's 'Human-Human' game type
        if (game.getGameType() == 2)
            while (true){
                human1.move(game);
                game.printGameField();
                if (game.checkWinner(Game.X_SYMBOL)){
                    System.out.println("\nPlayer 1 win! :)");
                    return;
                }if (game.isFreeSpace()){
                    System.out.println("\nIt's a tie!");
                    return;
                }
                human2.moveWithO(game);
                game.printGameField();
                if (game.checkWinner(Game.O_SYMBOL)){
                    System.out.println("\nPlayer 2 win! :)");
                    return;
                }if (game.isFreeSpace()){
                    System.out.println("\nIt's a tie!");
                    return;
                }
            }
    }
}
