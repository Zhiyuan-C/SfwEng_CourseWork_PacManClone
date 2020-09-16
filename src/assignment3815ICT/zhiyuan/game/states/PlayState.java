package assignment3815ICT.zhiyuan.game.states;

import assignment3815ICT.zhiyuan.game.Game;
import assignment3815ICT.zhiyuan.game.GameHandler;
import assignment3815ICT.zhiyuan.game.entities.mob.PacMan;
import assignment3815ICT.zhiyuan.game.map.Map;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayState extends State {

    private PacMan pacMan;
    private Map map;

    // constructor
    public PlayState(GameHandler gameHandler) {
        super(gameHandler);
        map = new Map(gameHandler,"res/map.txt");
        pacMan = new PacMan(gameHandler, 640, 360-8);

    }

    @Override
    public void update() {
        map.update();
        pacMan.update();
    }

    @Override
    public void render(Graphics graphics, BufferedImage gameObject) {
        map.render(graphics);
        pacMan.render(graphics, gameObject);
//        pacMan.move();
    }
}
