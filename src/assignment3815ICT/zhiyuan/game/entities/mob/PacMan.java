package assignment3815ICT.zhiyuan.game.entities.mob;

import assignment3815ICT.zhiyuan.game.GameHandler;
import assignment3815ICT.zhiyuan.game.graphics.display.Animation;
import assignment3815ICT.zhiyuan.game.graphics.sprite.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PacMan extends Mob {

    //Animation
    private ArrayList<BufferedImage> pacManImages;


//    private boolean keyPressed = false;
    private int score;

    public PacMan(GameHandler gameHandler) {
        super(gameHandler, 0, 0, 28, 28);
        init();
    }

    private void init() {
        // set up for animation
        this.pacManImages = gameHandler.getPlayerObjects();
        BufferedImage[] left = gameHandler.getGameObject().getObjectFrames(pacManImages, 0, 2);
        BufferedImage[] up = gameHandler.getGameObject().getObjectFrames(pacManImages, 2, 2);
        BufferedImage[] right = gameHandler.getGameObject().getObjectFrames(pacManImages, 4, 2);
        BufferedImage[] down = gameHandler.getGameObject().getObjectFrames(pacManImages, 6, 2);
        BufferedImage[] vanish = gameHandler.getGameObject().getObjectFrames(pacManImages, 8, 4);
        this.animeLeft = new Animation(left, 500);
        this.animeUp = new Animation(up, 500);
        this.animeRight = new Animation(right, 500);
        this.animeDown = new Animation(down, 500);
        objectLastFrame = pacManImages.get(0);
        // moving speed
        speed = 1.5f;
        // score
        score = 0;
        currentScore = 0;
        lastScore = 0;
        // set up collision bounds
        collisionBox.x = 3;
        collisionBox.y = 3;
        collisionBox.width = 22;
        collisionBox.height = 22;
    }

    @Override
    public void update() {

        // movement
        getInput();
        if (direction > 0) {
            move();
            // animation
            animeDown.update();
            animeLeft.update();
            animeRight.update();
            animeUp.update();
        }

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
//        if(!keyPressed) {
//            if(direction > 0) {
//                keyPressed = true;
//                isMoving = true;
//            }
//        }
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
