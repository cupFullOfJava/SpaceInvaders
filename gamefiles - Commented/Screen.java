

 
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
 
 
 
 

/**
 * The Class Screen.
 */
public class Screen extends JPanel implements KeyListener {
 
	/** The shotx. */
	public static int shotx = 30;
	
	/** The found. */
	private static boolean found = true; 

	/** The acount. */
	private static int acount = 55;
     
    /** The screen width. */
    public static int screenWidth = 600;
    
    /** The screen height. */
    public static int screenHeight = 500;
    
    /** The background img. */
    public static ImageIcon backgroundImg = new ImageIcon("space.jpg");  //Courtesy of NASA
    
    /** The alien img. */
    public static ImageIcon alienImg = new ImageIcon("alien1.png");
    
    /** The alien img2. */
    public static ImageIcon alienImg2 = new ImageIcon("alien2.jpg");
    
    /** The player img. */
    public static ImageIcon playerImg = new ImageIcon("player.png");
    
    /** The shot img. */
    public static ImageIcon shotImg = new ImageIcon("bullet.png");
    
    /** The enemy img. */
    public static ImageIcon enemyImg = new ImageIcon("enemybullet.png");
    
    /** The saucer img. */
    public static ImageIcon saucerImg = new ImageIcon("Saucer.png");
    
    /** The house img. */
    public static ImageIcon houseImg = new ImageIcon("house.png");
    
    /** The win img. */
    public static ImageIcon winImg = new ImageIcon("winner.png");
    
    /** The lose img. */
    public static ImageIcon loseImg = new ImageIcon("losered.png");
    
    /** The fire img. */
    public static ImageIcon fireImg = new ImageIcon("fire.jpg");
    
    /** The win. */
    private static boolean win = false;
    
    /** The lose. */
    private static boolean lose = false;
    
     
    /** The alien width. */
    public static int alienWidth = 35;
    
    /** The alien height. */
    public static int alienHeight = 35;
    
    /** The alien points. */
    public static int alienPoints = 10;
    
    /** The saucer width. */
    public static int saucerWidth = 80;
    
    /** The saucer height. */
    public static int saucerHeight = 60;
    
    /** The saucer points. */
    public static int saucerPoints = 100;
    
    /** The game soundtrack. */
    public Sound start = new Sound("01-title-screen.wav");
 
    /** The score pane. */
    JTextField scorePane = new JTextField();
    
    /** The lives pane. */
    JTextField livesPane = new JTextField();
    
    /** The slives pane. */
    JTextField slivesPane = new JTextField();
    
    /** The flash. */
    JTextField flash = new JTextField();
    
    /** The house. */
    public static ArrayList<JTextField> house = new ArrayList<JTextField>();
    
    /** The saucer life. */
    int saucerLife = 100;
     
     
    /** The screen objects. */
    private ArrayList<ScreenObject> screenObjects;
    
    /** The score. */
    private Score theScore;
     
    /** The timer. */
    private javax.swing.Timer timer;
    
    /** The alientimer. */
    private javax.swing.Timer alientimer;
    
    /** The saucertimer. */
    private javax.swing.Timer saucertimer;
     
