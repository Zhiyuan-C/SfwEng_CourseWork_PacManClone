package assignment3815ICT.zhiyuan.game.entities.mob.movement;

public class Movement {
    private int direction;
    private String directionWord;
    private int distance;
    private boolean movable;

    public Movement(int direction, int distance, String directionWord) {
        this.direction = direction;
        this.distance = distance;
        this.directionWord = directionWord;
    }

    public int getDirection() {
        return direction;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getDirectionWord() {
        return directionWord;
    }

    public boolean isMovable() {
        return movable;
    }

    public void setMovable(boolean movable) {
        this.movable = movable;
    }
}
