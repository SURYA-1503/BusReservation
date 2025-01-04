package BusReservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	
	 private static final String dburl="jdbc:mysql://localhost:3306/busresev?user=root&password=12345678";
	 
	 public static Connection getConnection() throws SQLException{
		 return  DriverManager.getConnection(dburl);
	 }
}
