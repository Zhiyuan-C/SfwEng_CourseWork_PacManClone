package assignment3815ICT.zhiyuan.game.entities.mob;

import assignment3815ICT.zhiyuan.game.entities.Entity;

public abstract class Mob extends Entity {

    protected float speed;
    protected int direction = 0;// 1 for up, 2 for down, 3 for left, 4 for right

    public Mob(float x, float y, int width, int height) {
        super(x, y, width, height);
    }

    public void move() {
        // 1 for up, 2 for down, 3 for left, 4 for right
        switch (direction) {
            case 1:
                y -= speed;
                break;
            case 2:
                y += speed;
                break;
            case 3:
                x -= speed;
                break;
            case 4:
                x += speed;
        }
    }
}
