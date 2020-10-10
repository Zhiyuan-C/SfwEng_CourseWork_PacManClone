package assignment3815ICT.zhiyuan.game.graphics.display;

import assignment3815ICT.zhiyuan.game.Game;
import assignment3815ICT.zhiyuan.game.GameHandler;
import org.junit.Test;

import java.awt.image.BufferedImage;

import static org.junit.Assert.*;

public class AnimationTest {

    @Test
    public void update() {
        Game game = new Game("testing", 100, 100);
        GameHandler gameHandler = new GameHandler(game);
        BufferedImage[] bufferedImages = new BufferedImage[2];
        bufferedImages[0] = gameHandler.getPlayerObjects().get(1);
        bufferedImages[1] = gameHandler.getPlayerObjects().get(2);
        Animation animation = new Animation(bufferedImages, 500);
        animation.update();
        assertEquals(animation.getIndex(), 0);

    }
}