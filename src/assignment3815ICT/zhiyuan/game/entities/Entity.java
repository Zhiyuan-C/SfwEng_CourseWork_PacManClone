package assignment3815ICT.zhiyuan.game.entities;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {

    protected float x, y; // x position and y position

    // constructor
    public Entity(float x, float y) {
        this.x = x;
        this.y = y;
    }

    //abstract methods
    public abstract void update();
    public abstract void render(Graphics graphics, BufferedImage image);
}
