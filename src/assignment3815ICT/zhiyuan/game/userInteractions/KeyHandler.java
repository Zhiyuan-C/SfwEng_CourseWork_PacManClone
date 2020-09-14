package assignment3815ICT.zhiyuan.game.userInteractions;

import assignment3815ICT.zhiyuan.game.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public Key up = new Key();
    public Key down = new Key();
    public Key left = new Key();
    public Key right = new Key();

    public KeyHandler(GamePanel gamePanel) {
        gamePanel.addKeyListener(this);
    }

    public void toggle(int keyCode, boolean pressed) {
        if (keyCode == KeyEvent.VK_UP) up.toggle(pressed);
        if (keyCode == KeyEvent.VK_DOWN) down.toggle(pressed);
        if (keyCode == KeyEvent.VK_LEFT) left.toggle(pressed);
        if (keyCode == KeyEvent.VK_RIGHT) right.toggle(pressed);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        toggle(e.getKeyCode(), true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        toggle(e.getKeyCode(), false);

    }
}
