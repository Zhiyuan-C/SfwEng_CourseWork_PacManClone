package assignment3815ICT.zhiyuan.game.states;

import assignment3815ICT.zhiyuan.game.GameHandler;
import assignment3815ICT.zhiyuan.game.buttons.*;
import assignment3815ICT.zhiyuan.game.graphics.display.GameFont;

import java.awt.*;
import java.util.ArrayList;

public class MenuState extends State{
    private StartButton startButton;
    private LevelButton levelButton1, levelButton2, levelButton3;
    private GameFont gameFont;
    private int fontWidth, fontHeight;
    private int initialPosY, boarderHeight;
    private int optionPos1, optionPos2, optionPos3, optionPos4;
    private int optionIndex1, optionIndex2, optionIndex3;
    private String optionMsg1, optionMsg2, optionMsg3;
    private ArrayList<UIButton> buttons;
    private ArrayList<UIButton> levelButtons, lifeButtons, timeButtons;
    private boolean configuration;
    private int selectOptionX, selectOptionY;
    private boolean pressed;
    private long startTime;
    private int upNum, downNum, leftNum, rightNum;
    private int key;

    public MenuState(GameHandler gameHandler) {
        super(gameHandler);
        gameFont = gameHandler.getGameFont();
        buttons = new ArrayList<>();
        levelButtons = new ArrayList<>();
        lifeButtons = new ArrayList<>();
        timeButtons = new ArrayList<>();
        displayPosInit();
        configuration = false;
        selectOptionX = 0;
        selectOptionY = 0;
        key = 0;

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
        if (!configuration && gameHandler.getKeyManager().down || gameHandler.getKeyManager().up) {
            configuration = true;
            startButton.setActive(false);
        }
        if(configuration) {
            if(gameHandler.getKeyManager().up) key = 1;
            if(gameHandler.getKeyManager().down) key = 2;
            if(gameHandler.getKeyManager().left) key = 3;
            if(gameHandler.getKeyManager().right) key = 4;

//            System.out.println(gameHandler.getKeyManager().count);
            if(key == 1) {
                upNum = gameHandler.getKeyManager().count;
//                System.out.println(upNum);
//                if(selectOptionY == 0) selectOptionY = 1;
                if(upNum == 1) {
                    if (selectOptionY == 1) {
                        selectOptionY = 0;
                    } else if (selectOptionY == 2) {
                        selectOptionY = 1;
                    }

                }
//                if(upNum == 2 && selectOptionY == 2) selectOptionY = 0;
            }
            if(key == 2) {
                downNum = gameHandler.getKeyManager().count;
//                if(downNum == 1 && selectOptionY == 0) selectOptionY = 1;
//                if(downNum == 2 && selectOptionY == 1) selectOptionY = 2;
                if (downNum > 0 && downNum < 3) selectOptionY = downNum;
            }
            System.out.println("selection: " + selectOptionY);


            if (key == 4) {
                if(gameHandler.getKeyManager().count > 0 && gameHandler.getKeyManager().count < 4) {
                    selectOptionX = gameHandler.getKeyManager().count - 1;
                    selectOption(levelButtons, selectOptionX);
                }

            }
//            System.out.println(selectOptionX);
//            if(selectOptionY() == 0) {
//                optionIndex1 = getOptionIndex();
//                selectOptionX(levelButtons, optionIndex1);
//            } else if(selectOptionY() == 1) {
//                optionIndex2 = getOptionIndex();
//                selectOptionX(lifeButtons, optionIndex2);
//            } else if(selectOptionY() == 2) {
//                selectOptionX = 0;
//                optionIndex3 = getOptionIndex();
//                selectOptionX(timeButtons, optionIndex2);
//            }
        }


    }
    private void selectOption(ArrayList<UIButton> selectButtons, int indexVal) {
        for(int i = 0; i < 3; i ++) {
            if(indexVal == i) {
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
