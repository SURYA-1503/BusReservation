package BusReservation;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Booking {
	
	  int booking_Id;
	  String passengerName;
	  int BusNo;
	  Date travelDate;
	  
	  Booking(){
		  Scanner sc=new Scanner(System.in);
		  System.out.println("Enter the Booking_Id :");
		  booking_Id=sc.nextInt();
		  System.out.println("Enter the PassengerName :");
		  passengerName=sc.next();
		  System.out.println("Enter the BusNo :");
		  BusNo=sc.nextInt();
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
	  public boolean isAvailable() throws SQLException {
		  BusDAO busdao=new BusDAO();
		  BookingDao bookingdao= new BookingDao();
		  
		  int capacity =busdao.getCapacity(BusNo);
		  int BookedCount=bookingdao.getBookedCount(BusNo,travelDate);
		  
		  return BookedCount<capacity;
	  }

}
