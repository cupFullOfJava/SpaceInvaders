package game;


// TODO: Auto-generated Javadoc
/**
 * The Class MyVector.
 */
public class MyVector {
	
	/** The change x. */
	private double changeX;
	
	/** The change y. */
	private double changeY;


	/**
	 * Instantiates a new my vector.
	 *
	 * @param changeX the change x
	 * @param changeY the change y
	 */
	public MyVector(double changeX, double changeY)
	{
		super();
		this.changeX = changeX;
		this.changeY = changeY;
	}


	/**
	 * Gets the change x.
	 *
	 * @return the change x
	 */
	public double getChangeX()
	{
		return changeX;
	}


	/**
	 * Sets the change x.
	 *
	 * @param changeX the new change x
	 */
	public void setChangeX(double changeX)
	{
		this.changeX = changeX;
	}


	/**
	 * Gets the change y.
	 *
	 * @return the change y
	 */
	public double getChangeY()
	{
		return changeY;
	}



	/**
	 * Sets the change y.
	 *
	 * @param changeY the new change y
	 */
	public void setChangeY(double changeY)
	{
		this.changeY = changeY;
	}

}