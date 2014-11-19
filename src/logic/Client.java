package logic; // ligger i logic-pakken

// importerer skærmen, forbindelse og kryptering
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Encrypter;
import model.TCPconnection;
import model.UserInfo;
import view.Screen;


public class Client { // Client klasse
	// Instantsvariable 
	private Screen screen;
	private TCPconnection tcpconnection;
	private Encrypter cryp;
	private UserInfo userInfo;

	public Client () { // Konstruktør

		// instansvariable instansieres
		screen = new Screen();
		tcpconnection = new TCPconnection();
		cryp = new Encrypter();
		userInfo = new UserInfo();

		// actionlistener til hvert panel
		screen.getLoginPanel().addActionListener(new LoginPanelActionListener());
		screen.getMainMenu().addActionListener(new MainMenuActionListener()); 
		screen.getWeather().addActionListener(new WeatherActionListener()); 
//		screen.getCalendarWeek().addActionListener(new CalendarWeekActionListener()); 
//		screen.getCalendarDay().addActionListener(new CalendarDayActionListener()); 

	} // konstruktør afsluttes
	public void run()
	{
		System.out.print("");
		screen.show(Screen.LOGINPANEL); //
		screen.setVisible(true); //vinduet vises
	}
	private class LoginPanelActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if(cmd.equals("LoginBtn")) {
				String userName = screen.getLoginPanel().getUserName_Login();
				String password = screen.getLoginPanel().getPassword_Login();
				try {
					String epassword = cryp.aesEncrypt(password);
					userInfo.setAuthUserEmail(userName);
					userInfo.setAuthUserPassword(epassword);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				screen.show(Screen.MAINMENU);
			}
		}
	}
	private class MainMenuActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if(cmd.equals("CalendarsBtn")) {
				screen.show(Screen.CALENDARMONTH);
			}
			if(cmd.equals("WeatherBtn")) {
				screen.show(Screen.WEATHER);			
			}
		}
	}
	private class WeatherActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			
			if(cmd.equals("BackToMainBtn")) {
				screen.show(Screen.MAINMENU);
			}
		}
	}
////	private class CalendarWeekActionListener implements ActionListener {
////		public void actionPerformed(ActionEvent e) {
////			String cmd = e.getActionCommand();
////		}
////	}
////	private class CalendarDayActionListener implements ActionListener {
////		public void actionPerformed(ActionEvent e) {
////			String cmd = e.getActionCommand();
////		}
//	}
}