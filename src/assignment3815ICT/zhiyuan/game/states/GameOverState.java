package assignment3815ICT.zhiyuan.game.states;

import assignment3815ICT.zhiyuan.game.GameHandler;
import assignment3815ICT.zhiyuan.game.buttons.StartButton;

import java.awt.*;

public class GameOverState extends State{
    private StartButton startButton;

    public GameOverState(GameHandler gameHandler) {
        super(gameHandler);

        startButton = new StartButton(gameHandler,
                gameHandler.getGameWidth() / 3.0f, gameHandler.getGameHeight() / 2.0f);
        startButton.setActive(true);
    }

    @Override
    public void update() {
        startButton.update();
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, gameHandler.getGameWidth(), gameHandler.getGameHeight());
        gameHandler.getGameFont().render(graphics,
                "Game Over",
                gameHandler.getGameWidth() / 3, gameHandler.getGameHeight() / 5,
                40, 40);
        gameHandler.getGameFont().render(graphics,
                "Highest score: " + gameHandler.getScore(),
                gameHandler.getGameWidth() / 4, gameHandler.getGameHeight() / 3,
                40, 40);
        startButton.render(graphics);
    }
}
