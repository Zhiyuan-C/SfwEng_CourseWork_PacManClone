package assignment3815ICT.zhiyuan.game.graphics.display;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Animation {

    private BufferedImage[] animationFrames;

    private int time, index;
    private long lastTime, timer;

    public Animation(BufferedImage[] animationFrames, int time) {
        this.animationFrames = animationFrames;
        this.time = time;
        index = 0;
        timer = 0;
        lastTime = System.currentTimeMillis();
    }

    public void update() {
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();

        if (timer > time) {
            index ++;
            timer = 0;
            if (index >= animationFrames.length) index = 0;
        }
    }

    public BufferedImage getCurrentObjectFrame() {
        return animationFrames[index];
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setTimer(long timer) {
        this.timer = timer;
    }

    public int getIndex() {
        return index;
    }
}
