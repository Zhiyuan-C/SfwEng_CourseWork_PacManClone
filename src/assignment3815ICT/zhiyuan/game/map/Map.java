package assignment3815ICT.zhiyuan.game.map;

import assignment3815ICT.zhiyuan.game.tiles.BackgroundTile;
import assignment3815ICT.zhiyuan.game.tiles.Tile;

import java.awt.*;

public class Map {
    private int mapWidth, mapHeight; // measure in tiles
    private int[][] tiles; //[x][y]
    private int spawnX, spawnY;

    public Map(String path) {
        loadMap(path);
    }

    private void loadMap(String path) {

    }

    public Tile getTile(int x, int y) {
        Tile tile = Tile.tiles[tiles[x][y]];
        if(tile == null) {
            return new BackgroundTile(0);
        }
        return tile;
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
