package assignment3815ICT.zhiyuan.game.entities;

import assignment3815ICT.zhiyuan.game.GameHandler;
import assignment3815ICT.zhiyuan.game.entities.mob.movement.Collision;
import assignment3815ICT.zhiyuan.game.entities.item.Item;
import assignment3815ICT.zhiyuan.game.entities.mob.ghosts.Ghost;

import java.awt.*;

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

    //item collision
    public void itemCollisions(float xOffset, float yOffset) {
        for (Item item : gameHandler.getMap().getEntityManager().getItems()) {
            if (item.equals(this)) continue;
            if (item.getCollisionBox(0f, 0f).intersects(getCollisionBox(xOffset, yOffset))) {
//                gameHandler.getMap().getEntityManager().removeItem(item);
                item.setActive(false);
            }
        }
    }
    //entity collision
    public void mobCollisions(float xOffset, float yOffset) {
        for (Ghost ghost : gameHandler.getMap().getEntityManager().getGhosts()) {
            if (ghost.equals(this)) continue;
            if (ghost.getCollisionBox(0f, 0f).intersects(getCollisionBox(xOffset, yOffset))) {
                // check if in the frightened mode
                if(ghost.isFrightenedMode()){
                    ghost.setAlive(false);
                } else {
                    gameHandler.getMap().getEntityManager().getPacMan().setAlive(false);
                }
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

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public float getxPos() {
        return xPos;
    }

    public float getyPos() {
        return yPos;
    }
}
