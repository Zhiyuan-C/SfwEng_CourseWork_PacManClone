package assignment3815ICT.zhiyuan.game.entities;

import assignment3815ICT.zhiyuan.game.Game;
import assignment3815ICT.zhiyuan.game.GameHandler;
import assignment3815ICT.zhiyuan.game.entities.item.FlowerLarge;
import org.junit.Test;

import static org.junit.Assert.*;

public class EntityManagerTest {
    private Game game = new Game("testing", 100, 100);
    private GameHandler gameHandler = new GameHandler(game);
    private EntityManager entityManager = new EntityManager(gameHandler);

    @Test
    public void addFlowerLarge() {
        entityManager.addFlowerLarge(10, 10);
        assertEquals(entityManager.getItems().size(), 1);
    }

    @Test
    public void addFlowerSmall() {
        entityManager.addFlowerLarge(10, 10);
        entityManager.addFlowerSmall(10, 10);
        assertEquals(entityManager.getItems().size(), 2);
    }

    @Test
    public void addWall() {
        entityManager.addWall(10, 10);
        assertEquals(entityManager.getWalls().size(), 1);
    }

}