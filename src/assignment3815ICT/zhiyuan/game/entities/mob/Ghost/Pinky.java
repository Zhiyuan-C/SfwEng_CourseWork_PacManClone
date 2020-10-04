package assignment3815ICT.zhiyuan.game.entities.mob.Ghost;

import assignment3815ICT.zhiyuan.game.GameHandler;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Pinky extends Ghost{

    private ArrayList<BufferedImage> pinkyImages;

    public Pinky(GameHandler gameHandler, float xPos, float yPos) {
        super(gameHandler, xPos, yPos);
        pinkyImages = getIndividualImages(10);
        setAnimationFrame(pinkyImages);
    }

    @Override
    public void update() {
        frightenedMode();
    }
}
