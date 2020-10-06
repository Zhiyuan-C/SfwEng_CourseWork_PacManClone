package assignment3815ICT.zhiyuan.game.entities.item;

import assignment3815ICT.zhiyuan.game.GameHandler;

import java.awt.*;

public class Wall extends Item{
    public Wall(GameHandler gameHandler, float xPos, float yPos) {
        super(gameHandler, xPos, yPos, 32, 32);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics graphics) {
//        graphics.setColor(Color.RED);
//        graphics.fillRect((int)(xPos + collisionBox.x), (int)(yPos + collisionBox.y), collisionBox.width, collisionBox.height);
    }
}
