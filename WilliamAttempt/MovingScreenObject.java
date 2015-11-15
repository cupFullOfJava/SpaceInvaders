import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;

public class MovingScreenObject extends ScreenObject {
	
	protected MyVector vector;
	protected double angle;
	protected Image myImage;
	protected int age;
	protected int maxAge;
	
	
	/**
	 * Create a MovingScreenObject at a particular location, size, and image.
	 * Age will be initialized to zero.
	 * 
	 * @param location
	 *            The starting location.
	 * @param size
	 *            The starting size.
	 * @param angle
	 *            The object's orientation.
	 */
	public MovingScreenObject(Point location, Rectangle size, Image i,double angle) {
		super(location, size);
		myImage = i;
		this.angle = angle;
		age = 0;
		maxAge = Integer.MAX_VALUE;

		}
	


	public void move()
	{
		location.x += vector.getChangeX();
		location.y += vector.getChangeY();

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
	
	
	public MyVector getVector() {
		return vector;
	}
	
	public void setVector(MyVector vector)
	{
		this.vector = vector;
	}
	
	public Image getMyImage() 
	{
		return myImage;
	}
	
	public void setMyImage(Image myImage)
	{
		this.myImage = myImage;
	}
	
	public double getAngle() 
	{
		return angle;
	}
	
	public void setAngle(double angle)
	{
		this.angle = angle;
	}
	
	public int getAge() 
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public int getMaxAge()
	{
		return maxAge;
	}
	
	public void setMaxAge(int maxAge)
	{
		this.maxAge = maxAge;
	}
	
	
	
	
	
	
	
	public void draw(Graphics g) {
			// reminder ... later we want to rotate image by
			// changeX and changeY
			Graphics2D g2 = (Graphics2D) g;
			
			if (this instanceof Player) 
			{
				Player player = (Player) this;

				// AffineTransform identity = new AffineTransform();
				AffineTransform trans = new AffineTransform();
				// trans.setTransform(identity);
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
			

		}
		
	}
