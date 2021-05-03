package ui_v2;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginWindow extends JPanel
{
	private static final long serialVersionUID = 4262174209528051140L;

	private App core;
	
	private JLabel prompt;
	private JTextField cardNumber;
	private JButton accessButton;
	private GridBagConstraints gbc;
	
	public LoginWindow(App co)
	{
		super();
			setPreferredSize(new Dimension(App.APP_WX, App.APP_WY));
			setLayout(new GridBagLayout());
		
		this.core = co;
		initializeComponents();
	}
	
	void initializeComponents()
	{
		gbc = new GridBagConstraints();
		
		prompt = new JLabel("Enter your Credit Card Number to continue");
			prompt.setFont(new Font("Arial", Font.BOLD, 27));
			gbc.fill = GridBagConstraints.VERTICAL;
			gbc.gridx = 1; gbc.gridy = 1;
			add(prompt, gbc);
			
		cardNumber = new JTextField();
			cardNumber.setFont(new Font("Consolas", Font.BOLD, 40));
			cardNumber.setColumns(24);
			cardNumber.setHorizontalAlignment(JTextField.CENTER);
			gbc.fill = GridBagConstraints.VERTICAL;
			gbc.gridx = 1; gbc.gridy = 2; gbc.insets = new Insets(25, 0, 0, 0);
			add(cardNumber, gbc);
			
		accessButton = new JButton("Confirm Information");
			accessButton.setFont(new Font("Arial", Font.BOLD, 24));
			gbc.fill = GridBagConstraints.VERTICAL;
			gbc.gridx = 1; gbc.gridy = 3; gbc.insets = new Insets(75, 0, 0, 0);
			
			accessButton.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e) 
					{ 
						core.stopAshowB(getScreen(), new WaitWindow(core));
					}
				}
			);
			
			add(accessButton, gbc);
	}
	
	JPanel getScreen() { return this; }
}