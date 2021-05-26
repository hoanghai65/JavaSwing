package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class BookUser extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textid;
	private JTextField textname;
	private JTextField textauthor;
	private JTextField textquantity;
	private JTextField txtBookShopSoftware;
	private JTextField textprice;
	private JLabel lblNewLabel;
	private JLabel lblName;
	private JLabel lblAuthor;
	private JLabel lblCate;
	private JLabel lblQuantity;
	private JLabel lblPrice;
	private JButton btnsave;
	private JButton btnEdit;
	private JButton btnDelete;
	private JButton btnResert;
	private JTable table;
	private JLabel lblNewLabel_1;

	private JLabel lblNewLabel_2;
	private JButton btnUser;
	private JButton btnBook;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;

	private String url = "jdbc:mysql://localhost:3306/book";
	private String UserName = "root";
	private String password = "060501";
	private Connection connect;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookUser frame = new BookUser();
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
	public BookUser() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 871, 703);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(10, 0, 857, 666);
		contentPane.add(panel);
		panel.setLayout(null);
		setLocationRelativeTo(null);

		textid = new JTextField();
		textid.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		textid.setBounds(10, 153, 137, 27);
		panel.add(textid);
		textid.setColumns(10);

		textname = new JTextField();
		textname.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		textname.setBounds(157, 153, 155, 27);
		panel.add(textname);
		textname.setColumns(10);

		textauthor = new JTextField();
		textauthor.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		textauthor.setBounds(322, 153, 140, 27);
		panel.add(textauthor);
		textauthor.setColumns(10);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Programming", "Math", "History", "Chemistry" }));
		comboBox.setBounds(472, 152, 120, 28);
		panel.add(comboBox);

		textquantity = new JTextField();
		textquantity.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		textquantity.setBounds(602, 153, 122, 27);
		panel.add(textquantity);
		textquantity.setColumns(10);

		txtBookShopSoftware = new JTextField();
		txtBookShopSoftware.setEditable(false);
		txtBookShopSoftware.setBackground(new Color(255, 165, 0));
		txtBookShopSoftware.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 25));
		txtBookShopSoftware.setText("Book Shop Software");
		txtBookShopSoftware.setHorizontalAlignment(SwingConstants.CENTER);
		txtBookShopSoftware.setIgnoreRepaint(true);
		txtBookShopSoftware.setInheritsPopupMenu(true);
		txtBookShopSoftware.setBounds(0, 0, 857, 40);
		panel.add(txtBookShopSoftware);
		txtBookShopSoftware.setColumns(10);

		textprice = new JTextField();
		textprice.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		textprice.setBounds(734, 153, 113, 27);
		panel.add(textprice);
		textprice.setColumns(10);

		lblNewLabel = new JLabel("Id");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(255, 140, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(22, 125, 69, 27);
		panel.add(lblNewLabel);

		lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setForeground(new Color(255, 140, 0));
		lblName.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		lblName.setBounds(157, 125, 69, 27);
		panel.add(lblName);

		lblAuthor = new JLabel("Author");
		lblAuthor.setHorizontalAlignment(SwingConstants.LEFT);
		lblAuthor.setForeground(new Color(255, 140, 0));
		lblAuthor.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		lblAuthor.setBounds(322, 125, 69, 27);
		panel.add(lblAuthor);

		lblCate = new JLabel("Categorle");
		lblCate.setHorizontalAlignment(SwingConstants.LEFT);
		lblCate.setForeground(new Color(255, 140, 0));
		lblCate.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		lblCate.setBounds(471, 125, 96, 27);
		panel.add(lblCate);

		lblQuantity = new JLabel("Quantity");
		lblQuantity.setHorizontalAlignment(SwingConstants.LEFT);
		lblQuantity.setForeground(new Color(255, 140, 0));
		lblQuantity.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		lblQuantity.setBounds(602, 125, 96, 27);
		panel.add(lblQuantity);

		lblPrice = new JLabel("Price");
		lblPrice.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrice.setForeground(new Color(255, 140, 0));
		lblPrice.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		lblPrice.setBounds(734, 125, 69, 27);
		panel.add(lblPrice);

		btnResert = new JButton("Resert");
		btnResert.setForeground(new Color(255, 140, 0));
		btnResert.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		btnResert.setBounds(602, 215, 102, 35);

		btnResert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textid.setText(null);
				textname.setText(null);
				textauthor.setText(null);
				comboBox.setSelectedIndex(0);
				textquantity.setText(null);
				textprice.setText(null);

			}
		});
		panel.add(btnResert);

		DefaultTableModel model = new DefaultTableModel();
		table = new JTable(model);
		table.setBorder(null);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		model.addColumn("id");
		model.addColumn("Name");
		model.addColumn("author");
		model.addColumn("categorle");
		model.addColumn("quantity");
		model.addColumn("price");

		model.addRow(new Object[] { "ID", "NAME", "AUTHOR", "CATEGORLE", "QUANTITY", "PRICE" });
		connect = DriverManager.getConnection(url, UserName, password);
		Statement st = connect.createStatement();
		String query = "Select * from book";
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			model.addRow(new Object[] { rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6) });
		}

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if (e.getValueIsAdjusting()) {
					textid.setText(model.getValueAt(table.getSelectedRow(), 0).toString());
					textname.setText(model.getValueAt(table.getSelectedRow(), 1).toString());
					textauthor.setText(model.getValueAt(table.getSelectedRow(), 2).toString());
					comboBox.getModel().setSelectedItem(model.getValueAt(table.getSelectedRow(), 3));
					textquantity.setText(model.getValueAt(table.getSelectedRow(), 4).toString());
					textprice.setText(model.getValueAt(table.getSelectedRow(), 5).toString());

				}

			}
		});
		table.getColumnModel().getColumn(0).setMinWidth(30);
		table.getColumnModel().getColumn(1).setMinWidth(30);
		table.getColumnModel().getColumn(2).setMinWidth(30);
		table.getColumnModel().getColumn(3).setMinWidth(30);
		table.getColumnModel().getColumn(4).setMinWidth(30);
		table.getColumnModel().getColumn(5).setMinWidth(30);
		table.setBounds(10, 304, 837, 336);
		panel.add(table);

		lblNewLabel_1 = new JLabel("BookList");
		lblNewLabel_1.setForeground(new Color(255, 140, 0));
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(395, 254, 120, 40);
		panel.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\ASUS\\Pictures\\Saved Pictures\\book.PNG"));
		lblNewLabel_2.setBounds(501, 61, 31, 35);
		panel.add(lblNewLabel_2);

		btnUser = new JButton("User");
		btnUser.setForeground(new Color(255, 140, 0));
		btnUser.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		btnUser.setContentAreaFilled(false);
		btnUser.setBorderPainted(false);
		btnUser.setBounds(328, 61, 78, 35);
		btnUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
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
		});
		panel.add(btnUser);

		btnBook = new JButton("Book");
		btnBook.setBorderPainted(false);
		btnBook.setForeground(new Color(255, 140, 0));
		btnBook.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		btnBook.setContentAreaFilled(false);
		btnBook.setBounds(516, 61, 102, 35);
		panel.add(btnBook);

		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\ASUS\\Pictures\\Saved Pictures\\danh ba.PNG"));
		lblNewLabel_3.setBounds(298, 62, 31, 34);
		panel.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setOpaque(true);
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setBackground(Color.RED);
		lblNewLabel_4.setBounds(542, 92, 50, 4);
		panel.add(lblNewLabel_4);

		btnsave = new JButton("Save");
		btnsave.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		btnsave.setForeground(new Color(255, 140, 0));
		btnsave.setBounds(231, 215, 96, 35);
		btnsave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (textid.getText() != null && textname.getText() != null && textauthor.getText() != null
						&& textquantity.getText() != null && textprice.getText() != null) {
					String id = textid.getText();
					String name = textname.getText();
					String author = textauthor.getText();
					String categorle = comboBox.getSelectedItem().toString();
					String quantity = textquantity.getText();
					String price = textprice.getText();
					model.addRow(new Object[] { id, name, author, categorle, quantity, price});
				
					String query = "insert into book (id, name,author,categorle,quantity,price) "
							+ "values  ("+id+",'"+name+"','"+author+"','"+categorle+"',"+quantity+","+price+")";
					try {
						PreparedStatement ps = connect.prepareStatement(query);
						ps.execute();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(contentPane, "Error");
					}
				}

			}
		});
		panel.add(btnsave);
		
		btnDelete = new JButton("Delete");
		btnDelete.setForeground(new Color(255, 140, 0));
		btnDelete.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		btnDelete.setBounds(478, 215, 102, 35);
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String idold = model.getValueAt(table.getSelectedRowCount(), 0).toString();
				String query = "delete from book where id = "+ idold;
				try {
					model.removeRow(table.getSelectedRow());
					PreparedStatement ps = connect.prepareStatement(query);
					ps.execute();
					
					textid.setText(null);
					textname.setText(null);
					textauthor.setText(null);
					comboBox.setSelectedItem(0);
					textquantity.setText(null);
					textprice.setText(null);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(contentPane, "Error");
				}
				
			}
		});
		panel.add(btnDelete);
		
		btnEdit = new JButton("Edit");
		btnEdit.setForeground(new Color(255, 140, 0));
		btnEdit.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		btnEdit.setBounds(351, 215, 102, 35);
		
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (textid.getText() != null && textname.getText() != null && textauthor.getText() != null
						&& textquantity.getText() != null && textprice.getText() != null) {
					
					String idold = model.getValueAt(table.getSelectedRow(), 0).toString();
					String id = textid.getText();
					String name = textname.getText();
					String author = textauthor.getText();
					String categorle = comboBox.getSelectedItem().toString();
					String quantity = textquantity.getText();
					String price = textprice.getText();
					
					String query = "update book set id = "+id+ ",name = '"+name +"',author = '"+author+"',categorle = '"+
					categorle+"',quantity = "+quantity+",price = "+price+" where id = "+ idold; ;
					try {
						PreparedStatement ps  = connect.prepareStatement(query);
						ps.execute();
						
						int i = table.getSelectedRow();
						if(i > 0) {
							model.setValueAt(id, i, 0);
							model.setValueAt(name, i, 1);
							model.setValueAt(author, i, 2);
							model.setValueAt(categorle, i, 3);
							model.setValueAt(quantity, i, 4);
							model.setValueAt(price, i, 5);
						}
					}
					catch (Exception e1) {
						JOptionPane.showMessageDialog(contentPane, "Error");
					}
				}
				
			}
		});
		panel.add(btnEdit);
	}
}
