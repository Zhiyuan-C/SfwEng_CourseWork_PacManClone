package assignment3815ICT.zhiyuan.game.entities.mob;

import assignment3815ICT.zhiyuan.game.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PacMan extends Mob {
    private Game game;



    public PacMan(Game game, float x, float y) {
        super(x, y);
        speed = 1;
        this.game = game;
    }

    @Override
    public void move() {
        // 1 for up, 2 for down, 3 for left, 4 for right
        switch (direction) {
            case 1:
                y -= speed;
                break;
            case 2:
                y += speed;
                break;
            case 3:
                x -= speed;
                break;
            case 4:
                x += speed;
        }
    }

    @Override
    public void update() {
        if(game.getKeyManager().up) direction = 1;
        if(game.getKeyManager().down) direction = 2;
        if(game.getKeyManager().left) direction = 3;
        if(game.getKeyManager().right) direction = 4;
    }

    @Override
    public void render(Graphics graphics, BufferedImage image) {
        graphics.drawImage(image, (int) x, (int) y, null);
    }
}
