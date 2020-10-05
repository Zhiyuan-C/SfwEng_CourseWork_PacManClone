package assignment3815ICT.zhiyuan.game.entities.mob.movement;

import assignment3815ICT.zhiyuan.game.GameHandler;

import java.awt.*;

public abstract class Movement {
    protected GameHandler gameHandler;
    protected float xPos, yPos;
    protected Rectangle collisionBox;
    protected Collision collisionDetection;

    public Movement(GameHandler gameHandler, float xPos, float yPos, Rectangle collisionBox, Collision collisionDetection) {
        this.gameHandler = gameHandler;
        this.xPos = xPos;
        this.yPos = yPos;
        this.collisionBox = collisionBox;
        this.collisionDetection = collisionDetection;
    }
    // set original and static position for horizontal
    protected void setOShorizontal(){
        collisionDetection.setStaticPoint(yPos, collisionBox.y, collisionBox.height, gameHandler.getTILE_HEIGHT());
        collisionDetection.setOriginalPoint(xPos);
    }
    // set original and static position for vertical
    protected void setOSvertical() {
        collisionDetection.setStaticPoint(xPos, collisionBox.x, collisionBox.width, gameHandler.getTILE_WIDTH());
        collisionDetection.setOriginalPoint(yPos);
    }
    public abstract boolean move();
    public abstract boolean isCrossing(int x);

}
