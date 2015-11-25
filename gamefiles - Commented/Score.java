package game;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;



// TODO: Auto-generated Javadoc
/**
 * The Class Score.
 */
public class Score extends ScreenObject {
	
	/** The score. */
	private int score;


	/**
	 * Instantiates a new score.
	 *
	 * @param location the location
	 * @param size the size
	 */
	public Score(Point location, Rectangle size)
	{
		super(location, size);
		score = 0;
	}


	/* (non-Javadoc)
	 * @see game.ScreenObject#draw(java.awt.Graphics)
	 */
	public void draw(Graphics g) 
	{
	}


	/**
	 * Gets the score.
	 *
	 * @return the score
	 */
	public int getScore()
	{
		return score;
	}


	/**
	 * Sets the score.
	 *
	 * @param score the new score
	 */
	public void setScore(int score)
	{
		this.score = this.score + score;
	}
	
	
	
	
	
	
	
	

}