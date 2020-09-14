package assignment3815ICT.zhiyuan.game.gameGraphics;

public class Vector2f {
    public float x;
    public float y;

    // x and y position for tiles
    public static float worldX;
    public static float worldY;

    //constructor
    public Vector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2f() {
        x = 0;
        y = 0;
    }

    public Vector2f(Vector2f vector) { new Vector2f(vector.x, vector.y); }
    public void addX(float num) { x += num; }
    public void addY(float num) { y += num; }
    public void setX(float num) { x = num; }
    public void setY(float num) { y = num; }

    public void setVector(Vector2f vector) {
        this.x = vector.x;
        this.y = vector.y;
    }

    public static void setWorldVariable(float x, float y) {
        worldX = x;
        worldY = y;
    }

    public Vector2f getWorldVariable() { return new Vector2f(x - worldX, y - worldY); }

    @Override
    public String toString() { return x + ", " + y; }

}
