package assignment3815ICT.zhiyuan.game.states;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayState extends State {

    // constructor
    public PlayState() {

    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics graphics, BufferedImage gameObject) {
        graphics.drawImage(gameObject, 0, 0, null);
    }
}
