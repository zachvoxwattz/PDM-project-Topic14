package UI;


import javax.swing.JFrame;
import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;


public class SignUpWindow    {

	private JFrame frame;
	private JTextField firstNametxt;
	private JTextField emailtxt;
	private JTextField phoneNotxt;
	private JTextField jobtxt;
	private JTextField addtxt;

	private JRadioButton sexMale;
	private JRadioButton sexFemale;
	
	@SuppressWarnings("rawtypes")
	JComboBox comboBox = new JComboBox();
	JComboBox<Integer> dayBox = new JComboBox<Integer>();
	JComboBox<Integer> monthBox = new JComboBox<Integer>();
	JComboBox<Integer> yearBox = new JComboBox<Integer>();
	
	
	JLabel lblNewLabel = new JLabel("Username");
	JLabel lblNewLabel_1 = new JLabel("Password");
	JLabel lblNewLabel_2 = new JLabel("E-mail");
	JLabel lblNewLabel_3 = new JLabel("Phone No");
	JLabel BirthDay = new JLabel("BirthDay");
	JLabel lblNewLabel_4 = new JLabel("Occupation");
	JLabel lblNewLabel_5 = new JLabel("Confirm Password");
	JLabel lblNewLabel_6 = new JLabel("Address");
	JLabel comfirmLable = new JLabel("");
	JLabel isvalid = new JLabel("");
	Image img1 =new ImageIcon(this.getClass().getResource("/icons8-ok-16.png")).getImage();
	Image img2 =new ImageIcon(this.getClass().getResource("/back.png")).getImage();
	Image img3 =new ImageIcon(this.getClass().getResource("/multiplebackground-1 (1).jpg")).getImage();
	
	ImageIcon imgi1 = new ImageIcon(img3);
	
	
	
	
	JButton btnNewButton_1 = new JButton("Create",new ImageIcon(img1));
	JButton backBt = new JButton("Back",new ImageIcon(img2));
	

	
	
	private JPasswordField passwordtxt;
	private JPasswordField conformtxt;
	
	public SignUpWindow() {
		initialize();
		this.frame.setVisible(true);
		
	
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setForeground(new Color(255, 255, 255));
		frame.setBounds(100, 40, 898, 771);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(false);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.GRAY);
		
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(92, 116, 85, 34);
		frame.getContentPane().add(lblNewLabel);
		
		
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(92, 234, 85, 22);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(92, 344, 85, 22);
		frame.getContentPane().add(lblNewLabel_2);
		
