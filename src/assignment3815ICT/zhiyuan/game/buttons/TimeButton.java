package assignment3815ICT.zhiyuan.game.buttons;

import assignment3815ICT.zhiyuan.game.GameHandler;

public class TimeButton extends UIButton{
    private int time;
    private int defaultTime = 5;

    public TimeButton(GameHandler gameHandler, int time, float xPos, float yPos) {
        super(gameHandler, xPos, yPos);
        this.time = time;
        displayMessage = time + "sec";
    }

    @Override
    public void update() {
        if(active && defaultTime != time) {
            gameHandler.setBoostingTime(time);
            defaultTime = time;
        }
    }
}
