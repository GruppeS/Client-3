package view; // en del af view

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.SystemColor;

public class MainMenu extends JPanel // MainMenu klasse der extender JPanel
{
	private static final long serialVersionUID = 1L; // Genereret ID

	// instansvariable til at holde p� JLabels, JTextFields og JButtons
	private JLabel lblMainMenu;
	private JButton btnCalendars;
	private JButton btnWeather;
	private JLabel lblQuoteOfTheDay;
	private JTextArea txtAreaTheQuote;
	private JButton btnLogout;

	public MainMenu()
	{
		setLayout(null); // absolut layout

		lblMainMenu = new JLabel("Main Menu"); // Opret label og s�t tekst
		lblMainMenu.setBounds(123, 47, 92, 51); // St�rrelse og placering
		lblMainMenu.setFont(new Font("Calibri", Font.BOLD, 19)); // Tekst formattering
		add(lblMainMenu); // Tilf�j til panel

		btnCalendars = new JButton("Calendar(s)");
		btnCalendars.setBounds(43, 189, 110, 23);
		add(btnCalendars);

		btnWeather = new JButton("Weather");
		btnWeather.setBounds(172, 189, 110, 23);
		add(btnWeather);

		lblQuoteOfTheDay = new JLabel("Quote of the day:");
		lblQuoteOfTheDay.setBounds(107, 258, 108, 16);
		lblQuoteOfTheDay.setFont(new Font("Calibri", Font.PLAIN, 12));
		add(lblQuoteOfTheDay);
		
		txtAreaTheQuote = new JTextArea();
		txtAreaTheQuote.setFont(new Font("Papyrus", Font.ITALIC, 13));
		txtAreaTheQuote.setBackground(SystemColor.menu);
		txtAreaTheQuote.setBounds(24, 285, 281, 156);
		txtAreaTheQuote.setLineWrap(true);
		txtAreaTheQuote.setWrapStyleWord(true);
		add(txtAreaTheQuote);
		
		btnLogout = new JButton("Log out");
		btnLogout.setBounds(123, 446, 89, 23);
		add(btnLogout);

	}

	public void addActionListener(ActionListener l) // metode til at tilf�je actionlisteners og actioncommands til knapper
	{
		btnCalendars.addActionListener(l); // tilf�jer actionlistener
		btnCalendars.setActionCommand("CalendarsBtn"); // tilf�jer actioncommand
		btnWeather.addActionListener(l);
		btnWeather.setActionCommand("WeatherBtn");
		btnLogout.addActionListener(l);
		btnLogout.setActionCommand("LogoutBtn");

	} // metode slutter
	
	// setters
	
	public void setQOTD (String quote)
	{
		txtAreaTheQuote.setText(quote);
	} // metode slutter
	
} // klasse slutter