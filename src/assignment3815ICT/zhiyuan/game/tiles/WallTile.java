package assignment3815ICT.zhiyuan.game.tiles;

import assignment3815ICT.zhiyuan.game.graphics.sprite.GameObject;

public class WallTile extends Tile{
    public WallTile(int tile, int TILE_ID) {
        super(GameObject.getGameObjects().get(tile), TILE_ID);
    }
    @Override
    public boolean isWall() {
        return true;
    }
}
