package assignment3815ICT.zhiyuan.game.entities;

import assignment3815ICT.zhiyuan.game.GameHandler;
import assignment3815ICT.zhiyuan.game.entities.item.FlowerLarge;
import assignment3815ICT.zhiyuan.game.entities.item.FlowerSmall;
import assignment3815ICT.zhiyuan.game.entities.item.Fruit;
import assignment3815ICT.zhiyuan.game.entities.item.Item;
import assignment3815ICT.zhiyuan.game.entities.mob.PacMan;

import java.awt.*;
import java.util.ArrayList;

public class EntityManager {

    private GameHandler gameHandler;
    private PacMan pacMan;
    private ArrayList<Item> items;
    private Item[] experiment;
    private ArrayList<Entity> mob;

    public EntityManager(GameHandler gameHandler) {
        this.gameHandler = gameHandler;
        pacMan = new PacMan(gameHandler);
        items = new ArrayList<>();
        mob = new ArrayList<>();
        addMob(pacMan);
    }

    public void update() {
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            item.update();
            if (!item.isActive()) {
                pacMan.setScore(pacMan.getScore() + item.getValue());
                items.remove(item);
            }
        }
        pacMan.update();
    }

    public void render(Graphics graphics) {
        for (Item item : items) {
            item.render(graphics);
        }
//        items.forEach(item -> item.render(graphics));
        pacMan.render(graphics);
    }

    public void addFlowerSmall(float xPos, float yPos){
        items.add(new FlowerSmall(gameHandler, xPos, yPos));
    }
    public void addFlowerLarge(float xPos, float yPos) {
        items.add(new FlowerLarge(gameHandler, xPos,yPos));
    }
    public void addFruit(float xPos, float yPos){
        items.add(new Fruit(gameHandler, xPos, yPos));
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }
    public void addMob(Entity entity) { mob.add(entity); }

    public PacMan getPacMan() {
        return pacMan;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
