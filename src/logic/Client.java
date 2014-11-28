package logic; // ligger i logic-pakken

// importerer skærmen, forbindelse og kryptering
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import model.Encrypter;
import model.QOTD;
import model.TCPconnection;
import model.UserInfo;
import view.Screen;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class Client { // Client klasse
	// Instantsvariable 
	private Screen screen;
	private TCPconnection tcpconnection;
	private Encrypter cryp;
	private UserInfo userInfo;
	private Gson gson;
	private QOTD qotd;


	public Client () { // Konstruktør

		// instansvariable instansieres
		screen = new Screen();
		tcpconnection = new TCPconnection();
		cryp = new Encrypter();
		userInfo = new UserInfo();
		gson = new GsonBuilder().create();
		qotd = new QOTD();


		// actionlistener til hvert panel
		screen.getLoginPanel().addActionListener(new LoginPanelActionListener());
		screen.getMainMenu().addActionListener(new MainMenuActionListener()); 
		screen.getWeather().addActionListener(new WeatherActionListener());
		screen.getCalendarMonth().addActionListener(new CalendarMonthActionListener());
		//		screen.getCalendarWeek().addActionListener(new CalendarWeekActionListener()); 
		//		screen.getCalendarDay().addActionListener(new CalendarDayActionListener()); 

	} // konstruktør afsluttes
	public void run()
	{
		screen.show(Screen.LOGINPANEL); //
		screen.setVisible(true); //vinduet vises
	}
	private class LoginPanelActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if(cmd.equals("LoginBtn")) {
				String userName = screen.getLoginPanel().getUserName_Login();
				String password = screen.getLoginPanel().getPassword_Login();
				userInfo.setAuthUserEmail(userName);
				userInfo.setAuthUserPassword(password);
				String json = gson.toJson(userInfo);
				String info = null;
				try {
					info = tcpconnection.connection(json);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(info.equals("0")){
					screen.show(Screen.MAINMENU);
					try {
						String reply = tcpconnection.connection(gson.toJson(qotd));
						qotd = gson.fromJson(reply, QOTD.class);
						screen.getMainMenu().setQOTD(qotd.getQuote());
						
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
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
				//			}
				//			if(cmd.equals("LogutBtn")) {
				//				 = false;
				//				screen.show(Screen.LOGINPANEL);	
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

	private class CalendarMonthActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();

			if(cmd.equals("BackToMainBtn")) {
				screen.show(Screen.MAINMENU);
			}

			int currentYear = screen.getCalendarMonth().getCurrentYear();
			int currentMonth = screen.getCalendarMonth().getCurrentMonth();


			if (cmd.equals("PrevBtn")){

				if (currentMonth == 0){ //Back one year
					screen.getCalendarMonth().setCurrentMonth(currentMonth = 11);
					screen.getCalendarMonth().setCurrentYear(currentYear -= 1);

				}
				else{ //Back one month
					screen.getCalendarMonth().setCurrentMonth(currentMonth -= 1);

				}
				screen.getCalendarMonth().refreshCalendar(currentMonth, currentYear);

			}

			if (cmd.equals("NextBtn")){

				if (currentMonth == 11){ //Foward one year
					screen.getCalendarMonth().setCurrentMonth(currentMonth = 0);
					screen.getCalendarMonth().setCurrentYear(currentYear += 1);
				}
				else{ //Foward one month
					screen.getCalendarMonth().setCurrentMonth(currentMonth += 1);
				}
				screen.getCalendarMonth().refreshCalendar(currentMonth, currentYear);


				if(cmd.equals("YearCmb")){

					if (screen.getCalendarMonth().getCmbYear().getSelectedItem() != null){
						String b = screen.getCalendarMonth().getCmbYear().getSelectedItem().toString();
						screen.getCalendarMonth().setCurrentYear(currentYear = Integer.parseInt(b));
						screen.getCalendarMonth().refreshCalendar(currentMonth, currentYear);	
					}
				}
			}
		}
	}

	//	private class CalendarWeekActionListener implements ActionListener {
	//		public void actionPerformed(ActionEvent e) {
	//			String cmd = e.getActionCommand();
	//		}
	//	}
	//	private class CalendarDayActionListener implements ActionListener {
	//		public void actionPerformed(ActionEvent e) {
	//			String cmd = e.getActionCommand();
	//		}
	//	}
}
