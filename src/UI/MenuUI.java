package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.border.BevelBorder;

import backend_functions.AlterButtonColor;
import backend_functions.SQLQueryClient;
import backend_functions.User;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class MenuUI extends JFrame
{
	private static final long serialVersionUID = -6227506676605276824L;
	private JPanel contentPane;
	private JLabel welcome;
	private SQLQueryClient sql;
	private User usr;
	private Font f;
	
	JButton vinfo = new JButton("View Information");
	JButton transfer = new JButton("Transfer Money");	
	JButton settle = new JButton("Cash Withdrawal");
	JButton history = new JButton("Transaction History");	
	JButton exit = new JButton("Log out");
	
	Image img1 =new ImageIcon(this.getClass().getResource("/man-user.png")).getImage();
	Image img2 =new ImageIcon(this.getClass().getResource("/transfer-money.png")).getImage();
	Image img3 =new ImageIcon(this.getClass().getResource("/paybill.png")).getImage();
	Image img4 =new ImageIcon(this.getClass().getResource("/clock.png")).getImage();
	Image img5 =new ImageIcon(this.getClass().getResource("/logout.png")).getImage();

	public MenuUI(SQLQueryClient sqle, User us)
	{
		this.sql = sqle; this.usr = us;
		
		setColor();
		setTitle("Menu Selection");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 600, 500);
		setLocationRelativeTo(null);
		
		f = new Font("Segoe UI", Font.BOLD, 16);
		
		contentPane = new JPanel();
		contentPane.setForeground(new Color(102, 0, 255));
		contentPane.setBackground(new Color(33, 43, 124));
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.setLayout(null);
		
		vinfo.setIcon(new ImageIcon(img1));
		vinfo.addMouseListener(new AlterButtonColor(this, vinfo));
		vinfo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if (!sql.checkLock(usr.getCardNo()))
				{	
					String accountID = JOptionPane.showInputDialog
							(null,"Verification Required! Please enter your AccountID below", "Notice", 
									JOptionPane.INFORMATION_MESSAGE);
					
					if (accountID.equals(sql.getAccountNo(usr.getCardNo())))
					{
						InfoUI view =new InfoUI(sql, usr);
						view.setVisible(true);
						dispose();
					}
					
					else JOptionPane.showMessageDialog(null,"Access is denied", "WARNING", 
							JOptionPane.WARNING_MESSAGE);
				}
				else JOptionPane.showMessageDialog(null,"This Credit Card has been LOCKED\nContact Bank Support for more information", "WARNING", 
						JOptionPane.WARNING_MESSAGE);
			}
		});
		vinfo.setFont(f);
		vinfo.setBounds(47, 120, 220, 45);
		contentPane.add(vinfo);
		
		history.addMouseListener(new AlterButtonColor(this, history));
		
		history.setIcon(new ImageIcon(img4));
		history.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if (!sql.checkLock(usr.getCardNo()))
				{	
					HistoryUI view = new HistoryUI(sql, usr);
					view.setVisible(true);
					dispose();
				}
				else JOptionPane.showMessageDialog(null,"This Credit Card has been LOCKED\nContact Bank Support for more information", "WARNING", 
						JOptionPane.WARNING_MESSAGE);
			}
		});
		history.setFont(f);
		history.setBounds(47, 200, 220, 45);
		contentPane.add(history);
		
		transfer.setIcon(new ImageIcon(img2));
		transfer.addMouseListener(new AlterButtonColor(this, transfer));
		transfer.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if (!sql.checkLock(usr.getCardNo()))
				{
					TransferUI view = new TransferUI(sql, usr);
					view.setVisible(true);
					dispose();
				}
				else JOptionPane.showMessageDialog(null,"This Credit Card has been LOCKED\nContact Bank Support for more information", "WARNING", 
						JOptionPane.WARNING_MESSAGE);
			}
		});
		transfer.setBounds(322, 200, 220, 45);
		transfer.setFont(f);
		contentPane.add(transfer);
		
		settle.setIcon(new ImageIcon(img3));
		settle.addMouseListener(new AlterButtonColor(this, settle));
		settle.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if (!sql.checkLock(usr.getCardNo()))
				{
					WithdrawalUI pay =new WithdrawalUI(sql, usr);
					pay.setVisible(true);
					dispose();
				}
				else JOptionPane.showMessageDialog(null,"This Credit Card has been LOCKED\nContact Bank Support for more information", "WARNING", 
						JOptionPane.WARNING_MESSAGE);
			}
		});
		settle.setFont(f);
		settle.setBounds(322, 120, 220, 45);
		contentPane.add(settle);
		
		exit.setIcon(new ImageIcon(img5));
		exit.addMouseListener(new AlterButtonColor(this, exit));
		exit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure?","Log out?",JOptionPane.YES_NO_OPTION);
				if (dialogResult == JOptionPane.YES_OPTION)
				{
					LoginWindow login = new LoginWindow(sql);
					login.setVisible(true);
					dispose();	
				}
			}
		});
		exit.setFont(f);
		exit.setBounds(420, 375, 120, 43);
		contentPane.add(exit);
		
		welcome = new JLabel();
		welcome.setBounds(50, 50, 1000, 30);
		welcome.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		welcome.setForeground(Color.WHITE);
		String tex = String.format("Welcome, %s", usr.getName());
		welcome.setText(tex);
		contentPane.add(welcome);
		
		add(contentPane);
	}
	
	public void setColor()
	{
		vinfo.setBackground(new Color(60, 179, 113));
		transfer.setBackground(new Color(60, 179, 113));
		history.setBackground(new Color(60, 179, 113));
		settle.setBackground(new Color(60, 179, 113));
		exit.setBackground(new Color(60, 179, 113));
	}
	public SQLQueryClient getQEngine() { return this.sql; }
}