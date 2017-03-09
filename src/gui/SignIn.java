package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.AuthLogic;
import validation.Validation;

import java.awt.Dialog.ModalityType;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignIn extends JDialog {
	private AuthLogic auth;
	private JTextField[] txts;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField txtLength1;
	private JTextField txtWidth1;
	private JTextField txtLength2;
	private JTextField txtWidth2;
	private JTextField txtLength3;
	private JTextField txtWidth3;
	private JTextField txtLength4;
	private JTextField txtWidth4;
	private JTextField txtLength5;
	private JTextField txtWidth5;

	/**
	 * Create the dialog.
	 */
	public SignIn(AuthLogic auth) {
		setResizable(false);
		this.auth = auth;
				
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 600, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		txtLength1 = new JTextField();
		txtLength1.setColumns(10);
		txtLength1.setBounds(173, 156, 70, 20);
		contentPanel.add(txtLength1);
		
		txtWidth1 = new JTextField();
		txtWidth1.setColumns(10);
		txtWidth1.setBounds(355, 187, 60, 20);
		contentPanel.add(txtWidth1);
		
		txtLength2 = new JTextField();
		txtLength2.setColumns(10);
		txtLength2.setBounds(173, 220, 70, 20);
		contentPanel.add(txtLength2);
		
		txtWidth2 = new JTextField();
		txtWidth2.setColumns(10);
		txtWidth2.setBounds(355, 252, 60, 20);
		contentPanel.add(txtWidth2);
		
		txtLength3 = new JTextField();
		txtLength3.setColumns(10);
		txtLength3.setBounds(173, 280, 70, 20);
		contentPanel.add(txtLength3);
		
		txtWidth3 = new JTextField();
		txtWidth3.setColumns(10);
		txtWidth3.setBounds(355, 310, 60, 20);
		contentPanel.add(txtWidth3);
		
		txtLength4 = new JTextField();
		txtLength4.setColumns(10);
		txtLength4.setBounds(173, 337, 70, 20);
		contentPanel.add(txtLength4);
		
		txtWidth4 = new JTextField();
		txtWidth4.setColumns(10);
		txtWidth4.setBounds(355, 367, 60, 20);
		contentPanel.add(txtWidth4);
		
		txtLength5 = new JTextField();
		txtLength5.setColumns(10);
		txtLength5.setBounds(173, 443, 70, 20);
		contentPanel.add(txtLength5);
		
		txtWidth5 = new JTextField();
		txtWidth5.setColumns(10);
		txtWidth5.setBounds(252, 418, 60, 20);
		contentPanel.add(txtWidth5);
		
		txts = new JTextField[]{
				txtWidth1, txtWidth2, txtWidth3, txtWidth4, txtWidth5,
				txtLength1, txtLength2, txtLength3, txtLength4, txtLength5
		};
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(SignIn.class.getResource("/resources/Signin.png")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBorder(null);
		label.setBounds(12, 12, 566, 68);
		contentPanel.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(SignIn.class.getResource("/resources/hand_edit.png")));
		label_1.setBorder(null);
		label_1.setBounds(12, 124, 566, 368);
		contentPanel.add(label_1);
		
		JButton btnSubmit = new JButton("Authenticate");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//validate txts
				for(JTextField txt:txts){
					if (!Validation.isValid(txt.getText())){
						JOptionPane.showMessageDialog(null, "Invalid values contain...", "Error!!!", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				
				
				float[] widths = new float[]{
						Float.valueOf(txtWidth1.getText()), Float.valueOf(txtWidth2.getText()),
						Float.valueOf(txtWidth3.getText()), Float.valueOf(txtWidth4.getText()),
						Float.valueOf(txtWidth5.getText())
				};
				float[] lengths = new float[]{
						Float.valueOf(txtLength1.getText()), Float.valueOf(txtLength2.getText()),
						Float.valueOf(txtLength3.getText()), Float.valueOf(txtLength4.getText()),
						Float.valueOf(txtLength5.getText())
				};
				String username = auth.signIn(widths, lengths);
				
				if (username.equals("")){
					JOptionPane.showMessageDialog(null, "No user found", "Authentiaction failed!!!", JOptionPane.INFORMATION_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(null, "Welcome, "+username+". Thanks for using our service.", "Authentication successful", JOptionPane.INFORMATION_MESSAGE);
					SignIn.this.dispose();
				}
				
			}
		});
		btnSubmit.setBounds(338, 527, 89, 23);
		contentPanel.add(btnSubmit);
		
		JButton button_1 = new JButton("Cancel");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignIn.this.dispose();
			}
		});
		button_1.setBounds(173, 527, 89, 23);
		contentPanel.add(button_1);
		
		JLabel lblPleaseUseCentimeters = new JLabel("Please use centimeter values to fill. Values up to first decimal place will be considered. eg. 8.7, 5.5");
		lblPleaseUseCentimeters.setBounds(12, 112, 566, 16);
		contentPanel.add(lblPleaseUseCentimeters);
	}
}
