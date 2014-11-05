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
	public static final String ADMINADD = "1";
	public static final String ADMINEDIT = "2";
	public static final String ADMINPANEL = "3";
	public static final String LOGINPANEL = "4";
	public static final String USERDEPOSIT = "5";
	public static final String USERPANEL = "6";
	public static final String USERPAY = "7";
	public static final String USERTRANSFER = "8";
	public static final String USERWITHDRAW = "9";
	public static final String RECIPIENTPANEL = "10";

	// variable til at holde på objekter af JPanel
	private JPanel contentPane;
	private AdminAdd adminAdd;
	private AdminEdit adminEdit;
	private AdminPanel adminPanel;
	private LoginPanel loginPanel;
	private UserDeposit userDeposit;
	private UserPanel userPanel;
	private UserPay userPay;
	private UserTransfer userTransfer;
	private UserWithdraw userWithdraw;
	private RecipientPanel recipientPanel;
	
	CardLayout c; //variabel til at holde på cardlayout

	/**
	 * Constructer that holds the frame and an object for every panel
	 */
	public Screen() // konstruktør
	{
		setTitle("Bitcoin@CBS"); // titel på vindue
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Programmet lukkes ned når vinduet lukkes
		setBounds(100, 100, 336, 519); // størrelsen på vinduet
		contentPane = new JPanel(); // der oprettes et tomt panel
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0)); // størrelsen på vinduet
		setContentPane(contentPane); // det tomme panel sættes i vinduet
		contentPane.setLayout(new CardLayout(0, 0)); // panelets layout sættes som et cardlayout

		// Der laves objekter af alle paneler og disse tilføjes contentpane, sammen med et kaldenavn
		
		adminAdd = new AdminAdd();
		contentPane.add(adminAdd, ADMINADD);

		adminEdit = new AdminEdit();
		contentPane.add(adminEdit, ADMINEDIT);

		adminPanel = new AdminPanel();
		contentPane.add(adminPanel, ADMINPANEL);

		loginPanel = new LoginPanel();
		contentPane.add(loginPanel, LOGINPANEL);

		userDeposit = new UserDeposit();
		contentPane.add(userDeposit, USERDEPOSIT);

		userPanel = new UserPanel();
		contentPane.add(userPanel, USERPANEL);

		userPay = new UserPay();
		contentPane.add(userPay, USERPAY);

		userTransfer = new UserTransfer();
		contentPane.add(userTransfer, USERTRANSFER);

		userWithdraw = new UserWithdraw();
		contentPane.add(userWithdraw, USERWITHDRAW);

		recipientPanel = new RecipientPanel();
		contentPane.add(recipientPanel, RECIPIENTPANEL);

		c = (CardLayout) getContentPane().getLayout(); // cardlayoutet sættes til kunne bestå af de forskellige contentpanes
	} // konstruktør slutter

	
	// getters og setters til paneler
	
	/**
	 * @return adminAdd
	 */
	public AdminAdd getAdminAdd() {
		return adminAdd; // returnerer adiminAdd
	}

	/**
	 * @return adminEdit
	 */
	public AdminEdit getAdminEdit() {
		return adminEdit; // returnerer adminEdit
	}

	/**
	 * @return adminPanel
	 */
	public AdminPanel getAdminPanel() {
		return adminPanel; // returnerer adminPanel
	}

	/**
	 * @return loginPanel
	 */
	public LoginPanel getLoginPanel() {
		return loginPanel; // returnerer loginPanel
	}

	/**
	 * @return userDeposit
	 */
	public UserDeposit getUserDeposit() {
		return userDeposit; // returnerer userDeposit
	}

	/**
	 * @return userPanel
	 */
	public UserPanel getUserPanel() {
		return userPanel; // returnerer userPanel
	}

	/**
	 * @return userPay
	 */
	public UserPay getUserPay() {
		return userPay; // returnerer userPay
	}

	/**
	 * @return userTransfer
	 */
	public UserTransfer getUserTransfer() {
		return userTransfer; // returnerer userTransfer
	}

	/**
	 * @return userWithdraw
	 */
	public UserWithdraw getUserWithdraw() {
		return userWithdraw; // returnerer userWithdraw
	}

	/**
	 * @return recipientPanel
	 */
	public RecipientPanel getRecipientPanel() {
		return recipientPanel; // returnerer recipientPanel
	}

	/**
	 * @param card
	 */
	public void show(String card) // metode til at skifte mellem de forskellige paneler gennem cardlayout
	{
		c.show(getContentPane(), card); // cardlayout viser den contentpane der bliver sendt gennem argumentet
	} // metoden slutter
} // klassen slutter