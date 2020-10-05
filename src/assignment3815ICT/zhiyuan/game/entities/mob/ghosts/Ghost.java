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
    protected int currentDirection;
    protected boolean inBase;
    protected int movingDir;
    protected int checkMovableDirection;


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
        switch (checkMovableDirection){
            case 1:
                if(canMoveVertical(-2, 0)) {
                    newPosY = yPos - (height / 2);
                    newPosX = xPos + (width / 2);
                    return true;
                }
                break;
            case 2:
                if(canMoveHorizontal(-2, 0)) {
                    newPosX = xPos - (width / 2);
                    newPosY = yPos + (height / 2);
                    return true;
                }
                break;
            case 3:
                if(canMoveVertical(2, collisionBox.height)) {
                    newPosY = yPos + (height / 2);
                    newPosX = xPos + (width / 2);
                    return true;
                }
                break;
            case 4:
                if(canMoveHorizontal(2, collisionBox.width)) {
                    newPosX = xPos + (width / 2);
                    newPosY = yPos + (height / 2);
                    return true;
                }
                break;
        }
        return false;
    }
    public void setMove() {
        for(Movement move: movements) {
            checkMovableDirection = move.getDirection();
            // check if can move
            if(canMove()) {
                // calculate distance
                // sqrt(abs((x2 - x1))^2 + abs((y2 - y1))^2)
                sqrDistance = Math.abs(targetPosX - newPosX) + Math.abs(targetPosY - newPosY);
                distance = (int) Math.sqrt(sqrDistance);
                move.setDistance(distance);
                move.setMovable(true);
            } else {
                move.setMovable(false);
            }
        }
    }

    public int getDirection() {
        currentDirection = direction;
        System.out.println("currentDirection = direction: " + direction);
        int currentDistance = 0;
        int newDirection;
        int newDistance;
        for(Movement move: movements) {
            System.out.println("check movement: current direction: " + currentDirection + " move direction: " + move.getDirection());
            if(currentDirection != move.getDirection()){
                if(move.isMovable()) {
                    newDirection = move.getDirection();
                    newDistance = move.getDistance();

                    if(currentDirection == 0) {
                        System.out.println("current Direction: " + currentDirection + " Initialise ");
                        currentDirection = newDirection;
                        currentDistance = newDistance;
                        continue;
                    }
                    // check if new distance is less or equal to current distance
                    if(newDistance <= currentDistance) {
                        System.out.println("new distance is less or equal to current distance");
                        System.out.println("current Direction: " + currentDirection + " new direction: " + newDirection);

                        // chekc if direction is not opposite to current direction
                        if(Math.abs(newDirection - currentDirection) != 2) {
                            System.out.println("direction is not opposite");
                            // check direction priority
                            if (newDistance == currentDistance && newDirection < currentDirection) {
                                System.out.println("distance are same");
                                currentDirection = newDirection;
                                currentDistance = newDistance;
                            } else if(newDistance < currentDistance) {
                                System.out.println("distance are different");
                                currentDirection = newDirection;
                                currentDistance = newDistance;
                            }

                        }
                    } else {
                        System.out.println("new distance is greater than current distance");
                    }
                }
            } else {
                if(!move.isMovable()) {
                    currentDirection = 0;
                }
            }
        }

//        System.out.println(setD);
        System.out.println("new direction: " + currentDirection);
//        setDirection(currentDirection);
        direction = currentDirection;
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
