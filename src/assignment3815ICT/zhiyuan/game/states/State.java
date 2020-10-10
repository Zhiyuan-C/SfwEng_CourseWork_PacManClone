package assignment3815ICT.zhiyuan.game.states;

import assignment3815ICT.zhiyuan.game.GameHandler;

import java.awt.*;

public abstract class State {
    protected GameHandler gameHandler;

    public State(GameHandler gameHandler) {
        this.gameHandler = gameHandler;
    }
    public abstract void update();
    public abstract void render(Graphics graphics);
}
