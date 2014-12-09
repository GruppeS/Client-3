 package logic; // ligger i logic-pakken

// importerer skærmen, forbindelse og kryptering
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;

import model.Events;
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
	private UserInfo userInfo;
	private Gson gson;
	private QOTD qotd;
	private Forecasts forecasts;
	private Events events;


	public Client () { // Konstruktør

		// instansvariable instansieres
		screen = new Screen();
		tcpconnection = new TCPconnection();
		userInfo = new UserInfo();
		gson = new GsonBuilder().create();
		qotd = new QOTD();
		forecasts = new Forecasts();
		events = new Events();


		// actionlistener til hvert panel
		screen.getLoginPanel().addActionListener(new LoginPanelActionListener());
		screen.getMainMenu().addActionListener(new MainMenuActionListener()); 
		screen.getWeather().addActionListener(new WeatherActionListener());
		screen.getCalendarView().addActionListener(new CalendarViewActionListener());

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
				String gsonString = gson.toJson(events);
				String calendar = null;
				
				try {
					calendar = tcpconnection.connection(gsonString);
					events = gson.fromJson(calendar,  Events.class);
					Vector<Object> data = new Vector<Object>();
					
					for(int i = 0; i<events.events.size(); i++) {
						
						Vector<Object> row = new Vector<Object>();
						row.addElement(events.events.get(i).getType());
						row.addElement(events.events.get(i).getDescription());
						row.addElement(events.events.get(i).getStartdate());
						row.addElement(events.events.get(i).getEnddate());
						row.addElement(events.events.get(i).getLocation());
						data.addElement(row);
					}
					screen.getCalendarView().addTable(data);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				screen.setSize(900, 562);
				screen.show(Screen.CALENDARVIEW);
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

	private class CalendarViewActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			
			if(cmd.equals("BackToMainBtn")) {
				screen.show(Screen.MAINMENU);
				screen.setSize(336, 519);
			}
		}
	}
}

