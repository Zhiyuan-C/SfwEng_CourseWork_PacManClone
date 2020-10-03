package assignment3815ICT.zhiyuan.game.entities.mob;

import assignment3815ICT.zhiyuan.game.GameHandler;
import assignment3815ICT.zhiyuan.game.entities.Entity;
import assignment3815ICT.zhiyuan.game.graphics.display.Animation;
import assignment3815ICT.zhiyuan.game.graphics.map.Tile;

import java.awt.image.BufferedImage;
import java.util.ArrayList;


public abstract class Mob extends Entity {

    protected Animation animeUp, animeLeft, animeRight, animeDown;
    protected BufferedImage objectLastFrame;

    protected float speed;
    protected int direction = 0;// 1 for up, 2 for down, 3 for left, 4 for right
//    protected boolean isMoving = false;
    protected int currentScore;
    protected int lastScore;

    public Mob(GameHandler gameHandler, float xPos, float yPos, int width, int height) {
        super(gameHandler, xPos, yPos, width, height);
    }

    /**
     * Return an array of buffered image containing the frames of the object for animation
     *
     * @param objects an arraylist containing object's buffered image retrieved from sprite sheet
     * @param startIndex start index of the object
     * @param length how many objects is required for that animation frame
     * @return BufferedImage[] objects for particular animation frame
     */
    public BufferedImage[] getObjectFrames(ArrayList<BufferedImage> objects, int startIndex, int length) {
        BufferedImage[] objectFrames = new BufferedImage[length];
        for (int frameIndex = 0; frameIndex < length; frameIndex ++) {
            objectFrames[frameIndex] = objects.get(startIndex);
            startIndex ++;
        }
        return objectFrames;
    }

    /**
     *
     * @return
     */
    public BufferedImage getCurrentObjectFrame() {
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
    }

    /**
     *
     */
    public void move() {
        moveY();
        moveX();
        if(lastScore != currentScore) {
            System.out.println(currentScore);
        }
    }

    /**
     *
     */
    private void moveX() {
        collisionDetection.setStaticPoint(yPos, collisionBox.y, collisionBox.height, Tile.TILE_HEIGHT);
        switch (direction) {
            case 3: // move left
                collisionDetection.setOriginalPoint(xPos);
                collisionDetection.setNewPoint(-2, collisionBox.x, 0, Tile.TILE_WIDTH);
                if(!collisionDetection.isCollideSG(true)) {

                    itemCollisions(-2f, 0f);

                    // check if the object is moving over the screen width
                    if(isCrossing((int)(xPos - 2))) {
                        xPos = gameHandler.getGameWidth();
                    }

                    xPos -= speed;
                } else {
                    xPos = collisionDetection.getOriginalPoint();
                    direction = 0;
                }
                break;

            case 4: // move right
                collisionDetection.setOriginalPoint(xPos);
                collisionDetection.setNewPoint(2, collisionBox.x, collisionBox.width, Tile.TILE_WIDTH);

                if (!collisionDetection.isCollideSG(true)) {
                    itemCollisions(2f, 0f);
                    // check if the object is moving over the screen width
                    if(isCrossing((int)(xPos + 1))) {
                        xPos = 0;
                    }
                    xPos += speed;
                } else {
                    xPos = collisionDetection.getOriginalPoint();
                    direction = 0;
                }
                break;
        }
    }

    /**
     *
     */
    private void moveY() {
        collisionDetection.setStaticPoint(xPos, collisionBox.x, collisionBox.width, Tile.TILE_WIDTH);
        switch (direction) {
            case 1: // up
                collisionDetection.setOriginalPoint(yPos);
                collisionDetection.setNewPoint(-2, collisionBox.y, 0, Tile.TILE_HEIGHT);
                if(!collisionDetection.isCollideSG(false)) {
                    itemCollisions(0f, -2f);
                    yPos -= speed;
                } else {
                    yPos = collisionDetection.getOriginalPoint();
                    direction = 0;
                    break;
                }
                break;
            case 2: //down
                collisionDetection.setOriginalPoint(yPos);
                collisionDetection.setNewPoint(2, collisionBox.y, collisionBox.height, Tile.TILE_HEIGHT);
                if(!collisionDetection.isCollideSG(false)) {
                    itemCollisions(0f, 2f);
                    yPos += speed;
                } else {
                    yPos = collisionDetection.getOriginalPoint();
                    direction = 0;
                    break;
                }

                break;
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


}
