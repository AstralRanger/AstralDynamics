import java.awt.Graphics;
import java.util.ArrayList;

public class Environment 
{
	private ArrayList <Item> items;
	
	public Environment ()
	{
		items = new ArrayList <Item> ();
	}
	
	public void addObj (Item item)
	{
		items.add(item);
	}
	
	public void show (Graphics g)
	{
		for (int c = 0; c < items.size(); c++)
			items.get(c).show(g);
	}
}
