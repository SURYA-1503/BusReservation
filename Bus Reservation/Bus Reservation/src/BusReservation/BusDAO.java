package BusReservation;

import java.sql.*;

public class BusDAO {
	
	public void displayBusInfo() throws SQLException
	{
		String query="select * from bus";
		Connection con = DBConnection.getConnection();
		Statement st = con.createStatement();
		ResultSet rs=st.executeQuery(query);
		while(rs.next())
		{
			System.out.println("Bus_Id :"+rs.getInt(1));
			if(rs.getInt(2)==1)
			{
				System.out.println("Bus_Type :"+"AC");
			}
			else
			{
				System.out.println("Bus_Type :"+"NON-AC");
			}
			System.out.println("Seat_Type :"+rs.getString(3));
			System.out.println("Bus_Capacity :"+rs.getInt(4));
			System.out.println("=====================================");
		}
	}
	public int getCapacity(int id) throws SQLException
	{
		String query="select capacity from bus where BusId= "+id;
		Connection con=DBConnection.getConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		rs.next();
		
		return rs.getInt(1);
	}

	
}
