package assignment3815ICT.zhiyuan.game.entities.mob.movement;

import assignment3815ICT.zhiyuan.game.GameHandler;

import java.awt.*;

public class MoveLeft extends Movement{
    public MoveLeft(GameHandler gameHandler, float xPos, float yPos, Rectangle collisionBox, Collision collisionDetection) {
        super(gameHandler, xPos, yPos, collisionBox, collisionDetection);
    }

    @Override
    public boolean move() {
        return false;
    }

    @Override
    public boolean isCrossing(int x) {
        return false;
    }
}
