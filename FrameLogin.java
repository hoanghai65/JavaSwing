package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

import project.FrameLogin.frameThread;

import java.awt.Panel;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class FrameLogin extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private LoginAdmin admin;
	private LoginUser user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameLogin frame = new FrameLogin();
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
	 * @throws InterruptedException
	 */

	public class frameThread extends Thread {
		JProgressBar prb;

		public frameThread(JProgressBar proccer) {
			prb = proccer;
		}

		public void run() {
			int i = 0;
			while (i <= 100) {
				prb.setValue(i);
				try {
					sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				i += 20;
			}
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Login frame = new Login();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	}

	public FrameLogin() throws InterruptedException {
		setUndecorated(true);
		setForeground(new Color(0, 191, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 315);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(248, 248, 255));
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ASUS\\Pictures\\Saved Pictures\\bookstore.jpg"));
		lblNewLabel.setBounds(207, 101, 86, 64);
		contentPane.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("BOOK STORE");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(189, 50, 116, 29);
		contentPane.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Loading");
		lblNewLabel_2.setForeground(Color.DARK_GRAY);
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 193, 70, 29);
		contentPane.add(lblNewLabel_2);

		JProgressBar progressBar = new JProgressBar(0, 100);
		progressBar.setBounds(10, 232, 523, 20);
		progressBar.setValue(0);
		progressBar.setStringPainted(true);
		progressBar.setVisible(true);
		contentPane.add(progressBar);
		frameThread ft = new frameThread(progressBar);
		ft.start();
		setLocationRelativeTo(null);

	}
}
