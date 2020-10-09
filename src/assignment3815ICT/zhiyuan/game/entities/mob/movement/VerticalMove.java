package assignment3815ICT.zhiyuan.game.entities.mob.movement;

import assignment3815ICT.zhiyuan.game.entities.mob.ghosts.Ghost;

public abstract class VerticalMove extends Move{
    public VerticalMove(Ghost ghost, int mapTileWidth, int mapTileHeight, int tileWidth, int tileHeight) {
        super(ghost, mapTileWidth, mapTileHeight, tileWidth, tileHeight);
    }

    @Override
    protected void checkMove(float xPos, float yPos, float targetX, float targetY, int delta) {
        this.xPos = xPos;
        this.yPos = yPos;
        int newTileY;
        currentTileX = (int) xPos / tileWidth;
        currentTileY = (int) yPos / tileHeight;
        newTileY = currentTileY + delta;

        offsetX = 0;
        offsetY = newTileY * tileHeight - yPos;

        movable = !ghost.isWallCollide(offsetX, offsetY);
        if(delta > 0) checkingLength = mapTileHeight - (currentTileY + delta);
        else checkingLength = currentTileY + delta;
        if(movable) {
            // set center position for the tile above
            int targetXtile = (int) targetX / tileWidth;
            int targetYtile = (int) targetY / tileHeight;
            newPosX = currentTileX;
            newPosY = newTileY;
            // get distance
            checkDistance(targetXtile, targetYtile);
            // get movable tiles
            checkMovableTiles(delta);
        }
    }

    @Override
    protected void checkMovableTiles(int delta) {
        int tempTileY;
        float tempOffsetY;
        int count = 0;
        if(delta > 0) tempTileY = currentTileY + delta;
        else tempTileY = checkingLength;
        for(int i = 0; i < checkingLength; i ++) {
            if(delta > 0) tempOffsetY = (tempTileY + i) * tileHeight - yPos;
            else tempOffsetY = (tempTileY - i) * tileHeight - yPos;
            if(ghost.isWallCollide(0, tempOffsetY)) { // if wall exists
                movableTiles = count;
                break;
            } else {
                count ++;
            }
        }
    }
    @Override
    protected void listener() {
        // checking for up and down
        Move up = ghost.checkUp();
        Move down = ghost.checkDown();

        if(changeMove(up)) {
            // call ghost to move up
//            System.out.println("go up");
            ghost.setDirection(1);
        }

        if(changeMove(down)) {
            // call ghost to move down
//            System.out.println("go down");
            ghost.setDirection(3);
        }
    }

    @Override
    protected boolean changeMove(Move move) {
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
