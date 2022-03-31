package eb3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class dbJtable extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnIrten;
	private JLabel lblIk;
	private Vector<String> zutabeak;
	private Vector<Vector<String>> datuakTabla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dbJtable frame = new dbJtable();
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
	public dbJtable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblIk = new JLabel("Ikasleen datuak");
		lblIk.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblIk.setForeground(new Color(0, 0, 0));
		lblIk.setHorizontalAlignment(SwingConstants.CENTER);
		lblIk.setBounds(10, 10, 583, 45);
		contentPane.add(lblIk);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 56, 583, 277);
		contentPane.add(scrollPane);
		
		btnIrten = new JButton("Irten");
		btnIrten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnIrten.setBounds(10, 343, 85, 21);
		contentPane.add(btnIrten);
		
		zutabeak = new Vector<String>();
		zutabeak.add("NAN");
		zutabeak.add("Izena");
		zutabeak.add("Abizena");
		zutabeak.add("Taldea");
		
		try {
			Class.forName("com.sql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/dbikasleak", "root", "");
			
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM ikasleak");
			
			datuakTabla = new Vector<Vector<String>>();
			
			while (rs.next()) {
				Vector<String> lerroa = new Vector<String>();
				
				lerroa.add(rs.getString(1));
				lerroa.add(rs.getString(2));
				lerroa.add(rs.getString(3));
				lerroa.add(rs.getString(4));
				
				datuakTabla.add(lerroa);
			}
			
			DefaultTableModel modelo = new DefaultTableModel(datuakTabla, zutabeak);
			table = new JTable(modelo);
			table.setPreferredScrollableViewportSize(new Dimension(500, 200));
			table.setFillsViewportHeight(true);
			
			modelo.addRow(datuakTabla);
			
			scrollPane = new JScrollPane(table);
			
		} catch(SQLException | ClassNotFoundException e) {
			//JOptionPane.showMessageDialog(null, (String) "Konexio Errorea", "Errorea", JOptionPane.ERROR_MESSAGE, null);
		}
		
		
	}
}
