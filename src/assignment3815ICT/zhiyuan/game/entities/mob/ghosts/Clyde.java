package assignment3815ICT.zhiyuan.game.entities.mob.ghosts;

import assignment3815ICT.zhiyuan.game.GameHandler;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Clyde extends Ghost{
    private ArrayList<BufferedImage> clydeImages;
    public Clyde(GameHandler gameHandler, float xPos, float yPos) {
        super(gameHandler, xPos, yPos);
        clydeImages = getIndividualImages(5);
        setAnimationFrame(clydeImages);
    }



    @Override
    public void update() {
        frightenedMode();
    }

    @Override
    public void setTargetPosition() {

    }

}
