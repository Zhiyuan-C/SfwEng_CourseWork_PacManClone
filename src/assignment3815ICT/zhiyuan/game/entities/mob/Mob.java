package assignment3815ICT.zhiyuan.game.entities.mob;

import assignment3815ICT.zhiyuan.game.entities.Entity;

public abstract class Mob extends Entity {

    protected double speed;
    protected int direction = 0;// 1 for up, 2 for down, 3 for left, 4 for right

    public Mob(float x, float y) {
        super(x, y);
    }

    public abstract void move(); // may change latter
}
