package logic; // ligger i logic-pakken

// importerer skærmen, forbindelse og kryptering
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Encrypter;
import model.TCPconnection;
import view.Screen;


public class Client { // Client klasse
	// Instantsvariable 
	private Screen screen;
	private TCPconnection tcpconnection;
	private Encrypter cryp;

	public Client () { // Konstruktør

		// instansvariable instansieres
		screen = new Screen();
		tcpconnection = new TCPconnection();
		cryp = new Encrypter();

		// actionlistener til hvert panel
		screen.getLoginPanel().addActionListener(new LoginPanelActionListener());
		screen.getMainMenu().addActionListener(new MainMenuActionListener());
		screen.getWeather().addActionListener(new WeatherActionListener());
		screen.getCalendarWeek().addActionListener(new CalendarWeekActionListener());
		screen.getCalendarDay().addActionListener(new CalendarDayActionListener());

	} // konstruktør afsluttes
	public void run()
	{
		screen.show(Screen.LOGINPANEL); //
		screen.setVisible(true); //vinduet vises
	}
	private class LoginPanelActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();	
		}
	}
	private class MainMenuActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
		}
	}
	private class WeatherActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
		}
	}
	private class CalendarWeekActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
		}
	}
	private class CalendarDayActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
		}
	}
}