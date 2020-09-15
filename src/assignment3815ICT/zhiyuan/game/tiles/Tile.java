package assignment3815ICT.zhiyuan.game.tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {
    private static final int TOTAL_TILES = 256; // 16 * 16, total tiles on the sprite sheet

    public static Tile[] tiles = new Tile[TOTAL_TILES];

    public static final int TILE_WIDTH = 32, TILE_HEIGHT = 32;

    protected BufferedImage tileImage;
    protected final int TILE_ID;

    public Tile(BufferedImage tileImage, int TILE_ID) {
        this.tileImage = tileImage;
        this.TILE_ID = TILE_ID;

        tiles[TILE_ID] = this;
    }

    public void update() {

    }

    public void render(Graphics graphics, int xPos, int yPos) {
        graphics.drawImage(tileImage, xPos, yPos, TILE_WIDTH, TILE_HEIGHT, null);
    }

    // check if is wall tile, default false
    public boolean isWall() {
        return false;
    }

    public int getTileId() {
        return TILE_ID;
    }

}
