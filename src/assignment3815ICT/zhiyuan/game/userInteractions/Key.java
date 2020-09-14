package assignment3815ICT.zhiyuan.game.userInteractions;

public class Key {
    private int numPressed = 0;
    private boolean isPressed = false;

    public void toggle (boolean pressed) {
        isPressed = pressed;
        if (pressed) numPressed++;
    }

    public boolean isPressed() {
        return isPressed;
    }

}
