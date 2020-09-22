package assignment3815ICT.zhiyuan.game.states;

import assignment3815ICT.zhiyuan.game.GameHandler;
import assignment3815ICT.zhiyuan.game.entities.mob.PacMan;
import assignment3815ICT.zhiyuan.game.graphics.map.Map;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayState extends State {

    private PacMan pacMan;
    private Map map;

    // constructor
    public PlayState(GameHandler gameHandler) {
        super(gameHandler);
        map = new Map(gameHandler,"res/map.txt");
        gameHandler.setMap(map);
        pacMan = new PacMan(gameHandler, 645, 356);

    }

    @Override
    public void update() {
        map.update();
        pacMan.update();
    }

    @Override
    public void render(Graphics graphics) {
        map.render(graphics);
        pacMan.render(graphics);
//        pacMan.move();
    }
}
