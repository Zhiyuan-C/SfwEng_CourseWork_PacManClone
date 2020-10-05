package assignment3815ICT.zhiyuan.game.entities.mob.ghosts;

import assignment3815ICT.zhiyuan.game.GameHandler;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Blinky extends Ghost {

    private ArrayList<BufferedImage> blinkyImages;

    public Blinky(GameHandler gameHandler, float xPos, float yPos) {
        super(gameHandler, xPos, yPos);
        blinkyImages = getIndividualImages(0);
        setAnimationFrame(blinkyImages);
    }


    @Override
    public void update() {
        frightenedMode();
    }
}
