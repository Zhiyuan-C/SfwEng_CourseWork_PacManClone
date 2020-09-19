package assignment3815ICT.zhiyuan.game.collisionDetection;

import assignment3815ICT.zhiyuan.game.GameHandler;
import assignment3815ICT.zhiyuan.game.graphics.tiles.Tile;

import java.awt.*;

public class Collision {
    private float originalPoint;
    private float newPoint; // edge point of the shape that the object is moving toward to
//    private float staticPoint; // edge point that remains the same even object move
    private float staticPointA;
    private float staticPointB; // middle point
    private float staticPointC;

    private GameHandler gameHandler;

    public Collision(GameHandler gameHandler) {
        this.gameHandler = gameHandler;
    }

    public void setOriginalPoint(float originalPoint) {
        this.originalPoint = originalPoint;
    }

    public void setNewPoint(int delta, float boundsPoint, int length, int unitSize) {
        this.newPoint = (originalPoint + delta + boundsPoint + length) / unitSize;
    }

    public void setStaticPoint(float objectPoint, float boundsPoint, int length, int unitSize) {
        this.staticPointA = (objectPoint + boundsPoint) / unitSize;
        this.staticPointB = (objectPoint + boundsPoint + length / 2) / unitSize;
        this.staticPointC = (objectPoint + boundsPoint + length) / unitSize;

    }

    public float getOriginalPoint() {
        return originalPoint;
    }

    public boolean isCollideSG(boolean xCoordinate) { // is collided for square gride
        boolean pointA;
        boolean pointB;
        boolean pointC;
        if (xCoordinate) {
            pointA = isPointWall(newPoint, staticPointA);
            pointB = isPointWall(newPoint, staticPointB);
            pointC = isPointWall(newPoint, staticPointC);
        } else {
            pointA = isPointWall(staticPointA, newPoint);
            pointB = isPointWall(staticPointB, newPoint);
            pointC = isPointWall(staticPointC, newPoint);
        }
        return isSideCollide(pointA, pointB, pointC);
    }

    private boolean isPointWall(float x, float y) {
        return gameHandler.getMap().getTile((int) x, (int) y).isWall();
    }

    private boolean isSideCollide(boolean pointA, boolean pointB, boolean pointC) {
        if (!pointB) { // if middle point is not wall
            if(pointA && pointC) {
                return true;
            } else if (pointA || pointC) {
                return true;
            } else { // three points all not wall
                return false;
            }
        } else {
            return true;
        }
    }


}
