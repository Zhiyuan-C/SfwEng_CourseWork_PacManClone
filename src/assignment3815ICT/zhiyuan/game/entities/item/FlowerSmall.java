package assignment3815ICT.zhiyuan.game.entities.item;

import assignment3815ICT.zhiyuan.game.GameHandler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class FlowerSmall extends Item{

    private BufferedImage flowerSmall;
    private int value = 10;

    public FlowerSmall(GameHandler gameHandler, float xPos, float yPos) {
        super(gameHandler, xPos, yPos, 32, 32);
        this.flowerSmall = itemImages.get(0);

        // setup collision bond
        collisionBox.x = 3;
        collisionBox.y = 5;
        collisionBox.width = 20;
        collisionBox.height = 20;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(flowerSmall, (int)xPos, (int)yPos, width, height, null);
        graphics.setColor(Color.RED);
        graphics.drawRect((int)(xPos + collisionBox.x), (int)(yPos + collisionBox.y), collisionBox.width, collisionBox.height);
    }

    public int getValue() {
        return value;
    }
}
