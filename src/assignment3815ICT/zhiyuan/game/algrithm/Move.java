//package assignment3815ICT.zhiyuan.game.algrithm;
//
//import assignment3815ICT.zhiyuan.game.GameHandler;
//import assignment3815ICT.zhiyuan.game.collisionDetection.Collision;
//import assignment3815ICT.zhiyuan.game.graphics.map.Tile;
//
//import java.awt.*;
//
//public class Move {
//    private GameHandler gameHandler;
//    private Collision collision;
//    private boolean isMoving = false;
//    private boolean upDir = false;
//    private boolean downDir = false;
//    private boolean leftDir = false;
//    private boolean rightDir = false;
//
//    public Move(GameHandler gameHandler, Collision collision) {
//        this.gameHandler = gameHandler;
//        this.collision = new Collision(gameHandler);
//    }
//
//    // check possible moving direction
//    public void checkAvailableRoute(float xPos, float yPos, Rectangle collisionBounds) {
//        // check x axis
//        collision.setStaticPoint(yPos, collisionBounds.y, collisionBounds.height, Tile.TILE_HEIGHT);
//        // check left
//        collision.setNewPoint(-2, collisionBounds.x, 0, Tile.TILE_WIDTH);
//        leftDir = collision.isCollideSG(true);
//        // check right
//        collision.setNewPoint(2, collisionBounds.x, collisionBounds.width, Tile.TILE_WIDTH);
//        rightDir = collision.isCollideSG(true);
//
//        // check y axis
//        collision.setStaticPoint(xPos, collisionBounds.x, collisionBounds.width, Tile.TILE_WIDTH);
//        // check up
//        collision.setNewPoint(-2, collisionBounds.y, 0, Tile.TILE_HEIGHT);
//        upDir = collision.isCollideSG(false);
//        // check down
//        collision.setNewPoint(2, collisionBounds.y, collisionBounds.height, Tile.TILE_HEIGHT);
//        downDir = collision.isCollideSG(false);
//    }
//
//    // during moving
//    public void movingUp(boolean up) {
//
//    }
//
//
//
//}
