package assignment3815ICT.zhiyuan.game.map;

import assignment3815ICT.zhiyuan.game.GameHandler;
import assignment3815ICT.zhiyuan.game.gameGraphics.GameObject;
import assignment3815ICT.zhiyuan.game.tiles.BackgroundTile;
import assignment3815ICT.zhiyuan.game.tiles.Tile;
import assignment3815ICT.zhiyuan.game.utils.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Map {
    private GameHandler gameHandler;
    private int mapWidth, mapHeight; // measure in tiles
    private int[][] tiles; //[x][y]
    private int spawnX, spawnY;
    private ArrayList<Tile> tileObjects = new ArrayList<>();

    public Map(GameHandler gameHandler, String path) {
        this.gameHandler = gameHandler;
        loadObjectTiles();
        loadMap(path);
    }

    private void loadObjectTiles() {
        ArrayList<BufferedImage> gameObjects = GameObject.getGameObjects();
        for(int i = 0; i < gameObjects.size(); i++) {
            Tile tile = new Tile(gameObjects.get(i), i);
            tileObjects.add(tile);
        }
    }

    private void loadMap(String path) {
        String file = Utils.loadFileAsString(path);

        //split space
        String[] chars = file.split("\\s+");
        mapWidth = Utils.parseInt(chars[0]);
        mapHeight = Utils.parseInt(chars[1]);
        spawnX = Utils.parseInt(chars[2]);
        spawnY = Utils.parseInt(chars[3]);

        //map data
        tiles = new int[mapWidth][mapHeight];
        for(int y = 0; y < mapHeight; y++) {
            for(int x = 0; x < mapWidth; x++) {
                tiles[x][y] = Utils.parseInt(chars[(x + y * mapWidth) + 4]);
            }
        }

    }

    public Tile getTile(int x, int y) {
        // check do not let player outside of map
        if(x < 0 || y < 0 || x >= mapWidth || y >= mapHeight) return new BackgroundTile(0);

        Tile tile = Tile.tileObjects[tiles[x][y]];
        if(tile == null) {
            return new BackgroundTile(0);
        }
        return tile;
    }

    public ArrayList<Tile> getTileObjects() {
        return tileObjects;
    }

    public void update() {}
    public void render(Graphics graphics) {
        for(int y = 0; y < mapHeight; y ++) {
            for(int x = 0; x < mapWidth; x ++){
                getTile(x, y).render(graphics, x * Tile.TILE_WIDTH, y * Tile.TILE_HEIGHT);
            }
        }
    }
}
