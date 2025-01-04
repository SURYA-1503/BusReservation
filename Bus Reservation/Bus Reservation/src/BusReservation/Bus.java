package BusReservation;

public class Bus {
	
	 int BusNo;
	public int getBusId() {
		return BusNo;
	}
	public void setBusId(int busNo) {
		BusNo = busNo;
	}
	public String getBusType() {
		return BusType;
	}
	public void setBusType(String busType) {
		BusType = busType;
	}
	public String getSeatType() {
		return SeatType;
	}
	public void setSeatType(String seatType) {
		SeatType = seatType;
	}
	public int getCapacity() {
		return Capacity;
	}
	public void setCapacity(int capacity) {
		Capacity = capacity;
	}
	 String BusType;
	String SeatType;
	 int Capacity;

}