    /** The lives. */
    private int lives = 3;  //Need to determine if this is correct
     
     
    /**
     * Instantiates a new screen.
     */
    public Screen()
    {
        setPreferredSize(new Dimension(screenWidth, screenHeight));
        setBackground(Color.black);
        setLayout(null);
        screenObjects = new ArrayList<ScreenObject>();
        addPlayerAndAliens();
         
        theScore = new Score(new Point(screenWidth/2 - 5, 30), new Rectangle(0,0));
        screenObjects.add(theScore);
 
        
        scorePane.setText("Score: " + theScore.getScore());
        scorePane.setEditable(false);
        scorePane.setForeground(Color.WHITE);
        scorePane.setBackground(Color.BLACK);
        scorePane.setBounds(0,0,100,20);
        add(scorePane);
        
       
        
        
        
 
        
        livesPane.setText("Lives: " + lives);
        livesPane.setEditable(false);
        livesPane.setForeground(Color.GREEN);
        livesPane.setBackground(Color.BLACK);
        livesPane.setBounds(550,0,70,20);
        add(livesPane);
        
        slivesPane.setText("Saucer Life: " + saucerLife);
        slivesPane.setEditable(false);
        slivesPane.setForeground(Color.WHITE);
        slivesPane.setBackground(Color.BLACK);
        slivesPane.setBounds(260,0,100,20);
        add(slivesPane);
 
        this.addKeyListener(this);
         
        timer = new javax.swing.Timer(30, new TimerListener());
        timer.start();
         
        alientimer = new javax.swing.Timer(1500, new AlienTimerListener());
        alientimer.start();
        
        saucertimer = new javax.swing.Timer(30, new SaucerTimerListener());
        saucertimer.start();
        start.play();
        
        
    }
 
 
    /**
     * This method removes all moving objects from the screen and
     * creates and adds new ones.  
     */
    public void addPlayerAndAliens()
    {
        System.out.println("Clearing Moving Screen Objects");
        Iterator<ScreenObject> it = screenObjects.iterator();
        //iterating through our arraylist of objects
        while (it.hasNext())
        {
            ScreenObject obj = it.next();
            if(obj instanceof MovingScreenObject) //checking if it is a moving object
            {
                it.remove();
            }
        }
         
        int x = screenWidth / 2 - 10; //middle of the screen
        int y = screenHeight - 30; //bottom of the screen
         
        //Adding Player
        System.out.println("Creating Player");
        Player player = new Player(new Point(x,y), new Rectangle(35,5),playerImg.getImage());
        player.setVector(new MyVector(300,0));
        player.setAngle(0);
        System.out.println("Adding Player");
        screenObjects.add(0,player);
         
        //Adding Aliens
        addAliens();
        
        
        int houseX = 100;
        int houseY = 400;
        for(int c = 0; c<4; c++)
        {
        	House h = new House(new Point(houseX,houseY), new Rectangle(50,50), houseImg.getImage());
        	screenObjects.add(h);
        	houseX += 125;
        }
        
        int sX = screenWidth-50;  //Centered
        int sY = screenHeight - 470; //Upper
 
        //Adding Saucer #1
        System.out.println("Adding Saucer");
        Saucer s = new Saucer(new Point(sX, sY), new Rectangle(saucerWidth,saucerHeight), saucerPoints, saucerImg.getImage());
        s.setVector(new MyVector(0,0));
        s.setAngle(0);
        screenObjects.add(s);
        
        /*Saucer s1 = new Saucer(new Point(70, sY), new Rectangle(saucerWidth,saucerHeight), saucerPoints, saucerImg.getImage());
        s1.setVector(new MyVector(0,0));
        s1.setAngle(0);
        screenObjects.add(s1);*/
    }
    /**
     * Sound class that handles starting and stopping the soundtrack.
     *
     * @param fileName the file name
     * @throws MalformedURLException the malformed url exception
     * @throws LineUnavailableException the line unavailable exception
     * @throws UnsupportedAudioFileException the unsupported audio file exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public class Sound {
        private Clip clip;
        public Sound(String fileName) {
            // specify the sound to play
            // (assuming the sound can be played by the audio system)
            // from a wave File
            try {
                File file = new File(fileName);
                if (file.exists()) {
                    AudioInputStream sound = AudioSystem.getAudioInputStream(file);
                 // load the sound into memory (a Clip)
                    clip = AudioSystem.getClip();
                    clip.open(sound);
                }
                else {
                    throw new RuntimeException("Sound: file not found: " + fileName);
                }
            }
            catch (MalformedURLException e) {
                e.printStackTrace();
                throw new RuntimeException("Sound: Malformed URL: " + e);
            }
            catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
                throw new RuntimeException("Sound: Unsupported Audio File: " + e);
            }
            catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Sound: Input/Output Error: " + e);
            }
            catch (LineUnavailableException e) {
                e.printStackTrace();
                throw new RuntimeException("Sound: Line Unavailable Exception Error: " + e);
            }

        // play, stop, loop the sound clip
        }
        public void play(){
            clip.setFramePosition(0);  // Must always rewind!
            clip.start();
        }
        public void loop(){
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        public void stop(){
                clip.stop();
            }
        }
    
   
                 
    

    /* (non-Javadoc)
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    public void paintComponent(Graphics g) {
        screenWidth = this.getWidth();
        screenHeight = this.getHeight();
        super.paintComponent(g);
        g.drawImage(backgroundImg.getImage(),
        0, 0, screenWidth, screenHeight, null);
         
        for (ScreenObject obj : screenObjects) 
        {
            obj.draw(g);
        }
        if (win == true){
        	g.drawImage(winImg.getImage(), 140, 175, null);
        	timer.stop();
        	alientimer.stop();
        	saucertimer.stop();
        	start.stop();
        	
        }
        if (lose == true){
        	g.drawImage(fireImg.getImage(),
        	        0, 0, screenWidth, screenHeight, null);
        	g.drawImage(loseImg.getImage(), 140, 175, null);
        	timer.stop();
        	alientimer.stop();
        	saucertimer.stop();
        	start.stop();
        	
        }
         
    }
    
    /**
     * Gets the timer.
     *
     * @return the timer
     */
    public javax.swing.Timer getTimer() {
        return timer;
    }
    
