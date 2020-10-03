package assignment3815ICT.zhiyuan.game;

import assignment3815ICT.zhiyuan.game.graphics.display.GameFont;
import assignment3815ICT.zhiyuan.game.graphics.map.Map;
import assignment3815ICT.zhiyuan.game.graphics.sprite.GameObject;
import assignment3815ICT.zhiyuan.game.inputs.KeyManager;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameHandler {
    private Game game;
    private Map map;
    private GameObject gameObject;
    // initialise game objects
    private ArrayList<BufferedImage> playerObjects, mapObjects, itemObjects, fontObjects, ghostObjects;
    private GameFont gameFont;

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
    }

    public void setGame(Game game) {
        this.game = game;
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
}
