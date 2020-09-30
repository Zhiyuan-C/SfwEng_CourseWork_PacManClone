package assignment3815ICT.zhiyuan.game.entities.item;

import assignment3815ICT.zhiyuan.game.GameHandler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class FlowerSmall extends Item{

    private BufferedImage flowerSmall;

    public FlowerSmall(GameHandler gameHandler, float xPos, float yPos) {
        super(gameHandler, xPos, yPos, 32, 32);
        this.flowerSmall = itemImages.get(0);

        // setup collision bond
        collisionBounds.x = 3;
        collisionBounds.y = 5;
        collisionBounds.width = 20;
        collisionBounds.height = 20;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(flowerSmall, (int)xPos, (int)yPos, width, height, null);

        graphics.setColor(Color.RED);
        graphics.drawRect((int)(xPos + collisionBounds.x), (int)(yPos + collisionBounds.y), collisionBounds.width, collisionBounds.height);
    }
}
