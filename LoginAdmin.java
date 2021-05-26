package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import javax.swing.JButton;

public class LoginAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField textUserName;
	private JPasswordField passwordField;
	private UserSetting user;
	private final String UserName = "Admin";
	private final String PassWord = "hoanghai";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginAdmin frame = new LoginAdmin();
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
	public LoginAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(0, 0, 554, 326);
		contentPane.add(panel);
		panel.setLayout(null);

		textUserName = new JTextField();
		textUserName.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		textUserName.setBounds(196, 104, 192, 39);
		panel.add(textUserName);
		textUserName.setColumns(10);

		JLabel username = new JLabel("User Name");
		username.setForeground(Color.WHITE);
		username.setFont(new Font("Tahoma", Font.PLAIN, 18));
		username.setBackground(new Color(240, 240, 240));
		username.setHorizontalAlignment(SwingConstants.CENTER);
		username.setBounds(87, 104, 100, 40);
		panel.add(username);

		JLabel AdminLogin = new JLabel("Admin Login");
		AdminLogin.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 35));
		AdminLogin.setHorizontalAlignment(SwingConstants.CENTER);
		AdminLogin.setBounds(141, 37, 291, 47);
		panel.add(AdminLogin);

		JLabel password = new JLabel("Password");
		password.setForeground(Color.WHITE);
		password.setFont(new Font("Tahoma", Font.PLAIN, 18));
		password.setHorizontalAlignment(SwingConstants.CENTER);
		password.setBounds(87, 168, 100, 40);
		panel.add(password);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		passwordField.setBounds(196, 168, 192, 40);
		panel.add(passwordField);

		JButton login = new JButton("Login");
		login.setForeground(Color.BLACK);
		login.setFont(new Font("Tahoma", Font.BOLD, 12));
		login.setBounds(196, 218, 80, 33);
		panel.add(login);
		login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (textUserName.getText().equals("Admin") && passwordField.getText().equals("hoanghai")) {

					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								user = new UserSetting();
								user.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});

				} else {
					JOptionPane.showMessageDialog(contentPane, "We can't login you in");
				}
			}
		});

		JButton resert = new JButton("Resert");
		resert.setFont(new Font("Tahoma", Font.BOLD, 12));
		resert.setForeground(Color.BLACK);
		resert.setBounds(311, 218, 80, 33);
		resert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textUserName.setText(null);
				passwordField.setText(null);
			}
		});
		panel.add(resert);
		setLocationRelativeTo(null);

	}
}
