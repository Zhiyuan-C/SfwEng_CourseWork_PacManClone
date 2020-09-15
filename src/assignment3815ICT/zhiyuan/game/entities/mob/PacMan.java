package assignment3815ICT.zhiyuan.game.entities.mob;

import assignment3815ICT.zhiyuan.game.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PacMan extends Mob {
    private Game game;

    public PacMan(Game game, float x, float y) {
        super(x, y);
//        speed = 1;
        this.game = game;
    }

//    @Override
//    public void move() {
//        x += speed;
//    }

    @Override
    public void update() {
        if(game.getKeyManager().up) y -= 3;
        if(game.getKeyManager().down) y += 3;
        if(game.getKeyManager().left) x -= 3;
        if(game.getKeyManager().right) x += 3;
    }

    @Override
    public void render(Graphics graphics, BufferedImage image) {
        graphics.drawImage(image, (int) x, (int) y, null);
    }
}
