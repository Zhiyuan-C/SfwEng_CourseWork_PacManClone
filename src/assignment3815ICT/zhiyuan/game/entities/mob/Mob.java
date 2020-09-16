package assignment3815ICT.zhiyuan.game.entities.mob;

import assignment3815ICT.zhiyuan.game.GameHandler;
import assignment3815ICT.zhiyuan.game.entities.Entity;

public abstract class Mob extends Entity {

    protected float speed;
    protected int direction = 0;// 1 for up, 2 for down, 3 for left, 4 for right

    public Mob(GameHandler gameHandler, float xPos, float yPos, int width, int height) {
        super(gameHandler, xPos, yPos, width, height);
    }

    public void move() {
        // 1 for up, 2 for down, 3 for left, 4 for right
        switch (direction) {
            case 1:
                yPos -= speed;
                break;
            case 2:
                yPos += speed;
                break;
            case 3:
                xPos -= speed;
                break;
            case 4:
                xPos += speed;
        }
    }

    public void moveX() {

    }
    public void moveY() {

    }

    protected boolean collisionWithWall(int x, int y) {
        return gameHandler.getMap().getTile(x, y).isWall();
    }
}
