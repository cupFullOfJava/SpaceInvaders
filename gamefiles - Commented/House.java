package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
 
 
 
 
/**
 * The Class House is one of four static houses that exist
 * on the screen.  They are can be hit a total of 30 times
 * before moving off screen.
 *
 * Super class is MovingScreenObject
 */
public class House extends MovingScreenObject {
     
    /** The Maximum number of times a house can be hit */
    int lifePoints = 30;
     
    /** The aliens x location. */
    int locationX;
     
    /** The aliens y location. */
    int locationY;
     
    /** The houses image */
    Image houseImage;
 
    /**
     * Instantiates a new house.
     *
     * @param location the Point
     * @param size the size
     * @param p the p
     */
    public House(Point location, Rectangle size, Image i) {
        super(location, size, i, 0);
        locationX = location.x;
        locationY = location.y;
        houseImage = i;
        System.out.println("A House Has Been Created"); //Console Output For Debugging.
    }
 
     
     
     
     
    /**
     * Quick Method for incrementing the hitCount
     */
    public void hit()
    {
        lifePoints--;
    }
     
       
    /**   Getters & Setters    */
     
    /**
     * Returns the amount of times the house has been hit.
     *
     * @return the hit count
     */
    public int getHitCount() {
        return lifePoints;
    }
     
    /**
     * Sets the amount of times the house has been hit.
     * @param hitCount the new hit count
     */
    public void setHitCount(int lifePoints) {
        this.lifePoints = lifePoints;
    }
 
 
    /**
     * Gets the x location of the house.
     *
     * @return the location x
     */
    public int getLocationX() {
        return locationX;
    }
 
    /**
     * Sets the x location of the house.
     *
     * @param locationX the new location x
     */
    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }
 
 
    /**
     * Gets the y location of the house.
     *
     * @return the location y
     */
    public int getLocationY() {
        return locationY;
    }
 
 
    /**
     * Sets the location y.
     *
     * @param locationY the new location y
     */
    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }
 
    /* 
     * Abstract Draw Method.
     */
    public void draw(Graphics g) 
    {
        Graphics g2 = (Graphics2D) g;
        g2.drawImage(houseImage, locationX, locationY, null);
        if(lifePoints > 20){
        	g2.setColor(Color.GREEN);
        }
        else if(lifePoints < 20 && lifePoints >= 10){
        	g2.setColor(Color.YELLOW);
        }
        else if(lifePoints < 10){
        	g2.setColor(Color.RED);
        }
        g2.drawString(String.valueOf(getHitCount()), locationX+18, locationY+40);
    }
     
 
}
