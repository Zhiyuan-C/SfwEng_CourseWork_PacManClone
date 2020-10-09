package assignment3815ICT.zhiyuan.game.entities.mob.movement;

import assignment3815ICT.zhiyuan.game.entities.mob.ghosts.Ghost;

public class MoveRight extends HorizontalMove{
    boolean isMoving;
    boolean moved;
    public MoveRight(Ghost ghost, int mapTileWidth, int mapTileHeight, int tileWidth, int tileHeight) {
        super(ghost, mapTileWidth, mapTileHeight, tileWidth, tileHeight);
    }

    @Override
    public void checkMovable(float xPos, float yPos, float targetX, float targetY) {
        checkMove(xPos, yPos, targetX, targetY, 1);
    }

    public void move() {
        int nextTile;
        if (movable) {
            float ghostX = ghost.getxPos();
            ghost.setxPos(ghostX += 1);
        } else {
            movableTiles = 0;
        }
        listener();

    }

    public void listener() {
        // checking for up and down
        Move up = ghost.checkUp();
        Move down = ghost.checkDown();

        if(changeMove(up)) {
            // call ghost to move up
            System.out.println("go up");
        }

        if(changeMove(down)) {
            // call ghost to move down
            System.out.println("go down");
        }
    }

    private boolean changeMove(Move move) {
        // if up is movable
        if (move.isMovable()) {
            // if distance is less
            if (move.distance < distance) {
                return true;
            } else if(move.distance == distance) {
                // check which one have higher movable tiles
                if(move.getMovableTiles() > movableTiles) {
                    return true;
                }
            }
        }
        return false;
    }
}
