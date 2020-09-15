package assignment3815ICT.zhiyuan.game.entities.mob;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PacMan extends Mob {
    public PacMan(float x, float y) {
        super(x, y);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics graphics, BufferedImage image) {
        graphics.drawImage(image, (int) x, (int) y, null);
    }
}
