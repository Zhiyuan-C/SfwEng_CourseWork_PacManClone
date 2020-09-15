package assignment3815ICT.zhiyuan.game.states;

public class StateManager {
    private static State currentState = null;

    public static void setState(State state) {
        currentState = state;
    }

    public static State getCurrentState() {
        return currentState;
    }
}
