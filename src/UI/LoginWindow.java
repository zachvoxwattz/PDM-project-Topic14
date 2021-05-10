package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend_functions.LoginCredentialsChecker;
import backend_functions.SQLQueryClient;
import backend_functions.User;

import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class LoginWindow extends JFrame 
{
	private static final long serialVersionUID = -3821183003050026681L;

	private JPanel contentPane;
	private JLabel pCard, pPin, imageSplash;
	private JTextField cardNo;
	private JPasswordField pinCode;
	private JButton login;
	
	private Image logInButtonIMG, splashIMG;
	
	private SQLQueryClient sql;
	private LoginCredentialsChecker checker;
	
	public LoginWindow(SQLQueryClient sqle)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setTitle("Log in Window");
		setSize(785, 387);
		setLocationRelativeTo(null);
		
		this.sql = sqle;
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(31, 198, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		splashIMG = new ImageIcon(this.getClass().getResource("/mainmenu.jpeg")).getImage();
		imageSplash = new JLabel(new ImageIcon(splashIMG));
			imageSplash.setBounds(0, 0, 350, 350);
			contentPane.add(imageSplash);

		pCard = new JLabel("Enter credit card number");
			pCard.setFont(new Font("Tahoma", Font.BOLD, 20));
			pCard.setBounds(435, 58, 255, 30);
			contentPane.add(pCard);
		
		cardNo = new JTextField();
			cardNo.setFont(new Font("Consolas", Font.PLAIN, 24));
			cardNo.setBounds(430, 92, 266, 40);
			cardNo.setHorizontalAlignment(JTextField.CENTER);
			cardNo.setColumns(10);
			contentPane.add(cardNo);
			
		pPin = new JLabel("Enter PIN code of card");
			pPin.setFont(new Font("Tahoma", Font.BOLD, 20));
			pPin.setBounds(450, 153, 255, 30);
			contentPane.add(pPin);
		
		pinCode = new JPasswordField();
			pinCode.setFont(new Font("Consolas", Font.PLAIN, 20));
			pinCode.setBounds(523, 185, 80, 40);
			pinCode.setHorizontalAlignment(JPasswordField.CENTER);
			contentPane.add(pinCode);
	
		logInButtonIMG = new ImageIcon(this.getClass().getResource("/if_login_173049.png")).getImage();
		login = new JButton("Login",new ImageIcon(logInButtonIMG));
			login.setFont(new Font("Consolas", Font.BOLD, 24));
			login.setBounds(500, 250, 128, 44);
			checker = new LoginCredentialsChecker(this);
			login.addActionListener(checker);
			contentPane.add(login);
		
		cardNo.setText("4040505060607070");
		pinCode.setText("017650");
			
		add(contentPane);
	}
	
	public void showUI(User s)
	{
		MenuUI ui = new MenuUI(sql, s);
		ui.setVisible(true);
		dispose();
	}
	
	public SQLQueryClient getQueryEngine() { return this.sql; }
	public String getCardNumber() { return this.cardNo.getText(); }
	public String getCardPIN() { return String.valueOf(this.pinCode.getPassword()); }
}
