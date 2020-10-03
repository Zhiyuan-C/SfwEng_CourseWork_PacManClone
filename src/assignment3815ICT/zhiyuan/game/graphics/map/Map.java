package assignment3815ICT.zhiyuan.game.graphics.map;

import assignment3815ICT.zhiyuan.game.GameHandler;
import assignment3815ICT.zhiyuan.game.entities.EntityManager;
import assignment3815ICT.zhiyuan.game.utils.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Map {

    private final int TILE_WIDTH = Tile.TILE_WIDTH;
    private final int TILE_HEIGHT = Tile.TILE_HEIGHT;

    private GameHandler gameHandler;
    private int mapWidth, mapHeight; // measure in tiles
    private int[][] tiles; //[x][y]
    private int spawnX, spawnY;
    private int ghostSpawnX, ghostSpawnY;
    private ArrayList<BufferedImage> mapObjects = new ArrayList<>();
    private ArrayList<Tile> tileObjects = new ArrayList<>();
    private EntityManager entityManager;

    public Map(GameHandler gameHandler, String path) {
        this.gameHandler = gameHandler;
        entityManager = new EntityManager(gameHandler);
        Tile.setTileObjects(4 * 4);
        loadObjectTiles();
        loadMap(path);
        // spawn pacman
        entityManager.getPacMan().setxPos(spawnX);
        entityManager.getPacMan().setyPos(spawnY);
        // spawn ghsot
        //loadGhost();
    }

    private void loadObjectTiles() {
        mapObjects = gameHandler.getMapObjects();
        for(int i = 0; i < mapObjects.size(); i++) {
            Tile tile = new Tile(mapObjects.get(i), i);
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

        loadItem();

    }

    public Tile getTile(int x, int y) {
        // check do not let player outside of map
        Tile background = new Tile(mapObjects.get(0), 0);
        if(x < 0 || y < 0 || x >= mapWidth || y >= mapHeight) return background;

        Tile tile = Tile.tileObjects[tiles[x][y]];
        if(tile == null) {
            return background;
        }
        return tile;
    }

    private void loadItem() {
        int itemCount = 0;
        int randomNum = 100 + (int) (Math.random() * 260); // generate random fruit
        for(int y = 0; y < mapHeight; y ++) {
            for(int x = 0; x < mapWidth; x ++) {
                // position where pacman spwan
                if(x * Tile.TILE_WIDTH == spawnX && y * TILE_HEIGHT == spawnY) continue;
                // render items
                if (getTile(x, y).getTileId() == 1){
                    itemCount += 1;
                    if( itemCount == randomNum ) {
                        entityManager.addFruit(x * TILE_WIDTH, y * TILE_HEIGHT);
                    } else if ( itemCount % 15 < 1 ) {
                        entityManager.addFlowerLarge(x * TILE_WIDTH, y * TILE_HEIGHT);
                    } else {
                        entityManager.addFlowerSmall(x * TILE_WIDTH, y * TILE_HEIGHT);
                    }

                }
            }
        }
    }

    private void loadGhost() {
        for(int y = 0; y < mapHeight; y ++) {
            for(int x = 0; x < mapWidth; x ++) {
                if (getTile(x, y).getTileId() == 5) {
                    // add ghost to entityManager.addGhost
                }
            }
        }
    }

    public ArrayList<Tile> getTileObjects() {
        return tileObjects;
    }

    public void update() {
        entityManager.update();
    }
    public void render(Graphics graphics) {

        for(int y = 0; y < mapHeight; y ++) {
            for(int x = 0; x < mapWidth; x ++){
                getTile(x, y).render(graphics, x * TILE_WIDTH, y * TILE_HEIGHT);
            }
        }
        entityManager.render(graphics);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public int getTILE_WIDTH() {
        return TILE_WIDTH;
    }

    public int getTILE_HEIGHT() {
        return TILE_HEIGHT;
    }

    public int getMapWidth() {
        return mapWidth;
    }

    public int getMapHeight() {
        return mapHeight;
    }
}
