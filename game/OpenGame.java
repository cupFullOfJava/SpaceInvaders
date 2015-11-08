package game; /**
 * 
 */

import javax.swing.*;
import java.awt.*;

/**
 * @author Jeremy Timothy Brown
 *
 */
public class OpenGame {

    private static JFrame window;
    private static final int W_WIDTH = 1100;
    private static final int W_HEIGHT = 1300;

    public OpenGame(){
        //creates game window
        window = new JFrame();
        window.setBackground(Color.BLACK);
        window.setResizable(false);
        window.setTitle("Game Window - Space Invaders");
        window.setSize(W_WIDTH,W_HEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //end creating window

        window.setVisible(true);
    }

}
