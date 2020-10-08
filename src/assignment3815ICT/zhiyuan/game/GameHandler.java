package assignment3815ICT.zhiyuan.game;

import assignment3815ICT.zhiyuan.game.entities.EntityManager;
import assignment3815ICT.zhiyuan.game.graphics.display.GameFont;
import assignment3815ICT.zhiyuan.game.graphics.map.Map;
import assignment3815ICT.zhiyuan.game.graphics.sprite.GameObject;
import assignment3815ICT.zhiyuan.game.inputs.KeyManager;
import assignment3815ICT.zhiyuan.game.states.GameOverState;
import assignment3815ICT.zhiyuan.game.states.PlayState;
import assignment3815ICT.zhiyuan.game.states.State;
import assignment3815ICT.zhiyuan.game.states.StateManager;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameHandler {
    private Game game;
    private Map map;
    private GameObject gameObject;
    // initialise game objects
    private ArrayList<BufferedImage> playerObjects, mapObjects, itemObjects, fontObjects, ghostObjects;
    private GameFont gameFont;
    private EntityManager entityManager;
    private StateManager stateManager;
    private int score;
    private int lifeNum;
    private int boostingTime;
    private int level;

    public GameHandler(Game game) {
        this.game = game;
        // load game object
        gameObject = new GameObject();
        playerObjects = gameObject.getPlayerObjects();
        mapObjects = gameObject.getMapObjects();
        itemObjects = gameObject.getItemObjects();
        ghostObjects = gameObject.getGhostObjects();
        // load fonts
        fontObjects = gameObject.getFontObjects();
        gameFont = new GameFont(fontObjects);
        stateManager = new StateManager(this);
        score = 0;
        lifeNum = 3;
        boostingTime = 10;
        level = 1;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void setPlayState() {
        stateManager.setPlayState();
    }

    public void setGameOverState() {
        stateManager.setGameOverState();
    }
    public void setMenuState() {
        stateManager.setMenuState();

    }

    public StateManager getStateManager() {
        return stateManager;
    }

    public Game getGame() {
        return game;
    }

    public int getGameWidth() {
        return game.getWidth();
    }

    public int getGameHeight() {
        return game.getHeight();
    }

    public KeyManager getKeyManager() {
        return game.getKeyManager();
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }


    public ArrayList<BufferedImage> getPlayerObjects() {
        return playerObjects;
    }

    public ArrayList<BufferedImage> getMapObjects() {
        return mapObjects;
    }

    public ArrayList<BufferedImage> getItemObjects() {
        return itemObjects;
    }

    public ArrayList<BufferedImage> getGhostObjects() {
        return ghostObjects;
    }

    public GameFont getGameFont() {
        return gameFont;
    }

    public int getTILE_WIDTH() {
        return map.getTILE_WIDTH();
    }

    public int getTILE_HEIGHT() {
        return map.getTILE_HEIGHT();
    }

    public int getMapWidth() {
        return map.getMapWidth();
    }

    public int getMapHeight() {
        return map.getMapHeight();
    }

    public GameObject getGameObject() {
        return gameObject;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLifeNum() {
        return lifeNum;
    }

    public void setLifeNum(int lifeNum) {
        this.lifeNum = lifeNum;
    }

    public int getBoostingTime() {
        return boostingTime;
    }

    public void setBoostingTime(int boostingTime) {
        this.boostingTime = boostingTime;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
