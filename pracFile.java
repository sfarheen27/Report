package sqlToJava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;

//import com.mysql.cj.xdevapi.Statement;

public class pracFile {
	
	public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
			pracFile pro = new pracFile();
			pro.createConnection();	
			
	}
    void createConnection() throws SQLException, IOException, ClassNotFoundException {
		try {
				
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "dfgcom/31yspg2!");
			System.out.println("DB connect success");
	 
			File file = new File("/Users/SarahF/Downloads/bankdocs.txt"); 
			BufferedReader br = new BufferedReader(new FileReader(file)); 
			  
			 // store data into var 
			  	String count;String line;
				String docID;String docClass;String docType;String daCr;
				String daCh;String docTi;String docSta; String ofn;
				String taxid; String acctnum; String bankNum;String Comnam;
				String oci; String creator; String status;
				
			// read file 
				  String [] tmp= new String [16];
				  int count1 = 0;
				  br.readLine(); 
				  String st = br.readLine();
				  while (st != null)  {
					// assign fields to var 
					tmp= st.split("\t");
					count1++;
					count = tmp[0]; docID = tmp[1] ;docClass = tmp[2];docType = tmp[3];daCr = tmp[4];
		            daCh =tmp[5];docTi =tmp[6];docSta =tmp[7]; ofn = tmp[8];
				    taxid = tmp[9]; acctnum= tmp[10]; bankNum = tmp[11];
					Comnam = tmp[12];oci=tmp[13];creator = tmp[14]; status = tmp[15];
				
					//System.out.println
					//(count + " ; " + docID +" ; "+ docClass +" ; "+ docType + " ; " + daCr + " ; "
					//+ daCh +" ; " + docTi +" ; " + docSta+ " ; " +  ofn+ " ; " + taxid+ " ; " + acctnum+ " ; " +  bankNum+ " ; " + 
					//Comnam+ " ; " +  oci+ " ; " +  creator+ " ; " +  status);
				
			 //save fields into sql table 
				java.sql.Statement stmt = con.createStatement();	
				String sqlQ= "INSERT into sBank VALUE ('"+count+"', '"+ docID +"', '"+ docClass +"', '" + docType + "', '" + daCr + "', '"+ daCh + "', '"+ docTi +"', '" + docSta+ "', '" +  ofn+ "', '" + taxid+ "', '" + acctnum+ "', '" + bankNum+ "',  '" +Comnam+ "', '" + oci+ "', '" + creator+ "', '" + status +"') ";
			    stmt.executeUpdate(sqlQ); 
				
				st = br.readLine();
		  } 
			  br.close(); 
		  
	    }catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
