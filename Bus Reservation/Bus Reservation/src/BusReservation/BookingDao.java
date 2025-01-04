package BusReservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class BookingDao {

	public int getBookedCount(int busNo, Date travelDate) throws SQLException {
		 String Query="select count(passangerName) from booking where busNo=? AND travel_date=?";
		 Connection con=DBConnection.getConnection();
		 PreparedStatement pst=con.prepareStatement(Query);
		 java.sql.Date sqldate = new java.sql.Date(travelDate.getTime());
		 pst.setInt(1, busNo);
		 pst.setDate(2, sqldate);
		 ResultSet rs=pst.executeQuery();
		 rs.next();
		 return rs.getInt(1);
		 
		 
		 
	}

	public void addBooking(Booking booking) throws SQLException {
		String query="insert into  booking values(?,?,?,?)";
		Connection con = DBConnection.getConnection();
		java.sql.Date sqldate = new java.sql.Date(booking.travelDate.getTime());
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, booking.booking_Id);
		pst.setString(2, booking.passengerName);
		pst.setInt(3, booking.BusNo);
		pst.setDate(4, sqldate);
		
		pst.executeUpdate();
		
		
		
		
		
		
		
	}

}
