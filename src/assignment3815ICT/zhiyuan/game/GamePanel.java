package assignment3815ICT.zhiyuan.game;

import assignment3815ICT.zhiyuan.game.states.StateManager;
import assignment3815ICT.zhiyuan.game.userInteractions.KeyHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel implements Runnable {

    public int width;
    public int height;

    private Thread thread;
    private boolean isRunning = false;

    private BufferedImage image;
    private Graphics2D graphics2D;

    private KeyHandler keyHandler;
    private StateManager stateManager;

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
        graphics2D = (Graphics2D) image.getGraphics();

        keyHandler = new KeyHandler(this);
        stateManager = new StateManager();

    }

    public void run() {
        init();
        gameLoop();
//        while (isRunning) {
//            update();
//            render();
//            draw();
//        }
    }

    public void gameLoop() {
        // restrict number of updates and render
        final double GAME_HERTZ = 60.0;
        final double TIME_BEFORE_UPDATE = 1000000000 / GAME_HERTZ;

        final int MOST_UPDATE_BEFORE_RENDER = 5;

        double lastUpdateTime = System.nanoTime(); //10^-9
        double lastRenderTime;

        final double TARGET_FPS = 60;
        final double TOTAL_TIME_BEFORE_RENDER = 1000000000 / TARGET_FPS;

        //fps counter
        int currentFrameCount = 0;
        int lastSecondTime = (int) (lastUpdateTime / 1000000000);
        int previousFrameCount = 0;

        while (isRunning) {
            double now = System.nanoTime(); //current time
            int updateCount = 0;
            while (((now - lastUpdateTime) > TIME_BEFORE_UPDATE) && (updateCount < MOST_UPDATE_BEFORE_RENDER)) {
                update();
                input(keyHandler);
                lastUpdateTime += TIME_BEFORE_UPDATE;
                updateCount ++;
            }

            if (now - lastUpdateTime > TIME_BEFORE_UPDATE) {
                lastUpdateTime = now - TIME_BEFORE_UPDATE;
            }
            input(keyHandler);
            render();
            draw();
            lastRenderTime = now;
            currentFrameCount++;

            int thisSecond = (int) (lastUpdateTime / 1000000000);
            if (thisSecond > lastSecondTime) {
                //display current frame rate when frame count changes
                if(currentFrameCount != previousFrameCount) {

                    System.out.println("NEW SECOND: " + thisSecond + ", FRAME COUNT: " + currentFrameCount);
                    previousFrameCount = currentFrameCount;
                }

                currentFrameCount = 0;
                lastSecondTime = thisSecond;
            }

            while (now - lastRenderTime < TOTAL_TIME_BEFORE_RENDER && now - lastUpdateTime < TIME_BEFORE_UPDATE){
                Thread.yield();
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    System.out.println("ERROR: yielding thread");
                }
                now = System.nanoTime();
            }
        }
    }

    private void input(KeyHandler keyHandler) {
        stateManager.input(keyHandler);
    }

    public void update(){
        stateManager.update();
    }

    public void render(){
        if( graphics2D != null) {
            // background
            graphics2D.setColor(new Color(0,0,0)); // black
            graphics2D.fillRect(0,0,width,height);
            stateManager.render(graphics2D);
        }

    }

    public void draw(){
        Graphics g = (Graphics) this.getGraphics();
        g.drawImage(image, 0, 0, width, height, null);
        g.dispose();
    }
}
