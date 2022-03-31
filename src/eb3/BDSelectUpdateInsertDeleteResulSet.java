package eb3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.*;

//import com.sun.rowset.CachedRowSetImpl;

import java.sql.ResultSet;

public class BDSelectUpdateInsertDeleteResulSet {
	public static void main(String[] args) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection konexioa;
			konexioa= DriverManager.getConnection("jdbc:mysql://localhost/dbikasleak", "root", "");
			
					
			// ondo konektatu baldin bada
			// Statement berria 
			Statement st = konexioa.createStatement();
			
			//Resulset berria
			//Ikasle guztiak ikusi
			ResultSet rs = st.executeQuery("SELECT * FROM ikasleak");
			
			System.out.println("--------Aldaketak egin baino lehen-----------------");
			while (rs.next())
			{
			   System.out.println("NAN: "+rs.getObject("nan")+", Izena: "+rs.getObject("izena")+
			      ", Abizenak: "+rs.getObject("abizenak")+
			      ", Taldea: "+rs.getObject("taldea"));
			}
			// Resulset itxi
			rs.close();
			// Statement itxi
			st.close();
			
			
			
			// Statement berria egin
			st = konexioa.createStatement();
			//  '11111111A' nan duen ikaslea ezabatu
			st.executeUpdate("DELETE FROM ikasleak  WHERE nan='11111111A'");
			// Statement itxi
			st.close();
			
			
			st = konexioa.createStatement();
			
			//Resulset berria
			rs = st.executeQuery("SELECT * FROM ikasleak");
			
			System.out.println("--------DELETE EGIN ETA GERO-----------------");
			while (rs.next())
			{
			   System.out.println("NAN: "+rs.getObject("nan")+", Izena: "+rs.getObject("izena")+
			      ", Abizenak: "+rs.getObject("abizenak")+
			      ", Taldea: "+rs.getObject("taldea"));
			}
			// Resulset itxi
			rs.close();
			st.close();
			
			
			// statement berria update egiteko
			st = konexioa.createStatement();
			//  '11111111A' nan duen ikasleari  '1DW3' jarri
			st.executeUpdate("UPDATE ikasleak SET taldea='1DW3' WHERE nan='22222222B'");
			// Statement itxi
			st.close();
			
			
			//statement berria select egiteko
			st = konexioa.createStatement();
			
			//Resulset berria
			rs = st.executeQuery("SELECT * FROM ikasleak");
			
			System.out.println("--------UPDATE EGIN ETA GERO-----------------");
			while (rs.next())
			{
			   System.out.println("NAN: "+rs.getObject("nan")+", Izena: "+rs.getObject("izena")+
			      ", Abizenak: "+rs.getObject("abizenak")+
			      ", Taldea: "+rs.getObject("taldea"));
			}
			// Resulset itxi
			rs.close();
			st.close();
			
			
			st = konexioa.createStatement();
			//  '11111111A' nan duen ikasleari  '3DW3' jarri
			st.executeUpdate("INSERT INTO ikasleak VALUES ('11111111A','N1', 'P1', '1DW3') ");
			// Statement itxi
			st.close();
			
			
			System.out.println("--------INSERT EGIN ETA GERO-----------------");
			
			rs = st.executeQuery("SELECT * FROM ikasleak");
			while (rs.next())
			{
			   System.out.println("NAN: "+rs.getObject("nan")+", Izena: "+rs.getObject("izena")+
			      ", Abizenak: "+rs.getObject("abizenak")+
			      ", Taldea: "+rs.getObject("taldea"));
			}
			// Resulset itxi
			rs.close();
			st.close();
			
			
			// cierro la konexioa con la base de datos
			konexioa.close();
			
			
		}
		catch (SQLException | ClassNotFoundException sqle){
			// si NO se ha conectado correctamente
			sqle.printStackTrace();
			System.out.println("Error de Conexión");
		}
	}
}
