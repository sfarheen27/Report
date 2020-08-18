package sqlToJava;

import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class readFromTable {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		readFromTable pro = new readFromTable();
		pro.createConnection();	
		
	}
	
	void createConnection() throws SQLException, IOException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "dfgcom/31yspg2!");
		//System.out.println("DB connect success");
		
		//java.sql.Statement stmt = con.createStatement();
		// create sql table using java 
		//String sqlQ= "create table sBank (count int, docID VARCHAR(50), docClass VARCHAR(20), docType VARCHAR(20), daCr VARCHAR(20), daCh VARCHAR(20), docTi VARCHAR(30), docSta VARCHAR(5), ofn VARCHAR(30), taxid VARCHAR(10), acctnum VARCHAR(10), bankNum VARCHAR(10), Comnam VARCHAR(20), oci VARCHAR(20), creator VARCHAR(20), status VARCHAR(20) ) ";
	    //String sqlQ = "alter table sBank modify ofn VARCHAR(60)";
		//stmt.executeUpdate(sqlQ);
		
		// write data into textfile 
		
		// pull data from sql table 
		 String sqlQ= "select * from sBank";
		//PreparedStatement stmt = con.prepareStatement(sqlQ);
		//ResultSet rs = sqlQ.executeQuery();
		
		java.sql.Statement selectStmt = con.createStatement();
		ResultSet rs = selectStmt.executeQuery(sqlQ);
		PrintWriter writer = new PrintWriter("resultFile.txt", "UTF-8");
		writer.println();
		writer.println("Doc Class");
		writer.printf("%20s","Doc Type");writer.printf("%20s","Date Created");writer.printf("%17s","Doc Status");
		writer.println();
		
		while (rs.next()) {
			// docClass, docType, daCr, docStatus , covert date string to date format 		
			writer.print(rs.getString(3));
			writer.printf("%17s",rs.getString(4));
			writer.printf("%17s",rs.getString(5));
			writer.printf("%8s",rs.getString(8));
			
			writer.println();
			
		}
		writer.close();
	}
	
	

}
