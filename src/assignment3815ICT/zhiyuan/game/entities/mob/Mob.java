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
        collisionDetection.setStaticPoint(yPos, collisionBounds.y, collisionBounds.height, Tile.TILE_HEIGHT);
        switch (direction) {
            case 3: // move left
                collisionDetection.setOriginalPoint(xPos);
                collisionDetection.setNewPoint(-2, collisionBounds.x, 0, Tile.TILE_WIDTH);
                if(!collisionDetection.squareWallCollision(true)) {
                    // check if the object is moving over the screen width
                    if(isCrossing((int)(xPos - 2))) {
                        xPos = gameHandler.getGameWidth();
                    }
                    xPos -= speed;
                } else {
                    xPos = collisionDetection.getOriginalPoint();
                    direction = 0;
                }
                break;

            case 4: // move right
                collisionDetection.setOriginalPoint(xPos);
                collisionDetection.setNewPoint(2, collisionBounds.x, collisionBounds.width, Tile.TILE_WIDTH);

                if (!collisionDetection.squareWallCollision(true)) {
                    // check if the object is moving over the screen width
                    if(isCrossing((int)(xPos + 2))) {
                        xPos = 0;
                    }
                    xPos += speed;
                } else {
                    xPos = collisionDetection.getOriginalPoint();
                    direction = 0;
                }
                break;
        }
    }
    public void moveY() {
        collisionDetection.setStaticPoint(xPos, collisionBounds.x, collisionBounds.width, Tile.TILE_WIDTH);
        switch (direction) {
            case 1: // up
                collisionDetection.setOriginalPoint(yPos);
                collisionDetection.setNewPoint(-2, collisionBounds.y, 0, Tile.TILE_HEIGHT);
                if(!collisionDetection.squareWallCollision(false)) {
                    yPos -= speed;
                } else {
                    yPos = collisionDetection.getOriginalPoint();
                    break;
                }
                break;
            case 2: //down
                collisionDetection.setOriginalPoint(yPos);
                collisionDetection.setNewPoint(2, collisionBounds.y, collisionBounds.height, Tile.TILE_HEIGHT);
                if(!collisionDetection.squareWallCollision(false)) {
                    yPos += speed;
                } else {
                    yPos = collisionDetection.getOriginalPoint();
                    break;
                }

                break;
        }

    }

    protected boolean isCrossing(int x) {
        // x and y in pixel measure
        if (x < 0 || x > gameHandler.getGameWidth()) {
            return true;
        }
        return false;
    }
}
