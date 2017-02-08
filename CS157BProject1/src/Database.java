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
				System.out.println("Creating database SALES_TRANSACTIONS");
				stmt = conn.createStatement();
				
				//create database sales_transactions if it is does not exist
				stmt.execute("CREATE DATABASE IF NOT EXISTS Sales_Transactions");
				
				stmt.close();
				System.out.println("Database created successfully");
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				conn.close(); //close connection
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		//reconnect with Sales_Transaction database
		String SalesTransactionConnection = "jdbc:mysql://localhost/SALES_TRANSACTIONS";
		populateDB(info, SalesTransactionConnection, jdbcDriver);
		
	}

	private static void populateDB(Properties info,
			String salesTransactionConnection, String jdbcDriver) {
		Connection conn;
		Statement stmt;
		
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(salesTransactionConnection, info);
			
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
				System.out.println("Created Sales_Transaction table");
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
