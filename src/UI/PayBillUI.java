package ui;

import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend_functions.SQLQueryEngine;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;

public class PayBillUI extends JFrame
{

	private static final long serialVersionUID = 7187090446647029621L;
	private JPanel contentPane;
	private SQLQueryEngine sql;
	private String cardNum;
	
	Image img1 =new ImageIcon(this.getClass().getResource("/icons8-search-16.png")).getImage();
	Image img2 =new ImageIcon(this.getClass().getResource("/ElectricityBill.png")).getImage();
	Image img3 =new ImageIcon(this.getClass().getResource("/icons8-ok-16.png")).getImage();
	Image img4 =new ImageIcon(this.getClass().getResource("/icons8-go-back-16.png")).getImage();
	ImageIcon imageIcon =new ImageIcon(img2);
 	private JTextField cusID;
	public PayBillUI(SQLQueryEngine sqle, String cardNo)
	{
		this.sql = sqle; this.cardNum = cardNo;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1016, 695);
		setLocationRelativeTo(null);
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
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setModel(new DefaultComboBoxModel<String>
			(new String[] {"--", "Water", "Internet", "Television", "Electricity"}));
		comboBox.setBounds(366, 108, 166, 21);
		panel.add(comboBox);
		
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
		cusID.setBounds(368, 45, 170, 22);
		panel_1.add(cusID);
		cusID.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Example");
		lblNewLabel_3.setBounds(232, 107, 72, 24);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(imageIcon);
		
		lblNewLabel_4.setBackground(Color.GRAY);
		lblNewLabel_4.setBounds(368, 107, 433, 231);
		panel_1.add(lblNewLabel_4);
		
		JButton btnNewButton_1 = new JButton("Comfirm", new ImageIcon(img3));
		btnNewButton_1.setBounds(567, 419, 102, 31);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back",new ImageIcon((img4)));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UI ui =new UI(sql, cardNum);
				ui.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(722, 419, 85, 31);
		panel_1.add(btnNewButton_2); 
	}
}
