package assignment3815ICT.zhiyuan.game.entities.mob.movement;

import assignment3815ICT.zhiyuan.game.entities.mob.ghosts.Ghost;

public abstract class Move {
    protected int distance;
    protected int movableTiles;
    protected boolean movable;
    protected float xPos, yPos;
    protected float newPosX, newPosY;
    protected int currentTileX, currentTileY;
    protected int mapTileWidth, mapTileHeight;
    protected int tileWidth, tileHeight;
    public int checkingLength;
    public float offsetX, offsetY;
    public float movableTileOffsetX, movableTileOffsetY;
    protected Ghost ghost;
    protected boolean up, left, right, down;

    public Move(Ghost ghost, int mapTileWidth, int mapTileHeight, int tileWidth, int tileHeight) {
        this.ghost = ghost;
        this.mapTileWidth = mapTileWidth;
        this.mapTileHeight = mapTileHeight;
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;

    }

    protected abstract void checkMove(float xPos, float yPos, float targetX, float targetY, int delta);
    protected abstract void checkMovableTiles(int delta);
    protected abstract void listener();
    protected abstract boolean changeMove(Move move);
    public abstract void checkMovable(float xPos, float yPos, float targetX, float targetY);



    protected void checkDistance(float targetX, float targetY) {
        // sqrt(abs((x2 - x1))^2 + abs((y2 - y1))^2)
         double sqrDistance = Math.pow(Math.abs(targetX - newPosX), 2) + Math.pow(Math.abs(targetY - newPosY), 2);
         distance = (int) Math.sqrt(sqrDistance);
    }

    public int getDistance() {
        return distance;
    }

    public int getMovableTiles() {
        return movableTiles;
    }

    public void setMovableTiles(int movableTiles) {
        this.movableTiles = movableTiles;
    }

    public boolean isMovable() {
        return movable;
    }

    public void setMovable(boolean movable) {
        this.movable = movable;
    }
}
