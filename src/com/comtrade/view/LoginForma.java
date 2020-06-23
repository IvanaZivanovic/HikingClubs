package com.comtrade.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.comtrade.controlerFK.KontrolerFK;
import com.comtrade.domen.KontrolerFKKonstanta;
import com.comtrade.domen.KontrolerPLKonstanta;
import com.comtrade.domen.TransferKlasa;
import com.comtrade.domen.User;
import com.comtrade.proxy.Proxy;
import com.comtrade.proxy.ProxyLogin;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginForma extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsername;
	private JPasswordField pfPassword;
	private JButton btnSignUp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForma frame = new LoginForma();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginForma() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(79, 57, 95, 14);
		contentPane.add(lblUsername);
		
		tfUsername = new JTextField();
		tfUsername.setBounds(213, 57, 133, 20);
		contentPane.add(tfUsername);
		tfUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(79, 117, 79, 14);
		contentPane.add(lblPassword);
		
		pfPassword = new JPasswordField();
		pfPassword.setBounds(213, 114, 133, 20);
		contentPane.add(pfPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = tfUsername.getText();
				String password = String.copyValueOf(pfPassword.getPassword());
				User user = new User(username, password);
				TransferKlasa transferKlasa = new TransferKlasa();
				transferKlasa.setRequest(user);
				transferKlasa.setKontrolerFK(KontrolerFKKonstanta.USER);
				transferKlasa.setKontrolerPL(KontrolerPLKonstanta.POST);
				KontrolerFK.getInstanca().execute(transferKlasa);
				Integer status = (Integer) transferKlasa.getResponse();
				Proxy proxy = new ProxyLogin();
				proxy.login(status);
			}
		});
		btnLogin.setBounds(234, 178, 89, 23);
		contentPane.add(btnLogin);
		
		btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistracijaForma registracijaForma = new RegistracijaForma();
				registracijaForma.setVisible(true);
			}
		});
		btnSignUp.setBounds(79, 178, 89, 23);
		contentPane.add(btnSignUp);
	}
}
