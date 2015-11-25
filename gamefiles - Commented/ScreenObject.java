package game;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;



// TODO: Auto-generated Javadoc
/**
 * The Class ScreenObject.
 */
public abstract class ScreenObject {
	
	/** The location. */
	protected  Point location;
	
	/** The size. */
	protected Rectangle size;



	/**
	 * Instantiates a new screen object.
	 *
	 * @param location the location
	 * @param size the size
	 */
	public ScreenObject (Point location, Rectangle size)
	{
		super();
		this.location = location;
		this.size = size;
	}


	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	public Point getLocation()
	{
		return location;
	}


	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public Rectangle getSize()
	{
		return size;
	}


	/**
	 * Sets the size.
	 *
	 * @param size the new size
	 */
	public void setSize(Rectangle size)
	{
		this.size = size;
	}


	/**
	 * Draw.
	 *
	 * @param g the g
	 */
	abstract public void draw(Graphics g);
	
}