package game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Jeremy Timothy Brown on 11/8/2015.
 */
public class GameScreen extends JPanel{

    private static final int W_WIDTH = 1100;
    private static final int W_HEIGHT = 1300;

    private static BufferedImage playerImg;
    private static BufferedImage alienImg;
    private static BufferedImage saucerImg;
    private static BufferedImage cannonBulletImg;
    private static BufferedImage enemyBulletImg;
    public static ImageIcon cannon;
    public static ImageIcon cannonBullet;
    public static ImageIcon enemy;
    public static ImageIcon enemyBullet;
    public static ImageIcon saucer;

    public GameScreen(){
        setPreferredSize(new Dimension(W_WIDTH, W_HEIGHT));
        setBackground(Color.BLACK);
        setLayout(new GridLayout(0,1));

        //create images
        try {
            playerImg = ImageIO.read(new File("player.png"));
            alienImg = ImageIO.read(new File("alien1.png"));
            saucerImg = ImageIO.read(new File("Saucer.png"));
            cannonBulletImg = ImageIO.read(new File("bullet.png"));
            enemyBulletImg = ImageIO.read(new File("enemybullet.png"));
        } catch (IOException e) {}
        cannon = new ImageIcon(playerImg.getScaledInstance(100, 50, Image.SCALE_SMOOTH));
        enemy = new ImageIcon(alienImg.getScaledInstance(100, 80, Image.SCALE_SMOOTH));
        saucer = new ImageIcon(saucerImg.getScaledInstance(230, 150, Image.SCALE_SMOOTH));
        cannonBullet = new ImageIcon(cannonBulletImg.getScaledInstance(64, 64, Image.SCALE_SMOOTH));
        enemyBullet = new ImageIcon(enemyBulletImg.getScaledInstance(64, 64, Image.SCALE_SMOOTH));
        //end image creation

        //testers for images
        //JLabel logoLabel = new JLabel("", cannon, JLabel.CENTER);
        //JLabel logoLabel1 = new JLabel("", enemy, JLabel.CENTER);
        //JLabel logoLabel2 = new JLabel("", saucer, JLabel.CENTER);
        //JLabel logoLabel3 = new JLabel("", cannonBullet, JLabel.CENTER);
        //JLabel logoLabel4 = new JLabel("", enemyBullet, JLabel.CENTER);
        //add(logoLabel);
        //add(logoLabel1);
        //add(logoLabel2);
        //add(logoLabel3);
        //add(logoLabel4);
        //end testers

    }
}
