package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Image;

import javax.swing.border.BevelBorder;

import backend_functions.AlterButtonColor;
import backend_functions.SQLQueryEngine;
import backend_functions.User;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuUI extends JFrame
{
	private static final long serialVersionUID = -6227506676605276824L;
	private JPanel contentPane;
	private SQLQueryEngine sql;
	private User usr;
	
	JButton vinfo = new JButton("View Information");
	JButton transfer = new JButton("Transfer Money");	
	JButton settle = new JButton("Bill Payment");
	JButton history = new JButton("History Transaction");	
	JButton exit = new JButton("Log out");
	
	private JLabel welcome;
	
	Image img1 =new ImageIcon(this.getClass().getResource("/man-user.png")).getImage();
	Image img2 =new ImageIcon(this.getClass().getResource("/transfer-money.png")).getImage();
	Image img3 =new ImageIcon(this.getClass().getResource("/paybill.png")).getImage();
	Image img4 =new ImageIcon(this.getClass().getResource("/clock.png")).getImage();
	Image img5 =new ImageIcon(this.getClass().getResource("/logout.png")).getImage();

	private final JPanel panel_1 = new JPanel();

	public MenuUI(SQLQueryEngine sqle, User us)
	{
		this.sql = sqle; this.usr = us;
		
		setColor();
		setTitle("Menu Selection");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 971, 578);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setForeground(new Color(102, 0, 255));
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.setLayout(null);
		
		vinfo.setIcon(new ImageIcon(img1));
		vinfo.addMouseListener(new AlterButtonColor(this, vinfo));
	
		vinfo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				InfoUI view =new InfoUI(sql, usr);
				view.setVisible(true);
				dispose();	
			}
		});
		
		vinfo.setBounds(47, 249, 176, 43);
		contentPane.add(vinfo);
		history.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				history.setBackground(Color.ORANGE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setColor();
			}
		});
		
		history.setIcon(new ImageIcon(img4));
		history.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HistoryUI view =new HistoryUI(sql, usr);
				view.setVisible(true);
				dispose();
				
				
			}
		});
		history.setBounds(47, 336, 176, 43);
		contentPane.add(history);
		
		transfer.setIcon(new ImageIcon(img2));
		transfer.addMouseListener(new AlterButtonColor(this, transfer));
		
		transfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TransferUI trans = new TransferUI(sql, usr);
				trans.setVisible(true);
				dispose();
				
				
			}
		});
		transfer.setBounds(733, 249, 162, 43);
		contentPane.add(transfer);
		
		settle.setIcon(new ImageIcon(img3));
		settle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				settle.setBackground(Color.ORANGE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setColor();
			}
		});
		settle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SettleBillUI pay =new SettleBillUI(sql, usr);
				pay.setVisible(true);
				dispose();
				
				
			}
			
		});
		settle.setBounds(733, 336, 162, 43);
		contentPane.add(settle);
		exit.setIcon(new ImageIcon(img5));
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exit.setBackground(Color.ORANGE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setColor();
			}
		});
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure?","Log out?",JOptionPane.YES_NO_OPTION);
				if(dialogResult==JOptionPane.YES_OPTION) {
					LoginWindow login =new LoginWindow(sql);
					login.setVisible(true);
					dispose();
					
					
				}
			}
		});
		exit.setBounds(733, 429, 162, 43);
		contentPane.add(exit);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 957, 541);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(0, 0, 957, 553);
		panel.add(lblNewLabel);
		Image img =new ImageIcon(this.getClass().getResource("/background.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		panel_1.setBackground(new Color(0, 255, 255));
		panel_1.setBounds(0, 0, 957, 162);
		
		
		panel.add(panel_1);
		
		add(contentPane);
	}
	public void setColor() {
		vinfo.setBackground(new Color(60, 179, 113));
		transfer.setBackground(new Color(60, 179, 113));
		history.setBackground(new Color(60, 179, 113));
		settle.setBackground(new Color(60, 179, 113));
		exit.setBackground(new Color(60, 179, 113));
	}

	public SQLQueryEngine getQEngine() { return this.sql; }
}
