package assignment3815ICT.zhiyuan.game;

import assignment3815ICT.zhiyuan.game.display.GameWindow;
import assignment3815ICT.zhiyuan.game.gameGraphics.Sprite;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable{
    // hold everything base game

    private GameWindow gameWindow;

    public String title;
    public int width, height;

    private Thread thread;
    private boolean isRunning = false;

    // initialise drawing things for render
    private BufferStrategy bufferStrategy; // normally bs
    private Graphics graphics; // normally g

    // prepare sprite sheet
    private BufferedImage image; // if only used in one place, then move into method
    private Sprite spriteSheet;

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
    }

    // initialise all the graphics for the game
    private void init() {
        gameWindow = new GameWindow(title, width, height);

        spriteSheet = new Sprite("/spriteSheetForPacMan.png");

    }

    // update game
    private void update() {}

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
        BufferedImage testImage = spriteSheet.getSpriteSheet();
        BufferedImage testImage2 = spriteSheet.getSpriteTileImage(16,0,16,16);
        graphics.drawImage(testImage2,0,0,null);

        // finish drawing. start display to screen
        bufferStrategy.show();
        graphics.dispose();
    }

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
