package view; // En del af view

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Weather extends JPanel // Weather klasse der extender JPanel
{
	private static final long serialVersionUID = 1L; // Genereret ID
	
	// instansvariable til at holde på JLabels, JTextFields og JButtons
	private JLabel lblNewLabel;
	private JButton btnBackToMain;
	private JLabel label_date1;
	private JLabel label_date2;
	private JLabel label_date3;
	private JLabel label_date4;
	private JLabel label_date5;
	private JLabel label_date6;
	private JLabel label_date7;
	private JLabel label_cel1;
	private JLabel label_cel2;
	private JLabel label_cel3;
	private JLabel label_cel4;
	private JLabel label_cel5;
	private JLabel label_cel6;
	private JLabel label_cel7;
	private JLabel label_desc7;
	private JLabel label_desc6;
	private JLabel label_desc5;
	private JLabel label_desc4;
	private JLabel label_desc3;
	private JLabel label_desc2;
	private JLabel label_desc1;
	private JLabel lblWeatherForThe;
	private JLabel lblCelcius;
	private JLabel lblDate;
	private JLabel lblDecription;
	
	public Weather() {
		setForeground(SystemColor.activeCaption);
		setLayout(null);
		
		btnBackToMain = new JButton("Back to Main Menu");
		btnBackToMain.setBounds(100, 449, 142, 23);
		add(btnBackToMain);
		
		label_date1 = new JLabel("");
		label_date1.setBounds(47, 203, 88, 30);
		add(label_date1);
		
		label_date2 = new JLabel("");
		label_date2.setBounds(47, 234, 88, 30);
		add(label_date2);
		
		label_date3 = new JLabel("");
		label_date3.setBounds(47, 265, 88, 30);
		add(label_date3);
		
		label_date4 = new JLabel("");
		label_date4.setBounds(47, 296, 88, 30);
		add(label_date4);
		
		label_date5 = new JLabel("");
		label_date5.setBounds(47, 327, 88, 30);
		add(label_date5);
		
		label_date6 = new JLabel("");
		label_date6.setBounds(47, 358, 88, 30);
		add(label_date6);
		
		label_date7 = new JLabel("");
		label_date7.setBounds(47, 389, 88, 30);
		add(label_date7);
		
		label_cel1 = new JLabel("");
		label_cel1.setBounds(133, 203, 50, 30);
		add(label_cel1);
		
		label_cel2 = new JLabel("");
		label_cel2.setBounds(133, 234, 50, 30);
		add(label_cel2);
		
		label_cel3 = new JLabel("");
		label_cel3.setBounds(133, 265, 50, 30);
		add(label_cel3);
		
		label_cel4 = new JLabel("");
		label_cel4.setBounds(133, 296, 50, 30);
		add(label_cel4);
		
		label_cel5 = new JLabel("");
		label_cel5.setBounds(133, 327, 50, 30);
		add(label_cel5);
		
		label_cel6 = new JLabel("");
		label_cel6.setBounds(133, 358, 50, 30);
		add(label_cel6);
		
		label_cel7 = new JLabel("");
		label_cel7.setBounds(133, 389, 50, 30);
		add(label_cel7);
		
		label_desc7 = new JLabel("");
		label_desc7.setBounds(183, 389, 100, 30);
		add(label_desc7);
		
		label_desc6 = new JLabel("");
		label_desc6.setBounds(183, 358, 100, 30);
		add(label_desc6);
		
		label_desc5 = new JLabel("");
		label_desc5.setBounds(183, 327, 100, 30);
		add(label_desc5);
		
		label_desc4 = new JLabel("");
		label_desc4.setBounds(183, 296, 100, 30);
		add(label_desc4);
		
		label_desc3 = new JLabel("");
		label_desc3.setBounds(183, 265, 100, 30);
		add(label_desc3);
		
		label_desc2 = new JLabel("");
		label_desc2.setBounds(183, 234, 100, 30);
		add(label_desc2);
		
		label_desc1 = new JLabel("");
		label_desc1.setBounds(183, 203, 100, 30);
		add(label_desc1);
		
		lblWeatherForThe = new JLabel("Weather for the week");
		lblWeatherForThe.setFont(new Font("Calibri", Font.BOLD, 19));
		lblWeatherForThe.setBounds(71, 66, 182, 51);
		add(lblWeatherForThe);
		
		lblCelcius = new JLabel("CELCIUS");
		lblCelcius.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 11));
		lblCelcius.setBounds(114, 171, 61, 30);
		add(lblCelcius);
		
		lblDate = new JLabel("DATE");
		lblDate.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 11));
		lblDate.setBounds(47, 171, 88, 30);
		add(lblDate);
		
		lblDecription = new JLabel("DECRIPTION");
		lblDecription.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 11));
		lblDecription.setBounds(194, 171, 100, 30);
		add(lblDecription);
	}
	public void addActionListener(ActionListener l) // metode til at tilføje actionlisteners og actioncommands til knapper
	{
		btnBackToMain.addActionListener(l); // tilføjer actionlistener
		btnBackToMain.setActionCommand("BackToMainBtn"); // tilføjer actioncommand
	}
	public void setDay1(String date, String cel, String desc)
	{
		label_date1.setText(date);
		label_cel1.setText(cel);
		label_desc1.setText(desc);
	}
	public void setDay2(String date, String cel, String desc)
	{
		label_date2.setText(date);
		label_cel2.setText(cel);
		label_desc2.setText(desc);
	}
	public void setDay3(String date, String cel, String desc)
	{
		label_date3.setText(date);
		label_cel3.setText(cel);
		label_desc3.setText(desc);
	}
	public void setDay4(String date, String cel, String desc)
	{
		label_date4.setText(date);
		label_cel4.setText(cel);
		label_desc4.setText(desc);
	}
	public void setDay5(String date, String cel, String desc)
	{
		label_date5.setText(date);
		label_cel5.setText(cel);
		label_desc5.setText(desc);
	}
	public void setDay6(String date, String cel, String desc)
	{
		label_date6.setText(date);
		label_cel6.setText(cel);
		label_desc6.setText(desc);
	}
	public void setDay7(String date, String cel, String desc)
	{
		label_date7.setText(date);
		label_cel7.setText(cel);
		label_desc7.setText(desc);
	}
}
