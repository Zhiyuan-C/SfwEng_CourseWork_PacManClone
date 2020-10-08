package assignment3815ICT.zhiyuan.game.buttons;

import assignment3815ICT.zhiyuan.game.GameHandler;

public class LevelButton extends UIButton{

    private int level;

    public LevelButton(GameHandler gameHandler, int level, float xPos, float yPos) {
        super(gameHandler, xPos, yPos);
        this.level = level;
        displayMessage = "Lv" + level;
    }

    @Override
    public void update() {
        if(active) gameHandler.setLevel(level);
    }
}
