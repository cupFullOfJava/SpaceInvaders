/**
 * 
 * @author devante
 * Vector class to store the x and y values for space objects.
 *
 */
public class Vector {
	private double changeX;
	private double changeY;
	
	/**
	 * 
	 * @param changeX
	 * @param changeY
	 */
	public Vector(double changeX, double changeY){
		super();
		this.changeX = changeX;
		this.changeY = changeY;
		
	}
	/**
	 * Returns the change in X.
	 * @return change in x.
	 */
	public double getChangeX(){
		return changeX;
	}
	/**
	 * Sets the change in X.
	 * @param changeX - the new X.
	 */
	public void setChangeX(double changeX){
		this.changeX = changeX;
	}
	/**
	 * Returns the change in Y.
	 * @return change in Y.
	 */
	public double getChangeY(){
		return changeY;
	}
	/**
	 * Set the change in y.
	 * @param changeY - the new change in Y.
	 */
	public void setChangeY(double changeY){
		this.changeY = changeY;
	}

}
