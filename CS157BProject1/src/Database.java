import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
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
				
				//drop database sales_transactions if it is already exists
				//comment out if it doesn't exist
				stmt.execute("DROP DATABASE SALES_TRANSACTIONS");
				
				stmt.execute("CREATE DATABASE SALES_TRANSACTIONS");
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
				
				stmt.executeUpdate("CREATE TABLE Sale_Transaction " +
						"(CustomerID INTEGER NOT NULL AUTO_INCREMENT, " +
						"Spent FLOAT, " +
						"DATE VARCHAR(255), " +
						"NumberOfItems INTEGER NOT NULL, " +
						"PRIMARY KEY (CustomerID))");
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
