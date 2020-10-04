package assignment3815ICT.zhiyuan.game.entities.item;

import assignment3815ICT.zhiyuan.game.GameHandler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class FlowerLarge extends Item{

    private BufferedImage flowerLarge;

    public FlowerLarge(GameHandler gameHandler, float xPos, float yPos) {
        super(gameHandler, xPos, yPos, 32, 32);
        this.flowerLarge = itemImages.get(1);
        value = 20;
        isEnergyBooster = true;

        // setup collision bond
        collisionBox.x = 2;
        collisionBox.y = 2;
        collisionBox.width = 27;
        collisionBox.height = 27;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(flowerLarge, (int)xPos, (int)yPos, width, height, null);
        graphics.setColor(Color.RED);
        graphics.drawRect((int)(xPos + collisionBox.x), (int)(yPos + collisionBox.y), collisionBox.width, collisionBox.height);
    }
}
