package assignment3815ICT.zhiyuan.game.tiles;


import assignment3815ICT.zhiyuan.game.gameGraphics.GameObject;

public class BackgroundTile extends Tile{
    public BackgroundTile(int TILE_ID) {
        super(GameObject.getGameObjects().get(0), TILE_ID);
    }
}
