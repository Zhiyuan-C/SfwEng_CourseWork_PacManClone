package assignment3815ICT.zhiyuan.game;

import assignment3815ICT.zhiyuan.game.graphics.map.Map;
import assignment3815ICT.zhiyuan.game.inputs.KeyManager;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameHandler {
    private Game game;
    private Map map;

    public GameHandler(Game game) {
        this.game = game;
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
        return game.getPlayerObjects();
    }

    public ArrayList<BufferedImage> getMapObjects() {
        return game.getMapObjects();
    }

    public ArrayList<BufferedImage> getItemObjects() {
        return game.getItemObjects();
    }
}
