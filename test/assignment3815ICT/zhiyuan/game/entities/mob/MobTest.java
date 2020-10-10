package assignment3815ICT.zhiyuan.game.entities.mob;

import assignment3815ICT.zhiyuan.game.Game;
import assignment3815ICT.zhiyuan.game.GameHandler;
import org.junit.Test;

import static org.junit.Assert.*;

public class MobTest {

    @Test
    public void isCrossing() {
        Game game = new Game("123", 10 , 10);
        GameHandler gameHandler = new GameHandler(game);
        PacMan pacMan = new PacMan(gameHandler);
        // return true when over width
        assertTrue(pacMan.isCrossing(11));
        // return false when less than the width
        assertFalse(pacMan.isCrossing(9));
    }
}