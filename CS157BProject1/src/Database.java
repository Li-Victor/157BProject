import java.io.*;
import java.sql.*;
import java.util.Properties;


public class Database {

	//set up database sales_transactions
	public static void setupDB(Properties info, String connString,
			String jdbcDriver) {
		
		Connection conn;
		Statement stmt;
		
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(connString, info);
			
			try {
				stmt = conn.createStatement();
				
				//change destination if needed
				FileReader file = new FileReader("C:/school/CS157BProject1/CS157BProject1/src/insert.sql");
				BufferedReader br = new BufferedReader(file);
				
				String query;
				while((query = br.readLine()) != null) {
					if(!query.trim().equals(""))
						stmt.executeUpdate(query);
				}
				stmt.close();
				System.out.println("Created school database");
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				conn.close();
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
