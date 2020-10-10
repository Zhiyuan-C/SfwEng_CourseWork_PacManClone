package assignment3815ICT.zhiyuan.game.entities.mob;

import assignment3815ICT.zhiyuan.game.GameHandler;
import assignment3815ICT.zhiyuan.game.entities.Entity;
import assignment3815ICT.zhiyuan.game.graphics.display.Animation;

import java.awt.image.BufferedImage;


public abstract class Mob extends Entity {
    // position
    protected float defaultXpos, defaultYpos;
    // animation
    protected Animation animeUp, animeLeft, animeRight, animeDown, animeVanish;
    protected BufferedImage objectLastFrame;
    // moving
    protected float speed;
    protected int direction = 0;// 1 for up, 2 for left, 3 for down, 4 for right
    protected int centerX, centerY;
    protected int destinationX, destinationY;
    protected boolean isMovable;

    // health and life
    protected boolean isAlive;
    protected boolean isResurrect;
    protected long timeDied = 0;
    protected long timeResurrect = 0;


    public Mob(GameHandler gameHandler, float xPos, float yPos, int width, int height) {
        super(gameHandler, xPos, yPos, width, height);
    }


    /**
     *
     * @return
     */
    public BufferedImage getCurrentObjectFrame() {
        if(isAlive) {
            // 1 - up, 2 - left, 3 - down, 4 - right
            if(direction == 1) {
                objectLastFrame = animeUp.getCurrentObjectFrame();
                return objectLastFrame;
            } else if (direction == 2) {
                objectLastFrame = animeLeft.getCurrentObjectFrame();
                return objectLastFrame;
            } else if (direction == 3) {
                objectLastFrame = animeDown.getCurrentObjectFrame();
                return objectLastFrame;
            } else if (direction == 4) {
                objectLastFrame = animeRight.getCurrentObjectFrame();
                return objectLastFrame;
            } else {
                return objectLastFrame;
            }
        } else {
            objectLastFrame = animeVanish.getCurrentObjectFrame();
            return objectLastFrame;
        }

    }


    /**
     *
     * @param x
     * @return boolean
     */
    protected boolean isCrossing(int x) {
        // x and y in pixel measure
        if (x < 0 || x > gameHandler.getGameWidth()) {
            return true;
        }
        return false;
    }

    // getters and setters

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public float getDefaultXpos() {
        return defaultXpos;
    }

    public void setDefaultXpos(float defaultXpos) {
        this.defaultXpos = defaultXpos;
    }

    public float getDefaultYpos() {
        return defaultYpos;
    }

    public void setDefaultYpos(float defaultYpos) {
        this.defaultYpos = defaultYpos;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getCurrentDirection() {
        return direction;
    }
}
