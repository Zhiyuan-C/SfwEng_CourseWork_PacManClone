package assignment3815ICT.zhiyuan.game.entities.mob.movement;

import assignment3815ICT.zhiyuan.game.entities.mob.ghosts.Ghost;

public class MoveUp extends VerticalMove{


    public MoveUp(Ghost ghost, int mapTileWidth, int mapTileHeight, int tileWidth, int tileHeight) {
        super(ghost, mapTileWidth, mapTileHeight, tileWidth, tileHeight);
    }

    @Override
    public void checkMovable(float xPos, float yPos, float targetX, float targetY) {
        checkMove(xPos, yPos, targetX, targetY, -1);
    }

}
