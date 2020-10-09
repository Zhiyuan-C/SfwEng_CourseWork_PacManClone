package assignment3815ICT.zhiyuan.game.entities.mob.ghosts;

import assignment3815ICT.zhiyuan.game.GameHandler;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Blinky extends Ghost {

    private ArrayList<BufferedImage> blinkyImages;

    public Blinky(GameHandler gameHandler, float xPos, float yPos) {
        super(gameHandler, xPos, yPos);
        blinkyImages = getIndividualImages(0);
        setAnimationFrame(blinkyImages);
        inBase = true;
//        direction = getDirection();
        speed = 1.5f;
//        direction = 4;
    }

    @Override
    public void update() {

        frightenedMode();
        setTargetPosition();

        setMove();
        moveRight.move();
//        for(Movement move: movements) {
//            System.out.println("direction: " + move.getDirectionWord() + " movable: " + move.isMovable());
//            System.out.println("direction: " + move.getDirectionWord() + " movable tiles: " + move.getMovableTiles());
//        }
//        tilePosX = (int) xPos/gameHandler.getTILE_WIDTH();
//        tilePosY = (int) yPos/gameHandler.getTILE_HEIGHT();
//        int topX = tilePosX * gameHandler.getTILE_WIDTH();
//        int topY = tilePosY * gameHandler.getTILE_HEIGHT();
//        int centerX = tilePosX * gameHandler.getTILE_WIDTH() + (gameHandler.getTILE_WIDTH() / 2);
//        int centerY =  tilePosY * gameHandler.getTILE_HEIGHT() + (gameHandler.getTILE_HEIGHT() / 2);
//
//        // if topX == current xPos, get a new direction
////        System.out.println("center tile");
////        System.out.println(centerX + " " + centerY);
//        if(xPos == topX && yPos == topY) {
//            System.out.println("current tile");
//            System.out.println(tilePosX + " " + tilePosY);
//            System.out.println("acutal entity: ");
//            System.out.println(xPos + " " + yPos);
//            System.out.println("top tile");
//            System.out.println(topX + " " + topY);
//            System.out.println("top is equal, check direction");
//
//            direction = getDirection();
//        }
////        move();
//
////        if(currentTileX != tilePosX || currentTileY != tilePosY) {
////            System.out.println("moved, get new direction");
////            System.out.println(xPos);
////            direction = getDirection();
////            System.out.println("new direction: " + direction);
////            currentTileX = tilePosX;
////            currentTileY = tilePosY;
////        }
//        if(direction != 0 && movements[direction-1].isMovable()) {
//            move();
//        } else {
//            System.out.println("not able to move");
//            System.out.println("current tile");
//            System.out.println(tilePosX + " " + tilePosY);
//            System.out.println("acutal entity: ");
//            System.out.println(xPos + " " + yPos);
//            System.out.println("top tile");
//            System.out.println(topX + " " + topY);
//            if((int)xPos == topX && (int)yPos == topY) {
//                System.out.println("current tile");
//                System.out.println(tilePosX + " " + tilePosY);
//                System.out.println("acutal entity: ");
//                System.out.println(xPos + " " + yPos);
//                System.out.println("top tile");
//                System.out.println(topX + " " + topY);
//                System.out.println("top is equal, check direction");
//
//                direction = getDirection();
//            }
//        }


//        direction = getDirection();
//        if (getDirection() != direction){
//            if(System.currentTimeMillis() - currentTime > 500) {
//                currentTime = System.currentTimeMillis();
//                direction = getDirection();
//            }
//        }

//        movingDir = direction;
//        System.out.println(direction);

//        if( ((xPos - lastMoveX) >= 2 )|| ((yPos - lastMoveY) >= 2)) {
//            System.out.println("moved. Current direction is: " + direction);
//            System.out.println("lastMoveX: " + lastMoveX + " xPos: " + xPos + " lastMoveY: " + lastMoveY + " yPos: " + yPos);
//            moved = true;
//        } else {
//            moved = false;
//        }


    }

    @Override
    public void setTargetPosition() {
        targetPosX = gameHandler.getEntityManager().getPacMan().getxPos() + (gameHandler.getEntityManager().getPacMan().getWidth() / 2 - (targetWidth / 2));
        targetPosY = gameHandler.getEntityManager().getPacMan().getyPos() + (gameHandler.getEntityManager().getPacMan().getHeight() / 2 - (targetHeight / 2));
    }



}
