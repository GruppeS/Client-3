package view; // En del af view

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPanel extends JPanel // LoginPanel klasse der extender JPanel
{ 
	private static final long serialVersionUID = 1L; // Genereret ID
	
	// instansvariable til at holde på JLabels, JTextFields og JButtons
	private JLabel lblNewLabel;
	private JLabel lblPleaseLoginBelow;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JLabel lblIncorrect_1;
	private JTextField userName_Login;
	private JPasswordField password_Login;
	private JButton btnLogin;
	private JLabel lblIncorrect_2;
	private JLabel lblIncorrect_3;
	private JLabel lblIncorrect_4;


	/**
	 * Constructer that adds the necessary layout and buttons for the Loginpanel
	 */
	public LoginPanel() // konstruktør der sætter panelets udseende
	{
		setLayout(null); // absolut layout

		// JLabels
		lblNewLabel = new JLabel("Welcome to Calendar"); // Opret label og sæt tekst
		lblNewLabel.setBounds(74, 97, 170, 24); // Størrelse og placering
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 19)); // Tekst formattering
		add(lblNewLabel); // Tilføj til panel

		lblPleaseLoginBelow = new JLabel("Please login below:");
		lblPleaseLoginBelow.setBounds(99, 145, 108, 16);
		lblPleaseLoginBelow.setFont(new Font("Calibri", Font.PLAIN, 12));
		add(lblPleaseLoginBelow);

		lblUsername = new JLabel("Username:");
		lblUsername.setBounds(83, 197, 52, 14);
		lblUsername.setFont(new Font("Calibri", Font.PLAIN, 11));
		add(lblUsername);

		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(86, 252, 49, 14);
		lblPassword.setFont(new Font("Calibri", Font.PLAIN, 11));
		add(lblPassword);
		
		// JTextField
		userName_Login = new JTextField(); // Opret textfield
		userName_Login.setBounds(86, 222, 143, 20); // Størrelse og placering
		userName_Login.setColumns(10); // Størrelse
		add(userName_Login); // Tilføj til panel
		
		//JPasswordField
		password_Login = new JPasswordField(); // Opret passwordfield
		password_Login.setBounds(86, 276, 143, 20); // Størrelse og placering
		password_Login.setColumns(10); // Størrelse
		add(password_Login); // Tilføj til panel

		//JButton
		btnLogin = new JButton("Login"); // Lav knap og sæt tekst
		btnLogin.setBounds(118, 446, 89, 23); // Størrelse og placering
		add(btnLogin); // Tilføj til panel
		
		lblIncorrect_1 = new JLabel("Username does not exist");
		lblIncorrect_1.setBounds(99, 318, 124, 14);
		lblIncorrect_1.setFont(new Font("Calibri", Font.ITALIC, 11));
		lblIncorrect_1.setForeground(Color.red);
		lblIncorrect_1.setVisible(false);
		add(lblIncorrect_1);
		
		lblIncorrect_2 = new JLabel("This user is inactive");
		lblIncorrect_2.setBounds(118, 318, 89, 14);
		lblIncorrect_2.setFont(new Font("Calibri", Font.ITALIC, 11));
		lblIncorrect_2.setForeground(Color.RED);
		lblIncorrect_2.setVisible(false);
		add(lblIncorrect_2);
		
		lblIncorrect_3 = new JLabel("Wrong password");
		lblIncorrect_3.setBounds(118, 318, 79, 14);
		lblIncorrect_3.setFont(new Font("Calibri", Font.ITALIC, 11));
		lblIncorrect_3.setForeground(Color.RED);
		lblIncorrect_3.setVisible(false);
		add(lblIncorrect_3);
		
		lblIncorrect_4 = new JLabel("Wrong login platform");
		lblIncorrect_4.setBounds(102, 318, 105, 14);
		lblIncorrect_4.setForeground(Color.RED);
		lblIncorrect_4.setFont(new Font("Calibri", Font.ITALIC, 11));
		lblIncorrect_4.setVisible(false);
		add(lblIncorrect_4);
	} // Konstruktør slutter

	/**
	 * adds actionlisteners and actioncommands for button
	 * @param l
	 */
	public void addActionListener(ActionListener l) // metode til at tilføje actionlisteners og actioncommands til knapper
	{
		btnLogin.addActionListener(l); // tilføjer actionlistener
		btnLogin.setActionCommand("LoginBtn"); // tilføjer actioncommand
	} // metode slutter
	// metode til at vise label
	public void incorrect_1()
	{
		lblIncorrect_1.setVisible(true);
	}
	public void incorrect_2()
	{
		lblIncorrect_2.setVisible(true);
	}
	public void incorrect_3()
	{
		lblIncorrect_3.setVisible(true);
	}
	public void incorrect_4()
	{
		lblIncorrect_4.setVisible(true);
	}
	/**
	 * @return UserName_Login.getText()
	 */
	// getters
	public String getUserName_Login()
	{
		return userName_Login.getText();
	}

	/**
	 * @return Password_Login.getText()
	 */
	@SuppressWarnings("deprecation")
	public String getPassword_Login()
	{
		return password_Login.getText();
	}

	public void reset() // metode der nulstiller panelet
	{
		// skjuler labels
		lblIncorrect_1.setVisible(false);
		lblIncorrect_2.setVisible(false);
		lblIncorrect_3.setVisible(false);
		lblIncorrect_4.setVisible(false);
		// fjerner tekst i textfields
		password_Login.setText("");
	}
	
	public void setPassword_Login(String password_Login){
		this.password_Login.setText(password_Login);
	}
}