package view; // en del af ui

// importerer de n�dvendige pakker fra swing og cardlayout
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Screen extends JFrame // Screen klasse der extender JFrame
{
	// instansvariable
	private static final long serialVersionUID = 1L; // id for screen
	
	//final static strenge til at kalde de korresponderende paneler
	public static final String LOGINPANEL = "1";
	public static final String MAINMENU = "2";
	public static final String WEATHER = "3";
	public static final String CALENDARMONTH = "4";
	public static final String CALENDARWEEK = "5";
	public static final String CALENDARDAY = "6";
	
	
	// variable til at holde p� objekter af JPanel
	private JPanel contentPane;
	private LoginPanel loginPanel;
	private MainMenu mainMenu;
	private Weather weather;
//	private CalendarMonth calendarMonth;
//	private CalendarWeek calendarWeek;
//	private CalendarDay calendarDay;
	
	CardLayout c; //variabel til at holde p� cardlayout

	/**
	 * Constructer that holds the frame and an object for every panel
	 */
	public Screen() // konstrukt�r
	{
		setTitle("Calendar"); // titel p� vindue
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Programmet lukkes ned n�r vinduet lukkes
		setBounds(100, 100, 336, 519); // st�rrelsen p� vinduet
		contentPane = new JPanel(); // der oprettes et tomt panel
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0)); // st�rrelsen p� vinduet
		setContentPane(contentPane); // det tomme panel s�ttes i vinduet
		contentPane.setLayout(new CardLayout(0, 0)); // panelets layout s�ttes som et cardlayout

		// Der laves objekter af alle paneler og disse tilf�jes contentpane, sammen med et kaldenavn
		

		loginPanel = new LoginPanel();
		contentPane.add(loginPanel, LOGINPANEL);

		mainMenu = new MainMenu();
		contentPane.add(mainMenu, MAINMENU); 

		weather = new Weather();
		contentPane.add(weather, WEATHER); 
		
//		calendarMonth = new CalendarMonth();
//		contentPane.add(calendarMonth, CALENDARMONTH); 

//		calendarWeek = new CalendarWeek();
//		contentPane.add(calendarWeek, CALENDARWEEK); 

//		calendarDay = new CalendarDay ();
//		contentPane.add(calendarDay, CALENDARDAY); 


		c = (CardLayout) getContentPane().getLayout(); // cardlayoutet s�ttes til kunne best� af de forskellige contentpanes
	} // konstrukt�r slutter

	
	// getters og setters til paneler
	
	/**
	 * @return loginPanel
	 */
	public LoginPanel getLoginPanel() {
		return loginPanel; // returnerer adminEdit
	}

	/**
	 * @return mainMenu
	 */
	public MainMenu getMainMenu() {
		return mainMenu; // returnerer adminPanel
	}

	/**
	 * @return weather
	 */
	public Weather getWeather() {
		return weather; // returnerer weather
	}
	
	/**
	 * @return weather
	 */
//	public CalendarMonth getCalendarMonth() {
//		return calendarMonth; // returnerer calendarMonth
//	}
	/**
	 * @return calendarWeek
	 */
//	public CalendarWeek getCalendarWeek() {
//		return calendarWeek; // returnerer calendarWeek
//	}

	/**
	 * @return calendarDay
	 */
//	public CalendarDay getCalendarDay() {
//		return calendarDay; // returnerer calendarDay
//	}
	/**
	 * @param card
	 */
	public void show(String card) // metode til at skifte mellem de forskellige paneler gennem cardlayout
	{
		c.show(getContentPane(), card); // cardlayout viser den contentpane der bliver sendt gennem argumentet
	} // metoden slutter
} // klassen slutter