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
        setAnimationFrame(blinkyImages);
    }

    @Override
    public void update() {
        int timePassed = 0;
        if(frightenedMode) {
            timePassed = (int) ((System.currentTimeMillis() - startTimeFrightened) / 1000);
        }
        if (timePassed > 5) {
            // five sec, change later
            frightenedMode = false;
        }


    }

    @Override
    public void render(Graphics graphics) {
        if(frightenedMode) {
            graphics.drawImage(ghostImages.get(20), (int) xPos, (int) yPos, width, height, null);
        } else {
            graphics.drawImage(getCurrentObjectFrame(), (int) xPos, (int) yPos, width, height, null);
        }

    }
}
