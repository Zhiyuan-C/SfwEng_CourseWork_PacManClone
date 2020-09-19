package assignment3815ICT.zhiyuan.game.entities.mob;

import assignment3815ICT.zhiyuan.game.GameHandler;
import assignment3815ICT.zhiyuan.game.entities.Entity;
import assignment3815ICT.zhiyuan.game.graphics.tiles.Tile;


public abstract class Mob extends Entity {

    protected float speed;
    protected int direction = 0;// 1 for up, 2 for down, 3 for left, 4 for right

    public Mob(GameHandler gameHandler, float xPos, float yPos, int width, int height) {
        super(gameHandler, xPos, yPos, width, height);
    }

    public void move() {
        moveY();
        moveX();
    }

    public void moveX() {
        int tileXPos = 0;
        int tileYPosUpper = (int)(yPos + collisionBounds.y) / Tile.TILE_HEIGHT;
        int tileYPosMiddle = (int)(yPos + collisionBounds.y + collisionBounds.height / 2) / Tile.TILE_HEIGHT;
        int tileYPosLower = (int)(yPos + collisionBounds.y + collisionBounds.height) / Tile.TILE_HEIGHT;
        boolean upperPoint;
        boolean middlePoint;
        boolean lowerPoint;
        switch (direction) {
            case 3: // move left
                tileXPos = (int)(xPos - 2 + collisionBounds.x) / Tile.TILE_WIDTH;
                if(!collisionWithWall(tileXPos, tileYPosUpper) &&
                        !collisionWithWall(tileXPos, tileYPosLower)) {
                    if(isCrossing((int)(xPos - 2))) {
                        xPos = gameHandler.getGameWidth();
                    }
                    xPos -= speed;
                } else {
                    xPos = tileXPos * Tile.TILE_WIDTH + Tile.TILE_WIDTH - collisionBounds.x;

                }
                break;

            case 4: // move right
                tileXPos = (int)(xPos + 2 + collisionBounds.x + collisionBounds.width) / Tile.TILE_WIDTH;
                if(!collisionWithWall(tileXPos, tileYPosUpper) &&
                        !collisionWithWall(tileXPos, tileYPosLower)) {
                    if(isCrossing((int)(xPos + 2))) {
                        xPos = 0;
                    }
                    xPos += speed;
                } else {
                    xPos = tileXPos * Tile.TILE_WIDTH - collisionBounds.x - collisionBounds.width - 2;
                }
                break;
        }
    }
    public void moveY() {
        int tileYPos = 0;
        int tileXPosLeft = (int)(xPos + collisionBounds.x) / Tile.TILE_WIDTH;
        int tileXPosRight = (int)(xPos + collisionBounds.x + collisionBounds.width) / Tile.TILE_WIDTH;
        switch (direction) {
            case 1: // up
                tileYPos = (int)(yPos - 2 + collisionBounds.y) / Tile.TILE_HEIGHT;
                if(!collisionWithWall(tileXPosLeft, tileYPos) &&
                        !collisionWithWall(tileXPosRight, tileYPos)) {
                    yPos -= speed;
                } else {
                    yPos = tileYPos * Tile.TILE_HEIGHT + Tile.TILE_HEIGHT - collisionBounds.y;
                }
                break;
            case 2: //down
                tileYPos = (int)(yPos + 2 + collisionBounds.y + collisionBounds.height) / Tile.TILE_HEIGHT;
                if(!collisionWithWall(tileXPosLeft, tileYPos) &&
                        !collisionWithWall(tileXPosRight, tileYPos)) {
                    yPos += speed;
                } else {
                    yPos = tileYPos * Tile.TILE_HEIGHT - collisionBounds.height - collisionBounds.y - 2;
                }
                break;
        }

    }

    protected boolean collisionWithWall(int x, int y) {
        // x and y in tile measure
        return gameHandler.getMap().getTile(x, y).isWall();
    }

    protected boolean isCrossing(int x) {
        // x and y in pixel measure
        if (x < 0 || x > gameHandler.getGameWidth()) {
            return true;
        }
        return false;
    }
}
