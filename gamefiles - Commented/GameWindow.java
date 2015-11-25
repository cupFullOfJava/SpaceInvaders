package game;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
 
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
 

 
// TODO: Auto-generated Javadoc
/**
 * The Class GameWindow.
 */
public class GameWindow extends JFrame {
         
 
    /**
     * Instantiates a new game window.
     */
    public GameWindow()
    {
        System.out.println("Creating Game Window");
        setTitle("SpaceInvaders");
        Screen screen = new Screen(); 
        add(screen);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setResizable(false);
 
        screen.setFocusable(true);
        screen.requestFocusInWindow();
        setVisible(true);
         
    }
 
     
 
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        System.out.println("Game Started");
        try {
            playSound("01-title-screen.wav");
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
        GameWindow window = new GameWindow();
 
    }
     

    /**
     * Play sound.
     *
     * @param fileName the file name
     * @throws MalformedURLException the malformed url exception
     * @throws LineUnavailableException the line unavailable exception
     * @throws UnsupportedAudioFileException the unsupported audio file exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void playSound(String fileName) throws MalformedURLException, 
    LineUnavailableException, UnsupportedAudioFileException, IOException{
        File url = new File(fileName);
        Clip clip = AudioSystem.getClip();
         
        AudioInputStream ais = AudioSystem.getAudioInputStream(url);
        clip.open(ais);
        clip.start();
                 
    }
     
 
}