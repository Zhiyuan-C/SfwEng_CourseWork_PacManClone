package assignment3815ICT.zhiyuan.game.buttons;

import assignment3815ICT.zhiyuan.game.GameHandler;

public class LifeButton extends UIButton {
    private int life;

    public LifeButton(GameHandler gameHandler, int life, float xPos, float yPos) {
        super(gameHandler, xPos, yPos);
        this.life = life;
        displayMessage = "" + life;
    }

    @Override
    public void update() {
        if(active) gameHandler.setLifeNum(life);
    }
}
