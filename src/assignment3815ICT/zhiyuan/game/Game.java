package assignment3815ICT.zhiyuan.game;

import assignment3815ICT.zhiyuan.game.graphics.display.GameWindow;
import assignment3815ICT.zhiyuan.game.inputs.KeyManager;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable{
    // hold everything base game

    private GameWindow gameWindow;

    private String title;
    private int width, height;

    private Thread thread;
    private boolean isRunning = false;

    // initialise drawing things for render
    private BufferStrategy bufferStrategy;
    private Graphics graphics;

    private KeyManager keyManager;

    private GameHandler gameHandler;


    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager();
    }

    // initialise all the graphics for the game
    private void init() {
        gameWindow = new GameWindow(title, width, height);
        gameWindow.getFrame().addKeyListener(keyManager);

        // set handler
        gameHandler = new GameHandler(this);

        // set state
        gameHandler.setMenuState();
    }

    // update game
    private void update() {
        keyManager.update();

        if(gameHandler.getStateManager().getCurrentState() != null){
            gameHandler.getStateManager().getCurrentState().update();
        }
    }

    // render game - draw things to the display
    private void render() {
        bufferStrategy = gameWindow.getCanvas().getBufferStrategy(); // buffere strategy is a way computer use to draw things onto the screen
        // create buffer if not exist yet
        if(bufferStrategy == null) {
            gameWindow.getCanvas().createBufferStrategy(3); // no more than 3, maxmium is 3
            return;
        }

        graphics = bufferStrategy.getDrawGraphics(); // this is like to have paint brushes prepared ready to draw things onto canvas

        // clear screen every time rendering
        graphics.clearRect(0,0, width, height); // not sure if really need
        // begin drawing
//        graphics.drawImage(gameObjects.get(1), 0, 0, null);
        if(gameHandler.getStateManager().getCurrentState() != null) {
            gameHandler.getStateManager().getCurrentState().render(graphics);
        }
        // finish drawing. start display to screen
        bufferStrategy.show();
        graphics.dispose();
    }

    @Override
    public void run() {
        init();
        // variable for set up restrictions for how many times the update and render methods needs to run in 1 sec
        final int ONE_SEC = 1000000000; // 1000000000 nano sec = 1 sec;
        final double TARGET_FPS = 60; // frame per sec or tick per sec, how many times per sec we want every frame or update to run
        final double TIME_PER_UPDATE = ONE_SEC / TARGET_FPS; // time per update or time per tick; 1 / 60 => allow to have the maximum time that allow us to run 60 per sec goal
        double delta = 0;
        long now;
        long lastTime = System.nanoTime(); // amount of time in nano sec, current time of our computer in nanosec

        // variable for fps counter
        long timer = 0;
        int updateNum = 0; // fps rate
        int lastUpdateNum = 0;

        // game loop
        while (isRunning) {
            now = System.nanoTime();
            // how much time we have util we have to call the update and render method again, tells comuter when and when not to call the update and render methods
            delta += (now - lastTime) / TIME_PER_UPDATE; // amount of time passed / maximum time allowed to call the render and update method
            timer += now - lastTime;
            lastTime = now;

            if(delta >= 1) {
                update();
                render();
                updateNum ++;
                delta --;
            }

            // if timer is greater than 1 sec
            if( timer >= ONE_SEC) {
                if(lastUpdateNum != updateNum) System.out.println("Updates and Frames: " + updateNum);
                lastUpdateNum = updateNum;
                updateNum = 0;
                timer = 0;
            }

        }

        stop(); // in case not stop
    }

    // start thread
    public synchronized void start() {
        // if already running then just keep whatever running, not start new thread
        if(isRunning) return;
        isRunning = true;
        thread = new Thread(this); // run this class on new thread
        thread.start(); // call run()
    }

    // stop thread
    public synchronized void stop() {
        // check if already stopped
        if (!isRunning) return;
        isRunning = false;
        try {
            thread.join(); // stop thread safely
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
