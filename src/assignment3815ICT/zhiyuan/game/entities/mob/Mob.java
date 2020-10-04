package assignment3815ICT.zhiyuan.game.entities.mob;

import assignment3815ICT.zhiyuan.game.GameHandler;
import assignment3815ICT.zhiyuan.game.entities.Entity;
import assignment3815ICT.zhiyuan.game.graphics.display.Animation;

import java.awt.image.BufferedImage;


public abstract class Mob extends Entity {

    protected Animation animeUp, animeLeft, animeRight, animeDown, animeVanish;
    protected BufferedImage objectLastFrame;

    protected float speed;
    protected float upLeftSpeed, downRightSpeed; // upLeft -> move up or left, downRight -> move down or right
    protected int direction = 0;// 1 for up, 2 for down, 3 for left, 4 for right
//    protected boolean isMoving = false;
    protected int currentScore;
    protected int lastScore;
    protected boolean isAlive;
    protected float defaultXpos, defaultYpos;

    public Mob(GameHandler gameHandler, float xPos, float yPos, int width, int height) {
        super(gameHandler, xPos, yPos, width, height);
    }


    /**
     *
     * @return
     */
    public BufferedImage getCurrentObjectFrame() {
        if(isAlive) {
            if(direction == 1) {
                objectLastFrame = animeUp.getCurrentObjectFrame();
                return objectLastFrame;
            } else if (direction == 2) {
                objectLastFrame = animeDown.getCurrentObjectFrame();
                return objectLastFrame;
            } else if (direction == 3) {
                objectLastFrame = animeLeft.getCurrentObjectFrame();
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
     */
    public boolean canMoveHorizontal(int delta, int length, float speed) {
        collisionDetection.setStaticPoint(yPos, collisionBox.y, collisionBox.height, gameHandler.getTILE_HEIGHT());
        collisionDetection.setOriginalPoint(xPos);
        collisionDetection.setNewPoint(delta, collisionBox.x, length, gameHandler.getTILE_WIDTH());
        if(!collisionDetection.isCollideSG(true)) {
            // check if the object is moving over the screen width
            if(delta > 0) {
                if(isCrossing((int)(xPos + delta))) {
                    xPos = 0;
                }
            } else {
                if(isCrossing((int)(xPos - delta))) {
                    xPos = gameHandler.getGameWidth();
                }
            }
            xPos += speed;
            return true;
        }
        else {
            xPos = collisionDetection.getOriginalPoint();
            direction = 0;
            return false;
        }
    }

    public boolean canMoveVertical(int delta, int length, float speed) {
        collisionDetection.setStaticPoint(xPos, collisionBox.x, collisionBox.width, gameHandler.getTILE_WIDTH());
        collisionDetection.setOriginalPoint(yPos);
        collisionDetection.setNewPoint(delta, collisionBox.y, length, gameHandler.getTILE_HEIGHT());
        if(!collisionDetection.isCollideSG(false)) {
            yPos += speed;
            return true;
        } else {
            yPos = collisionDetection.getOriginalPoint();
            direction = 0;
            return false;
        }
    }

    /**
     *
     * @param x
     * @return boolean
     */
    private boolean isCrossing(int x) {
        // x and y in pixel measure
        if (x < 0 || x > gameHandler.getGameWidth()) {
            return true;
        }
        return false;
    }

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
}
