package assignment3815ICT.zhiyuan.game.entities.mob.movement;

import assignment3815ICT.zhiyuan.game.entities.mob.ghosts.Ghost;

public abstract class HorizontalMove extends Move{
    public HorizontalMove(Ghost ghost, int mapTileWidth, int mapTileHeight, int tileWidth, int tileHeight) {
        super(ghost, mapTileWidth, mapTileHeight, tileWidth, tileHeight);
    }

    @Override
    protected void checkMove(float xPos, float yPos, float targetX, float targetY, int delta) {

    }

    @Override
    protected void checkMovableTiles(int delta) {

    }
}
