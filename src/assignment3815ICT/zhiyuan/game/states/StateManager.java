package assignment3815ICT.zhiyuan.game.states;

import assignment3815ICT.zhiyuan.game.GamePanel;
import assignment3815ICT.zhiyuan.game.gameGraphics.Vector2f;
import assignment3815ICT.zhiyuan.game.userInteractions.KeyHandler;

import java.awt.*;
import java.util.ArrayList;

public class StateManager {

    public static final int PLAY = 0;
    public static final int GAMEOVER = 1;

    public static Vector2f map;

    private ArrayList<State> states;

    public StateManager() {
        map = new Vector2f(GamePanel.width, GamePanel.height);
        Vector2f.setWorldVariable(map.x, map.y);

        states = new ArrayList<State>();
        states.add(new Play(this));
    }

    public void removeState(int state) { states.remove(state); }

    public void addState(int state) {
        if(state == PLAY) states.add(new Play(this));
        if(state == GAMEOVER) states.add(new GameOver(this));
    }

    // ensure we do duplicate adding state, if state already exist, remove
    public void addAndRemove(int state) {
        states.remove(0);
        addState(state);
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
