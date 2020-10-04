package assignment3815ICT.zhiyuan.game.entities.mob.Ghost;

import assignment3815ICT.zhiyuan.game.GameHandler;
import assignment3815ICT.zhiyuan.game.entities.mob.Mob;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class Ghost extends Mob {
    protected ArrayList<BufferedImage> ghostImages;

    public Ghost(GameHandler gameHandler, float xPos, float yPos) {
        super(gameHandler, xPos, yPos, 28, 28);

        this.ghostImages = gameHandler.getGhostObjects();
    }

    protected BufferedImage[] getObjectFrames(ArrayList<BufferedImage> objects, int startIndex, int endIndex) {
        BufferedImage[] objectFrames = new BufferedImage[2];
        // hard code from here
        objectFrames[0] = objects.get(startIndex);
        objectFrames[1] = objects.get(endIndex);
        return objectFrames;
    }

    protected ArrayList<BufferedImage> getIndividualImages(int startIndex){
        ArrayList<BufferedImage> newImages = new ArrayList<>();
        for (int i = startIndex; i < 5; i ++) {
            newImages.add(ghostImages.get(i));
        }
        return newImages;
    }
}
