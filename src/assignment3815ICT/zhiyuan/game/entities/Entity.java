package assignment3815ICT.zhiyuan.game.entities;

import assignment3815ICT.zhiyuan.game.GameHandler;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {
    protected GameHandler gameHandler;
    protected float x, y; // x position and y position
    protected int width, height; // size of the entity

    // constructor
    public Entity(GameHandler gameHandler, float x, float y, int width, int height) {
        this.gameHandler = gameHandler;
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
