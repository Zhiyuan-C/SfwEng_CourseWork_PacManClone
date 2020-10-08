package assignment3815ICT.zhiyuan.game.buttons;

import assignment3815ICT.zhiyuan.game.GameHandler;
import assignment3815ICT.zhiyuan.game.graphics.display.GameFont;

import java.awt.*;

public abstract class UIButton {
    protected GameHandler gameHandler;
    protected float xPos, yPos;
    protected int width, height;
    protected GameFont gameFont;
    protected String displayMessage;
    protected boolean active;

    public UIButton(GameHandler gameHandler, float xPos, float yPos) {
        this.gameHandler = gameHandler;
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = 30;
        this.height = 30;
        gameFont = gameHandler.getGameFont();
        active = false;
    }

    public abstract void update();

    public void render(Graphics graphics) {
        if(active) {
            graphics.setColor(Color.WHITE);
            graphics.drawRoundRect((int) xPos - 5, (int) yPos - 5,
                    displayMessage.length() * width + 10, height + 10,
                    30, 30);
        }

        gameFont.render(graphics, displayMessage, (int) xPos, (int) yPos, width, height);
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
