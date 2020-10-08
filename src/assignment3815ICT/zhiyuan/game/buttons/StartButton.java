package assignment3815ICT.zhiyuan.game.buttons;

import assignment3815ICT.zhiyuan.game.GameHandler;

import java.awt.*;

public class StartButton extends UIButton{

    public StartButton(GameHandler gameHandler, float xPos, float yPos) {
        super(gameHandler, xPos, yPos);
        displayMessage = "Start new game";
    }

    @Override
    public void update() {
        if(active && gameHandler.getKeyManager().enter) gameHandler.setPlayState();
    }

}
