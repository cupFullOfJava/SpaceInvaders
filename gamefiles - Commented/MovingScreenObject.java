package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;



// TODO: Auto-generated Javadoc
/**
 * The Class MovingScreenObject.
 */
public class MovingScreenObject extends ScreenObject {
	
	/** The vector. */
	protected MyVector vector;
	
	/** The angle. */
	protected double angle;
	
	/** The my image. */
	protected Image myImage;
	
	/** The age. */
	protected int age;
	
	/** The max age. */
	protected int maxAge;
	
	
	
	
	/**
	 * Instantiates a new moving screen object.
	 *
	 * @param location the location
	 * @param size the size
	 * @param i the i
	 * @param angle the angle
	 */
	public MovingScreenObject(Point location, Rectangle size, Image i,double angle) {
		super(location, size);
		myImage = i;
		this.angle = angle;
		age = 0;
		maxAge = Integer.MAX_VALUE;

		}
	
	/**
	 * Collide.
	 *
	 * @param otherObj the other obj
	 * @return true, if successful
	 */
	public boolean collide(MovingScreenObject otherObj) {
		Rectangle otherR = otherObj.getSize();
		otherR.setLocation(otherObj.getLocation());
		this.getSize().setLocation(this.getLocation());
		if (otherR.intersects(this.getSize())) {
			return true;
		}
		return false;
	}



	/**
	 * Move.
	 */
	public void move()
	{
		location.x = (int) vector.getChangeX();
		location.y = Screen.screenHeight - 20;

		if (location.x > Screen.screenWidth) 
		{
			location.x -= Screen.screenWidth;
		}
		if (location.x < 0)
		{
			location.x += Screen.screenWidth;
		}

		if (location.y > Screen.screenHeight) 
		{
			location.y -= Screen.screenHeight;
		}
		if (location.y < 0)
		{
			location.y += Screen.screenHeight;
		}
		
	}


	/**
	 * Move shot.
	 */
	public void moveShot()
	{
			location.y -= 1;	
		
	}

	/**
	 * Move alien shot.
	 */
	public void moveAlienShot()
	{
		location.y += 1;
	}


	/**
	 * Move alien.
	 */
	public void moveAlien()
	{
		
		if (location.x > Screen.screenWidth-50){
			location.y += 35;
			location.x = 15;
		}
		else {
			location.x += 35;
		}
	}

	/**
	 * Move saucer.
	 *
	 * @return the int
	 */
	public int moveSaucer()
	{
		
		if (location.x == 0){
			location.x = Screen.screenWidth - 50;
		}
		else
		{
			location.x -= 1;
		}
		
		return location.x;
	}



	/**
	 * Gets the vector.
	 *
	 * @return the vector
	 */
	public MyVector getVector() {
		return vector;
	}


	/**
	 * Sets the vector.
	 *
	 * @param vector the new vector
	 */
	public void setVector(MyVector vector)
	{
		this.vector = vector;
	}


	/**
	 * Gets the my image.
	 *
	 * @return the my image
	 */
	public Image getMyImage() 
	{
		return myImage;
	}


	/**
	 * Sets the my image.
	 *
	 * @param myImage the new my image
	 */
	public void setMyImage(Image myImage)
	{
		this.myImage = myImage;
	}


	/**
	 * Gets the angle.
	 *
	 * @return the angle
	 */
	public double getAngle() 
	{
		return angle;
	}


	/**
	 * Sets the angle.
	 *
	 * @param angle the new angle
	 */
	public void setAngle(double angle)
	{
		this.angle = angle;
	}


	/* (non-Javadoc)
	 * @see game.ScreenObject#draw(java.awt.Graphics)
	 */
	public void draw(Graphics g) {

			Graphics2D g2 = (Graphics2D) g;
			
			if (this instanceof Player) 
			{
				Player player = (Player) this;

				AffineTransform trans = new AffineTransform();
				trans.translate(location.x, location.y);
				trans.scale(0.25, 0.25);

				trans.rotate(Math.toRadians(player.getAngle()),
						myImage.getWidth(null) / 2, myImage.getHeight(null) / 2);

				g2.drawImage(myImage, trans, null);
			} 
			if (this instanceof Alien)
			{
				g2.drawImage(myImage, location.x, location.y, size.width,
						size.height, null);
			}
			if (this instanceof Saucer)
			{
				g2.drawImage(myImage, location.x, location.y, size.width,
						size.height, null);
			}
			

		}
}
		