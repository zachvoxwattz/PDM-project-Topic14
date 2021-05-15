package ui;

import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend_functions.DisplayMenu;
import backend_functions.SQLQueryClient;
import backend_functions.User;
import backend_functions.WithdrawFunction;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;

public class WithdrawalUI extends JFrame
{

	private static final long serialVersionUID = 7187090446647029621L;
	private JPanel contentPane;
	private SQLQueryClient sql;
	private DisplayMenu dm;
	private User us;
	
	Image img1 =new ImageIcon(this.getClass().getResource("/icons8-search-16.png")).getImage();
	Image img3 =new ImageIcon(this.getClass().getResource("/icons8-ok-16.png")).getImage();
	Image img4 =new ImageIcon(this.getClass().getResource("/icons8-go-back-16.png")).getImage();
 	private JTextField amount;
 	
	public WithdrawalUI(SQLQueryClient sqle, User u)
	{
		this.sql = sqle; this.us = u;
		dm = new DisplayMenu(us, this);
		setTitle("PDM Project Topic 14");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 500, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JLabel lblNewLabel = new JLabel("Withdrawing Money");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 45, 190, 36);
		contentPane.add(lblNewLabel);
		
		JLabel withdrawLabel = new JLabel("Amount to Withdraw");
		withdrawLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
		withdrawLabel.setBounds(50, 100, 300, 30);
		contentPane.add(withdrawLabel);
		
		amount = new JTextField();
		amount.setBounds(250, 100, 200, 30);
		amount.setFont(new Font("Consolas", Font.BOLD, 20));
		contentPane.add(amount);
		amount.setColumns(10);
		
		JButton confirm = new JButton("Comfirm", new ImageIcon(img3));
		confirm.setBounds(250, 200, 110, 31);
		confirm.addActionListener(new WithdrawFunction(sql, us, this));
		contentPane.add(confirm);
		
		JButton btnNewButton_2 = new JButton("Back",new ImageIcon((img4)));
		btnNewButton_2.addActionListener(dm);
		btnNewButton_2.setBounds(370, 200, 85, 31);
		contentPane.add(btnNewButton_2); 
	}
	
	public String getAmount() { return this.amount.getText(); }
	public SQLQueryClient getQEngine() { return this.sql; }
}
