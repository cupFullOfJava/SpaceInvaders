package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
  
  
/**
 * This class creates the main window for the game.
 * @author Jeremy Timothy Brown
 *
 */
public class MainWindow extends JFrame{
  
    private static JFrame window;
    private static JPanel startPanel;
    private static BufferedImage img;
    private static ImageIcon icon;
    private static ImageIcon logo;
    private static JLabel logoLabel;
    private static JButton startButton;
  
    private static final int W_WIDTH = 1100;
    private static final int W_HEIGHT = 1300;
  
    /**
     * Constructor method.  Creates the window which the main menu will be displayed  in.
     */
    public MainWindow(){
  
        //creates start window
        window = new JFrame();
        window.setBackground(Color.BLACK);
        window.setResizable(false);
        window.setTitle("Main Menu - Space Invaders");
        window.setSize(W_WIDTH,W_HEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //end creating window
  
        //builds and places the start menu
        buildStart();
        window.add(startPanel);
        //end start menu stuff
  
        window.setVisible(true);
  
          
    }
  
    /**
     * Creates the start menu to be added to the window.
     *
     */
    private static void buildStart() {
  
        //creates panel
        startPanel = new JPanel();
        startPanel.setLayout(new GridLayout(0,1));
        startPanel.setBackground(Color.BLACK);
        //end creating panel
  
        //create start button
        startButton = new JButton("START");
        startButton.setFont(new Font("Courier New", Font.PLAIN, 150));
        startButton.setBackground(Color.RED);
        startButton.setForeground(Color.BLACK);
        startButton.setFocusPainted(false);
        startButton.setBorderPainted(false);
        //end creating start button
  
        //create image to display logo
        try {
            img = ImageIO.read(new File("spaceInvadersStart.png"));
        } catch (IOException e) {}
        logo = new ImageIcon(img.getScaledInstance(900, 600, Image.SCALE_SMOOTH));
        logoLabel = new JLabel("", logo, JLabel.CENTER);
        //end logo display creation
  
        //create action listener for button
        class AddClickListener implements ActionListener{
            public void actionPerformed(ActionEvent e){
                window.dispose();
                GameWindow g = new GameWindow();
            }
        }
  
        ActionListener click = new AddClickListener();
        startButton.addActionListener(click);
        //end action listener creation for button
  
        //adds stuff to the JPanel
        startPanel.add(logoLabel);
        startPanel.add(startButton);
        //end adding stuff
    }
  
  
}