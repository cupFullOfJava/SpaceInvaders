package game; /**
 * 
 */

import javax.swing.*;

/**
 * @author Jeremy Timothy Brown
 *
 */
public class OpenGame extends JFrame{

    private static final int W_WIDTH = 1100;
    private static final int W_HEIGHT = 1300;

    /**
     * Constructor class.  Creates the window which the game will be displayed in.
     */
    public OpenGame(){

        //creates game window
        setResizable(false);
        setTitle("Game Window - Space Invaders");
        setSize(W_WIDTH,W_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //end creating window

        GameScreen screen = new GameScreen();
        add(screen);

        setVisible(true);
    }

}
