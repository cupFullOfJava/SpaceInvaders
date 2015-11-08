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

    private static final int W_WIDTH = 1100;
    private static final int W_HEIGHT = 1300;
    private static JFrame window;
    private static JLabel hud;
    private static int points = 0;
    private static int lives = 3;

    /**
     * Constructor class.  Creates the window which the game will be displayed in.
     */
    public OpenGame(){

        //creates game window
        window = new JFrame();
        window.setBackground(Color.BLACK);
        window.setResizable(false);
        window.setTitle("Game Window - Space Invaders");
        window.setSize(W_WIDTH,W_HEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //end creating window

        displayHUD();

        //Container contentPane = window.getContentPane();
        SpringLayout springLay = new SpringLayout();
        window.setLayout(springLay);

       ///contentPane.add(hud);
        //springLay.putConstraint(SpringLayout.WEST, hud, 5, SpringLayout.WEST, contentPane);
        //springLay.putConstraint(SpringLayout.NORTH, hud, 5, SpringLayout.NORTH, contentPane);


        window.add(hud);

        window.setVisible(true);
    }

    public static void displayHUD(){
        hud = new JLabel();
        hud.setText("  Score: " + points + "      Lives: " + lives);
        hud.setFont(new Font("Courier New", Font.PLAIN, 30));
    }

}
