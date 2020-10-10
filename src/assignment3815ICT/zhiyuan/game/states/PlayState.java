package assignment3815ICT.zhiyuan.game.states;

import assignment3815ICT.zhiyuan.game.GameHandler;
import assignment3815ICT.zhiyuan.game.graphics.map.Map;

import java.awt.*;

public class PlayState extends State {

    private Map map;

    // constructor
    public PlayState(GameHandler gameHandler) {
        super(gameHandler);
        map = new Map(gameHandler,"res/map.txt");
        gameHandler.setMap(map);
    }

    @Override
    public void update() {
        map.update();
    }

    @Override
    public void render(Graphics graphics) {
        map.render(graphics);
    }
}
