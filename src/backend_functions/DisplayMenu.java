package backend_functions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.HistoryUI;
import ui.InfoUI;
import ui.MenuUI;
import ui.WithdrawalUI;
import ui.TransferUI;

public class DisplayMenu implements ActionListener
{
	private User us;
	private MenuUI ui1;
	private WithdrawalUI ui2;
	private TransferUI ui3;
	private InfoUI ui4;
	private HistoryUI ui5;
	private int index;

	public DisplayMenu(User s, MenuUI fr) { this.us = s; this.ui1 = fr; index = 1; }
	public DisplayMenu(User s, WithdrawalUI fr) { this.us = s; this.ui2 = fr; index = 2; }
	public DisplayMenu(User s, TransferUI fr) { this.us = s; this.ui3 = fr; index = 3; }
	public DisplayMenu(User s, InfoUI fr) { this.us = s; this.ui4 = fr; index = 4; }
	public DisplayMenu(User s, HistoryUI fr) { this.us = s; this.ui5 = fr; index = 5; }

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		switch(index)
		{
			case 1:
				MenuUI ui = new MenuUI(ui1.getQEngine(), us);
				ui.setVisible(true);
				ui1.dispose();
				break;
				
			case 2:
				MenuUI uii = new MenuUI(ui2.getQEngine(), us);
				uii.setVisible(true);
				ui2.dispose();
				break;
				
			case 3:
				MenuUI uiii = new MenuUI(ui3.getQEngine(), us);
				uiii.setVisible(true);
				ui3.dispose();
				break;
				
			case 4:
				MenuUI uiiii = new MenuUI(ui4.getQEngine(), us);
				uiiii.setVisible(true);
				ui4.dispose();
				break;
				
			case 5:
				MenuUI uiiiii = new MenuUI(ui5.getQEngine(), us);
				uiiiii.setVisible(true);
				ui5.dispose();
				break;
		}
	}
}