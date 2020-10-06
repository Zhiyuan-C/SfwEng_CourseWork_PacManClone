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
    protected int direction = 0;// 1 for up, 2 for down, 3 for left, 4 for right
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

    public void move() {
        if(direction == 1 && centerY!=destinationY) yPos -= 1;
        if(direction == 4 && centerX!=destinationX) xPos += 1;
    }

    public boolean isMovable(){
        if(direction == 1) {
            // move up, get current tile
            int currentTileX = (int)centerX / gameHandler.getTILE_WIDTH();
            int currentTileY = centerY / gameHandler.getTILE_HEIGHT();
            int newTileY = (int)(centerY / gameHandler.getTILE_HEIGHT()) - 1;
            System.out.println("currentTileX: " + currentTileX + " currentTileY: " + currentTileY +" newTileY " + newTileY);
            boolean movable = gameHandler.getMap().getTile(currentTileX, newTileY).isMovable();
            if(movable) {
                // get destination point
                destinationX = (int) currentTileX * gameHandler.getTILE_WIDTH() + width / 2;
                destinationY = (int) newTileY * gameHandler.getTILE_HEIGHT() + height / 2;
                System.out.println("centerX: " + centerX + " centerY: " + centerY);
                System.out.println("NEW destinationX: " + destinationX + " NEW destinationY: " + destinationY);
                return true;
            }
        }else if(direction == 4) {
            // move up, get current tile
            int currentTileX = (int)centerX / gameHandler.getTILE_WIDTH();
            int currentTileY = centerY / gameHandler.getTILE_HEIGHT();
            int newTileX = (int)currentTileX + 1;
            System.out.println("currentTileX: " + currentTileX + " currentTileY: " + currentTileY +" newTileX " + newTileX);
            boolean movable = gameHandler.getMap().getTile(newTileX, currentTileY).isMovable();
            if(movable) {
                // get destination point
                destinationX = (int) newTileX * gameHandler.getTILE_WIDTH() + width / 2;
                destinationY = (int) currentTileY * gameHandler.getTILE_HEIGHT() + height / 2;
                System.out.println("centerX: " + centerX + " centerY: " + centerY);
                System.out.println("destinationX: " + destinationX + " destinationY: " + destinationY);
                return true;
            }
        }
        return false;
    }

//    /**
//     *
//     */
//    public boolean canMoveHorizontal(float delta, int length) {
//        collisionDetection.setStaticPoint(yPos, collisionBox.y, collisionBox.height, gameHandler.getTILE_HEIGHT());
//        collisionDetection.setOriginalPoint(xPos);
//        collisionDetection.setNewPoint(delta, collisionBox.x, length, gameHandler.getTILE_WIDTH());
//        if(!collisionDetection.isCollideSG(true)) {
//            // check if the object is moving over the screen width
//            if(delta > 0) {
//                if(isCrossing((int)(xPos + delta))) {
//                    xPos = 0;
//                }
//            } else {
//                if(isCrossing((int)(xPos - delta))) {
//                    xPos = gameHandler.getGameWidth();
//                }
//            }
//            return true;
//        }
//        else {
//            xPos = collisionDetection.getOriginalPoint();
////            direction = 0;
//            return false;
//        }
//    }
//
//    public boolean canMoveVertical(float delta, int length) {
//        collisionDetection.setStaticPoint(xPos, collisionBox.x, collisionBox.width, gameHandler.getTILE_WIDTH());
//        collisionDetection.setOriginalPoint(yPos);
//        collisionDetection.setNewPoint(delta, collisionBox.y, length, gameHandler.getTILE_HEIGHT());
//        if(!collisionDetection.isCollideSG(false)) {
//            return true;
//        } else {
//            yPos = collisionDetection.getOriginalPoint();
////            direction = 0;
//            return false;
//        }
//    }

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
