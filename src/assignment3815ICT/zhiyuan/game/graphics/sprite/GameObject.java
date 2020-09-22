package assignment3815ICT.zhiyuan.game.graphics.sprite;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameObject {
    // load all game object once from the sprite sheet
    private static final int TILE_SIZE = 32;
//    private static final int SPRITE_SHEET_SIZE = 256; // 256 x 256
    private static ArrayList<BufferedImage> gameObjects = new ArrayList<>();
    private static ArrayList<BufferedImage> wallObjects;
    private static ArrayList<BufferedImage> playerObjects;
    private static ArrayList<BufferedImage> itemObjects;
    private static ArrayList<BufferedImage> fontObjects;

    public static void init() {
        Sprite wallSprite = new Sprite("/pacManWallSheet.png");
        Sprite playerSprite = new Sprite("/pacManPlayerSheet.png");
        Sprite fontSprite = new Sprite("/pacManFontSheet.png");
        wallObjects = setObjects(wallSprite, 4, 4);
        playerObjects = setObjects(playerSprite, 3, 4);
        fontObjects = setObjects(fontSprite, 9, 9);
    }

    private static ArrayList<BufferedImage> setObjects(Sprite spriteSheet, int rowNum, int colNum) {
        ArrayList<BufferedImage> objects = new ArrayList<>();
        for(int y = 0; y < colNum; y++) {
            for(int x = 0; x < rowNum; x++) {
                objects.add(spriteSheet.getSpriteTileImage(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE));
            }
        }
        return objects;
    }

    public static ArrayList<BufferedImage> getWallObjects() {
        return wallObjects;
    }

    public static ArrayList<BufferedImage> getPlayerObjects() {
        return playerObjects;
    }

    public static ArrayList<BufferedImage> getItemObjects() {
        return itemObjects;
    }

    public static ArrayList<BufferedImage> getFontObjects() {
        return fontObjects;
    }

    public static ArrayList<BufferedImage> getGameObjects() {
        return gameObjects;
    }

}
