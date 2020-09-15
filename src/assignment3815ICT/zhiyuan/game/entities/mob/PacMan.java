package assignment3815ICT.zhiyuan.game.entities.mob;

import assignment3815ICT.zhiyuan.game.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PacMan extends Mob {
    private Game game;



    public PacMan(Game game, float x, float y) {
        super(x, y, 32, 32);
        speed = 2.0f;
        this.game = game;
    }


    @Override
    public void update() {
        getInput();
        move();
    }

    private void getInput() {
        if(game.getKeyManager().up) direction = 1;
        if(game.getKeyManager().down) direction = 2;
        if(game.getKeyManager().left) direction = 3;
        if(game.getKeyManager().right) direction = 4;
    }

    @Override
    public void render(Graphics graphics, BufferedImage image) {
        graphics.drawImage(image, (int) x, (int) y, width, height, null);
    }
}
