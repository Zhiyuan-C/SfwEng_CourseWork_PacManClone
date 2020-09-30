package assignment3815ICT.zhiyuan.game.entities.item;

import assignment3815ICT.zhiyuan.game.GameHandler;
import assignment3815ICT.zhiyuan.game.entities.Entity;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class Item extends Entity {
    protected ArrayList<BufferedImage> itemImages;

    public Item(GameHandler gameHandler, float xPos, float yPos, int width, int height) {
        super(gameHandler, xPos, yPos, width, height);
        this.itemImages = gameHandler.getItemObjects();
    }
}