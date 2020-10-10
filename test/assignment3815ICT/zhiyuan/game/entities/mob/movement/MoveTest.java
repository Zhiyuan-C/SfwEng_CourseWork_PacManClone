package assignment3815ICT.zhiyuan.game.entities.mob.movement;

import assignment3815ICT.zhiyuan.game.Game;
import assignment3815ICT.zhiyuan.game.GameHandler;
import assignment3815ICT.zhiyuan.game.entities.mob.ghosts.Blinky;
import org.junit.Test;

import static org.junit.Assert.*;

public class MoveTest {
    private Game game = new Game ("testing", 100, 100);
    private GameHandler gameHandler = new GameHandler(game);
    private Blinky blinky = new Blinky(gameHandler, 50, 50);
    private MoveUp moveUp = new MoveUp(blinky, 40, 23, 32, 32);
    private MoveDown moveDown = new MoveDown(blinky, 40, 23, 32, 32);

    @Test
    public void checkDistance() {
        moveUp.newPosX = 0;
        moveUp.newPosY = 3;
        // sqrt((3 - 0) ^ 2 + (0 - 3) ^ 2) = sqrt(3^2 + 3^2) = sqrt(18) = 4.24.... (int) => 4
        moveUp.checkDistance(3, 0);
        assertEquals(moveUp.distance, 4);
    }

    @Test
    public void changeMove() {
        moveUp.distance = 10;
        moveDown.distance = 9;
        moveDown.movable = true;
        moveUp.movable = true;
        assertTrue(moveUp.changeMove(moveDown));
    }
}