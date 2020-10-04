package assignment3815ICT.zhiyuan.game.entities.mob.Ghost;

import assignment3815ICT.zhiyuan.game.GameHandler;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Inky extends Ghost {
    private ArrayList<BufferedImage> InkyImages;
    public Inky(GameHandler gameHandler, float xPos, float yPos) {
        super(gameHandler, xPos, yPos);
        InkyImages = getIndividualImages(15);
        setAnimationFrame(InkyImages);
    }

    @Override
    public void update() {
        frightenedMode();

    }
}
