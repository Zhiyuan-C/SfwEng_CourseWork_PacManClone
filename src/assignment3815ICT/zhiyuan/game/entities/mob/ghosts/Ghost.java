package assignment3815ICT.zhiyuan.game.entities.mob.ghosts;

import assignment3815ICT.zhiyuan.game.GameHandler;
import assignment3815ICT.zhiyuan.game.entities.mob.Mob;
import assignment3815ICT.zhiyuan.game.entities.mob.movement.Movement;
import assignment3815ICT.zhiyuan.game.graphics.display.Animation;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class Ghost extends Mob {
    protected ArrayList<BufferedImage> ghostImages;
    protected boolean frightenedMode;
    protected long startTimeFrightened;

    protected Movement[] movements = new Movement[4];
    protected float targetPosX, targetPosY;
    protected int targetWidth, targetHeight;
    protected float newPosX, newPosY;
    protected double sqrDistance;
    protected int distance;
    protected int lastDistance;
//    protected int currentDirection;
    protected int lastDirection;
    protected boolean inBase;
    protected int movingDir;
    protected int checkMovableDirection;
    protected long currentTime;
    protected int tilePosX, tilePosY;
    protected int currentTileX, currentTileY;
    protected boolean moved;


    public Ghost(GameHandler gameHandler, float xPos, float yPos) {
        super(gameHandler, xPos, yPos, 28, 28);

        this.ghostImages = gameHandler.getGhostObjects();

        // moving speed
        speed = 1.5f;
        // alive
        isAlive = true;
        // set up collision bounds
//        collisionBox.x = 3;
//        collisionBox.y = 3;
        collisionBox.width = 30;
        collisionBox.height = 30;
        // set up default target position
        targetPosX = 0;
        targetPosY = 0;
        targetHeight = 10;
        targetWidth = 10;
        // traveling direction
//        movingDir = 0; // default
        // 1 - up, 2 - left, 3 - down, 4 - right, lower number also have higher proprioty
        movements[0] = new Movement(1, 0, "up");
        movements[1] = new Movement(2, 0, "left");
        movements[2] = new Movement(3, 0, "down");
        movements[3] = new Movement(4, 0, "right");
        lastDistance = 0;
        currentTime = System.currentTimeMillis();
        moved = false;
        tilePosX = 0;
        tilePosY = 0;
        currentTileX = 0;
        currentTileY = 0;
        lastDirection = 0;

    }



    @Override
    public void render(Graphics graphics) {
        if(frightenedMode) {
            graphics.drawImage(ghostImages.get(20), (int) xPos, (int) yPos, width, height, null);
        } else {
            graphics.drawImage(getCurrentObjectFrame(), (int) xPos, (int) yPos, width, height, null);
        }
        graphics.setColor(Color.BLUE);
        graphics.drawRect((int)(xPos + collisionBox.x), (int)(yPos + collisionBox.y), collisionBox.width, collisionBox.height);

        graphics.setColor(Color.RED);
        graphics.fillOval((int)targetPosX, (int)targetPosY, targetWidth, targetHeight);
    }

    public abstract void setTargetPosition();

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

    public boolean canMove() {
        // 1 - up, 2 - left, 3 - down, 4 - right,
//        switch (checkMovableDirection){
//            case 1:
//                if(canMoveVertical(-2, 0)) {
//                    newPosY = yPos - (height / 2);
//                    newPosX = xPos + (width / 2);
//                    return true;
//                }
//                break;
//            case 2:
//                if(canMoveHorizontal(-2, 0)) {
//                    newPosX = xPos - (width / 2);
//                    newPosY = yPos + (height / 2);
//                    return true;
//                }
//                break;
//            case 3:
//                if(canMoveVertical(2, collisionBox.height)) {
//                    newPosY = yPos + (height / 2);
//                    newPosX = xPos + (width / 2);
//                    return true;
//                }
//                break;
//            case 4:
//                if(canMoveHorizontal(2, collisionBox.width)) {
//                    newPosX = xPos + (width / 2);
//                    newPosY = yPos + (height / 2);
//                    return true;
//                }
//                break;
//        }
        return false;
    }
    public void setMove() {
        for(Movement move: movements) {
            checkMovableDirection = move.getDirection();
            //check if moving direction is wall or not
            // check how many wall in the way
            // get current tile, current pos / 32
            // get starting tile
            // current tile + 1 is the starting tile
            // if new direction is movable
            // count how many tiles can move
            // count = 0
            // while(true)
            //    check next tile is wall or not
            //    tileNum + 1
            //    if movable
            //       count+=1
            //    if not movable
            //       break;
            // set movable tile
            // calculate distance
            // sqrt(abs((x2 - x1))^2 + abs((y2 - y1))^2)
            sqrDistance = Math.abs(targetPosX - newPosX) + Math.abs(targetPosY - newPosY);
            distance = (int) Math.sqrt(sqrDistance);
            move.setDistance(distance);
            // check if can move
            if(canMove()) {

                move.setMovable(true);
            } else {
                move.setMovable(false);
            }

        }
    }

    public int getDirection() {
//        currentDirection = direction;
        int currentDirection = direction;
        int newDirection;
        int newDistance;
        int n = 0;
        for(Movement move: movements) {
            System.out.println("for loop times: " + n);
            System.out.println("currentDirection: " + currentDirection + " move.getDirection: " + move.getDirection());
            System.out.println("move.getDirection: " + move.getDirection() + " movable: " + move.isMovable() + " direction: " + move.getDirectionWord());
            System.out.println("lastDistance: " + lastDistance + " move.getDistance(): " + move.getDistance());
            if(currentDirection == move.getDirection() && !move.isMovable()) {
                lastDirection = currentDirection;
                currentDirection = 0;
                n += 1;
                continue;
            }
            // check if direction is movable or not
            if(move.isMovable()) {
                // check if direction == 0
                if (currentDirection == 0) {
                    System.out.println("currentDirection = 0, set currentDirection to this direction: " + move.getDirection());
                    System.out.println("set lastDistance to current move");
                    if(lastDirection == 0) {
                        currentDirection = move.getDirection();
                        lastDistance = move.getDistance();
                    } else {
                        if(Math.abs(lastDirection - move.getDirection()) != 2) {
                            currentDirection = move.getDirection();
                            lastDistance = move.getDistance();
                        }
                    }

                    n += 1;
                    continue;
                }
                // compare if currentDirection's distance is less than the new direction's distance
                if(move.getDistance() < lastDistance) {
                    System.out.println("new distance is less than last distance");
                    System.out.println("lastDistance: " + lastDistance + " move.getDistance(): " + move.getDistance());
                    System.out.println("check if new distance is opposite to current distance");
                    if(Math.abs(currentDirection - move.getDirection())!= 2) {
                        System.out.println("new direction is not opposite to current");
                        System.out.println("currentDirection: " + currentDirection + " move.getDirection(): " + move.getDirection());
                        System.out.println("update currentDirection and lastDistance");
                        currentDirection = move.getDirection();
                        lastDistance = move.getDistance();
                    }
                }
                // compare if distance are the same
                if(lastDistance == move.getDistance()) {
                    // check if new direction have higher priority
                    System.out.println("distance are the same, check if new direction have higher priority");
                    if(move.getDirection() <= currentDirection) {
                        System.out.println("this direction have higher priority");
                        System.out.println("check if new distance is opposite to current distance");
                        if(currentDirection - move.getDirection() != 2) {
                            System.out.println("new direction is not opposite to current");
                            System.out.println("currentDirection: " + currentDirection + " move.getDirection(): " + move.getDirection());
                            System.out.println("update currentDirection and lastDistance");
                            currentDirection = move.getDirection();
                            lastDistance = move.getDistance();
                        }

                    }
                }
            }
            n += 1;
        }

//        System.out.println(setD);

//        setDirection(currentDirection);
        System.out.println("for loop finished. currentDirection: " + currentDirection);
//        currentTime = System.currentTimeMillis();
//        if(!moved) currentDirection = direction;
        return currentDirection;
    }

    public void move() {
        if(direction == 1) yPos -= speed;
        if(direction == 2) xPos -= speed;
        if(direction == 3) yPos += speed;
        if(direction == 4) xPos += speed;
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

    public float getTargetPosX() {
        return targetPosX;
    }

    public void setTargetPosX(float targetPosX) {
        this.targetPosX = targetPosX;
    }

    public float getTargetPosY() {
        return targetPosY;
    }

    public void setTargetPosY(float targetPosY) {
        this.targetPosY = targetPosY;
    }
}
