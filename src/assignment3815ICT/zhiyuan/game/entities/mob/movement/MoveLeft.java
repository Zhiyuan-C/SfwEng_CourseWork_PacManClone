package assignment3815ICT.zhiyuan.game.entities.mob.movement;

import assignment3815ICT.zhiyuan.game.entities.mob.ghosts.Ghost;

public class MoveLeft extends HorizontalMove{
    public MoveLeft(Ghost ghost, int mapTileWidth, int mapTileHeight, int tileWidth, int tileHeight) {
        super(ghost, mapTileWidth, mapTileHeight, tileWidth, tileHeight);
    }

    @Override
    public void checkMovable(float xPos, float yPos, float targetX, float targetY) {
//        this.xPos = xPos;
//        this.yPos = yPos;
//        currentTileX = (int) xPos / tileWidth;
//        currentTileY = (int) yPos / tileHeight;
//
//        int newTileX;
//        newTileX = currentTileX + delta;
//
//        offsetX = newTileX * tileWidth - xPos;
//        offsetY = 0;
//
//        movable = !ghost.isWallCollide(offsetX, offsetY);
//        checkingLength = currentTileX + (delta * 2);
    }
}
