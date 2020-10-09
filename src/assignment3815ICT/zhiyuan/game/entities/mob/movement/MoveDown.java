package assignment3815ICT.zhiyuan.game.entities.mob.movement;

import assignment3815ICT.zhiyuan.game.entities.mob.ghosts.Ghost;

public class MoveDown extends VerticalMove{
    public MoveDown(Ghost ghost, int mapTileWidth, int mapTileHeight, int tileWidth, int tileHeight) {
        super(ghost, mapTileWidth, mapTileHeight, tileWidth, tileHeight);
    }
    @Override
    public void checkMovable(float xPos, float yPos, float targetX, float targetY) {
        checkMove(xPos, yPos, targetX, targetY, 1);
    }

    @Override
    public void move() {
        if (movable) {
            System.out.println("going down");
            float ghostY = ghost.getyPos();
            ghost.setyPos(ghostY += 1);
        } else {
            movableTiles = 0;
            if (ghost.getCurrentDirection() == 3) {
                Move up = ghost.checkUp();
                if(up.isMovable()) ghost.setDirection(1);
            }
        }
        listener();
    }



}
