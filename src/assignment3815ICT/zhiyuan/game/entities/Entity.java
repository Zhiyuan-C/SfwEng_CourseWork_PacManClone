package assignment3815ICT.zhiyuan.game.entities;

import assignment3815ICT.zhiyuan.game.GameHandler;
import assignment3815ICT.zhiyuan.game.collisionDetection.Collision;
import assignment3815ICT.zhiyuan.game.entities.item.Item;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {
    protected GameHandler gameHandler;
    protected float xPos, yPos; // x position and y position
    protected int width, height; // size of the entity

    //collision detection
    protected Rectangle collisionBox;
    protected Collision collisionDetection;
    protected boolean active;

    // constructor
    public Entity(GameHandler gameHandler, float xPos, float yPos, int width, int height) {
        this.gameHandler = gameHandler;
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
        this.active = true;

        collisionBox = new Rectangle(0 ,0, width, height);
        collisionDetection = new Collision(gameHandler);
    }

    //abstract methods
    public abstract void update();
    public abstract void render(Graphics graphics);

    //entity collision
    public void itemCollisions(float xOffset, float yOffset) {
        for (Item item : gameHandler.getMap().getEntityManager().getItems()) {
            if (item.equals(this)) continue;
            if (item.getCollisionBox(0f, 0f).intersects(getCollisionBox(xOffset, yOffset))) {
//                gameHandler.getMap().getEntityManager().removeItem(item);
                item.setActive(false);
            }
        }
    }

    public Rectangle getCollisionBox(float xOffset, float yOffset) {
        return new Rectangle((int)(xPos + collisionBox.x + xOffset), (int)(yPos + collisionBox.y + yOffset), collisionBox.width, collisionBox.height);
    }

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

    public boolean isActive() {
        return active;
    }
}
