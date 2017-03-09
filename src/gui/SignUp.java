package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jtattoo.plaf.noire.NoireLookAndFeel;

import logic.AuthLogic;
import validation.Validation;

import java.awt.Dialog.ModalityType;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUp extends JDialog {
	private AuthLogic auth;
	private JTextField[] txts;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField txtLengthFinger1;
	private JTextField txtWidthFinger1;
	private JTextField txtLengthFinger2;
	private JTextField txtWidthFinger2;
	private JTextField txtWidthFinger3;
	private JTextField txtLengthFinger4;
	private JTextField txtWidthFinger4;
	private JTextField txtLengthFinger5;
	private JTextField txtWidthFinger5;
	private JLabel lblHand;
	private JTextField txtUsername;
	private JLabel lblUsername;
	private JLabel label;

	/**
	 * Create the dialog.
	 */
	public SignUp(AuthLogic auth) {
		setResizable(false);
		this.auth = auth;
		
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 600, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		txtLengthFinger1 = new JTextField();
		txtLengthFinger1.setBounds(172, 157, 70, 20);
		contentPanel.add(txtLengthFinger1);
		txtLengthFinger1.setColumns(10);
		
		txtWidthFinger1 = new JTextField();
		txtWidthFinger1.setColumns(10);
		txtWidthFinger1.setBounds(349, 184, 60, 20);
		contentPanel.add(txtWidthFinger1);
		
		txtLengthFinger2 = new JTextField();
		txtLengthFinger2.setColumns(10);
		txtLengthFinger2.setBounds(172, 221, 70, 20);
		contentPanel.add(txtLengthFinger2);
		
		txtWidthFinger2 = new JTextField();
		txtWidthFinger2.setColumns(10);
		txtWidthFinger2.setBounds(349, 251, 60, 20);
		contentPanel.add(txtWidthFinger2);
		
		JTextField txtLengthFinger3 = new JTextField();
		txtLengthFinger3.setColumns(10);
		txtLengthFinger3.setBounds(172, 278, 70, 20);
		contentPanel.add(txtLengthFinger3);
		
		txtWidthFinger3 = new JTextField();
		txtWidthFinger3.setColumns(10);
		txtWidthFinger3.setBounds(349, 311, 60, 20);
		contentPanel.add(txtWidthFinger3);
		
		txtLengthFinger4 = new JTextField();
		txtLengthFinger4.setColumns(10);
		txtLengthFinger4.setBounds(172, 339, 70, 20);
		contentPanel.add(txtLengthFinger4);
		
		txtWidthFinger4 = new JTextField();
		txtWidthFinger4.setColumns(10);
		txtWidthFinger4.setBounds(349, 365, 60, 20);
		contentPanel.add(txtWidthFinger4);
		
		txtLengthFinger5 = new JTextField();
		txtLengthFinger5.setColumns(10);
		txtLengthFinger5.setBounds(172, 444, 70, 20);
		contentPanel.add(txtLengthFinger5);
		
		txtWidthFinger5 = new JTextField();
		txtWidthFinger5.setColumns(10);
		txtWidthFinger5.setBounds(251, 415, 60, 20);
		contentPanel.add(txtWidthFinger5);
		
		txts = new JTextField[]{txtLengthFinger1, txtLengthFinger2, txtLengthFinger3, txtLengthFinger4, txtLengthFinger5,
				txtWidthFinger1, txtWidthFinger2, txtWidthFinger3, txtWidthFinger4, txtWidthFinger5};
		
		JLabel lblSignUp = new JLabel("");
		lblSignUp.setIcon(new ImageIcon(SignUp.class.getResource("/resources/Signup.png")));
		lblSignUp.setBorder(null);
		lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignUp.setBounds(6, 12, 572, 68);
		contentPanel.add(lblSignUp);
		
		lblHand = new JLabel("");
		lblHand.setBorder(null);
		lblHand.setIcon(new ImageIcon(SignUp.class.getResource("/resources/hand_edit.png")));
		lblHand.setBounds(6, 123, 572, 368);
		contentPanel.add(lblHand);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(290, 91, 100, 20);
		contentPanel.add(txtUsername);
		txtUsername.setColumns(10);
		
		lblUsername = new JLabel("USERNAME");
		lblUsername.setLabelFor(txtUsername);
		lblUsername.setBounds(202, 92, 70, 20);
		contentPanel.add(lblUsername);
		
		JButton btnSubmit = new JButton("SignUp");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//validate txts
				for(JTextField txt:txts){
					if (!Validation.isValid(txt.getText())){
						JOptionPane.showMessageDialog(null, "Invalid values contain...", "Error!!!", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				if (txtUsername.getText().trim().length()==0){
					JOptionPane.showMessageDialog(null, "Username cannot be empty...", "Error!!!", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				
				float[] widths = new float[]{
						Float.valueOf(txtWidthFinger1.getText()), Float.valueOf(txtWidthFinger2.getText()),
						Float.valueOf(txtWidthFinger3.getText()), Float.valueOf(txtWidthFinger4.getText()),
						Float.valueOf(txtWidthFinger5.getText())
				};
				float[] lengths = new float[]{
						Float.valueOf(txtLengthFinger1.getText()), Float.valueOf(txtLengthFinger2.getText()),
						Float.valueOf(txtLengthFinger3.getText()), Float.valueOf(txtLengthFinger4.getText()),
						Float.valueOf(txtLengthFinger5.getText())
				};
				auth.signUp(txtUsername.getText().trim(), widths, lengths);
				JOptionPane.showMessageDialog(null, "You have successfully registered.", "Successful!!!", JOptionPane.INFORMATION_MESSAGE);
				
				
				//clear all
				for(JTextField txt:txts){
					txt.setText("");
				}
				txtUsername.setText("");
				SignUp.this.dispose();
			}
		});
		btnSubmit.setBounds(337, 527, 89, 23);
		contentPanel.add(btnSubmit);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp.this.dispose();
			}
		});
		btnCancel.setBounds(172, 527, 89, 23);
		contentPanel.add(btnCancel);
		
		label = new JLabel("Please use centimeter values to fill. Values up to first decimal place will be considered. eg. 8.7, 5.5");
		label.setBounds(6, 129, 566, 16);
		contentPanel.add(label);
	}
}
