package assignment3815ICT.zhiyuan.game.entities.mob.movement;

import assignment3815ICT.zhiyuan.game.entities.mob.ghosts.Ghost;

public class MoveLeft extends HorizontalMove{
    public MoveLeft(Ghost ghost, int mapTileWidth, int mapTileHeight, int tileWidth, int tileHeight) {
        super(ghost, mapTileWidth, mapTileHeight, tileWidth, tileHeight);
    }
    @Override
    public void checkMovable(float xPos, float yPos, float targetX, float targetY) {
        checkMove(xPos, yPos, targetX, targetY, -1);
    }

    @Override
    public void move() {
        if (movable) {
            float ghostX = ghost.getxPos();
            ghost.setxPos(ghostX -= 1);
        } else {
            movableTiles = 0;
        }
        listener();
    }


}
