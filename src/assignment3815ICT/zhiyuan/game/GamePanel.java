package assignment3815ICT.zhiyuan.game;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel implements Runnable {

    public int width;
    public int height;

    private Thread thread;
    private boolean isRunning = false;

    private BufferedImage image;
    private Graphics2D g;

    public GamePanel(int width, int height) {
        this.width = width;
        this.height = height;
        setPreferredSize(new Dimension(width, height));
        // allow jpanel to have input as soon as jframe is made
        setFocusable(true);
        requestFocus();

    }

    public void addNotify() {
        super.addNotify();

        if (thread == null) {
            thread = new Thread(this, "GameThread");
            thread.start();
        }
    }

    public void init() {
        isRunning = true;
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g = (Graphics2D) image.getGraphics();

    }

    public void run() {
        init();

        while (isRunning) {
            update();
            render();
            draw();
        }
    }

    private int x = 0;

    public void update(){
        x ++;

    }

    public void render(){

    }

    public void draw(){

    }
}
