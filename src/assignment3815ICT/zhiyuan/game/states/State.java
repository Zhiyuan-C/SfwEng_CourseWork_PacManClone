package assignment3815ICT.zhiyuan.game.states;

import assignment3815ICT.zhiyuan.game.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class State {
    protected Game game;

    public State(Game game) {
        this.game = game;
    }
    public abstract void update();
    public abstract void render(Graphics graphics, BufferedImage gameObject);
}
