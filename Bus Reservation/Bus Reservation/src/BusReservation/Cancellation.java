package BusReservation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Cancellation {
	      String  passengerName;
	     int CancellationId;
	     int BookingId;
	     Date travelDate;
	     Cancellation(){
			  Scanner sc=new Scanner(System.in);
			  System.out.println("Enter the Cancellation_Id :");
			  CancellationId=sc.nextInt();
			  System.out.println("Enter the passengerName :");
			  passengerName=sc.next();
			  System.out.println("Enter the bookingId:");
			  BookingId=sc.nextInt();
			  System.out.println("Enter date dd-mm-yyyy");
			  String dateInput = sc.next();
			  SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			  
			  try {
					travelDate = dateFormat.parse(dateInput);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		  }

	public boolean cancelTickets(int id) throws SQLException {
		String query = "select busNo from booking where BookingId=" + id;
		Connection con = DBConnection.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		int rs1=0;
		if (rs.next()) {
			String query1 = "delete from booking where BookingId= " + id;
			Connection con1 = DBConnection.getConnection();
			Statement st1 = con.createStatement();
			 rs1 = st1.executeUpdate(query1);
			 rs1++;
			
			
		}
		return rs1>0;

	}

}
