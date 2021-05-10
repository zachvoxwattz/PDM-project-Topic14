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
	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public InfoUI(SQLQueryClient sqle, User s)
	{
		this.sql = sqle; this.us = s;
		dm = new DisplayMenu(us, this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 994, 619);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel UserInfor = new JLabel("User Information",SwingConstants.CENTER);
		UserInfor.setFont(new Font("Tahoma", Font.BOLD, 18));
		UserInfor.setBackground(new Color(211, 211, 211));
		UserInfor.setForeground(new Color(0, 0, 139));
		UserInfor.setBounds(0, 0, 980, 86);
		contentPane.add(UserInfor);
		UserInfor.setOpaque(true);
		
		UserName = new JLabel("New label");
		UserName.setBounds(542, 92, 87, 21);
		contentPane.add(UserName);
		
		JLabel lblNewLabel = new JLabel("Account Name");
		lblNewLabel.setBounds(215, 87, 126, 30);
		contentPane.add(lblNewLabel);
		
				
				JLabel BirthDay = new JLabel("New label");
				BirthDay.setBounds(542, 151, 87, 21);
				contentPane.add(BirthDay);
				
				JLabel Sex = new JLabel("New label");
				Sex.setBounds(542, 201, 102, 30);
				contentPane.add(Sex);
				
				JLabel Address = new JLabel("New label");
				Address.setBounds(542, 252, 87, 24);
				contentPane.add(Address);
				
				JLabel PhoneNumber = new JLabel("New label");
				PhoneNumber.setBounds(542, 304, 87, 18);
				contentPane.add(PhoneNumber);
				
				JLabel Email = new JLabel("New label");
				Email.setBounds(541, 352, 88, 30);
				contentPane.add(Email);
				
				JButton Back = new JButton("Back", new ImageIcon(img2));
				Back.addActionListener(dm);
				Back.setBounds(783, 421, 102, 42);
				contentPane.add(Back);
				
				JLabel accNum = new JLabel("Account Number");
				accNum.setHorizontalAlignment(SwingConstants.LEFT);
				accNum.setBounds(215, 44, 102, 21);
				contentPane.add(accNum);
				
				JLabel lblNewLabel_7 = new JLabel("New label");
				lblNewLabel_7.setBounds(541, 46, 71, 17);
				contentPane.add(lblNewLabel_7);
	}
	
	public SQLQueryClient getQEngine() { return this.sql; }
}
