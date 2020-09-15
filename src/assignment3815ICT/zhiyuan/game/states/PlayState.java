package assignment3815ICT.zhiyuan.game.states;

import assignment3815ICT.zhiyuan.game.Game;
import assignment3815ICT.zhiyuan.game.entities.mob.PacMan;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayState extends State {

    private PacMan pacMan;

    // constructor
    public PlayState(Game game) {
        super(game);
        pacMan = new PacMan(game, 640 - 16, 360 - 16);
    }

    @Override
    public void update() {
        pacMan.update();
    }

    @Override
    public void render(Graphics graphics, BufferedImage gameObject) {
        pacMan.render(graphics, gameObject);
        pacMan.move();
    }
}
