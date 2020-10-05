package assignment3815ICT.zhiyuan.game.entities.mob;

import assignment3815ICT.zhiyuan.game.GameHandler;
import assignment3815ICT.zhiyuan.game.graphics.display.Animation;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PacMan extends Mob {

    //Animation
    private ArrayList<BufferedImage> pacManImages;
    private int life = 3;
    private long timeDied = 0;


//    private boolean keyPressed = false;
    private int score;

    public PacMan(GameHandler gameHandler) {
        super(gameHandler, 0, 0, 28, 28);
        init();
    }

    private void init() {
        // set up for animation
        this.pacManImages = gameHandler.getPlayerObjects();
        BufferedImage[] left = getObjectFrames(pacManImages, 0, 2);
        BufferedImage[] up = getObjectFrames(pacManImages, 2, 2);
        BufferedImage[] right = getObjectFrames(pacManImages, 4, 2);
        BufferedImage[] down = getObjectFrames(pacManImages, 6, 2);
        BufferedImage[] vanish = getObjectFrames(pacManImages, 8, 4);
        this.animeLeft = new Animation(left, 500);
        this.animeUp = new Animation(up, 500);
        this.animeRight = new Animation(right, 500);
        this.animeDown = new Animation(down, 500);
        this.animeVanish = new Animation(vanish, 1000);
        objectLastFrame = pacManImages.get(0);
        // alive
        isAlive = true;
        // moving speed
        upLeftSpeed = -1.5f;
        downRightSpeed = 1.5f;
        // score
        score = 0;
        // set up collision bounds
        collisionBox.x = 3;
        collisionBox.y = 3;
        collisionBox.width = 22;
        collisionBox.height = 22;
    }

    /**
     * Return an array of buffered image containing the frames of the object for animation
     *
     * @param objects an arraylist containing object's buffered image retrieved from sprite sheet
     * @param startIndex start index of the object
     * @param length how many objects is required for that animation frame
     * @return BufferedImage[] objects for particular animation frame
     */
    private BufferedImage[] getObjectFrames(ArrayList<BufferedImage> objects, int startIndex, int length) {
        BufferedImage[] objectFrames = new BufferedImage[length];
        for (int frameIndex = 0; frameIndex < length; frameIndex ++) {
            objectFrames[frameIndex] = objects.get(startIndex);
            startIndex ++;
        }
        return objectFrames;
    }

    @Override
    public void update() {

        // movement
        if(isAlive) getInput();

        if (direction > 0) {
            // moving - direction 1 for up, 2 for down, 3 for left, 4 for right
            switch (direction){
                case 1:
                    if(canMoveVertical(-2, 0, upLeftSpeed)) {
                        itemCollisions(0f, -2f);
                        mobCollisions(0f, -2f);
                    }
                    break;
                case 2:
                    if(canMoveVertical(2, collisionBox.height, downRightSpeed)){
                        itemCollisions(0f, 2f);
                        mobCollisions(0f, 2f);
                    }
                    break;
                case 3:
                    if(canMoveHorizontal(-2, 0, upLeftSpeed)) {
                        itemCollisions(-2f, 0f);
                        mobCollisions(-2f, 0f);
                    }
                    break;
                case 4:
                    if(canMoveHorizontal(2, collisionBox.width, downRightSpeed)) {
                        itemCollisions(2f, 0f);
                        mobCollisions(2f, 0f);
                    }
                    break;

            }

            // life
            if(!isAlive) {
                if(life > 0) {
                    life -= 1;
                    xPos = defaultXpos;
                    yPos = defaultYpos;
                    timeDied = System.currentTimeMillis();
                    direction = 0;
                }
                else {
                    System.out.println("GAME OVER!");
                }
            }
        }

        if(!isAlive) {
            if((System.currentTimeMillis() - timeDied) > 2500){
                objectLastFrame = pacManImages.get(0);
                isAlive = true;
            }
        }



        // animation
        animeDown.update();
        animeLeft.update();
        animeRight.update();
        animeUp.update();
        animeVanish.update();

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(getCurrentObjectFrame(), (int) xPos, (int) yPos, width, height, null);

        graphics.setColor(Color.RED);
        graphics.drawRect((int)(xPos + collisionBox.x), (int)(yPos + collisionBox.y), collisionBox.width, collisionBox.height);

        gameHandler.getGameFont().render(graphics, "score " + score, 0, 5, 20, 20);
    }

    private void getInput() {
        if(gameHandler.getKeyManager().up) direction = 1;
        if(gameHandler.getKeyManager().down) direction = 2;
        if(gameHandler.getKeyManager().left) direction = 3;
        if(gameHandler.getKeyManager().right) direction = 4;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
}
