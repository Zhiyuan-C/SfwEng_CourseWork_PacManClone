package assignment3815ICT.zhiyuan.game.entities.mob.Ghost;

import assignment3815ICT.zhiyuan.game.GameHandler;
import assignment3815ICT.zhiyuan.game.entities.mob.Mob;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class Ghost extends Mob {
    protected ArrayList<BufferedImage> ghostImages;

    public Ghost(GameHandler gameHandler, float xPos, float yPos, int width, int height) {
        super(gameHandler, xPos, yPos, width, height);

        this.ghostImages = gameHandler.getGhostObjects();
    }

    @Override
    protected BufferedImage[] getObjectFrames(ArrayList<BufferedImage> objects, int startIndex, int length) {
        return new BufferedImage[0];
    }
}
