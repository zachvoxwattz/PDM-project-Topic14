package ui_v2;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

public class App extends JPanel
{
	private static final long serialVersionUID = 1768021579204985820L;
	public static int APP_WX = 1280, APP_WY = 720;
	
	private LoginWindow logWin;
	
	public App()
	{
		super();
			setPreferredSize(new Dimension(APP_WX, APP_WY));
			setLayout(new BorderLayout());
		
		logWin = new LoginWindow(this);
			add(logWin);
	}
	
	public void stopAshowB(JPanel a, JPanel b)
	{
		remove(a);
		add(b);
		fetchScreen();
	}
	
	void fetchScreen() { validate(); repaint(); }
}