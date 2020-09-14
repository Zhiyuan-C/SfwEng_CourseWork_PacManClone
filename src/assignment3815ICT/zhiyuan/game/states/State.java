package assignment3815ICT.zhiyuan.game.states;

import assignment3815ICT.zhiyuan.game.userInteractions.KeyHandler;

import java.awt.*;

public abstract class State {

    private StateManager stateManager;

    public State(StateManager stateManager){
        this.stateManager = stateManager;
    }

    public abstract void update();
    public abstract void input(KeyHandler keyHandler);
    public abstract void render(Graphics2D graphics2D);
}