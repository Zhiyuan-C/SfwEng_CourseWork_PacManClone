package assignment3815ICT.zhiyuan.game.states;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class State {
    public abstract void update();
    public abstract void render(Graphics graphics, BufferedImage gameObject);
}
