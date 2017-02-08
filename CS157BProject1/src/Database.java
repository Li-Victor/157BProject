import java.io.*;
import java.sql.*;
import java.util.Properties;


public class Database {

	//creating database sales_transactions
	public static void CreateDB(Properties info, String connString,
			String jdbcDriver) {
		Connection conn;
		Statement stmt;
		
		try {
			Class.forName(jdbcDriver);
			
			System.out.println("Connecting to database");
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
				conn.close();
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void PopulateDB(Properties info,
			String salesTransactionConnection, String jdbcDriver) {
		
		Connection conn;
		Statement stmt;
		
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(salesTransactionConnection, info);
			
			try {
				stmt = conn.createStatement();
				//drop table sale_transaction if it exists
				stmt.execute("DROP TABLE IF EXISTS Sale_Transaction");
				
				stmt.executeUpdate("CREATE TABLE Sale_Transaction " +
						"(CustomerID INTEGER NOT NULL AUTO_INCREMENT, " +
						"Spent FLOAT, " +
						"Date VARCHAR(255), " +
						"NumberOfItems INTEGER NOT NULL, " +
						"PRIMARY KEY (CustomerID))");
				
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
