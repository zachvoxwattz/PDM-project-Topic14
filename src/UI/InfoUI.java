package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import backend_functions.DisplayMenu;
import backend_functions.SQLQueryClient;
import backend_functions.User;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class InfoUI extends JFrame
{
	private static final long serialVersionUID = 6093292816844002519L;
	private JPanel contentPane;
	private JLabel UserName;
	private SQLQueryClient sql;
	private User us;
	private DisplayMenu dm;
	
	Image img1 =new ImageIcon(this.getClass().getResource("/changePin.png")).getImage();
	Image img2 =new ImageIcon(this.getClass().getResource("/back.png")).getImage();

	public InfoUI(SQLQueryClient sqle, User s)
	{
		this.sql = sqle; this.us = s;
		dm = new DisplayMenu(us, this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 600, 400);
		setTitle("PDM Project Topic 14");
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel UserInfor = new JLabel("User Information",SwingConstants.CENTER);
		UserInfor.setFont(new Font("Tahoma", Font.BOLD, 18));
		UserInfor.setBackground(new Color(211, 211, 211));
		UserInfor.setForeground(new Color(0, 0, 139));
		UserInfor.setBounds(0, 0, 600, 80);
		contentPane.add(UserInfor);
		UserInfor.setOpaque(true);
		
		
		
		JLabel accountName = new JLabel("Account Name");
		accountName.setBounds(100, 90, 126, 30);
		contentPane.add(accountName);
		
		UserName = new JLabel(us.getName());
			UserName.setBounds(300, 95, 150, 21);
			contentPane.add(UserName);
				
		JLabel accNum = new JLabel("Account Number");
			accNum.setBounds(100, 144, 126, 30);
			contentPane.add(accNum);
				
		JLabel accName = new JLabel(sql.getAccountNo(us.getCardNo()));
			accName.setBounds(300, 150, 150, 17);
			contentPane.add(accName);
			
		JLabel card = new JLabel("Card Number");
			card.setBounds(100, 200, 126, 30);
			contentPane.add(card);
				
		JLabel cardid = new JLabel(us.getCardNo());
			cardid.setBounds(300, 205, 150, 17);
			contentPane.add(cardid);
			
		JLabel status = new JLabel("Card Status");
			status.setBounds(100, 250, 126, 30);
			contentPane.add(status);
				
		JLabel stat = new JLabel(sql.getCardStatus(us.getCardNo()));
			stat.setBounds(300, 255, 150, 17);
			contentPane.add(stat);
				
		JButton Back = new JButton("Back", new ImageIcon(img2));
			Back.addActionListener(dm);
			Back.setBounds(400, 300, 102, 42);
			contentPane.add(Back);
	}
	
	public SQLQueryClient getQEngine() { return this.sql; }
}
