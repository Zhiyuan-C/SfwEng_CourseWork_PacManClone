package assignment3815ICT.zhiyuan.game.inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

    private boolean[] keys;
    public boolean up, down, left, right, enter;
    private int lastKey;
    public int count;

    public KeyManager() {
        keys = new boolean[256];
    }

    public void update() {
        up = keys[KeyEvent.VK_UP];
        down = keys[KeyEvent.VK_DOWN];
        left = keys[KeyEvent.VK_LEFT];
        right = keys[KeyEvent.VK_RIGHT];
        enter = keys[KeyEvent.VK_ENTER];
    }


    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
        if(lastKey != e.getKeyCode()) {
            count = 0;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
        lastKey = e.getKeyCode();
        count += 1;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // do nothing
    }
}
