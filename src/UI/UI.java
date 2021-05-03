package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

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
	JButton ViewInf = new JButton("View Information");
	JButton TransferMoney = new JButton("Transfer Money");	
	JButton PayBill = new JButton("Bill Payment");
	JButton HisTrans = new JButton("History Transaction");	
	JButton Exitbn = new JButton("    Log out");
	
	
	Image img1 =new ImageIcon(this.getClass().getResource("/man-user.png")).getImage();
	Image img2 =new ImageIcon(this.getClass().getResource("/transfer-money.png")).getImage();
	Image img3 =new ImageIcon(this.getClass().getResource("/paybill.png")).getImage();
	Image img4 =new ImageIcon(this.getClass().getResource("/clock.png")).getImage();
	Image img5 =new ImageIcon(this.getClass().getResource("/logout.png")).getImage();
	
	
	
	
	
	
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
		ViewInf.setIcon(new ImageIcon(img1));
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
		
		HisTrans.setIcon(new ImageIcon(img4));
		HisTrans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				HistoryUI view =new HistoryUI();
				view.setVisible(true);
				
			}
		});
		HisTrans.setBounds(47, 336, 176, 43);
		contentPane.add(HisTrans);
		
		TransferMoney.setIcon(new ImageIcon(img2));
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
		
		PayBill.setIcon(new ImageIcon(img3));
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
		Exitbn.setIcon(new ImageIcon(img5));
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
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(0, 0, 957, 553);
		panel.add(lblNewLabel);
		Image img =new ImageIcon(this.getClass().getResource("/background.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
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
