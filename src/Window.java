import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

@SuppressWarnings("serial")
public class Window extends JFrame implements ActionListener
{
	JMenuBar menuBar;
	JMenu add;
	JMenuItem block; 
	JSpinner x_coord, y_coord, length, height, weight;
	JLabel x_coord_label, y_coord_label, length_label, height_label, weight_label;
	JPanel options;
	Environment screen;
	DrawArea center;
	
	public Window ()
	{
		screen = new Environment();
		center = new DrawArea(1000, 800);
		menuBar = new JMenuBar();
		
		
		// Dialog options
		options = new JPanel(new GridLayout (3, 4));
		
		// Dialog labels
		x_coord_label = new JLabel ("X ");
		y_coord_label = new JLabel (" Y ");
		length_label = new JLabel ("Length ");
		height_label = new JLabel (" Height ");
		weight_label = new JLabel ("Weight ");
		
		// Dialog spinners
		x_coord = new JSpinner (new SpinnerNumberModel (100, 0, 1000, 10));
		y_coord = new JSpinner (new SpinnerNumberModel (100, 0, 800, 10));
	    length = new JSpinner (new SpinnerNumberModel (100, 0, 800, 10));
		height = new JSpinner (new SpinnerNumberModel (100, 0, 600, 10));
		weight = new JSpinner (new SpinnerNumberModel (100, 0, 1000, 1));
		
		// Add to panel	
		options.add(x_coord_label);
		options.add(x_coord);
		options.add(y_coord_label);
		options.add(y_coord);
		options.add(length_label);
		options.add(length);
		options.add(height_label);
		options.add(height);
		options.add(weight_label);
		options.add(weight);
		
		
		// Add menu
		add = new JMenu("Add");
		
		block = new JMenuItem("Block");
		block.addActionListener(this);
		block.setActionCommand("Add Block");
		
		add.add(block);
		
		menuBar.add(add);
		
		this.setJMenuBar(menuBar);
		setContentPane(center);
		setTitle ("AstralDynamics");
		setSize (1000, 800);
		setResizable (false);
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo (null);  
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getActionCommand() == "Add Block")
		{
			int result = JOptionPane.showConfirmDialog(null, options, ""
					+ "Create New Block", JOptionPane.OK_CANCEL_OPTION); 
			if (result == JOptionPane.OK_OPTION)
			{
				Block temp = new Block ((int)x_coord.getValue(),
						 (int)y_coord.getValue(),
					     (int)length.getValue(),
						 (int)height.getValue(),
						 (int)weight.getValue());
			     screen.addObj(temp);
			}
		}
		repaint();
	}
	
	class DrawArea extends JPanel
    {
		public DrawArea (int width, int height)
		{
		    this.setPreferredSize (new Dimension (width, height)); // size
		}
	
	
		public void paintComponent (Graphics g)
		{
		    screen.show(g);
		}
    }
}
