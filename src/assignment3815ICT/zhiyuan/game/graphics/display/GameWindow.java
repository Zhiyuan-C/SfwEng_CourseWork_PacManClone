package assignment3815ICT.zhiyuan.game.graphics.display;

import javax.swing.*;
import java.awt.*;

public class GameWindow {

    private JFrame frame;
    private Canvas canvas;
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

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false);

        frame.add(canvas);
        frame.pack();
    }

    // get canvas
    public Canvas getCanvas() {
        return canvas;
    }

    // get frame
    public JFrame getFrame() { return frame; }
}
