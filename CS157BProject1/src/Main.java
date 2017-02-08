import java.util.Properties;


public class Main {
	//change for credentials
	private static Properties INFO = new Properties();
	
	private static final String CONN_STRING = "jdbc:mysql://localhost/books";
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String USERNAME = "VictorLi";
	private static final String PASSWORD = "password";
	
	public static void main(String[] args) {
		//login credentials
		INFO.setProperty("user", USERNAME);
		INFO.setProperty("password", PASSWORD);
		INFO.setProperty("useSSL", "false");
		
		//setup database SALES_TRANSACTIONS along with populated tables
		Database.setupDB(INFO, CONN_STRING, JDBC_DRIVER);
		
	}
}
