package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.jtattoo.plaf.noire.NoireLookAndFeel;

import logic.AuthLogic;

import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Main {

	private JFrame frmBiometricAuthentication;
	private AuthLogic auth;
	private JLabel lblNousers;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//Changing look and feel
		try {
			NoireLookAndFeel.setTheme("Default", "", "");
			UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException 
		| UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
				
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmBiometricAuthentication.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.auth = new AuthLogic();
		
		frmBiometricAuthentication = new JFrame();
		frmBiometricAuthentication.setTitle("Biometric Authentication");
		frmBiometricAuthentication.setResizable(false);
		frmBiometricAuthentication.setBounds(100, 100, 300, 200);
		frmBiometricAuthentication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBiometricAuthentication.getContentPane().setLayout(null);
		
		JButton btnSignUp = new JButton("SIGN UP");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SignUp signUp = new SignUp(auth);
				signUp.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
				signUp.setVisible(true);
			}
		});
		btnSignUp.setBounds(65, 40, 165, 24);
		frmBiometricAuthentication.getContentPane().add(btnSignUp);
		
		JButton btnSignIn = new JButton("SIGN IN");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SignIn signIn = new SignIn(auth);
				signIn.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
				signIn.setVisible(true);
			}
		});
		btnSignIn.setBounds(65, 88, 165, 24);
		frmBiometricAuthentication.getContentPane().add(btnSignIn);
		
		JLabel lblNousers = new JLabel("");
		lblNousers.setBounds(12, 12, 270, 16);
		frmBiometricAuthentication.getContentPane().add(lblNousers);
		lblNousers.setText("No. of Users: "+String.valueOf(auth.getNumberOfUsers()));
	}
}
