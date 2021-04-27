package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingContainer;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewInforUI extends JFrame {

	private JPanel contentPane;
	private JLabel UserName;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ViewInforUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 994, 619);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel UserInfor = new JLabel("User Information",SwingConstants.CENTER);
		UserInfor.setFont(new Font("Tahoma", Font.BOLD, 18));
		UserInfor.setBackground(new Color(211, 211, 211));
		UserInfor.setForeground(new Color(0, 0, 139));
		UserInfor.setBounds(0, 0, 980, 80);
		contentPane.add(UserInfor);
		UserInfor.setOpaque(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 240, 245));
		panel.setBounds(0, 84, 980, 488);
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
				
				JButton Back = new JButton("Back");
				Back.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						UI ui =new UI();
						ui.setVisible(true);
					}
				});
				Back.setBounds(798, 421, 87, 42);
				panel.add(Back);
				
				JButton ChangePinbn = new JButton("Change Pin");
				ChangePinbn.setBounds(633, 421, 87, 42);
				panel.add(ChangePinbn);
				
				JLabel accNum = new JLabel("Account Number");
				accNum.setHorizontalAlignment(SwingConstants.LEFT);
				accNum.setBounds(217, 46, 102, 21);
				panel.add(accNum);
				
				JLabel lblNewLabel_7 = new JLabel("New label");
				lblNewLabel_7.setBounds(541, 46, 71, 17);
				panel.add(lblNewLabel_7);
	}
}
