package assignment3815ICT.zhiyuan.game.entities;

import assignment3815ICT.zhiyuan.game.GameHandler;
import assignment3815ICT.zhiyuan.game.collisionDetection.Collision;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {
    protected GameHandler gameHandler;
    protected float xPos, yPos; // x position and y position
    protected int width, height; // size of the entity

    //collision detection
    protected Rectangle collisionBounds;
    protected Collision collisionDetection;

    // constructor
    public Entity(GameHandler gameHandler, float xPos, float yPos, int width, int height) {
        this.gameHandler = gameHandler;
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;

        collisionBounds = new Rectangle(0 ,0, width, height);
        collisionDetection = new Collision(gameHandler);
    }

    //abstract methods
    public abstract void update();
    public abstract void render(Graphics graphics);

    // getters and setters


    public void setxPos(float xPos) {
        this.xPos = xPos;
    }

    public void setyPos(float yPos) {
        this.yPos = yPos;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
