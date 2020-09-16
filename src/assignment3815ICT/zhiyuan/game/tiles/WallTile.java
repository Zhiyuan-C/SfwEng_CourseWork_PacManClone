package assignment3815ICT.zhiyuan.game.tiles;

import assignment3815ICT.zhiyuan.game.gameGraphics.GameObject;

import java.awt.image.BufferedImage;

public class WallTile extends Tile{
    public WallTile(int tile, int TILE_ID) {
        super(GameObject.getGameObjects().get(tile), TILE_ID);
    }
    @Override
    public boolean isWall() {
        return true;
    }
}
