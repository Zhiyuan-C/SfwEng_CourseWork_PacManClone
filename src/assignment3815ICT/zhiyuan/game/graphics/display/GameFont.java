package assignment3815ICT.zhiyuan.game.graphics.display;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameFont {
    private String characters =""+
            "ABCDEFGHI" +
            "JKLMNOPQR" +
            "STUVWXYZ " +
            "abcdefghi" +
            "jklmnopqr" +
            "stuvwxyz " +
            "!,-./<=>?" +
            "012345678" +
            "9        ";
    private ArrayList<BufferedImage> fontObjects;

    public GameFont(ArrayList<BufferedImage> fontObjects) {
        this.fontObjects = fontObjects;
    }

    public void render(Graphics graphics, String message, int xPos, int yPos, int width, int height) {
        for(int i = 0; i < message.length(); i ++){
            int charIndex = characters.indexOf(message.charAt(i));
            if(charIndex >= 0) graphics.drawImage(fontObjects.get(charIndex), xPos + i * width, yPos, width, height, null);
        }
    }

}
