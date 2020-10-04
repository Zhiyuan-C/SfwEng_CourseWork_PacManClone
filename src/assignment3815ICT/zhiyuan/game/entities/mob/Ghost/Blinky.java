package assignment3815ICT.zhiyuan.game.entities.mob.Ghost;

import assignment3815ICT.zhiyuan.game.GameHandler;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Blinky extends Ghost {

    private BufferedImage[] blinkyImages;

    public Blinky(GameHandler gameHandler, float xPos, float yPos, int width, int height) {
        super(gameHandler, xPos, yPos, width, height);
        init();
    }

    private void init() {
//        blinkyImages = gameHandler.getGameObject().getObjectFrames(ghostImages, )
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics graphics) {

    }
}
