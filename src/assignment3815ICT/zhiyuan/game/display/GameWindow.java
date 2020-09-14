package assignment3815ICT.zhiyuan.game.display;

import assignment3815ICT.zhiyuan.game.GamePanel;

import javax.swing.*;

public class GameWindow extends JFrame {
    public GameWindow() {
        setTitle("Pac-Man");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new GamePanel(1280, 720)); //set internal pane of the JFrame

        pack(); //condens the window, compacts the window
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
