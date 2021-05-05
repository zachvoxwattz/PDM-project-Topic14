package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewInforUI extends JFrame
{
	private static final long serialVersionUID = 6093292816844002519L;
	private JPanel contentPane;
	private JLabel UserName;
	
	Image img1 =new ImageIcon(this.getClass().getResource("/changePin.png")).getImage();
	Image img2 =new ImageIcon(this.getClass().getResource("/back.png")).getImage();
	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ViewInforUI() {
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
		
		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("InternalFrame.border"));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 84, 980, 498);
		contentPane.add(panel);
		panel.setLayout(null);
		
		UserName = new JLabel("New label");
		UserName.setBounds(542, 92, 87, 21);
		panel.add(UserName);
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setBounds(215, 87, 126, 30);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Birth Day");
		lblNewLabel_1.setBounds(215, 146, 146, 30);
		panel.add(lblNewLabel_1);
		
				
				JLabel lblNewLabel_3 = new JLabel("Sex");
				lblNewLabel_3.setBounds(217, 205, 77, 23);
				panel.add(lblNewLabel_3);
				
				JLabel lblNewLabel_4 = new JLabel("Address");
				lblNewLabel_4.setBounds(217, 250, 102, 29);
				panel.add(lblNewLabel_4);
				
				JLabel lblNewLabel_5 = new JLabel("Phone Number");
				lblNewLabel_5.setBounds(217, 302, 102, 23);
				panel.add(lblNewLabel_5);
				
				JLabel lblNewLabel_6 = new JLabel("Email");
				lblNewLabel_6.setBounds(217, 352, 77, 30);
				panel.add(lblNewLabel_6);
				
				JLabel BirthDay = new JLabel("New label");
				BirthDay.setBounds(542, 151, 87, 21);
				panel.add(BirthDay);
				
				JLabel Sex = new JLabel("New label");
				Sex.setBounds(542, 201, 102, 30);
				panel.add(Sex);
				
				JLabel Address = new JLabel("New label");
				Address.setBounds(542, 252, 87, 24);
				panel.add(Address);
				
				JLabel PhoneNumber = new JLabel("New label");
				PhoneNumber.setBounds(542, 304, 87, 18);
				panel.add(PhoneNumber);
				
				JLabel Email = new JLabel("New label");
				Email.setBounds(541, 352, 88, 30);
				panel.add(Email);
				
				JButton Back = new JButton("Back", new ImageIcon(img2));
				Back.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						UI ui =new UI();
						ui.setVisible(true);
					}
				});
				Back.setBounds(783, 421, 102, 42);
				panel.add(Back);
				
				JButton ChangePinbn = new JButton("Change Pin", new ImageIcon(img1));
				ChangePinbn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				ChangePinbn.setBounds(603, 421, 126, 42);
				panel.add(ChangePinbn);
				
				JLabel accNum = new JLabel("Account Number");
				accNum.setHorizontalAlignment(SwingConstants.LEFT);
				accNum.setBounds(215, 44, 102, 21);
				panel.add(accNum);
				
				JLabel lblNewLabel_7 = new JLabel("New label");
				lblNewLabel_7.setBounds(541, 46, 71, 17);
				panel.add(lblNewLabel_7);
	}
}
