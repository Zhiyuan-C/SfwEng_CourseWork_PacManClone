package assignment3815ICT.zhiyuan.game;

import assignment3815ICT.zhiyuan.game.display.GameWindow;

public class Game implements Runnable{
    // hold everything base game

    private GameWindow gameWindow;

    public String title;
    public int width, height;

    private Thread thread;
    private boolean isRunning = false;

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
    }

    // initialise all the graphics for the game
    private void init() {
        gameWindow = new GameWindow(title, width, height);
    }

    // update game
    private void update() {}

    // render game
    private void render() {}

    @Override
    public void run() {
        init();
        // game loop
        while (isRunning) {
            update();
            render();
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
}
