package assignment3815ICT.zhiyuan.game.entities;

import assignment3815ICT.zhiyuan.game.Game;
import assignment3815ICT.zhiyuan.game.GameHandler;
import assignment3815ICT.zhiyuan.game.entities.item.FlowerLarge;
import assignment3815ICT.zhiyuan.game.entities.item.Item;
import assignment3815ICT.zhiyuan.game.entities.item.Wall;
import assignment3815ICT.zhiyuan.game.entities.mob.ghosts.Blinky;
import assignment3815ICT.zhiyuan.game.entities.mob.ghosts.Ghost;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class EntityTest {
    Game game = new Game("testing", 100, 100);
    GameHandler gameHandler = new GameHandler(game);


    @Test
    public void itemCollisions() {
        gameHandler.setPlayState();
        ArrayList<Item> items = new ArrayList<>();
        FlowerLarge flowerLarge = new FlowerLarge(gameHandler, 50, 50);
        items.add(flowerLarge);

        gameHandler.getMap().getEntityManager().getPacMan().setxPos(50);
        gameHandler.getMap().getEntityManager().getPacMan().setyPos(50);
        gameHandler.getMap().getEntityManager().setItems(items);
        // before collide active should be true
        assertTrue(flowerLarge.active);
        // same position should collide
        gameHandler.getMap().getEntityManager().getPacMan().itemCollisions(0, 0);
        // item active should be false
        assertFalse(flowerLarge.active);
    }

    @Test
    public void mobCollisions() {
        // set position pacman and blinky same so they will collide
        gameHandler.setPlayState();
        ArrayList<Ghost> ghosts = new ArrayList<>();
        Blinky blinky = new Blinky(gameHandler, 50, 60);
        ghosts.add(blinky);

        gameHandler.getMap().getEntityManager().getPacMan().setxPos(50);
        gameHandler.getMap().getEntityManager().getPacMan().setyPos(60);
        gameHandler.getMap().getEntityManager().setGhosts(ghosts);
        // if collide pac-man alive should be false
        gameHandler.getMap().getEntityManager().getPacMan().mobCollisions(0, 0);
        assertFalse(gameHandler.getMap().getEntityManager().getPacMan().isAlive());

    }

    @Test
    public void isWallCollide() {
        gameHandler.setPlayState();
        ArrayList<Item> walls = new ArrayList<>();
        Wall wall = new Wall(gameHandler, 78, 78);
        walls.add(wall);

        gameHandler.getMap().getEntityManager().getPacMan().setxPos(78);
        gameHandler.getMap().getEntityManager().getPacMan().setyPos(78);
        gameHandler.getMap().getEntityManager().setWalls(walls);

        assertTrue(gameHandler.getMap().getEntityManager().getPacMan().isWallCollide(0, 0));
    }
}