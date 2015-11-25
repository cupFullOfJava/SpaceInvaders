package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;



// TODO: Auto-generated Javadoc
/**
 * The Class Shot.
 */
public class Shot extends MovingScreenObject {


	/**
	 * Instantiates a new shot.
	 *
	 * @param location the location
	 * @param size the size
	 * @param i the i
	 * @param angle the angle
	 */
	public Shot(Point location, Rectangle size, Image i, double angle) {
		super(location, size, i, angle);
		

		double endX = location.x;
		double endY = location.y + 5;

		
		double newEndX = 
				location.x + (endX -location.x)*Math.cos(Math.toRadians(angle));
		double newEndY =
				location.y + (endX - location.x)*Math.sin(Math.toRadians(angle));
		
		double changeX = (newEndX - location.x);
		double changeY = (newEndY - location.y);
		vector = new MyVector(changeX, changeY);

		maxAge = Screen.screenHeight/5;
	}
	

	/* (non-Javadoc)
	 * @see game.MovingScreenObject#draw(java.awt.Graphics)
	 */
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		AffineTransform old = g2.getTransform();
		g2.setColor(Color.yellow);
		Rectangle2D.Double ray =
				new Rectangle2D.Double(location.x, location.y,
						size.getWidth(), size.getHeight());
		AffineTransform at = g2.getTransform();
		at.rotate(Math.toRadians(angle), location.x, location.y);
		g2.setTransform(at);
		g2.fill(ray);
		g2.setTransform(old);
		
	}

}