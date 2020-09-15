package assignment3815ICT.zhiyuan.game.gameGraphics;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameObject {
    // load all game object once from the sprite sheet
    private static final int TILE_SIZE = 16;
    private static final int SPRITE_SHEET_SIZE = 256; // 256 x 256
    private static ArrayList<BufferedImage> gameObjects = new ArrayList<>();

    public static void init() {
        Sprite spriteSheet = new Sprite("/spriteSheetForPacMan.png");
        for(int y = 0; y < SPRITE_SHEET_SIZE / TILE_SIZE; y++) {
            for(int x = 0; x < SPRITE_SHEET_SIZE / TILE_SIZE; x++) {
                gameObjects.add(spriteSheet.getSpriteTileImage(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE));
            }
        }
    }

    public static ArrayList<BufferedImage> getGameObjects() {
        return gameObjects;
    }

}
