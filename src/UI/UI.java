package UI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UI extends JFrame {

	private JPanel contentPane;
	JButton TransferMoney = new JButton("Transfer Money");
	JButton ViewInf = new JButton("View Information");
	JButton HisTrans = new JButton("History Transaction");
	JButton PayBill = new JButton("Pay Bill");
	JButton Exitbn = new JButton("Log out");
	private final JPanel panel_1 = new JPanel();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI frame = new UI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



	public UI() {
		setColor();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 971, 578);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(102, 0, 255));
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ViewInf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ViewInf.setBackground(Color.ORANGE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setColor();
			}
		});
			
		ViewInf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ViewInforUI view =new ViewInforUI();
				view.setVisible(true);
				
				
			}
		});
		ViewInf.setBounds(47, 249, 176, 43);
		contentPane.add(ViewInf);
		HisTrans.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				HisTrans.setBackground(Color.ORANGE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setColor();
			}
		});
		
		
		HisTrans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				HistoryUI view =new HistoryUI();
				view.setVisible(true);
				
			}
		});
		HisTrans.setBounds(47, 336, 176, 43);
		contentPane.add(HisTrans);
		
		
		TransferMoney.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				TransferMoney.setBackground(Color.ORANGE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setColor();
			}
		});
		
		TransferMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TranferMoneyUI trans =new TranferMoneyUI();
				trans.setVisible(true);
			}
		});
		TransferMoney.setBounds(733, 249, 162, 43);
		contentPane.add(TransferMoney);
		
		
		PayBill.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				PayBill.setBackground(Color.ORANGE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setColor();
			}
		});
		PayBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PayBillUI pay =new PayBillUI();
				pay.setVisible(true);
			}
			
		});
		PayBill.setBounds(733, 336, 162, 43);
		contentPane.add(PayBill);
		
		Exitbn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Exitbn.setBackground(Color.ORANGE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setColor();
			}
		});
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
		lblNewLabel.setBackground(new Color(0, 206, 209));
		lblNewLabel.setBounds(0, 0, 957, 553);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Duy\\eclipse-workspace\\ProjectPDM\\src\\UI\\background.png"));
		panel_1.setBackground(new Color(0, 255, 255));
		panel_1.setBounds(0, 0, 957, 162);
		
		
		panel.add(panel_1);
		
	}
	public void setColor() {
		ViewInf.setBackground(new Color(60, 179, 113));
		TransferMoney.setBackground(new Color(60, 179, 113));
		HisTrans.setBackground(new Color(60, 179, 113));
		PayBill.setBackground(new Color(60, 179, 113));
		Exitbn.setBackground(new Color(60, 179, 113));
		
	}

}
