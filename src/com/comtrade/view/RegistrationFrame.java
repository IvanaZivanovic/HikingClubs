package com.comtrade.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.comtrade.controllerFC.KontrolerFK;
import com.comtrade.domen.KontrolerFKKonstanta;
import com.comtrade.domen.KontrolerPLKonstanta;
import com.comtrade.domen.TransferKlasa;
import com.comtrade.domen.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrationFrame extends JFrame {

	private JPanel contentPane;
	private JPasswordField pfPassword;
	private JTextField tfUsername;
	private JPasswordField pfRepeatPassword;
	private JTextField tfFirstName;
	private JTextField tfLastName;
	private JTextField tfEmail;

	

	/**
	 * Create the frame.
	 */
	public RegistrationFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 409, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(44, 50, 109, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(44, 92, 109, 14);
		contentPane.add(lblPassword);
		
		pfPassword = new JPasswordField();
		pfPassword.setBounds(183, 92, 174, 20);
		contentPane.add(pfPassword);
		
		tfUsername = new JTextField();
		tfUsername.setBounds(183, 47, 174, 20);
		contentPane.add(tfUsername);
		tfUsername.setColumns(10);
		
		JLabel lblRepeatPass = new JLabel("Repeat password");
		lblRepeatPass.setBounds(44, 143, 109, 14);
		contentPane.add(lblRepeatPass);
		
		pfRepeatPassword = new JPasswordField();
		pfRepeatPassword.setBounds(183, 143, 174, 20);
		contentPane.add(pfRepeatPassword);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(44, 201, 94, 14);
		contentPane.add(lblFirstName);
		
		tfFirstName = new JTextField();
		tfFirstName.setBounds(183, 201, 174, 20);
		contentPane.add(tfFirstName);
		tfFirstName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(44, 240, 94, 14);
		contentPane.add(lblLastName);
		
		JLabel lblEmail = new JLabel("email");
		lblEmail.setBounds(44, 294, 94, 14);
		contentPane.add(lblEmail);
		
		tfLastName = new JTextField();
		tfLastName.setColumns(10);
		tfLastName.setBounds(183, 243, 174, 20);
		contentPane.add(tfLastName);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(183, 294, 174, 20);
		contentPane.add(tfEmail);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ime = tfFirstName.getText();
				String prezime = tfLastName.getText();
				String email = tfEmail.getText();
				String username = tfUsername.getText();
				String password = String.copyValueOf(pfPassword.getPassword());
				String repeatPassword = String.copyValueOf(pfRepeatPassword.getPassword());
				if (!password.equals(repeatPassword)) {
					JOptionPane.showMessageDialog(null, "Passwords don't match");
															
				} else {User user = new User(username, password, ime, prezime, email);
				TransferKlasa transferKlasa = new TransferKlasa().kreirajRequest(user, KontrolerFKKonstanta.USER, KontrolerPLKonstanta.POST_USER);
				KontrolerFK.getInstanca().execute(transferKlasa);
									
				
				JOptionPane.showMessageDialog(null, "Registration successful!");
				BookingFrame rezervacijaForma = new BookingFrame();
				rezervacijaForma.setVisible(true);
				} 
				
				
			}
		});
		btnSignUp.setBounds(117, 368, 144, 23);
		contentPane.add(btnSignUp);
	}
}
