package application.view;


import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import application.controller.ApplicationLogIn;
import application.utils.GridBagLayoutUtils;

public class LoginView extends JFrame {

	private static final long serialVersionUID = 8981053836072595592L;
	
	private JButton btnLogin;
	private JTextField txtLogin;
	private JPasswordField txtPass;
	private ApplicationLogIn controller;

	public LoginView(ApplicationLogIn controller) {
		this.controller = controller;
		initGUI();
	}
	
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Login");
		setLayout(new GridBagLayout());
		
		txtLogin = new JTextField(15);
		txtPass = new JPasswordField(15);
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.logIn(txtLogin.getText(), String.valueOf(txtPass.getPassword()));
			}
		});
		
		add(new JLabel("Username:"), GridBagLayoutUtils.constraint(0, 0, 5));
		add(txtLogin, GridBagLayoutUtils.constraint(1, 0, 5));
		add(new JLabel("Password:"), GridBagLayoutUtils.constraint(0, 1, 5));
		add(txtPass, GridBagLayoutUtils.constraint(1, 1, 5));
		add(btnLogin, GridBagLayoutUtils.constraint(1, 2, 5));
		
		pack();
		setLocationRelativeTo(null);
	}
	
	public void showError(String string) {
		JOptionPane.showMessageDialog(this, string , "Login error", JOptionPane.ERROR_MESSAGE);
	}
}
