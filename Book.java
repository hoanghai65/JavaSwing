package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Book extends JFrame {

	private JPanel contentPane;
	private JTextField txtBookShopSoftware;
	private JTextField textid;
	private JTextField textName;
	private JTextField textAuthor;
	private JTextField textPrice;
	private JTable table;
	private JTable table_1;
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
					Book frame = new Book();
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
	public Book() throws SQLException {
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

		txtBookShopSoftware = new JTextField();
		txtBookShopSoftware.setEditable(false);
		txtBookShopSoftware.setBounds(0, 0, 857, 40);
		txtBookShopSoftware.setBackground(new Color(255, 165, 0));
		txtBookShopSoftware.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 25));
		txtBookShopSoftware.setText("Book Shop Software");
		txtBookShopSoftware.setHorizontalAlignment(SwingConstants.CENTER);
		txtBookShopSoftware.setIgnoreRepaint(true);
		txtBookShopSoftware.setInheritsPopupMenu(true);
		panel.add(txtBookShopSoftware);
		txtBookShopSoftware.setColumns(10);

		JLabel IdLabel = new JLabel("Id");
		IdLabel.setBounds(22, 90, 55, 22);
		IdLabel.setForeground(new Color(255, 140, 0));
		IdLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		IdLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(IdLabel);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(22, 141, 55, 22);
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setForeground(new Color(255, 140, 0));
		lblName.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		panel.add(lblName);

		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setBounds(22, 194, 70, 22);
		lblAuthor.setHorizontalAlignment(SwingConstants.LEFT);
		lblAuthor.setForeground(new Color(255, 140, 0));
		lblAuthor.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		panel.add(lblAuthor);

		JLabel lblCategorle = new JLabel("Categorle");
		lblCategorle.setBounds(22, 240, 88, 33);
		lblCategorle.setHorizontalAlignment(SwingConstants.LEFT);
		lblCategorle.setForeground(new Color(255, 140, 0));
		lblCategorle.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		panel.add(lblCategorle);

		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(22, 288, 88, 33);
		lblPrice.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrice.setForeground(new Color(255, 140, 0));
		lblPrice.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		panel.add(lblPrice);

		textid = new JTextField();
		textid.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		textid.setBounds(120, 90, 158, 33);
		textid.setColumns(10);
		panel.add(textid);

		textName = new JTextField();
		textName.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		textName.setBounds(120, 141, 158, 33);
		textName.setColumns(10);
		panel.add(textName);

		textAuthor = new JTextField();
		textAuthor.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		textAuthor.setBounds(120, 194, 158, 33);
		textAuthor.setColumns(10);
		panel.add(textAuthor);

		textPrice = new JTextField();
		textPrice.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		textPrice.setBounds(120, 290, 158, 33);
		textPrice.setColumns(10);
		panel.add(textPrice);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(120, 240, 158, 32);
		comboBox.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Programming", "Math", "History", "Chemistry" }));
		panel.add(comboBox);

		DefaultTableModel model = new DefaultTableModel();
		table = new JTable(model);
		table.setBorder(null);
		table.setBounds(314, 99, 543, 304);
		table.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		model.addColumn("id");
		model.addColumn("Name");
		model.addColumn("author");
		model.addColumn("categorle");
		model.addColumn("quantity");
		model.addColumn("price");

		model.addRow(new Object[] { "ID", "NAME", "AUTHOR", "CATEGORLE", "QUANTITY", "PRICE" });
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if(e.getValueIsAdjusting()) {
					textid.setText(model.getValueAt(table.getSelectedRow(), 0).toString());
					textName.setText(model.getValueAt(table.getSelectedRow(), 1).toString());
					textAuthor.setText(model.getValueAt(table.getSelectedRow(), 2).toString());
					comboBox.setSelectedItem(model.getValueAt(table.getSelectedRow(), 3).toString());
					textPrice.setText(model.getValueAt(table.getSelectedRow(), 5).toString());
				}
			}
		});
		panel.add(table);

		JButton buttom_find = new JButton("");
		buttom_find.setForeground(new Color(0, 191, 255));
		buttom_find.setBackground(new Color(0, 191, 255));
		buttom_find.setIcon(new ImageIcon("C:\\Users\\ASUS\\Pictures\\Saved Pictures\\Capture.PNG"));
		buttom_find.setBounds(270, 50, 35, 30);
		buttom_find.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
				connect = DriverManager.getConnection(url, UserName, password);
				Statement st = connect.createStatement();
				String query = "Select * from book";
				ResultSet rs = st.executeQuery(query);
				for(int i = model.getRowCount() - 1; i > 0; i-- ) {
					model.removeRow(i);
				}
				while (rs.next()) {
					String id = rs.getString(1);
					String Name = rs.getString(2);
					String author = rs.getString(3);
					String categorle = rs.getString(4);
					String quantity = rs.getString(5);
					String price = rs.getString(6);
					
					if(id.equals(textid.getText()) || Name.equals(textName.getText())
					|| author.equals(textAuthor.getText())
					|| price.equals(textPrice.getText())) {
						model.addRow(new Object[] {id,Name,author,categorle,quantity,price});
					}
					
				}
				}
				catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(contentPane, "Can't Find Book");
				}
			}
		});
		panel.add(buttom_find);

		JButton btnResert = new JButton("Resert");
		btnResert.setForeground(new Color(255, 140, 0));
		btnResert.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		btnResert.setBounds(10, 354, 102, 35);
		btnResert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textid.setText(null);
				textName.setText(null);
				textAuthor.setText(null);
				comboBox.setSelectedIndex(0);
				textPrice.setText(null);
				
			}
		});
		panel.add(btnResert);
		
		DefaultTableModel model1 = new DefaultTableModel();
		table_1 = new JTable(model1);
		table_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		table_1.setBorder(null);
		model1.addColumn("id");
		model1.addColumn("Name");
		model1.addColumn("author");
		model1.addColumn("categorle");
		model1.addColumn("quantity");
		model1.addColumn("price");

		model1.addRow(new Object[] { "ID", "NAME", "AUTHOR", "CATEGORLE", "QUANTITY", "PRICE" });
		
		table_1.setBounds(22, 481, 548, 160);
		panel.add(table_1);

		JLabel lblNewLabel_1 = new JLabel("Book List");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 140, 0));
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(503, 46, 141, 40);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Buy List");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(new Color(255, 140, 0));
		lblNewLabel_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 30));
		lblNewLabel_1_1.setBounds(205, 431, 120, 40);
		panel.add(lblNewLabel_1_1);

		JButton btnBuy = new JButton("Buy");
		btnBuy.setForeground(new Color(255, 140, 0));
		btnBuy.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		btnBuy.setBounds(231, 354, 73, 35);
		btnBuy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int i = table.getSelectedRow();
				if(i > 0 ) {
					String id = model.getValueAt(i, 0).toString();
					String name = model.getValueAt(i, 1).toString();
					String author = model.getValueAt(i, 2).toString();
					String categorle = model.getValueAt(i, 3).toString();
					String quantity = model.getValueAt(i, 4).toString();
					String price = model.getValueAt(i, 5).toString();
					model1.addRow(new Object[] {id,name,author,categorle,quantity,price});
				}
				
			}
		});
		panel.add(btnBuy);

		JButton btnTotal = new JButton("Total");
		btnTotal.setForeground(new Color(255, 140, 0));
		btnTotal.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		btnTotal.setBounds(562, 415, 95, 40);
		btnTotal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for( int i = model.getRowCount() - 1; i > 0; i-- )
				{
				    model.removeRow(i);
				}
				try {
					connect = DriverManager.getConnection(url, UserName, password);
					Statement st = connect.createStatement();
					String query = "Select * from book";
					ResultSet rs = st.executeQuery(query);
					while (rs.next()) {
						model.addRow(new Object[] { rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
								rs.getString(5), rs.getString(6) });
					}
					
				} catch (Exception e1) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(contentPane, "The list is empty");
				}
			}
		});
		panel.add(btnTotal);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setForeground(new Color(255, 140, 0));
		btnDelete.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		btnDelete.setBounds(120, 354, 102, 35);
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = table_1.getSelectedRow();
				if( i > 0) {
					model1.removeRow(i);
				}
				
			}
		});
		panel.add(btnDelete);

	}
}
