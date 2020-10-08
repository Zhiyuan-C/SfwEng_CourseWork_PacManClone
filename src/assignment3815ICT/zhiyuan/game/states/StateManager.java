package assignment3815ICT.zhiyuan.game.states;

import assignment3815ICT.zhiyuan.game.GameHandler;

public class StateManager {
    private State currentState = null;
    private GameHandler gameHandler;

    public StateManager(GameHandler gameHandler) {
        this.gameHandler = gameHandler;
    }

    public void setPlayState() {
        this.currentState = new PlayState(gameHandler);
    }

    public void setGameOverState() {
        this.currentState = new GameOverState(gameHandler);
    }

    public void setMenuState() {
        this.currentState = new MenuState(gameHandler);

    }

    public void setState(State state) {
        currentState = state;
    }

    public State getCurrentState() {
        return currentState;
    }
}
