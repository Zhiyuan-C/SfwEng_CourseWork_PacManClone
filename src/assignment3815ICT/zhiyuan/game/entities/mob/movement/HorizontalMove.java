package assignment3815ICT.zhiyuan.game.entities.mob.movement;

import assignment3815ICT.zhiyuan.game.entities.mob.ghosts.Ghost;

public abstract class HorizontalMove extends Move{
    public HorizontalMove(Ghost ghost, int mapTileWidth, int mapTileHeight, int tileWidth, int tileHeight) {
        super(ghost, mapTileWidth, mapTileHeight, tileWidth, tileHeight);
    }

    @Override
    protected void checkMove(float xPos, float yPos, float targetX, float targetY, int delta) {
        this.xPos = xPos;
        this.yPos = yPos;
        currentTileX = (int) xPos / tileWidth;
        currentTileY = (int) yPos / tileHeight;

        int newTileX;
        newTileX = currentTileX + delta;

        offsetX = newTileX * tileWidth - xPos;
        offsetY = 0;

        movable = !ghost.isWallCollide(offsetX, offsetY);
        if(delta > 0) checkingLength = mapTileWidth - (currentTileX + delta);
        else checkingLength = currentTileX + delta;


        if(movable) {
            // set center position for the tile above
            int targetXtile = (int) targetX / tileWidth;
            int targetYtile = (int) targetY / tileHeight;
            newPosX = newTileX;
            newPosY = currentTileY;
            // get distance
            checkDistance(targetXtile, targetYtile);
            // get movable tiles
            checkMovableTiles(delta);
        }
    }

    @Override
    protected void checkMovableTiles(int delta) {
        int tempTileX;
        float tempOffsetX;
        int count = 0;
        if(delta > 0) tempTileX = currentTileX + delta;
        else tempTileX = checkingLength;
        for(int i = 0; i < checkingLength; i ++) {
            if(delta > 0) tempOffsetX = (tempTileX + i) * tileWidth - xPos;
            else tempOffsetX = (tempTileX - i) * tileWidth - xPos;
//            System.out.println(tempOffsetX);
            if(ghost.isWallCollide(tempOffsetX, 0)) { // if wall exists
                movableTiles = count;
                break;
            } else {
                count ++;
            }
        }
    }
}
