package game;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Jeremy Timothy Brown on 11/8/2015.
 */
public class GameScreen extends JPanel{



    private static final int W_WIDTH = 1100;
    private static final int W_HEIGHT = 1300;

    public GameScreen(){
        setPreferredSize(new Dimension(W_WIDTH, W_HEIGHT));
        setBackground(Color.BLACK);

    }
}
