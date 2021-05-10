package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.JTable;

import backend_functions.DisplayMenu;
import backend_functions.SQLQueryClient;
import backend_functions.User;

import javax.swing.JScrollPane;
import javax.swing.JButton;

public class HistoryUI extends JFrame
{

	private static final long serialVersionUID = 3065062498405223480L;
	private JPanel contentPane;
	private JTable table;
	private SQLQueryClient sql;
	private User us;
	private DisplayMenu dm;
	
	public HistoryUI(SQLQueryClient sqle, User u) 
	{
		this.sql = sqle; this.us = u;
		dm = new DisplayMenu(us, this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1200, 713);
		setTitle("PDM Project Topic 14");
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 912, 126);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Transaction History ");
		lblNewLabel.setBounds(0, 10, 214, 41);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(1, 130, 1199, 420);
		contentPane.add(scrollPane);
		
		table = new JTable();
			table.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			table.setRowHeight(25);
			table.setEnabled(false);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		scrollPane.setViewportView(table);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		sql.getTransactions(us, this);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 525, 922, 141);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(dm);
		btnNewButton.setBounds(799, 55, 85, 33);
		panel_1.add(btnNewButton); 
	}
	
	public SQLQueryClient getQEngine() { return this.sql; }
	
	public void showTable(List<String> columns, List<String> data)
	{
		DefaultTableModel dtm = new DefaultTableModel(0, 0);
		for (String itor: columns) { dtm.addColumn(itor); }
		
		Iterator<String> itor = data.iterator();
		while (itor.hasNext())
		{
			Vector<String> dataVect3 = new Vector<>();
			for (int i = 1; i <= columns.size(); i++)
			{
				String dat = itor.next();
				dataVect3.add(dat);
			}	
			dtm.addRow(dataVect3);
		}
		table.setModel(dtm);
		repaint();
	}
}