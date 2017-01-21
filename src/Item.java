import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public abstract class Item 
{
	protected ArrayList <Point> points;
	protected int length; 
	protected int height;
	
	public void show (Graphics g)
	{
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(points.get(1).getX(), points.get(1).getY(), length, height);
	}
}
