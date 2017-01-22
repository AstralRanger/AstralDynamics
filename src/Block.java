import java.util.ArrayList;

public class Block extends Item 
{
	private int mass;
	private final String BLOCK_URL = "block";
	public Block (int x, int y, int length, int height, int mass)
	{
		this.length = length;
		this.height = height;
		this.mass = mass;
		points = new ArrayList <Point> ();
		
		points.add(new Point (x, y));
		points.add(new Point (x + length, y));
		points.add(new Point (x, y + height));
		points.add(new Point (x + length, y + height));	
		
		url = BLOCK_URL;
	    loadImage();
	}
	
	public int getMass()
	{
		return mass;
	}
}
