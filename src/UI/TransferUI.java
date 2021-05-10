package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;

import backend_functions.DisplayMenu;
import backend_functions.SQLQueryClient;
import backend_functions.TransferFunction;
import backend_functions.User;

import java.awt.Color;

public class TransferUI extends JFrame
{
	private static final long serialVersionUID = 6786168069376771108L;
	private JPanel contentPane;
	private JTextField targetID, transferAmount;
	private JTextArea comments;
	private SQLQueryClient sql;
	private User us;
	private DisplayMenu dm;
	
	Image img1 =new ImageIcon(this.getClass().getResource("/transfer-money.png")).getImage();
	Image img2 =new ImageIcon(this.getClass().getResource("/icons8-go-back-16.png")).getImage();

	public TransferUI(SQLQueryClient sqle, User S)
	{
		this.sql = sqle; this.us = S;
		dm = new DisplayMenu(us, this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 600, 535);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel.setBounds(0, 0, 585, 532);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Money Transfer");
		lblNewLabel.setBounds(29, 10, 118, 24);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblNewLabel_2 = new JLabel("Account Number");
		lblNewLabel_2.setBounds(65, 126, 118, 29);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Amount of money");
		lblNewLabel_3.setBounds(65, 181, 107, 24);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Message");
		lblNewLabel_4.setBounds(65, 229, 86, 36);
		panel.add(lblNewLabel_4);
		
		targetID = new JTextField();
		targetID.setBounds(240, 127, 279, 30);
		targetID.setColumns(10);
		targetID.setFont(new Font("Consolas", Font.BOLD, 24));
		panel.add(targetID);
		
		transferAmount = new JTextField();
		transferAmount.setBounds(240, 179, 277, 30);
		transferAmount.setColumns(10);
		transferAmount.setFont(new Font("Consolas", Font.BOLD, 24));
		panel.add(transferAmount);

		comments = new JTextArea();
		comments.setBounds(240, 241, 279, 118);
		comments.setLineWrap(true); comments.setWrapStyleWord(true);
		panel.add(comments);
		
		JButton btnNewButton = new JButton("Submit",new ImageIcon(img1));
		btnNewButton.setBounds(240, 410, 118, 36);
		btnNewButton.addActionListener(new TransferFunction(sql, us, this));
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel", new ImageIcon(img2));
		btnNewButton_1.addActionListener(dm);
		btnNewButton_1.setBounds(412, 410, 107, 36);
		panel.add(btnNewButton_1); 
	}
	
	public String getRecipientID() { return targetID.getText(); }
	public String getTransferAmount() { return transferAmount.getText(); }
	public String getComments() { return comments.getText(); }
	
	public SQLQueryClient getQEngine() { return this.sql; }
}
