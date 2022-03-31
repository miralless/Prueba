package eb3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.swing.JOptionPane; 


public class DBkonexioa2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection konexioa =
				DriverManager.getConnection("jdbc:mysql://localhost/dbikasleak", "root", "");
			
			konexioa.setAutoCommit(false);
			
			CachedRowSet crs;
			RowSetFactory myRowSetFactory = null;
			myRowSetFactory = RowSetProvider.newFactory();
			crs = myRowSetFactory.createCachedRowSet();
			
			crs.setCommand("SELECT * FROM ikasleak");
			
			crs.execute(konexioa);
			
			boolean aldatuta = false;
			
			System.out.println("KONEXIO EGOKIA \n");
			
			while(crs.next()) {
				System.out.println("NAN: " + crs.getObject("nan") + ", Izena: " + crs.getObject("izena")
				+ ", Abizenak: " + crs.getObject("abizenak") + ", Taldea: " + crs.getObject("taldea"));
			}
			
			/*try {
				String nan = "00000000A";
				String izena = "N0";
				String abizena = "A0";
				String taldea = "1DW3";
				
				crs.moveToInsertRow();
				crs.updateString(1, nan);
				crs.updateString(2, izena);
				crs.updateString(3, abizena);
				crs.updateString(4, taldea);
				
				crs.insertRow();
				
				crs.moveToCurrentRow();
				
				aldatuta = true;
				
				
			} catch(SQLException e) {
				JOptionPane.showMessageDialog(null, (String) "Errorea. Ezin izan da erregistroa txertatu", "Errorea", JOptionPane.ERROR_MESSAGE, null);
			}*/
			
			konexioa.close();
			
			if (aldatuta) {
				konexioa.setAutoCommit(aldatuta);
			}
			
		} catch(SQLException | ClassNotFoundException e) {
			System.out.println("Konexio errorea");
		}
		
	}

}