    /**
     * Sets the timer.
     *
     * @param timer the new timer
     */
    public void setTimer(javax.swing.Timer timer) {
        this.timer = timer;
    }
         
    /**
     * The listener interface for receiving alienTimer events.
     * The class that is interested in processing a alienTimer
     * event implements this interface, and the object created
     * with that class is registered with a component using the
     * component's <code>addAlienTimerListener<code> method. When
     * the alienTimer event occurs, that object's appropriate
     * method is invoked.
     * Handles moving the aliens and checking to see if they've reached a certain pos
     * on the screen, if they do it resets them to their original pos.
     *
     * @see AlienTimerEvent
     */
    private class AlienTimerListener implements ActionListener {
        
        /* (non-Javadoc)
         * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
         */
        public void actionPerformed(ActionEvent arg0)
        {
        	
            
            AlienShot shot = new AlienShot(new Point(shotx+35,60),new Rectangle(4,12), enemyImg.getImage(), 180.0);
            screenObjects.add(shot);
            //shot.moveAlienShot();
            //repaint();
            for (int z = 0; z < screenObjects.size(); z++)
            {
            	ScreenObject obj = screenObjects.get(z);
        		
                if (obj instanceof Alien)
                {
                    MovingScreenObject movingObj = (MovingScreenObject) obj;
                        movingObj.moveAlien();  
                        checkPos();
                        
                }
                
                                
            }
            
            
        }
    }
    
    /**
     * Check pos.
     */
    private void checkPos() {
		for(int i = screenObjects.size()-1; i >= 0; i--){
			ScreenObject obj = screenObjects.get(i);
			if (obj instanceof MovingScreenObject){
                MovingScreenObject movingObj = (MovingScreenObject)obj;
				//System.out.println("I got to the 1st for loop");
				if (movingObj instanceof Alien)
				{
					//System.out.println("I got to 2nd if statement");
					Point p = new Point();
					p = movingObj.getLocation();
					int y = p.y;
					if (y >= 400)
					{	
						
						System.out.print(screenObjects.size());
						for (int x = 0; x < screenObjects.size(); x++){
							//System.out.println("I got to the 2nd for loop");
							ScreenObject remove = screenObjects.get(x);
							if(remove instanceof MovingScreenObject){
								MovingScreenObject rA = (MovingScreenObject) remove;
								if (rA instanceof Alien)
								{
									//alientimer.stop();
									x -= 1;
									screenObjects.remove(rA);
									
								}
								
							}
							
						}
						addAliens();
						acount = 55;
						//alientimer.start();
					//break;
				}
					break;
			}
		}
			
		}
	}
	

		
		
    
    /**
     * The listener interface for receiving saucerTimer events.
     * The class that is interested in processing a saucerTimer
     * event implements this interface, and the object created
     * with that class is registered with a component using the
     * component's <code>addSaucerTimerListener<code> method. When
     * the saucerTimer event occurs, that object's appropriate
     * method is invoked.
     * Handles the saucers movements.
     *
     * @see SaucerTimerEvent
     */
    private class SaucerTimerListener implements ActionListener {
    	
