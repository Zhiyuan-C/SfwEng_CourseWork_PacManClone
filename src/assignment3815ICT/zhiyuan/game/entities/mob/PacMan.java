package assignment3815ICT.zhiyuan.game.entities.mob;

import assignment3815ICT.zhiyuan.game.GameHandler;
import assignment3815ICT.zhiyuan.game.graphics.sprite.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PacMan extends Mob {

    private boolean keyPressed = false;

    public PacMan(GameHandler gameHandler, float xPos, float yPos) {
        super(gameHandler, xPos, yPos, 28, 28);
        speed = 1.5f;

        // set up collision bounds
        collisionBounds.x = 3;
        collisionBounds.y = 3;
        collisionBounds.width = 22;
        collisionBounds.height = 22;
    }

    @Override
    public void update() {
        getInput();
        if (direction > 0) {
            move();
        }

    }

    private void getInput() {
        if(gameHandler.getKeyManager().up) direction = 1;
        if(gameHandler.getKeyManager().down) direction = 2;
        if(gameHandler.getKeyManager().left) direction = 3;
        if(gameHandler.getKeyManager().right) direction = 4;
        if(!keyPressed) {
            if(direction > 0) {
                keyPressed = true;
                isMoving = true;
            }
        }
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(GameObject.getPlayerObjects().get(1), (int) xPos, (int) yPos, width, height, null);

        graphics.setColor(Color.RED);
        graphics.drawRect((int)(xPos + collisionBounds.x), (int)(yPos + collisionBounds.y), collisionBounds.width, collisionBounds.height);
    }
}
