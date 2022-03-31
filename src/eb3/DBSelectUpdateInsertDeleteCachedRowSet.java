package eb3;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;*/

public class DBSelectUpdateInsertDeleteCachedRowSet {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		//hemen konexioaren datuak jarriko ditugu
		//select-a egin eta gero, datu guztiak crs-an daude
		//crs-an insert, delete eta update guztiak egingo dira eta gero, amaieran, datu guztiak db-an eguneratu
		Connection konexioa;
		CachedRowSet crs;
		boolean aldatuta=false;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		konexioa =DriverManager.getConnection("jdbc:mysql://localhost/dbikasleak", "root","");
		// datuen eguneratze automatikoa desgaitu
		konexioa.setAutoCommit(false);
		// CachedRowSet eratu
		
		RowSetFactory myRowSetFactory = null;
		myRowSetFactory = RowSetProvider.newFactory();
		crs = myRowSetFactory.createCachedRowSet();
		
		System.out.println("Konexio egokia");
		
		//SELECT-a egin crs-ra
		try {
			
			// ikasle guztiak aukeratu
			// aurreko konexioa erabiliz
			crs.setCommand("SELECT * FROM ikasleak");
			crs.execute(konexioa);
			
			while (crs.next()){
				
				System.out.println("NAN: " + crs.getObject("nan") + ", Izena: " + crs.getObject("izena")
				+ ", Abizenak: " + crs.getObject("abizenak") + ", Taldea: " + crs.getObject("taldea"));
				}
					
			
			System.out.println("Select-a ondo eginda");
			
		}catch (SQLException sqle){
			// ez baldin bada konexioa era egokian egin
			sqle.printStackTrace();
			System.out.println("Select errorea");
		}
		
		
		//UPDATE-a egin
		try {
			
			// datuak aldagaietan jarri
			
			String balioa1 ="99999999Z"; 
			String balioa2 ="ss"; 
			String balioa3 ="A9";
			String balioa4 ="yyy";
		
			
			
			crs.first();
			
			
			
			while (crs.next()){
				
				if (crs.getObject("nan").equals (balioa1)) {
					crs.updateString(2, balioa2);
					crs.updateString(3, balioa3);
					crs.updateString(4, balioa4);
					crs.updateRow();
					aldatuta=true;		
					}
				
			}
			
			
			System.out.println("Updatea ondo eginda");
			
			
			
			
		}catch (SQLException sqle){
			// ez baldin bada konexioa era egokian egin
			sqle.printStackTrace();
			System.out.println("Update errorea");
		}
		//INSERT-a egin
		try {
			//crs.setCommand("SELECT * FROM ikasleak");
			//crs.execute(konexioa);
			//Datuak aldagaietan jaso
			String nan = "42222222T";
			String izena = "N2";
			String abizenak = "A2";
			String taldea = "2AS3";
		
			crs.moveToInsertRow();
			crs.updateString(1, nan);
			crs.updateString(2, izena);
			crs.updateString(3, abizenak);
			crs.updateString(4, taldea);
			crs.insertRow();
			crs.moveToCurrentRow();
			
			// sartutako datuak eguneratu
			aldatuta = true; 
			System.out.println("Insert ondo");
			
			
		//}catch (MySQLIntegrityConstraintViolationException mslcve) {
			System.out.println("Ikasle hori badago datubasean");
		}catch (SQLException sqle){
			// ez baldin bada konexioa era egokian egin
			sqle.printStackTrace();
			System.out.println("Insert errorea");
		}
		
		
		
		//DELETE-a egin
		try {
			
			//Lehenengo erregistroan jarri
			crs.first();
	
			//Bilatu dagokigun erregistroa eta ezabatu		
			while (crs.next()){
				
				if (crs.getObject("nan").equals ("22222222T")) {
					
					crs.deleteRow();
					aldatuta=true;			}
				
			}
			
		
			
			System.out.println("Deletea ondo eginda");
			
		}catch (SQLException sqle){
			// ez baldin bada konexioa era egokian egin
			sqle.printStackTrace();
			System.out.println("Delete errorea");
		}
		
		
		
		
		// Daturen bat aldatu baldin bada
		if (aldatuta){
			try{
			
			// Ondo konektatu baldin bada
			// datuen eguneratze automatikoa desgaitu
			konexioa.setAutoCommit(false);
			crs.acceptChanges(konexioa);
			} catch (SQLException sqle) {
				System.out.println("Ez");
				sqle.printStackTrace();
				JOptionPane.showMessageDialog(null,(String)"Errorea. Ezin izan dira datuak gorde",
						"Errorea",JOptionPane.ERROR_MESSAGE,null);
				
			}
		} 
		
		
		
		//SELECT erabili
			try {
				
				// ikasle guztiak aukeratu
				// aurreko konexioa erabiliz
				crs.setCommand("SELECT * FROM ikasleak");
				crs.execute(konexioa);
				
				while (crs.next()){
					
					System.out.println("NAN: " + crs.getObject("nan") + ", Izena: " + crs.getObject("izena")
					+ ", Abizenak: " + crs.getObject("abizenak") + ", Taldea: " + crs.getObject("taldea"));
					}
					// ResultSet itxi
					crs.close();
					// Statement itxi kontsulta egin eta gero
					
					
					
				
				
				
				
				//crs.execute(konexioa);
				
				// Databaseko konexioa itxi
			
				System.out.println("Konexio egokia5");
			}catch (SQLException sqle){
				// ez baldin bada konexioa era egokian egin
				sqle.printStackTrace();
				System.out.println("Konexio errorea5");
			}
			konexioa.close();
	}

}
