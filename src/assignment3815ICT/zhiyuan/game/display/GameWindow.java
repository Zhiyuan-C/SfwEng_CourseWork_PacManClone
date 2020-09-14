package assignment3815ICT.zhiyuan.game.display;

import javax.swing.*;

public class GameWindow {

    private JFrame frame;
    private String title;
    private int width, height;

    public GameWindow(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        createWindow();
    }

    private void createWindow() {
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
