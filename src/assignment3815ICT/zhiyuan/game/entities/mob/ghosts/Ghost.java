package assignment3815ICT.zhiyuan.game.entities.mob.ghosts;

import assignment3815ICT.zhiyuan.game.GameHandler;
import assignment3815ICT.zhiyuan.game.entities.mob.Mob;
import assignment3815ICT.zhiyuan.game.entities.mob.movement.*;
import assignment3815ICT.zhiyuan.game.graphics.display.Animation;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class Ghost extends Mob {
    protected ArrayList<BufferedImage> ghostImages;
    protected boolean frightenedMode;
    protected long startTimeFrightened;

    protected float targetPosX, targetPosY;
    protected int targetWidth, targetHeight;

    protected boolean inBase;
    protected MoveUp moveUp;
    protected MoveDown moveDown;
    protected MoveLeft moveLeft;
    protected MoveRight moveRight;


    public Ghost(GameHandler gameHandler, float xPos, float yPos) {
        super(gameHandler, xPos, yPos, 28, 28);

        this.ghostImages = gameHandler.getGhostObjects();

        // moving speed
        speed = 1.5f;
        // alive
        isAlive = true;
        // set up collision bounds
        collisionBox.x = 4;
        collisionBox.y = 4;
        collisionBox.width = 22;
        collisionBox.height = 22;
        // set up default target position
        targetPosX = 0;
        targetPosY = 0;
        targetHeight = 10;
        targetWidth = 10;
        // traveling direction
//        movingDir = 0; // default
        // 1 - up, 2 - left, 3 - down, 4 - right, lower number also have higher proprioty
        moveUp = new MoveUp(this, gameHandler.getMapWidth(), gameHandler.getMapHeight(),
                gameHandler.getTileWidth(), gameHandler.getTileHeight());
        moveLeft = new MoveLeft(this, gameHandler.getMapWidth(), gameHandler.getMapHeight(),
                gameHandler.getTileWidth(), gameHandler.getTileHeight());
        moveRight = new MoveRight(this, gameHandler.getMapWidth(), gameHandler.getMapHeight(),
                gameHandler.getTileWidth(), gameHandler.getTileHeight());
        moveDown = new MoveDown(this, gameHandler.getMapWidth(), gameHandler.getMapHeight(),
                gameHandler.getTileWidth(), gameHandler.getTileHeight());

    }



    @Override
    public void render(Graphics graphics) {
        if(frightenedMode) {
            graphics.drawImage(ghostImages.get(20), (int) xPos, (int) yPos, width, height, null);
        } else {
            graphics.drawImage(getCurrentObjectFrame(), (int) xPos, (int) yPos, width, height, null);
        }
//        graphics.setColor(Color.BLUE);
//        graphics.drawRect((int)(xPos + collisionBox.x), (int)(yPos + collisionBox.y), collisionBox.width, collisionBox.height);
//
//        graphics.setColor(Color.RED);
//        graphics.fillOval((int)targetPosX, (int)targetPosY, targetWidth, targetHeight);
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

    protected void frightenedMode() {
        int timePassed = 0;
        if(frightenedMode) {
            timePassed = (int) ((System.currentTimeMillis() - startTimeFrightened) / 1000);
        }
        if (timePassed > gameHandler.getBoostingTime()) {
            // five sec, change later
            frightenedMode = false;
        }
    }

    public Move checkUp() {
        moveUp.checkMovable(xPos, yPos, targetPosX, targetPosY);
        return moveUp;
    }
    public Move checkDown() {
        moveDown.checkMovable(xPos, yPos, targetPosX, targetPosY);
        return moveDown;
    }
    public Move checkLeft() {
        moveLeft.checkMovable(xPos, yPos, targetPosX, targetPosY);
        return moveLeft;
    }
    public Move checkRight() {
        moveRight.checkMovable(xPos, yPos, targetPosX, targetPosY);
        return moveRight;
    }

    protected void move() {
        // up, left, down, right
        if(direction == 1) checkUp().move();
        if(direction == 2) checkLeft().move();
        if(direction == 3) checkDown().move();
        if(direction == 4) checkRight().move();
    }

    protected void tempTargetPosition () {
        targetPosX = gameHandler.getEntityManager().getPacMan().getxPos() + (gameHandler.getEntityManager().getPacMan().getWidth() / 2 - (targetWidth / 2));
        targetPosY = gameHandler.getEntityManager().getPacMan().getyPos() + (gameHandler.getEntityManager().getPacMan().getHeight() / 2 - (targetHeight / 2));
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
