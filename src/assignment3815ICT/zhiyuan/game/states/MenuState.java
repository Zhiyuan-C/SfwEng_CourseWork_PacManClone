package assignment3815ICT.zhiyuan.game.states;

import assignment3815ICT.zhiyuan.game.GameHandler;
import assignment3815ICT.zhiyuan.game.buttons.*;
import assignment3815ICT.zhiyuan.game.graphics.display.GameFont;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class MenuState extends State{
    private StartButton startButton;
    private LevelButton levelButton1, levelButton2, levelButton3;
    private GameFont gameFont;
    private int fontWidth, fontHeight;
    private int initialPosY, boarderHeight;
    private int optionPos1, optionPos2, optionPos3, optionPos4;
    private int optionSizeY;
    private int optionIndexY;
    private int optionIndexX;
    private String optionMsg1, optionMsg2, optionMsg3;
    private ArrayList<UIButton> buttons;
    private ArrayList<UIButton> levelButtons, lifeButtons, timeButtons;
    private boolean configuration;
    private boolean once, twice;
    private boolean onceX, twiceX, leftOnceX;
    private int selectOptionXa, selectOptionXb, selectOptionXc;
    private boolean pressed;
    private long startTime;
    private int upNum, downNum, leftNum, rightNum;

    public MenuState(GameHandler gameHandler) {
        super(gameHandler);
        gameFont = gameHandler.getGameFont();
        buttons = new ArrayList<>();
        levelButtons = new ArrayList<>();
        lifeButtons = new ArrayList<>();
        timeButtons = new ArrayList<>();
        displayPosInit();
        configuration = false;
        optionSizeY = 4;

        startButton = new StartButton(gameHandler,
                gameHandler.getGameWidth() / 3.0f, optionPos4);
        startButton.setActive(true);
        buttons.add(startButton);

        loadLevelButtons();
        loadLifeButtons();
        loadTimeButtons();

    }

    private void displayPosInit() {
        initialPosY = 140;
        boarderHeight = 20;
        fontWidth = 30;
        fontHeight = 30;
        optionPos1 = initialPosY + fontHeight;
        optionPos2 = initialPosY + boarderHeight + fontHeight * 2;
        optionPos3 = initialPosY + boarderHeight * 2 + fontHeight * 3;
        optionPos4 = initialPosY + boarderHeight * 5 + fontHeight * 4;
        optionMsg1 = "Select level";
        optionMsg2 = "Select total life";
        optionMsg3 = "select boosting time";
    }

    private void loadLevelButtons() {
        for(int i = 1; i < 4; i ++) {
            float xPos = optionMsg1.length() * fontWidth + fontWidth * i * 4;
            LevelButton levelButton = new LevelButton(gameHandler, i, xPos, optionPos1);
            levelButtons.add(levelButton);
            buttons.add(levelButton);
        }
    }

    private void loadLifeButtons() {
        for(int i = 1; i < 4; i ++) {
            float xPos = optionMsg2.length() * fontWidth + fontWidth * i * 4;
            LifeButton lifeButton = new LifeButton(gameHandler, 1 + i * 2, xPos, optionPos2);
            lifeButtons.add(lifeButton);
            buttons.add(lifeButton);
        }
    }

    private void loadTimeButtons() {
        for(int i = 1; i < 4; i ++) {
            float xPos = optionMsg3.length() * fontWidth + fontWidth * i * (i + 2);
            TimeButton timeButton = new TimeButton(gameHandler, i * 5, xPos, optionPos3);
            timeButtons.add(timeButton);
            buttons.add(timeButton);
        }
    }

    @Override
    public void update() {
//        int count = 0;
        for(UIButton button: buttons) {
            button.update();
        }
        if (!configuration && gameHandler.getKeyManager().up) {
            configuration = true;
            startButton.setActive(false);
            optionIndexY = 0;
        }
        if(configuration) {
            if(gameHandler.getKeyManager().justPressedKey(38)) optionIndexY --;
            if(gameHandler.getKeyManager().justPressedKey(40)) optionIndexY ++;
            if(gameHandler.getKeyManager().justPressedKey(37)) optionIndexX --;
            if(gameHandler.getKeyManager().justPressedKey(39)) optionIndexX ++;
            if(optionIndexY < 0) {
                optionIndexY = 0;
            } else if(optionIndexY >= optionSizeY) {
                optionIndexY = optionSizeY - 1;
            }

            if(optionIndexY == 0) {
                selectOptionXa = getIndex(selectOptionXa);
                selectOption(levelButtons, selectOptionXa);
            } else if (optionIndexY == 1) {
                selectOptionXb = getIndex(selectOptionXb);
                selectOption(lifeButtons, selectOptionXb);
            } else if (optionIndexY == 2) {
                selectOptionXc = getIndex(selectOptionXc);
                selectOption(timeButtons, selectOptionXc);
            } else {
                configuration = false;
                startButton.setActive(true);
            }
        }
    }
    private int getIndex(int index) {
        if(gameHandler.getKeyManager().justPressedKey(37)) index --;
        if(gameHandler.getKeyManager().justPressedKey(39)) index ++;
        if(index < 0) {
            index = 0;
            return index;
        } else if(index >= 3) {
            index = 3 - 1;
            return index;
        }
        return index;
    }

    private void selectOption(ArrayList<UIButton> selectButtons, int index) {
        for(int i = 0; i < 3; i ++) {
            if(index == i) {
                selectButtons.get(i).setActive(true);
            } else {
                selectButtons.get(i).setActive(false);
            }
        }

    }



    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, gameHandler.getGameWidth(), gameHandler.getGameHeight());
        gameFont.render(graphics, "Pac-Man",gameHandler.getGameWidth() / 3 + 50, 20 + boarderHeight, 50, 50);

        gameFont.render(graphics, optionMsg1, 50, optionPos1, fontWidth, fontHeight);
        gameFont.render(graphics, optionMsg2, 50, optionPos2, fontWidth, fontHeight);
        gameFont.render(graphics, optionMsg3, 50, optionPos3, fontWidth, fontHeight);

        for(UIButton button: buttons) {
            button.render(graphics);
        }

    }
}
