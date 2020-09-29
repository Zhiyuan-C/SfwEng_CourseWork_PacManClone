package assignment3815ICT.zhiyuan.game.entities;

import assignment3815ICT.zhiyuan.game.GameHandler;
import assignment3815ICT.zhiyuan.game.entities.mob.PacMan;

import java.awt.*;
import java.util.ArrayList;

public class EntityManager {

    private GameHandler gameHandler;
    private PacMan pacMan;
    private ArrayList<Entity> items;

    public EntityManager(GameHandler gameHandler, PacMan pacMan) {
        this.gameHandler = gameHandler;
        this.pacMan = pacMan;
        items = new ArrayList<>();
    }

    public void update() {
        for (int i = 0; i < items.size(); i++) {
            Entity entity = items.get(i);
            entity.update();
        }
        pacMan.update();
    }
    public void render(Graphics graphics) {
        for (Entity entity : items) {
            entity.render(graphics);
        }
        pacMan.render(graphics);
    }

    public void addEntity(Entity entity) {
        items.add(entity);
    }

    public PacMan getPacMan() {
        return pacMan;
    }
}
