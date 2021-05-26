package project;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginUser extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUserName;
	private JPasswordField passwordField;
	private Book book;

	/**
	 * Launch the application.
	 */

	class UserList {
		private String url = "jdbc:mysql://localhost:3306/user";
		private String UserName = "root";
		private String password = "060501";
		private Connection connect = null;

		public UserList() {
			try {
				connect = DriverManager.getConnection(url, UserName, password);

			} catch (Exception e) {
				System.out.println("connection failed !");
			}
		}

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUser frame = new LoginUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @return
	 */
	public LoginUser() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(0, 0, 554, 294);
		contentPane.add(panel);
		panel.setLayout(null);

		textUserName = new JTextField();
		textUserName.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		textUserName.setBounds(203, 106, 192, 39);
		panel.add(textUserName);
		textUserName.setColumns(10);

		JLabel username = new JLabel("User Name");
		username.setForeground(Color.WHITE);
		username.setFont(new Font("Tahoma", Font.PLAIN, 18));
		username.setBackground(new Color(240, 240, 240));
		username.setHorizontalAlignment(SwingConstants.CENTER);
		username.setBounds(94, 106, 100, 40);
		panel.add(username);

		JLabel UserLogin = new JLabel("User Login");
		UserLogin.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 35));
		UserLogin.setHorizontalAlignment(SwingConstants.CENTER);
		UserLogin.setBounds(148, 39, 291, 47);
		panel.add(UserLogin);

		JLabel password = new JLabel("Password");
		password.setForeground(Color.WHITE);
		password.setFont(new Font("Tahoma", Font.PLAIN, 18));
		password.setHorizontalAlignment(SwingConstants.CENTER);
		password.setBounds(94, 170, 100, 40);
		panel.add(password);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		passwordField.setBounds(203, 170, 192, 40);
		panel.add(passwordField);

		JButton login = new JButton("Login");
		login.setForeground(Color.BLACK);
		login.setFont(new Font("Tahoma", Font.BOLD, 12));
		login.setBounds(203, 220, 80, 33);
		UserList userlist = new UserList();
		login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String enterusername = textUserName.getText();
				String enterpassword = passwordField.getText();
				try {
					boolean check = false;
					Statement st = userlist.connect.createStatement();
					String query = "Select * from user";
					ResultSet rs = st.executeQuery(query);
					while (rs.next()) {
						if (enterusername.equals(rs.getString(2)) && enterpassword.equals(rs.getString(3))) {
							check = true;
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										book = new Book();
										book.setVisible(true);
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							});
							break;
						}
						
					}
					if(!check) {
						JOptionPane.showMessageDialog(contentPane, "We can't login you in");
					}
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(contentPane, "We can't login you in");
				}

			}
		});
		panel.add(login);

		JButton resert = new JButton("Resert");
		resert.setFont(new Font("Tahoma", Font.BOLD, 12));
		resert.setForeground(Color.BLACK);
		resert.setBounds(318, 220, 80, 33);
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
