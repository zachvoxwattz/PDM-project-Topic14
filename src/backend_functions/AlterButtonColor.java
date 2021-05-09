package backend_functions;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import ui.MenuUI;

public class AlterButtonColor implements MouseListener
{
	private MenuUI menu;
	private JButton butt;
	public AlterButtonColor(MenuUI mui, JButton b) { this.menu = mui; this.butt = b; }
	
	@Override
	public void mouseEntered(MouseEvent e) { butt.setBackground(Color.ORANGE); }
	@Override
	public void mouseExited(MouseEvent e) { menu.setColor(); }

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
}
