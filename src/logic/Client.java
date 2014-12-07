 package logic; // ligger i logic-pakken

// importerer skærmen, forbindelse og kryptering
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import model.Encrypter;
import model.Forecast;
import model.Forecasts;
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
	private Forecast forecast;
	private Forecasts forecasts;


	public Client () { // Konstruktør

		// instansvariable instansieres
		screen = new Screen();
		tcpconnection = new TCPconnection();
		cryp = new Encrypter();
		userInfo = new UserInfo();
		gson = new GsonBuilder().create();
		qotd = new QOTD();
		forecast = new Forecast(null, null, null);
		forecasts = new Forecasts();


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
				userInfo.setUsername(userName);
				userInfo.setPassword(password);
				String json = gson.toJson(userInfo);
				String info = null;
				try {
					tcpconnection.connect();
					info = tcpconnection.connection(json);
					userInfo = gson.fromJson(info,  UserInfo.class);
					info = userInfo.getAuthenticated();
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
				if (info.equals("1")){
					screen.getLoginPanel().reset();
					screen.getLoginPanel().incorrect_1();
				}
				if (info.equals("2")){
					screen.getLoginPanel().reset();
					screen.getLoginPanel().incorrect_2();
				}
				if (info.equals("3")){
					screen.getLoginPanel().reset();
					screen.getLoginPanel().incorrect_3();
				}
				if (info.equals("4")){
					screen.getLoginPanel().reset();
					screen.getLoginPanel().incorrect_4();
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
			if (cmd.equals("LogoutBtn")) {
				tcpconnection.closeConnection();
				screen.getLoginPanel().setPassword_Login("");
				screen.getLoginPanel().reset();
				screen.show(Screen.LOGINPANEL);
				
				
			}
			if(cmd.equals("WeatherBtn")) {
				try {
					String reply = tcpconnection.connection(gson.toJson(forecasts));
					forecasts = gson.fromJson(reply, Forecasts.class);
					
					for(int i = 0; i<7; i++) {
						if(i==0){
							screen.getWeather().setDay1(forecasts.forecasts.get(i).getDate().substring(0, 10), forecasts.forecasts.get(i).getCelsius(), forecasts.forecasts.get(i).getDesc());
						}
						if(i==1){
							screen.getWeather().setDay2(forecasts.forecasts.get(i).getDate().substring(0, 10), forecasts.forecasts.get(i).getCelsius(), forecasts.forecasts.get(i).getDesc());
						}
						if(i==2){
							screen.getWeather().setDay3(forecasts.forecasts.get(i).getDate().substring(0, 10), forecasts.forecasts.get(i).getCelsius(), forecasts.forecasts.get(i).getDesc());
						}
						if(i==3){
							screen.getWeather().setDay4(forecasts.forecasts.get(i).getDate().substring(0, 10), forecasts.forecasts.get(i).getCelsius(), forecasts.forecasts.get(i).getDesc());
						}
						if(i==4){
							screen.getWeather().setDay5(forecasts.forecasts.get(i).getDate().substring(0, 10), forecasts.forecasts.get(i).getCelsius(), forecasts.forecasts.get(i).getDesc());
						}
						if(i==5){
							screen.getWeather().setDay6(forecasts.forecasts.get(i).getDate().substring(0, 10), forecasts.forecasts.get(i).getCelsius(), forecasts.forecasts.get(i).getDesc());
						}
						if(i==6){
							screen.getWeather().setDay7(forecasts.forecasts.get(i).getDate().substring(0, 10), forecasts.forecasts.get(i).getCelsius(), forecasts.forecasts.get(i).getDesc());
						}
						
					}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
