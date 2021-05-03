package ui_v2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class WaitWindow extends JPanel
{
	private static final long serialVersionUID = 4177136426902704138L;
	private JLabel wait;
	private Timer delay;
	private App core;
	
	public WaitWindow(App co)
	{
		super();
			setPreferredSize(new Dimension(App.APP_WX, App.APP_WY));
			setLayout(new BorderLayout());
		
		this.core = co;
		delay = new Timer(2000, new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{ core.stopAshowB(getScreen(), new SelectionWindow(core)); }
			}
		);
		
		delay.start();
		wait = new JLabel("Please wait");
			wait.setFont(new Font("Consolas", Font.BOLD, 36));
			wait.setHorizontalAlignment(JLabel.CENTER);
			
			add(wait, BorderLayout.CENTER);
	}
	
	JPanel getScreen() { return this; }
}
