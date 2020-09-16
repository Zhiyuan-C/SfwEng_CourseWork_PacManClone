package assignment3815ICT.zhiyuan.game.entities.mob;

import assignment3815ICT.zhiyuan.game.Game;
import assignment3815ICT.zhiyuan.game.GameHandler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PacMan extends Mob {

    public PacMan(GameHandler gameHandler, float x, float y) {
        super(gameHandler, x, y, 32, 32);
        speed = 1.5f;

        // set up collision bounds
        collisionBounds.x = 8;
        collisionBounds.y = 16;
        collisionBounds.width = 16;
        collisionBounds.height = 16;
    }


    @Override
    public void update() {
        getInput();
        move();
    }

    private void getInput() {
        if(gameHandler.getKeyManager().up) direction = 1;
        if(gameHandler.getKeyManager().down) direction = 2;
        if(gameHandler.getKeyManager().left) direction = 3;
        if(gameHandler.getKeyManager().right) direction = 4;
    }

    @Override
    public void render(Graphics graphics, BufferedImage image) {
        graphics.drawImage(image, (int) x, (int) y, width, height, null);

        graphics.setColor(Color.RED);
        graphics.fillRect((int)(x + collisionBounds.x), (int)(y + collisionBounds.y), collisionBounds.width, collisionBounds.height);
    }
}
