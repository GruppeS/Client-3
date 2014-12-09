package view; // en del af ui

// importerer de nødvendige pakker fra swing og cardlayout
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
	public static final String CALENDARVIEW = "4";

	
	// variable til at holde på objekter af JPanel
	private JPanel contentPane;
	private LoginPanel loginPanel;
	private MainMenu mainMenu;
	private Weather weather;
	private CalendarView calendarView;

	CardLayout c; //variabel til at holde på cardlayout

	/**
	 * Constructer that holds the frame and an object for every panel
	 */
	public Screen() // konstruktør
	{
		setTitle("Calendar"); // titel på vindue
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Programmet lukkes ned når vinduet lukkes
		setBounds(100, 100, 336, 519); // størrelsen på vinduet
		contentPane = new JPanel(); // der oprettes et tomt panel
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0)); // størrelsen på vinduet
		setContentPane(contentPane); // det tomme panel sættes i vinduet
		contentPane.setLayout(new CardLayout(0, 0)); // panelets layout sættes som et cardlayout

		// Der laves objekter af alle paneler og disse tilføjes contentpane, sammen med et kaldenavn
		

		loginPanel = new LoginPanel();
		contentPane.add(loginPanel, LOGINPANEL);

		mainMenu = new MainMenu();
		contentPane.add(mainMenu, MAINMENU); 

		weather = new Weather();
		contentPane.add(weather, WEATHER); 
		
		calendarView = new CalendarView();
		contentPane.add(calendarView, CALENDARVIEW); 


		c = (CardLayout) getContentPane().getLayout(); // cardlayoutet sættes til kunne bestå af de forskellige contentpanes
	} // konstruktør slutter

	
	// getters og setters til paneler
	
	/**
	 * @return 
	 * @return loginPanel
	 */
	
	public void setSize(int h, int w){
		setBounds(0, 0, h, w);
	}
	
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
	
	public CalendarView getCalendarView() {
		return calendarView; // returnerer calendarView
	}

	public void show(String card) // metode til at skifte mellem de forskellige paneler gennem cardlayout
	{
		c.show(getContentPane(), card); // cardlayout viser den contentpane der bliver sendt gennem argumentet
	} // metoden slutter
} // klassen slutter