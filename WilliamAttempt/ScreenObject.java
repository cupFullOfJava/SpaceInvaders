import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public abstract class ScreenObject {
	protected Point location;
	protected Rectangle size;
	
	
	
	public ScreenObject (Point location, Rectangle size)
	{
		super();
		this.location = location;
		this.size = size;
	}
	
	public Point getLocation()
	{
		return location;
	}
	
	
	public Rectangle getSize()
	{
		return size;
	}
	
	
	public void setSize(Rectangle size)
	{
		this.size = size;
	}
	
	abstract public void draw(Graphics g);
	
}
