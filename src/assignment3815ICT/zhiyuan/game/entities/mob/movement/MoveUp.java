package assignment3815ICT.zhiyuan.game.entities.mob.movement;

import assignment3815ICT.zhiyuan.game.entities.mob.ghosts.Ghost;

public class MoveUp extends VerticalMove{


    public MoveUp(Ghost ghost, int mapTileWidth, int mapTileHeight, int tileWidth, int tileHeight) {
        super(ghost, mapTileWidth, mapTileHeight, tileWidth, tileHeight);
    }

    @Override
    public void move() {
        if (movable) {
            System.out.println("going up");
            float ghostY = ghost.getyPos();
            ghost.setyPos(ghostY -= 1);
        } else {
            movableTiles = 0;
//            System.out.println(movable);
        }
        listener();
    }

    @Override
    public void checkMovable(float xPos, float yPos, float targetX, float targetY) {
        checkMove(xPos, yPos, targetX, targetY, -1);
    }

}
