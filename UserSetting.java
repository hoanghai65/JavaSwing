package project;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserSetting extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textid;
	private JTextField textusername;
	private JTextField textpassword;
	private JTextField txtBookShopSoftware;
	private JLabel lblNewLabel;
	private JLabel lblName;
	private JLabel lblAuthor;
	private JButton btnsave;
	private JButton btnEdit;
	private JButton btnDelete;
	private JButton btnResert;
	private JTable table;
	private JLabel lblNewLabel_1;
	private JButton btnBook;
	private JButton btnUser;
	private JPanel contentPane;
	private BookUser bookuser = new BookUser();
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private Statement st;
	private String query;
	private ResultSet rs;

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
					UserSetting frame = new UserSetting();
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
	 * @throws SQLException
	 */
	public UserSetting() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 871, 703);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(0, 0, 857, 693);
		contentPane.add(panel);
		panel.setLayout(null);
		setLocationRelativeTo(null);

		textid = new JTextField();
		textid.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		textid.setBounds(154, 130, 155, 27);
		panel.add(textid);
		textid.setColumns(10);

		textusername = new JTextField();
		textusername.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		textusername.setBounds(154, 179, 155, 27);
		panel.add(textusername);
		textusername.setColumns(10);

		textpassword = new JTextField();
		textpassword.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		textpassword.setBounds(154, 228, 155, 27);
		panel.add(textpassword);
		textpassword.setColumns(10);

		txtBookShopSoftware = new JTextField();
		txtBookShopSoftware.setBackground(new Color(255, 165, 0));
		txtBookShopSoftware.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 25));
		txtBookShopSoftware.setText("Book Shop Software");
		txtBookShopSoftware.setHorizontalAlignment(SwingConstants.CENTER);
		txtBookShopSoftware.setIgnoreRepaint(true);
		txtBookShopSoftware.setInheritsPopupMenu(true);
		txtBookShopSoftware.setBounds(0, 0, 857, 40);
		panel.add(txtBookShopSoftware);
		txtBookShopSoftware.setColumns(10);

		lblNewLabel = new JLabel("Id");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(255, 140, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(10, 125, 69, 27);
		panel.add(lblNewLabel);

		lblName = new JLabel("User Name");
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setForeground(new Color(255, 140, 0));
		lblName.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		lblName.setBounds(10, 179, 137, 27);
		panel.add(lblName);

		lblAuthor = new JLabel("Password");
		lblAuthor.setHorizontalAlignment(SwingConstants.LEFT);
		lblAuthor.setForeground(new Color(255, 140, 0));
		lblAuthor.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		lblAuthor.setBounds(10, 223, 120, 27);
		panel.add(lblAuthor);

		btnResert = new JButton("Resert");
		btnResert.setForeground(new Color(255, 140, 0));
		btnResert.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		btnResert.setBounds(709, 243, 102, 35);
		btnResert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textid.setText(null);
				textusername.setText(null);
				textpassword.setText(null);

			}
		});
		panel.add(btnResert);

		DefaultTableModel model = new DefaultTableModel();
		table = new JTable(model);
		table.setBorder(null);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		model.addColumn("Id");
		model.addColumn("UserName");
		model.addColumn("password");

		model.addRow(new Object[] { "ID", "USER_NAME", "PASSWORD" });
		UserList userlist = new UserList();
		st = userlist.connect.createStatement();
		query = "Select * from user";
		rs = st.executeQuery(query);
		while (rs.next()) {
			model.addRow(new Object[] { rs.getInt(1), rs.getString(2), rs.getString(3) });
		}
		table.getColumnModel().getColumn(0).setMinWidth(30);
		table.getColumnModel().getColumn(1).setMinWidth(30);
		table.getColumnModel().getColumn(2).setMinWidth(30);
		table.setBounds(10, 304, 837, 336);

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				// do some actions here, for example
				// print first column value from selected row
				if (event.getValueIsAdjusting()) {
					textid.setText(model.getValueAt(table.getSelectedRow(), 0).toString());
					textusername.setText(model.getValueAt(table.getSelectedRow(), 1).toString());
					textpassword.setText(model.getValueAt(table.getSelectedRow(), 2).toString());
				}
			}
		});
		panel.add(table);

		lblNewLabel_1 = new JLabel("UserList");
		lblNewLabel_1.setForeground(new Color(255, 140, 0));
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(415, 236, 120, 40);
		panel.add(lblNewLabel_1);

		btnBook = new JButton("Book");
		btnBook.setBorderPainted(false);
		btnBook.setContentAreaFilled(false);
		btnBook.setForeground(new Color(255, 140, 0));
		btnBook.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		btnBook.setBounds(516, 65, 90, 35);
		panel.add(btnBook);
		btnBook.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							bookuser = new BookUser();
							bookuser.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});

			}
		});

		btnUser = new JButton("User");
		btnUser.setContentAreaFilled(false);
		btnUser.setBorderPainted(false);
		btnUser.setForeground(new Color(255, 140, 0));
		btnUser.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		btnUser.setBounds(321, 65, 78, 35);
		panel.add(btnUser);

		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\ASUS\\Pictures\\Saved Pictures\\book.PNG"));
		lblNewLabel_2.setBounds(486, 65, 31, 35);
		panel.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\ASUS\\Pictures\\Saved Pictures\\danh ba.PNG"));
		lblNewLabel_3.setBounds(291, 66, 31, 34);
		panel.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setOpaque(true);
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setBackground(Color.RED);
		lblNewLabel_4.setBounds(338, 96, 50, 4);
		panel.add(lblNewLabel_4);

		btnsave = new JButton("Save");
		btnsave.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		btnsave.setForeground(new Color(255, 140, 0));
		btnsave.setBounds(709, 104, 102, 35);
		btnsave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if (textid.getText() != null && textusername.getText() != null && textpassword.getText() != null) {
					model.addRow(new Object[] { textid.getText(), textusername.getText(), textpassword.getText() });

					String query = "insert into user (id,username,password) " + "values (" + textid.getText() + ","
							+ "'" + textusername.getText() + "'," + "'" + textpassword.getText() + "')";
					;
					try {
						PreparedStatement ps = userlist.connect.prepareStatement(query);
						ps.execute();
						ps.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(contentPane, "Error!");
					}
				}

			}
		});
		panel.add(btnsave);

		btnEdit = new JButton("Edit");
		btnEdit.setForeground(new Color(255, 140, 0));
		btnEdit.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		btnEdit.setBounds(709, 153, 102, 35);
		btnEdit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// TODO Auto-generated method stub
				if (textid.getText() != null && textusername.getText() != null && textpassword.getText() != null) {
					String idold = model.getValueAt(table.getSelectedRow(), 0).toString();

					String query = "update user set id = '" + textid.getText() + "',username = '"
							+ textusername.getText() + "',password = '" + textpassword.getText() + "'" + " where "
							+ "id = '" + idold + "'";
					try {
						PreparedStatement ps = userlist.connect.prepareStatement(query);
						ps.executeUpdate();
						
						int i = table.getSelectedRow();
						if(i > 0) {
							model.setValueAt(textid.getText(), i, 0);
							model.setValueAt(textusername.getText(), i, 1);
							model.setValueAt(textpassword.getText(), i, 2);
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(contentPane, "Error!");
					}
					
				}
			}
		});
		panel.add(btnEdit);

		btnDelete = new JButton("Delete");
		btnDelete.setForeground(new Color(255, 140, 0));
		btnDelete.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		btnDelete.setBounds(709, 198, 102, 35);
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				int row = table.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) table.getModel();

				int selected = Integer.parseInt(model.getValueAt(row, 0).toString());

				if (row >= 0) {
					textid.setText(null);
					textusername.setText(null);
					textpassword.setText(null);
					model.removeRow(row);

					try {

						PreparedStatement ps = userlist.connect
								.prepareStatement("delete from user where id =" + selected);
						ps.execute();
					} catch (Exception w) {
						JOptionPane.showMessageDialog(contentPane, "Error!");
					}
				}

			}
		});
		panel.add(btnDelete);
	}

}
