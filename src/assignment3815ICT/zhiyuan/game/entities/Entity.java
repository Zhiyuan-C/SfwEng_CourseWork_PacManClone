package assignment3815ICT.zhiyuan.game.entities;

import assignment3815ICT.zhiyuan.game.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {
    protected Game game;
    protected float x, y; // x position and y position
    protected int width, height; // size of the entity

    // constructor
    public Entity(Game game, float x, float y, int width, int height) {
        this.game = game;
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