	    /* (non-Javadoc)
	     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	     */
	    public void actionPerformed(ActionEvent arg0){
    		for (ScreenObject obj : screenObjects)
    		{
    			if (obj instanceof Saucer)
    			{
    				MovingScreenObject movingObj = (MovingScreenObject) obj;
                    shotx = movingObj.moveSaucer(); 
    			}
    		}
    	}
    }
 
    /**
     * Adds the aliens.
     */
    public void addAliens(){
    	//Adding Aliens
        System.out.println("Adding Aliens");
         
        int width = alienWidth;
        int height = alienHeight;
        int points = alienPoints;
        
        int x = 0;
        int y = 70;
        
        int rowCount = -1;
        for (int count = 0; count <55; count ++){
        	if(rowCount < 10)
        	{
        		x += 35;
        		rowCount++;
        	}
        	else
        	{
        		x = 35;
        		y += 35;
        		rowCount = 0;
        	}
        	
        	Alien alien = new Alien (new Point(x,y), new Rectangle (width,height), points,
                    alienImg.getImage());
            alien.setVector(new MyVector(0, 0));
             
            screenObjects.add(alien);
        }
        
        
        
         
        
      
    }
    
    /**
     * The listener interface for receiving timer events.
     * The class that is interested in processing a timer
     * event implements this interface, and the object created
     * with that class is registered with a component using the
     * component's <code>addTimerListener<code> method. When
     * the timer event occurs, that object's appropriate
     * method is invoked.
     * Handles all the collisions that take place.
     *
     * @see TimerEvent
     */
    private class TimerListener implements ActionListener {
 
       
        
    
    	
