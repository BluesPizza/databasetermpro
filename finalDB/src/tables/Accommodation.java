package tables;

public class Accommodation {
	private Integer scheduleID3;
	private Integer hotelID;
	
	
	public Accommodation(Integer scheduleID3, Integer hotelID) {
		super();
		this.scheduleID3 = scheduleID3;
		this.hotelID = hotelID;
	}
	public Accommodation() {
		super();
	}
	
	@Override
	public String toString() {
		return "Accommodation [scheduleID3=" + scheduleID3 + ", hotelID=" + hotelID + "]";
	}
	public Integer getScheduleID3() {
		return scheduleID3;
	}
	public void setScheduleID3(Integer scheduleID3) {
		this.scheduleID3 = scheduleID3;
	}
	public Integer getHotelID() {
		return hotelID;
	}
	public void setHotelID(Integer hotelID) {
		this.hotelID = hotelID;
	}
	
	
	
}
