package assignment3815ICT.zhiyuan.game.states;

import assignment3815ICT.zhiyuan.game.userInteractions.KeyHandler;

import java.awt.*;
import java.util.ArrayList;

public class StateManager {

    private ArrayList<State> states;

    public StateManager() {
        states = new ArrayList<State>();

//        states.add();
    }

    public void update() {
        for (State state : states) {
            state.update();
        }

    }
    public void input(KeyHandler keyHandler) {
        for (State state : states) {
            state.input(keyHandler);
        }

    }
    public void render(Graphics2D graphics2D) {
        for (State state : states) {
            state.render(graphics2D);
        }
    }
}
