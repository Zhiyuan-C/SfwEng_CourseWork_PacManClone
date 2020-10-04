package assignment3815ICT.zhiyuan.game.graphics.sprite;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameObject {
    // load all game object once from the sprite sheet
    private final int TILE_SIZE = 32;
//    private static final int SPRITE_SHEET_SIZE = 256; // 256 x 256
    private ArrayList<BufferedImage> ghostObjects;
    private ArrayList<BufferedImage> mapObjects;
    private ArrayList<BufferedImage> playerObjects;
    private ArrayList<BufferedImage> itemObjects;
    private ArrayList<BufferedImage> fontObjects;

    public GameObject() {
        Sprite mapSprite = new Sprite("/pacManMapSheet.png");
        Sprite playerSprite = new Sprite("/pacManPlayerSheet.png");
        Sprite fontSprite = new Sprite("/pacManFontSheet.png");
        Sprite itemSprite = new Sprite("/pacManItemSheet.png");
        Sprite ghostSprite = new Sprite("/pacManGhostSheet.png");
        mapObjects = setObjects(mapSprite, 4, 4);
        playerObjects = setObjects(playerSprite, 3, 4);
        fontObjects = setObjects(fontSprite, 9, 9);
        itemObjects = setObjects(itemSprite, 2, 2);
        ghostObjects = setObjects(ghostSprite, 5, 5);
    }

    private ArrayList<BufferedImage> setObjects(Sprite spriteSheet, int rowNum, int colNum) {
        ArrayList<BufferedImage> objects = new ArrayList<>();
        for(int y = 0; y < rowNum; y++) {
            for(int x = 0; x < colNum; x++) {
                objects.add(spriteSheet.getSpriteTileImage(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE));
            }
        }
        return objects;
    }

    public ArrayList<BufferedImage> getMapObjects() {
        return mapObjects;
    }

    public ArrayList<BufferedImage> getPlayerObjects() {
        return playerObjects;
    }

    public ArrayList<BufferedImage> getItemObjects() {
        return itemObjects;
    }

    public ArrayList<BufferedImage> getFontObjects() {
        return fontObjects;
    }

    public ArrayList<BufferedImage> getGhostObjects() {
        return ghostObjects;
    }
}
