package assignment3815ICT.zhiyuan.game.inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

    private boolean[] keys, pressedKeys, cantPressKeys;
    public boolean up, down, left, right, enter;

    public KeyManager() {
        keys = new boolean[256];
        pressedKeys = new boolean[keys.length];
        cantPressKeys = new boolean[keys.length];
    }

    public void update() {
        for(int i = 0; i < keys.length; i ++) {
            if(cantPressKeys[i] && !keys[i]) {
                cantPressKeys[i] = false;
            } else if (pressedKeys[i]) {
                cantPressKeys[i] = true;
                pressedKeys[i] = false;
            }
            if(!cantPressKeys[i] && keys[i]) {
                pressedKeys[i] = true;
            }
        }
        up = keys[KeyEvent.VK_UP];
        down = keys[KeyEvent.VK_DOWN];
        left = keys[KeyEvent.VK_LEFT];
        right = keys[KeyEvent.VK_RIGHT];
        enter = keys[KeyEvent.VK_ENTER];
    }

    public boolean justPressedKey(int keyCode) {
        return pressedKeys[keyCode];
    }


    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // do nothing
    }
}
