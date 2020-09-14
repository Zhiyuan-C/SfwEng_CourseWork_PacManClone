package assignment3815ICT.zhiyuan.game.states;

import assignment3815ICT.zhiyuan.game.userInteractions.KeyHandler;

import java.awt.*;

public class Play extends State {

    public Play(StateManager stateManager) {
        super(stateManager);
    }

    @Override
    public void update() {

    }

    @Override
    public void input(KeyHandler keyHandler) {

    }

    @Override
    public void render(Graphics2D graphics2D) {
        graphics2D.setColor(Color.RED);
        graphics2D.fillRect(100,100,64,64);
    }
}
