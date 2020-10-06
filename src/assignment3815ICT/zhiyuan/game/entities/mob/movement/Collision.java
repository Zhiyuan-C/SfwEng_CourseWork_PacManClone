package assignment3815ICT.zhiyuan.game.entities.mob.movement;

import assignment3815ICT.zhiyuan.game.GameHandler;

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

    public void setNewPoint(float delta, float boundsPoint, int length, int unitSize) {
        this.newPoint = (originalPoint + delta + boundsPoint + length) / unitSize;
    }

    public void setStaticPoint(float objectPoint, float boundsPoint, int length, int unitSize) {
//        this.staticPointA = (objectPoint + boundsPoint) / unitSize;
        this.staticPointB = (objectPoint + boundsPoint + length / 2) / unitSize;
//        this.staticPointC = (objectPoint + boundsPoint + length) / unitSize;

    }

    public float getOriginalPoint() {
        return originalPoint;
    }

//    public boolean isCollideSG(boolean xCoordinate) { // is collided for square gride
//        boolean pointA;
//        boolean pointB;
//        boolean pointC;
//        if (xCoordinate) {
//            pointA = isPointWall(newPoint, staticPointA);
//            pointB = isPointWall(newPoint, staticPointB);
//            pointC = isPointWall(newPoint, staticPointC);
//        } else {
//            pointA = isPointWall(staticPointA, newPoint);
//            pointB = isPointWall(staticPointB, newPoint);
//            pointC = isPointWall(staticPointC, newPoint);
//        }
//        return isSideCollide(pointA, pointB, pointC);
//    }
    public boolean isCollideSG(boolean xCoordinate) { // is collided for square gride
        boolean pointA;
        boolean pointB;
        boolean pointC;
        if (xCoordinate) {
//            pointA = isPointMovable(newPoint, staticPointA);
            pointB = isPointMovable(newPoint, staticPointB);
//            pointC = isPointMovable(newPoint, staticPointC);
        } else {
//            pointA = isPointMovable(staticPointA, newPoint);
            pointB = isPointMovable(staticPointB, newPoint);
//            pointC = isPointMovable(staticPointC, newPoint);

            System.out.println("newPoint: " + (int)newPoint);
            System.out.println("staticPointB: " + (int)staticPointB);
            System.out.println(pointB);
//            System.out.println("staticPointA: " + (int)staticPointA + " staticPointB: " + (int)staticPointB + " staticPointC: " + (int)staticPointC );
//            System.out.println("detection: ");
//            System.out.println("pointA: " + pointA + " pointB: " + pointB + " pointC: " + pointC);
        }
        return isSideCollide(pointB);
    }

    private boolean isPointWall(float x, float y) {
        return gameHandler.getMap().getTile((int) x, (int) y).isWall();
    }
    private boolean isPointMovable(float x, float y)  {
        return gameHandler.getMap().getTile((int) x, (int) y).isMovable();
    }

//    private boolean isSideCollide(boolean pointA, boolean pointB, boolean pointC) {
//        if (!pointB) { // if middle point is not wall
//            if(pointA && pointC) {
//                return false;
//            } else if (pointA || pointC) {
//                return true;
//            } else { // three points all not wall
//                return false;
//            }
//        } else {
//            return true;
//        }
//    }
    private boolean isSideCollide(boolean pointB) {
        if(pointB) return false;
        return true;
//        if (!pointB) { // if middle point is not wall
//            if(pointA && pointC) {
//                return false;
//            } else if (pointA || pointC) {
//                return true;
//            } else { // three points all not wall
//                return false;
//            }
//        } else {
//            return true;
//        }
    }


    public float getNewPoint() {
        return newPoint;
    }

    public float getStaticPointA() {
        return staticPointA;
    }
}