		sexMale = new JRadioButton("Male");
		sexMale.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(sexFemale.isSelected() && sexMale.isSelected()) {
					sexFemale.setSelected(false);
				}
			}
		});

		sexMale.setFont(new Font("Tahoma", Font.BOLD, 13));
		sexMale.setBounds(603, 179, 103, 21);
		frame.getContentPane().add(sexMale);
		
		sexFemale = new JRadioButton("Female");
		sexFemale.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(sexMale.isSelected() && sexFemale.isSelected()) {
					sexMale.setSelected(false);
				}
			}
		});
		sexFemale.setFont(new Font("Tahoma", Font.BOLD, 13));
		sexFemale.setBounds(716, 179, 103, 21);
		frame.getContentPane().add(sexFemale);
	
		firstNametxt = new JTextField();
		firstNametxt.setBounds(251, 121, 314, 28);
		frame.getContentPane().add(firstNametxt);
		firstNametxt.setColumns(10);
		
		emailtxt = new JTextField();
		emailtxt.setBounds(251, 342, 314, 29);
		frame.getContentPane().add(emailtxt);
		emailtxt.setColumns(10);
		
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(92, 436, 85, 29);
		frame.getContentPane().add(lblNewLabel_3);
		
		phoneNotxt = new JTextField();
		phoneNotxt.setBounds(251, 437, 314, 29);
		frame.getContentPane().add(phoneNotxt);
		phoneNotxt.setColumns(10);
		
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(92, 479, 85, 34);
		frame.getContentPane().add(lblNewLabel_4);
		
		jobtxt = new JTextField();
		jobtxt.setBounds(251, 483, 314, 29);
		frame.getContentPane().add(jobtxt);
		jobtxt.setColumns(10);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(456, 562, 109, 34);
		frame.getContentPane().add(btnNewButton_1);
		
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(92, 289, 122, 22);
		frame.getContentPane().add(lblNewLabel_5);
		
	
		dayBox.setBounds(251, 180, 41, 21);
		frame.getContentPane().add(dayBox);
		
		
		monthBox.setBounds(325, 180, 51, 20);
		frame.getContentPane().add(monthBox);
		
		yearBox.setBounds(422, 180, 73, 20);
		frame.getContentPane().add(yearBox);
		BirthDay.setBackground(Color.WHITE);
		BirthDay.setForeground(Color.BLACK);
		
		
		BirthDay.setFont(new Font("Tahoma", Font.BOLD, 13));
		BirthDay.setBounds(92, 172, 73, 34);
		frame.getContentPane().add(BirthDay);
		
		passwordtxt = new JPasswordField();
	
		passwordtxt.setToolTipText("Password must be contains:"+"\n"+ "more than 8 characters\r\n+ at least one UPPER character  \r\n+ at least one LOWER character\r\n+ at least one digit\r\nEX: Duy12345\r\n");
		passwordtxt.setBounds(251, 232, 314, 29);
		frame.getContentPane().add(passwordtxt);
		
		conformtxt = new JPasswordField();
		conformtxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String password =String.valueOf(passwordtxt.getPassword());
				String comfirm =String.valueOf(conformtxt.getPassword());
				if(password.equals(comfirm)) {
					comfirmLable.setText("Correct password");
					comfirmLable.setForeground(Color.green);
				}
				else {
					comfirmLable.setText("Incorrect password");
				    comfirmLable.setForeground(Color.red);
			}}
		});
		conformtxt.setBounds(251, 289, 314, 29);
		frame.getContentPane().add(conformtxt);
		

		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(92, 388, 85, 32);
		frame.getContentPane().add(lblNewLabel_6);
		
		addtxt = new JTextField();
		addtxt.setBounds(251, 388, 314, 27);
		frame.getContentPane().add(addtxt);
		addtxt.setColumns(10);
		generateDate();
		
		backBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame.dispose();
				LoginWindow frame =new LoginWindow();
				new LoginWindow();
				frame.setVisible(true);
				}	
		});
		backBt.setFont(new Font("Tahoma", Font.BOLD, 13));
		backBt.setBounds(252, 562, 103, 34);
		frame.getContentPane().add(backBt);
		comfirmLable.setBackground(Color.WHITE);
		comfirmLable.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		
		
		comfirmLable.setBounds(626, 290, 170, 23);
		frame.getContentPane().add(comfirmLable);
		
		
		isvalid.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		isvalid.setBounds(626, 232, 59, 29);
		frame.getContentPane().add(isvalid);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(imgi1);
		lblNewLabel_8.setBounds(0, 0, 884, 734);
		frame.getContentPane().add(lblNewLabel_8);}
		
	boolean checkfill() {
		String password =String.valueOf(passwordtxt.getPassword());
		if(firstNametxt.getText().isEmpty()|| password.isEmpty() || password.isEmpty()
				|| emailtxt.getText().isEmpty()	|| phoneNotxt.getText().isEmpty() 
				  || jobtxt.getText().isEmpty()) 
		{
			return false;
		}
		if((!sexMale.isSelected()) && (!sexFemale.isSelected())) {
			return false;
		}
		return true;
	}
	
	
	void generateDate()
	{
		for(int i=1;i<=31;i++)
		{
			dayBox.addItem(i);
		}
		for(int i=1;i<=12;i++)
		{	
			monthBox.addItem(i);
		}
		for(int i=1900;i<=2020;i++)
		{
			yearBox.addItem(i);
		}
	}
	}