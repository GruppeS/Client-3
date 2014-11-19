package view; // En del af view

import javax.swing.JPanel;

import java.awt.CardLayout;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Weather extends JPanel // Weather klasse der extender JPanel
{
	private static final long serialVersionUID = 1L; // Genereret ID
	
	// instansvariable til at holde på JLabels, JTextFields og JButtons
	private JLabel lblNewLabel;
	private JButton btnBackToMain;
	
	public Weather() {
		setLayout(null);
		
		lblNewLabel = new JLabel("Forecast");
		lblNewLabel.setBounds(123, 44, 66, 64);
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 19));
		add(lblNewLabel);
		
		btnBackToMain = new JButton("Back to Main Menu");
		btnBackToMain.setBounds(80, 288, 142, 23);
		add(btnBackToMain);
	}
	public void addActionListener(ActionListener l) // metode til at tilføje actionlisteners og actioncommands til knapper
	{
		btnBackToMain.addActionListener(l); // tilføjer actionlistener
		btnBackToMain.setActionCommand("BackToMainBtn"); // tilføjer actioncommand
	}

}
