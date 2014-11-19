package view; // en del af view

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainMenu extends JPanel // MainMenu klasse der extender JPanel
{
	private static final long serialVersionUID = 1L; // Genereret ID

	// instansvariable til at holde på JLabels, JTextFields og JButtons
	private JLabel lblMainMenu;
	private JButton btnCalendars;
	private JButton btnWeather;
	private JLabel lblQuoteOfTheDay;
	private JLabel lblTheQuote;

	public MainMenu()
	{
		setLayout(null); // absolut layout

		lblMainMenu = new JLabel("Main Menu"); // Opret label og sæt tekst
		lblMainMenu.setBounds(123, 47, 92, 51); // Størrelse og placering
		lblMainMenu.setFont(new Font("Calibri", Font.PLAIN, 19)); // Tekst formattering
		add(lblMainMenu); // Tilføj til panel

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
		
		lblTheQuote = new JLabel("");
		lblTheQuote.setBounds(24, 285, 281, 99);
		add(lblTheQuote);

	}

	public void addActionListener(ActionListener l) // metode til at tilføje actionlisteners og actioncommands til knapper
	{
		btnCalendars.addActionListener(l); // tilføjer actionlistener
		btnCalendars.setActionCommand("CalendarsBtn"); // tilføjer actioncommand
		btnWeather.addActionListener(l);
		btnWeather.setActionCommand("WeatherBtn");

	} // metode slutter
	
	// setters
	
	public void setQuote (String quote, String auther, String topic)
	{
		lblTheQuote.setText(quote + ", Auther:" + auther + ", Topic:" + topic);
	} // metode slutter
} // klasse slutter