package ui_v2;

import java.awt.Dimension;

import javax.swing.JPanel;

public class SelectionWindow extends JPanel
{
	private static final long serialVersionUID = 5197040115392948199L;
	private App core;
	
	public SelectionWindow(App co)
	{
		super();
			setPreferredSize(new Dimension(App.APP_WX, App.APP_WY));
			
		this.core = co;
	}
}