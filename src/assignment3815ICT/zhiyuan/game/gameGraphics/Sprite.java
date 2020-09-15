package assignment3815ICT.zhiyuan.game.gameGraphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Sprite {
    private BufferedImage spriteSheet;

    public Sprite(String path) {
        this.spriteSheet = loadImage(path);
    }

    // load image
    private static BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(Sprite.class.getResource(path));
            //getClass().getClassLoader().getResourceAsStream(file)
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1); // if image not loaded, do not run the game
        }
        return null;
    }

    // get image
    public BufferedImage getSpriteSheet() {
        return spriteSheet;
    }

    // return only a section of the sprite sheet, return a tile
    public BufferedImage getSpriteTileImage(int x, int y, int width, int height) {
        return spriteSheet.getSubimage(x, y, width, height);
    }
}
