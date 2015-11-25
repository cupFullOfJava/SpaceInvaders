package game;

import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;


// TODO: Auto-generated Javadoc
/**
 * The Class Enemy.
 */
public class Enemy extends MovingScreenObject {
	
	/** The point value. */
	protected int pointValue;


	/**
	 * Instantiates a new enemy.
	 *
	 * @param p the p
	 * @param s the s
	 * @param pv the pv
	 * @param i the i
	 */
	public Enemy(Point p, Rectangle s, int pv, Image i) {
		super(p, s, i, 0);
		pointValue = pv;
	}


	/**
	 * Gets the point value.
	 *
	 * @return the point value
	 */
	public int getPointValue() {
			return pointValue;
		}


	/**
	 * Sets the point value.
	 *
	 * @param pointValue the new point value
	 */
	public void setPointValue(int pointValue) {
		this.pointValue = pointValue;
	}
	

}