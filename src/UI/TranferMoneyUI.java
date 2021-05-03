package UI;


import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TranferMoneyUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	
	Image img1 =new ImageIcon(this.getClass().getResource("/submit.png")).getImage();
	Image img2 =new ImageIcon(this.getClass().getResource("/cancel.png")).getImage();

	public TranferMoneyUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1006, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel.setBounds(0, 0, 992, 498);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Money Transfer");
		lblNewLabel.setBounds(29, 10, 118, 24);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"--", "Asia Commercial Joint Stock Bank", "Tien Phong Commercial Joint Stock Bank", "Dong A Commercial Joint Stock Bank", "Southeast Asia Commercial Joint Stock Bank", "Saigon Bank for Industry & Trade ", "Military Commercial Joint Stock Bank", "Viet A Commercial Joint Stock Bank", "Mekong Commercial Bank", "VPBank"}));
		comboBox.setBounds(340, 72, 279, 21);
		panel.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Select the bank");
		lblNewLabel_1.setBounds(165, 72, 118, 21);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Account Number");
		lblNewLabel_2.setBounds(165, 126, 118, 29);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Amount of money");
		lblNewLabel_3.setBounds(165, 181, 107, 24);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Message");
		lblNewLabel_4.setBounds(165, 229, 86, 36);
		panel.add(lblNewLabel_4);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(340, 241, 279, 118);
		panel.add(textPane);
		
		textField = new JTextField();
		textField.setBounds(340, 131, 279, 24);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(342, 181, 277, 24);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit",new ImageIcon(img1));
		btnNewButton.setBounds(504, 410, 118, 36);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel", new ImageIcon(img2));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				UI ui= new UI();
				ui.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(665, 410, 107, 36);
		panel.add(btnNewButton_1);
	}
}
