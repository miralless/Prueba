package eb3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaDB extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private Statement st;
	private ResultSet rs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaDB frame = new PantallaDB();
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
	public PantallaDB() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conexion = 
					DriverManager.getConnection("jdbc:mysql://localhost/dbikasleak", "root", "");
			
			st = conexion.createStatement();
			rs = st.executeQuery("");
			
			st.executeUpdate("SELECT * FROM ikasleak");
			
			st.close();
			rs.close();
			conexion.close();
			
			//System.out.println("Konexio egokia");
			
		} catch(SQLException | ClassNotFoundException sql) {
			//JOptionPane.showMessageDialog(null, (String) "Konexio Errorea", "Errorea", JOptionPane.ERROR_MESSAGE, null);
		}
		
		JLabel lblNewLabel = new JLabel("DNI");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 83, 108, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNombre.setBounds(10, 120, 108, 34);
		contentPane.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblApellidos.setBounds(10, 158, 108, 34);
		contentPane.add(lblApellidos);
		
		JLabel lblGrupo = new JLabel("Grupo");
		lblGrupo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGrupo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGrupo.setBounds(10, 195, 108, 34);
		contentPane.add(lblGrupo);
		
		textField = new JTextField();
		textField.setBounds(128, 90, 597, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(128, 127, 597, 25);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(128, 165, 597, 25);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(128, 205, 597, 25);
		contentPane.add(textField_3);
		
		JButton btnNewButton = new JButton("Insertar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection conexion = 
							DriverManager.getConnection("jdbc:mysql://localhost/dbikasleak", "root", "");
					
					st = conexion.createStatement();
					rs = st.executeQuery("");
					
					if (textField.getText() != null && textField_1.getText() != null && textField_2.getText() != null && textField_3.getText() != null) {
						st.executeUpdate("INSERT INTO ikasleak VALUES ('...', 'N10', 'A10', 'PLTO')");
					}
					
				} catch(SQLException | ClassNotFoundException sql) {
					JOptionPane.showMessageDialog(null, (String) "Konexio Errorea", "Errorea", JOptionPane.ERROR_MESSAGE, null);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(184, 267, 108, 34);
		contentPane.add(btnNewButton);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection conexion = 
							DriverManager.getConnection("jdbc:mysql://localhost/dbikasleak", "root", "");
					
					st = conexion.createStatement();
					rs = st.executeQuery("");
					
					if (textField.getText() != null && textField_1.getText() != null && textField_2.getText() != null && textField_3.getText() != null) {
						st.executeUpdate("DELETE FROM ikasleak WHERE nan = '...'");
					}
					
				} catch(SQLException | ClassNotFoundException sql) {
					JOptionPane.showMessageDialog(null, (String) "Konexio Errorea", "Errorea", JOptionPane.ERROR_MESSAGE, null);
				}
			}
		});
		btnBorrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBorrar.setBounds(302, 267, 108, 34);
		contentPane.add(btnBorrar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection conexion = 
							DriverManager.getConnection("jdbc:mysql://localhost/dbikasleak", "root", "");
					
					st = conexion.createStatement();
					rs = st.executeQuery("");
					
					if (textField.getText() != null && textField_1.getText() != null && textField_2.getText() != null && textField_3.getText() != null) {
						st.executeUpdate("");
					}
					
				} catch(SQLException | ClassNotFoundException sql) {
					JOptionPane.showMessageDialog(null, (String) "Konexio Errorea", "Errorea", JOptionPane.ERROR_MESSAGE, null);
				}
			}
		});
		btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnActualizar.setBounds(420, 267, 108, 34);
		contentPane.add(btnActualizar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(WIDTH);
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSalir.setBounds(538, 267, 108, 34);
		contentPane.add(btnSalir);
		
		JButton btnNewButton_1 = new JButton("<<");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(161, 30, 63, 34);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton(">>");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_1.setBounds(634, 30, 63, 34);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("<");
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_1_1.setBounds(234, 30, 55, 34);
		contentPane.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_2 = new JButton(">");
		btnNewButton_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_1_2.setBounds(569, 30, 55, 34);
		contentPane.add(btnNewButton_1_1_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setBounds(302, 30, 257, 34);
		contentPane.add(lblNewLabel_1);
	}
}
