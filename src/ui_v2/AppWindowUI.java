package ui_v2;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class AppWindowUI extends JFrame
{
	private static final long serialVersionUID = 1603913893126945007L;
	private App app;
	
	public AppWindowUI()
	{
		super();
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setTitle("PDM Project");
			setLayout(new BorderLayout());
		
		app = new App();
			add(app);
			pack();
			setLocationRelativeTo(null);
	}
	
	void execute() { setVisible(true); }
	
	public static void main(String[] r)
	{
		SwingUtilities.invokeLater(new Runnable()
			{
				@Override
				public void run()
				{
					AppWindowUI ui = new AppWindowUI();
						ui.execute();
				}
			}
		);
	}
}
