
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public abstract class Item 
{
	protected ArrayList <Point> points;
	protected int length; 
	protected int height;
	protected String url;
	protected Image image;
	
	public void loadImage ()
	{
		Image temp = null;
		try
	    {
			temp = ImageIO.read (new File ("Images/" + url + ".png")); // load file into Image object     
	    }
	    catch (IOException e) // Catch exception if image does not exist
	    {
	    }
		image = temp;
	}
	
	public void show (Graphics g)
	{
		g.drawImage(image, points.get(1).getX(), points.get(1).getY(), length, height, null);
	}
}
