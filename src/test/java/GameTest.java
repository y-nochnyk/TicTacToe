import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

//    private Game game;
//    @Before
//    public void setUp() throws Exception {
//
//    }


//    @After
//    public void tearDown() throws Exception {
//    }

    @Test(expected = TicTacToeException.class)
    public void getGameType() throws TicTacToeException {
        int expected = 2;
        assertEquals(expected, Game.getGameType(2));
        Game.getGameType(3);

    }

    @Test
    public void initGameField() {

        Game.initGameField();

        char expected = '*';
        assertEquals(expected, Game.getGameField()[1][1]);
    }


    @Test(expected = TicTacToeException.class)
    public void checkIsMoveValid() throws TicTacToeException {

        assertFalse(Game.checkIsMoveValid(2,2));
        Game.initGameField();
        assertTrue(Game.checkIsMoveValid(0,0));
        Game.checkIsMoveValid(3,2);
    }


    @Test
    public void isFreeSpace() {
        Game.initGameField();

        assertFalse(Game.isFreeSpace());
    }

    @Test
    public void checkWinner() {
    }
}