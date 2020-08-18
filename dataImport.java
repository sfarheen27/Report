package sqlToJava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dataImport {
	
	public static void main(String[] args) throws SQLException, IOException {
		dataImport pro = new dataImport();
		pro.createConnection();	
	}
	
	void createConnection() throws SQLException, IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "dfgcom/31yspg2!");
			System.out.println("DB connect success");
			
			File file = new File("/Users/SarahF/Downloads/bankdocs.rtf"); 
			BufferedReader br = new BufferedReader(new FileReader(file)); 
			
			String count;String line;
			String docID;String docClass;String docType;String daCr;
			String daCh;String docTi;String docSta; String ofn;
			String taxid; String acctnum; String bankNum;String Comnam;
			String oci; String creator; String status;
			
			line = null;
			int count1 = 0;
	        while ((line = br.readLine()) != null)
	        {
	            String tmp[] = line.split(" ");
	            //int i;
	            //for (i=0;i<tmp.length;i++) {
	            	
	            //}
	            //tmp = new String [16];
	            //count = tmp[0]; docID = tmp[1] ;docClass = tmp[2];docType = tmp[3];daCr = tmp[4];
	            //daCh =tmp[5];docTi =tmp[6];docSta =tmp[7]; ofn = tmp[8];
				//taxid = tmp[9]; acctnum= tmp[10]; bankNum = tmp[11];
				//Comnam = tmp[12];oci=tmp[13];creator = tmp[14]; status = tmp[15];
	            count1++;
				System.out.println("line number: " + count1);
				System.out.println(Arrays.toString(tmp));
	        }
	        				
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(dataImport.class.getName()).log(Level.SEVERE, null, e);
		} catch (SQLException ex) {
			Logger.getLogger(dataImport.class.getName()).log(Level.SEVERE, null,ex);
		}
	}
	
}
