import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JPanel;



public class Screen extends JPanel implements KeyListener {

	
	public static int screenWidth = 600;
	public static int screenHeight = 500;
	public static ImageIcon backgroundImg = new ImageIcon("space.jpg");  //Courtesy of NASA
	public static ImageIcon alienImg = new ImageIcon("alien1.png");
	public static ImageIcon playerImg = new ImageIcon("player.png");
	
	public static int alienWidth = 35;
	public static int alienHeight = 35;
	public static int alienPoints = 10;
	
	
	private ArrayList<ScreenObject> screenObjects;
	private Score theScore;
	
	private javax.swing.Timer timer;
	
	private int lives = 3;  //Need to determine if this is correct
	
	
	public Screen()
	{
		setPreferredSize(new Dimension(screenWidth, screenHeight));
		setBackground(Color.black);
		screenObjects = new ArrayList<ScreenObject>();
		addPlayerAndAliens();  
		
		
		
		
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
		Player player = new Player(new Point(x,y), new Rectangle(20,20),playerImg.getImage());
		player.setVector(new MyVector(0,0));
		player.setAngle(0);
		System.out.println("Adding Player");
		screenObjects.add(0,player);
		
		//Adding Aliens
		System.out.println("Adding Aliens");
		
		int width = alienWidth;
		int height = alienHeight;
		int points = alienPoints;
		
		

		
		int rowCount = 0;
		for (int count = 0; count <55; count ++)
		{
			ScreenObject lastObj = screenObjects.get(count);
			
			//If the last object is the player, we need to set the first alien point
			if (lastObj instanceof Player)
			{
				x = screenWidth / 6;  //Centered
				y = screenHeight / 20; //Upper
			}
			
			//If the row is not full, continue
			else if (rowCount < 10)
			{				
				x = (int) lastObj.getLocation().getX() + 35;
				y = (int) lastObj.getLocation().getY();	
				rowCount++;
			}
			else  //If the row is full, start a new one, and go back to beginning. 
			{
				x = (int) lastObj.getLocation().getX() - 10*35;
				y = (int) lastObj.getLocation().getY() + 35;
				rowCount = 0;
			}
		
		
		
			Alien alien = new Alien (new Point(x,y), new Rectangle (width,height), points,
				alienImg.getImage());
		
			screenObjects.add(alien);
		}
		
		
		
		
	}		
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
		
	}
	public javax.swing.Timer getTimer() {
		return timer;
	}
	public void setTimer(javax.swing.Timer timer) {
		this.timer = timer;
	}
		
		

	private class TimerListener implements ActionListener {

		/*
		 * Remove any objects that are beyond their maximum age.
		 * See if there are any collisions.  Remove asteroids,
		 * shots, and the ship if necessary.  Add an explosion for collisions.
		 * 
		 * Move each object.
		 * Then repaint.  
		 */
		
		public void actionPerformed(ActionEvent arg0) 
		{
			// move each object
			for (ScreenObject obj : screenObjects)
			{
				if (obj instanceof MovingScreenObject)
				{
					MovingScreenObject movingObj = (MovingScreenObject) obj;
					movingObj.move();
				}
			}
			repaint();
		}
	}
			
		public void keyPressed(KeyEvent event) {
			int keyCode = event.getKeyCode();
			Player player = null;
			if (screenObjects.get(0) instanceof Player) 
			{
				player = (Player) screenObjects.get(0);
			}
			switch (keyCode) {
			
			case KeyEvent.VK_RIGHT:
				if (player != null) 
				{
					double newAngle = player.getAngle() + 5;
					if (newAngle > 360) 
					{
						newAngle -= 360;
					}
					player.setAngle(newAngle);
				}
				break;
			
			case KeyEvent.VK_LEFT:
				if (player != null) {
					double newAngle = player.getAngle() - 5;
					if (newAngle < 0) {
						newAngle += 360;
					}
					player.setAngle(newAngle);
				}
				break;
			}
			
		repaint();
			
		}
	
		
	
	
	
		public void keyReleased(KeyEvent arg0) 
		{
			// TODO Auto-generated method stub
		}

		public void keyTyped(KeyEvent arg0) 
		{
			// TODO Auto-generated method stub
		}
			
}