        /* (non-Javadoc)
         * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
         */
        public void actionPerformed(ActionEvent arg0) 
        {
        	
        
        	for (int i =0; i < screenObjects.size(); i++){
        		ScreenObject obj = screenObjects.get(i);
        		
   
    		
        		
       
        		
        		if (obj instanceof MovingScreenObject){
        			MovingScreenObject movingObj = (MovingScreenObject) obj;
        			for (int j = i + 1; j < screenObjects.size(); j++){
        				ScreenObject otherObj = screenObjects.get(j);
        				if (!(otherObj instanceof MovingScreenObject)) {
        					continue;
        				}
        				if (movingObj == otherObj){
        					continue;
        				}
        			
      
        				if (otherObj instanceof MovingScreenObject){
        					MovingScreenObject otherMovingObj = (MovingScreenObject) otherObj;
        					if (movingObj.collide(otherMovingObj)){ //checks if there were any collisions then sees what kind of collision it was.
        						
        						
        						if (movingObj instanceof Player){ // ship collides with alien shot
        							if (otherMovingObj instanceof AlienShot){
        								screenObjects.remove(movingObj); // remove alien
        								screenObjects.remove(otherMovingObj);
        							
        								try {
        									
											Thread.sleep(400);
											
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
        								lives -= 1;
        								if (lives == -1){
        									lose = true;
        									break;
        								}
        								else{
        									if(lives < 3){
        										livesPane.setForeground(Color.YELLOW);
        									}
        									if(lives == 0){
        										livesPane.setForeground(Color.RED);
        				
        									}
        									livesPane.setText("Lives: "+lives);
        									
        									//screenObjects.add(0,movingObj);
        									//flash.setVisible(true);
        									Player player = new Player(new Point(0,screenHeight - 30), new Rectangle(35,5),playerImg.getImage());
        							        player.setVector(new MyVector(300,0));
        							        player.setAngle(0);
        							        System.out.println("Adding Player");
        							        screenObjects.add(0,player);
        									
        									}
        								
        								continue;
        							}
        								
        							
        		
        							break;
        						}
        						else if (movingObj instanceof Alien)
        						{
        							if (otherMovingObj instanceof Shot)
        							{
        								theScore.setScore(((Alien) movingObj).getPointValue());
        								scorePane.setText("Score: "+ theScore.getScore());
        								screenObjects.remove(otherMovingObj);
        								screenObjects.remove(movingObj);
        								acount --;
        							}
        							break;
        						}
        						else if(acount == 0){
        						
        		    				addAliens();
        		    				acount = 55;
        		    				
	
        		    			}
        						else if (movingObj instanceof Saucer)
        						{
        							if (otherMovingObj instanceof Shot)
        							{
        								theScore.setScore(((Saucer) movingObj).getPointValue());
        								scorePane.setText("Score: "+ theScore.getScore());
        								screenObjects.remove(otherMovingObj);
        								if(saucerLife == 0){
        									screenObjects.remove(movingObj);
        									win = true;
        				
        								}
        								else{
        									saucerLife -= 1;
        								}
        								slivesPane.setText("Saucer Life: " + saucerLife);
        							}
        						}
        						else if (movingObj instanceof House){
        							if (otherMovingObj instanceof AlienShot)
        							{
        								screenObjects.remove(otherMovingObj);
        								int hit = ((House) movingObj).getHitCount();
        								if (hit == 0){
        									screenObjects.remove(movingObj);
        								}
        								else{
        									((House) movingObj).hit();
        								}
        							}
        							else if (otherMovingObj instanceof Shot)
        							{
        								screenObjects.remove(otherMovingObj);
        								int hit = ((House) movingObj).getHitCount();
        								if (hit == 0){
        									screenObjects.remove(movingObj);
        								}
        								else{
        									((House) movingObj).hit();
        								}
        							}
        						}
        						
        						
        					}
        				}
        			}
        		}
        	}
            // move each object
            for (ScreenObject obj : screenObjects)
            {
                if (obj instanceof Player)
                {
                    MovingScreenObject movingObj = (MovingScreenObject) obj;
                    movingObj.move();
                     
                }
                if (obj instanceof Shot)
                {
                    MovingScreenObject movingObj = (MovingScreenObject) obj;
                    for (int i = 0; i < 15; i++){
                    movingObj.moveShot();
                    
                    }repaint();
                }
                if (obj instanceof AlienShot)
                {
                	MovingScreenObject movingObj = (MovingScreenObject) obj;
                    for (int i = 0; i < 15; i++){
                    movingObj.moveAlienShot();
                    repaint();
                }
                }

                
                 
            }
            //repaint();
        }
    }
     
             
        /* (non-Javadoc)
         * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
         */
        public void keyReleased(KeyEvent event) {
            int keyCode = event.getKeyCode();
            Player player = null;
            if (screenObjects.get(0) instanceof Player) 
            {
                player = (Player) screenObjects.get(0);
            }
            switch (keyCode) {
            
                 
            case KeyEvent.VK_SPACE:
                if (player != null) {
                Point p = player.getLocation();
                double a = player.getAngle();
                //Rectangle r = player.getSize();
                Shot shot = new Shot(new Point(p.x + 10, p.y - 15), new Rectangle(4, 12), shotImg.getImage(), a);
                screenObjects.add(shot);
                }
                break;
                
                
                
            }
             
        repaint();
             
        }
     
         
     
        /* (non-Javadoc)
         * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
         */
        public void keyPressed(KeyEvent event)
        {
        	int keyCode = event.getKeyCode();
            Player player = null;
            if (screenObjects.get(0) instanceof Player) 
            {
                player = (Player) screenObjects.get(0);
            }
            switch (keyCode) {
             
            case KeyEvent.VK_RIGHT:
                // move right
                if (player != null) 
                {
                    Point location = player.getLocation();
                    // set up changeX 
                    // we're going to move by 10 pixels
                    double endX = location.x + 10;
                    if (location.x == screenWidth-20){ //If it's at the end of the screen.
                        endX = location.x - 0;
                    }
                    MyVector vector = new MyVector(endX, location.y);
                    player.setVector(vector);
                     
                     
                }
                break;
             
            case KeyEvent.VK_LEFT:
            {
                Point location = player.getLocation();
                // set up changeX 
                // we're going to move by 10 pixels
                double endX = location.x - 10;
                if (location.x == 0){ //If it's at the end of the screen.
                    endX = location.x - 0;
                }
                MyVector vector = new MyVector(endX, location.y);
                player.setVector(vector);
            }
            break;
                
            }   
            repaint();
                
            
                 
        }
     
      
 
        /* (non-Javadoc)
         * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
         */
        public void keyTyped(KeyEvent arg0) 
        {
            // TODO Auto-generated method stub
        }
             
}