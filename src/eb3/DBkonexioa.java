package eb3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBkonexioa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			//Driver-a
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection konexioa =
				DriverManager.getConnection("jdbc:mysql://localhost/dbikasleak", "root", "");
			Statement st = konexioa.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM ikasleak"); 
			//Konexioa ondo baldin badabil
			System.out.println("Konexio egokia\n");
			while (rs.next()) {
				System.out.println("NAN: " + rs.getObject("nan") + ", Izena: " + rs.getObject("izena")
				+ ", Abizenak: " + rs.getObject("abizenak") + ", Taldea: " + rs.getObject("taldea"));
			}
			
			// Statement itxi kontsulta egin eta gero
			st.close();
			// ResultSet itxi
			rs.close();
			
			System.out.println("");
			
			st = konexioa.createStatement();
			// '11111111A' nana duen ikasleari '1DW3' jarri taldean
			st.executeUpdate("INSERT INTO ikasleak VALUES ('12345678Z', 'N10', 'A10', 'PLTO')");
			st.executeUpdate("DELETE FROM ikasleak WHERE izena = 'N3'");
			
			
			
			st = konexioa.createStatement();
			rs = st.executeQuery("SELECT * FROM ikasleak"); 
			while (rs.next()) {
				System.out.println("NAN: " + rs.getObject("nan") + ", Izena: " + rs.getObject("izena")
				+ ", Abizenak: " + rs.getObject("abizenak") + ", Taldea: " + rs.getObject("taldea"));
			}
			
			//Konexioa itxi
			konexioa.close();
		} catch (SQLException | ClassNotFoundException e) {
			//Konexioa txarto baldin badabil
			e.printStackTrace();
			System.out.println("Konexio errorea");
		}
		
		
		
		
		
	}

}
