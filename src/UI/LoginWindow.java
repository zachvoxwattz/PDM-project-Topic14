package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class LoginWindow extends JFrame {

	private JPanel contentPane;
	
	private JTextField Usernametxt;
	private JPasswordField pass;

	
	JButton signin = new JButton("Sign in",new ImageIcon("C:\\Users\\Duy\\eclipse-workspace\\ProjectPDM\\src\\icons8-add-user-male-16.png"));
	JButton login = new JButton("Login",new ImageIcon("C:\\Users\\Duy\\eclipse-workspace\\ProjectPDM\\src\\if_login_173049.png"));
    ImageIcon im=new ImageIcon("C:\\Users\\Duy\\eclipse-workspace\\ProjectPDM\\src\\mainmenu.jpeg");
	public static void main(String[] args) {
		new LoginWindow();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
			
				try {
					LoginWindow frame = new LoginWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public LoginWindow() {
		this.addWindowListener(new WindowAdapter() {
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setTitle("Log in Window");
		setBounds(100, 100, 785, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(348, 0, 423, 356);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Usernametxt = new JTextField();
		Usernametxt.setFont(new Font("Tahoma", Font.BOLD, 13));
		Usernametxt.setBounds(89, 92, 256, 29);
		panel.add(Usernametxt);
		Usernametxt.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(89, 58, 97, 30);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(88, 153, 80, 22);
		panel.add(lblNewLabel_1);
		
		
		signin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					dispose();
					contentPane.setVisible(false);
					new SignUpWindow();
					
					
			
					}		
		});
		signin.setFont(new Font("Tahoma", Font.BOLD, 11));
		signin.setBounds(89, 274, 107, 44);
		panel.add(signin);
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			UI ui = new UI();
			ui.setVisible(true);
				
			}
		});
			
		
		
		login.setFont(new Font("Tahoma", Font.BOLD, 11));
		login.setBounds(238, 274, 107, 44);
		panel.add(login);
		
		pass = new JPasswordField();
	
		pass.setFont(new Font("Tahoma", Font.BOLD, 13));
		pass.setBounds(88, 185, 256, 29);
		panel.add(pass);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 350, 350);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel(im);
		lblNewLabel_2.setBounds(0, 0, 350, 350);
		panel_1.add(lblNewLabel_2);
	}
	public boolean isFill() {
		String passw=  new String(pass.getPassword());
		if(Usernametxt.getText().isEmpty() || passw.isEmpty()) {
			return false;
		}
		return true;
	}
}
