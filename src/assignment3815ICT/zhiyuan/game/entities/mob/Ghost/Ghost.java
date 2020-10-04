package assignment3815ICT.zhiyuan.game.entities.mob.Ghost;

import assignment3815ICT.zhiyuan.game.GameHandler;
import assignment3815ICT.zhiyuan.game.entities.mob.Mob;
import assignment3815ICT.zhiyuan.game.graphics.display.Animation;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class Ghost extends Mob {
    protected ArrayList<BufferedImage> ghostImages;
    protected boolean frightenedMode;
    protected long startTimeFrightened;

    public Ghost(GameHandler gameHandler, float xPos, float yPos) {
        super(gameHandler, xPos, yPos, 28, 28);

        this.ghostImages = gameHandler.getGhostObjects();

        // moving speed
        speed = 1.5f;
        // set up collision bounds
        collisionBox.x = 3;
        collisionBox.y = 3;
        collisionBox.width = 22;
        collisionBox.height = 22;
    }

    @Override
    public void render(Graphics graphics) {
        if(frightenedMode) {
            graphics.drawImage(ghostImages.get(20), (int) xPos, (int) yPos, width, height, null);
        } else {
            graphics.drawImage(getCurrentObjectFrame(), (int) xPos, (int) yPos, width, height, null);
        }
    }

    protected BufferedImage[] getObjectFrames(ArrayList<BufferedImage> objects, int startIndex, int endIndex) {
        BufferedImage[] objectFrames = new BufferedImage[2];
        // hard code from here
        objectFrames[0] = objects.get(startIndex);
        objectFrames[1] = objects.get(endIndex);
        return objectFrames;
    }

    protected ArrayList<BufferedImage> getIndividualImages(int startIndex){
        ArrayList<BufferedImage> newImages = new ArrayList<>();
        for (int i = startIndex; i < startIndex + 5; i ++) {
            newImages.add(ghostImages.get(i));
        }
        return newImages;
    }

    public void setAnimationFrame(ArrayList<BufferedImage> objectImages) {
        BufferedImage[] left = getObjectFrames(objectImages, 1, 0);
        BufferedImage[] right = getObjectFrames(objectImages, 2, 0);
        BufferedImage[] up = getObjectFrames(objectImages, 3, 0);
        BufferedImage[] down = getObjectFrames(objectImages, 4, 0);
        this.animeLeft = new Animation(left, 500);
        this.animeUp = new Animation(up, 500);
        this.animeRight = new Animation(right, 500);
        this.animeDown = new Animation(down, 500);
        objectLastFrame = objectImages.get(0);
    }

    public void frightenedMode() {
        int timePassed = 0;
        if(frightenedMode) {
            timePassed = (int) ((System.currentTimeMillis() - startTimeFrightened) / 1000);
        }
        if (timePassed > 5) {
            // five sec, change later
            frightenedMode = false;
        }
    }

    public boolean isFrightenedMode() {
        return frightenedMode;
    }

    public void setFrightenedMode(boolean frightenedMode) {
        this.frightenedMode = frightenedMode;
    }

    public void setStartTimeFrightened(long startTimeFrightened) {
        this.startTimeFrightened = startTimeFrightened;
    }
}
