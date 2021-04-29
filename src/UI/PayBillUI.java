package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;

public class PayBillUI extends JFrame {

	private JPanel contentPane;



	/**
	 * Create the frame.
	 */
	Image img1 =new ImageIcon(this.getClass().getResource("/icons8-search-16.png")).getImage();
	Image img2 =new ImageIcon(this.getClass().getResource("/ElectricityBill.png")).getImage();
	ImageIcon imageIcon =new ImageIcon(img2);
 	private JTextField cusID;
	public PayBillUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1016, 695);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1002, 177);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New Transaction");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 45, 190, 36);
		panel.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"--", "Water", "Internet", "Television", "Electricity"}));
		comboBox.setBounds(373, 108, 166, 21);
		panel.add(comboBox);
		
		JButton btnNewButton = new JButton("",new ImageIcon(img1));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(641, 108, 85, 21);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Pay for ");
		lblNewLabel_1.setBounds(232, 108, 91, 21);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 174, 1002, 484);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("CustomerID");
		lblNewLabel_2.setBounds(232, 43, 84, 24);
		panel_1.add(lblNewLabel_2);
		
		cusID = new JTextField();
		cusID.setBounds(413, 43, 170, 22);
		panel_1.add(cusID);
		cusID.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Example");
		lblNewLabel_3.setBounds(232, 107, 72, 24);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(imageIcon);
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Duy\\eclipse-workspace\\ProjectPDM\\Images\\ElectricityBill.png"));
		lblNewLabel_4.setBackground(Color.GRAY);
		lblNewLabel_4.setBounds(368, 107, 433, 231);
		panel_1.add(lblNewLabel_4);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(641, 419, 85, 21);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(792, 419, 85, 21);
		panel_1.add(btnNewButton_2);
	}
}
