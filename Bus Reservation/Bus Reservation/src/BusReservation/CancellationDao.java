package BusReservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CancellationDao {

	public void addCancellation(Cancellation cancel) throws SQLException {
	     String query="insert into cancellation values(?,?,?,?)";
	     Connection con=DBConnection.getConnection();
	     java.sql.Date sqldate = new java.sql.Date(cancel.travelDate.getTime());
	     PreparedStatement pst=con.prepareStatement(query);
	     pst.setInt(1,cancel.CancellationId);
	     pst.setString(2, cancel.passengerName);
	     pst.setInt(3, cancel.BookingId);
	     pst.setDate(4, sqldate);
	     
	     pst.executeUpdate();
	     
		
	}

}
