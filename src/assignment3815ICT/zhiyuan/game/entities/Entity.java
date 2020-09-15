package assignment3815ICT.zhiyuan.game.entities;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {

    protected float x, y; // x position and y position
    protected int width, height; // size of the entity

    // constructor
    public Entity(float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    //abstract methods
    public abstract void update();
    public abstract void render(Graphics graphics, BufferedImage image);

    // getters and setters

}
