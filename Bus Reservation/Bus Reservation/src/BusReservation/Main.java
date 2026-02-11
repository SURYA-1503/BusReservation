package BusReservation;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String args[]) {

		BusDAO busdao = new BusDAO();
		try {

			busdao.displayBusInfo();
			int opt = 1;
			Scanner sc = new Scanner(System.in);
			while (opt == 1) {
				System.out.println("Enter 1 for Booking and  Enter 2 for Cancellation and Enter 3 for Exit Booking");
				opt = sc.nextInt();
				if (opt == 1) {
					Booking booking = new Booking();
					if (booking.isAvailable()) {
						BookingDao bookingdao = new BookingDao();
						bookingdao.addBooking(booking);
						System.out.println("Your Booking is Confirmed");
					} else {
						System.out.println("Sorry Bus is Full... Try Another Buso");
					}

				} else if (opt == 2) {
					
					System.out.println("Enter Booking_id to Cancel :");
					int booking_Id = sc.nextInt();
					Cancellation cancel = new Cancellation();
					 boolean tickets=cancel.cancelTickets(booking_Id);
					 if(tickets)
					 {
						 
					 CancellationDao cancellationDao=new CancellationDao();
					 cancellationDao.addCancellation(cancel);
					 System.out.println("Your Ticket Cancelled Successfully");
					 }
					 else
					 {
						 System.out.println("Booking Id doesn't exist");
					 }
					 
					 
//					if(cancel.cancelTickets(booking_Id))
//					{
//						CancellationDao cancellationDao=new CancellationDao();
//						cancellationDao.addCancellation(cancel);
//					    System.out.println("Your Ticket Cancelled Successfully");
//					}
				}
				else
				{
					System.out.println("Thank you Have a Great Journey");
				}

			}
		}
		catch(Exception e)
		{
			System.out.print("Sorry error");
		} 

	}
}

