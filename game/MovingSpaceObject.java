import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MovingSpaceObject extends SpaceObject{
	Vector vector;
	Image myImage;
	
	
	
	public MovingSpaceObject(Point location, Rectangle size, Image i){
		super(location, size);
		myImage = i;
	}
	/**
	 * Changes the x and y vector values to make object move. Then redraws the objects.
	 */
	public Vector move(){
		location.x += vector.getChangeX();
		location.y += vector.getChangeY();
		
		if (location.x > Screen.screenWidth){
			location.x -= Screen.screenWidth;
		}
		if (location.x < 0) {
			location.x += Screen.screenWidth;
		}
		
		if (location.y > Screen.screenHeight) {
			location.y -= Screen.screenHeight;
		}
		if (location.y < 0) {
			location.y += Screen.screenHeight;
		}
		public void draw(Graphics g){
			Graphics2D g2 = (Graphics2D) g;
			g2.drawImage(myImage, location.x, location.y,
					size.width, size.height, null);
		}		
	}
	
	/**
	 * Gets the vector for a moving space object.
	 * @return - the vector.
	 */
	public Vector getVector() {
		return vector;
	}
	/**
	 * Set the vector for a moving space object.
	 * @param vector - the new vector.
	 */
	public void setVector(Vector vector){
		this.vector = vector;
	}
	/**
	 * Gets the image for a space object.
	 * @return
	 */
	public Image getImage(){
		return myImage;
	}
	public void setImage(Image image){
		this.myImage = image;
	}
	
	private class InputHandler extends KeyAdapter{
		
		public void keyPressed(KeyEvent e){
			if (e.getKeyCode() == KeyEvent.VK_LEFT){
				leftPressed = true;
				//move ship left
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT){
				rightPressed = true;
				//move ship right
			}
			if (e.getKeyCode() == KeyEvent.VK_UP){
				upPressed = true;
				//shoot
			}
			if (e.getKeyCode() == KeyEvent.VK_SPACE){
				spacePressed = true;
				//shoot
			}
			
		}
		//We need to figure out where to put this code.
		addKeyListener(new InputHandler)
		if ((leftPressed) && (!rightPressed)){
			ship.vector.setChangeX(val);
		}
		if ((rightPressed)) && (!leftPressed)){
			ship.vector.setChangeX(val);
		}
			
	}

}
