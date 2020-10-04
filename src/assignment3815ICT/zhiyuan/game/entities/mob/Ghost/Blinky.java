package assignment3815ICT.zhiyuan.game.entities.mob.Ghost;

import assignment3815ICT.zhiyuan.game.GameHandler;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Blinky extends Ghost {

    private ArrayList<BufferedImage> blinkyImages;

    public Blinky(GameHandler gameHandler, float xPos, float yPos) {
        super(gameHandler, xPos, yPos);
        init();
    }

    private void init() {
        blinkyImages = getIndividualImages(0);
        BufferedImage[] left = getObjectFrames(blinkyImages, 1, 0);
        BufferedImage[] right = getObjectFrames(blinkyImages, 2, 0);
        BufferedImage[] up = getObjectFrames(blinkyImages, 3, 0);
        BufferedImage[] down = getObjectFrames(blinkyImages, 4, 0);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(blinkyImages.get(1), (int) xPos, (int) yPos, width, height, null);
    }
}
