package UI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class UI extends JFrame {

	private JPanel contentPane;

	


	public UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 971, 578);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(102, 0, 255));
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton ViewInf = new JButton("View Information");
		ViewInf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ViewInforUI view =new ViewInforUI();
				view.setVisible(true);
				
				
			}
		});
		ViewInf.setBounds(47, 249, 176, 43);
		contentPane.add(ViewInf);
		
		JButton Withdraw = new JButton("Withdraw");
		Withdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				WithDrawGUI view =new WithDrawGUI();
				view.setVisible(true);
				
			}
		});
		Withdraw.setBounds(47, 336, 176, 43);
		contentPane.add(Withdraw);
		
		JButton ViewBanlance = new JButton("View Balance");
		ViewBanlance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ViewBalanceUI view =new ViewBalanceUI();
				view.setVisible(true);
				
			}
		});
		ViewBanlance.setBounds(47, 429, 176, 43);
		contentPane.add(ViewBanlance);
		
		JButton TransferMoney = new JButton("Transfer Money");
		TransferMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TranferMoneyUI trans =new TranferMoneyUI();
				trans.setVisible(true);
			}
		});
		TransferMoney.setBounds(733, 249, 162, 43);
		contentPane.add(TransferMoney);
		
		JButton PayBill = new JButton("Pay Bill");
		PayBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PayBillUI pay =new PayBillUI();
				pay.setVisible(true);
			}
			
		});
		PayBill.setBounds(733, 336, 162, 43);
		contentPane.add(PayBill);
		
		JButton Exitbn = new JButton("Log out");
		Exitbn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure?","Log out?",JOptionPane.YES_NO_OPTION);
				if(dialogResult==JOptionPane.YES_OPTION) {
					dispose();
					LoginWindow login =new LoginWindow();
					login.setVisible(true);
				}
			}
		});
		Exitbn.setBounds(733, 429, 162, 43);
		contentPane.add(Exitbn);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 957, 541);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(0, 0, 957, 553);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Duy\\eclipse-workspace\\ProjectPDM\\src\\background.png"));
		
	}
}
