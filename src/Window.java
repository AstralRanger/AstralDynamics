import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Window extends JFrame
{
	public Window ()
	{
		setTitle ("AstralDynamics");
		setSize (1000, 600);
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo (null);  
	}
}
