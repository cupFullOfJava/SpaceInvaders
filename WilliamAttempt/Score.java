import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class Score extends ScreenObject {
	
	private int score;
	
	public Score(Point location, Rectangle size)
	{
		super(location, size);
		score = 0;
	}

	
	public void draw(Graphics g) 
	{
	}
	
	public int getScore()
	{
		return score;
	}
	
	public void setScore(int score)
	{
		this.score = score;
	}
	
	
	
	
	
	
	
	

}
