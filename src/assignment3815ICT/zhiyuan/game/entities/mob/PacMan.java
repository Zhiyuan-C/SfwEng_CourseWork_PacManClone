package assignment3815ICT.zhiyuan.game.entities.mob;

import assignment3815ICT.zhiyuan.game.GameHandler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PacMan extends Mob {

    public PacMan(GameHandler gameHandler, float xPos, float yPos) {
        super(gameHandler, xPos, yPos, 28, 28);
        speed = 1.5f;

        // set up collision bounds
//        collisionBounds.x = 2;
//        collisionBounds.y = 2;
//        collisionBounds.width = 24;
//        collisionBounds.height = 24;
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
    }

    @Override
    public void render(Graphics graphics, BufferedImage image) {
        graphics.drawImage(image, (int) xPos, (int) yPos, width, height, null);

        graphics.setColor(Color.RED);
        graphics.drawRect((int)(xPos + collisionBounds.x), (int)(yPos + collisionBounds.y), collisionBounds.width, collisionBounds.height);
    }
}
