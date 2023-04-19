package tables;

public class Schedule {
	private Integer scheduleID;
	private Integer routeID;
	private Integer depature_date;
	private Integer return_date;
	private Double price;
	public Schedule(Integer scheduleID, Integer routeID, Integer depature_date, Integer return_date, Double price) {
		super();
		this.scheduleID = scheduleID;
		this.routeID = routeID;
		this.depature_date = depature_date;
		this.return_date = return_date;
		this.price = price;
	}
	public Schedule() {
		super();
	}
	public Integer getScheduleID() {
		return scheduleID;
	}
	public void setScheduleID(Integer scheduleID) {
		this.scheduleID = scheduleID;
	}
	public Integer getRouteID() {
		return routeID;
	}
	public void setRouteID(Integer routeID) {
		this.routeID = routeID;
	}

	public Integer getDepature_date() {
		return depature_date;
	}
	public void setDepature_date(Integer depature_date) {
		this.depature_date = depature_date;
	}
	public Integer getReturn_date() {
		return return_date;
	}
	public void setReturn_date(Integer return_date) {
		this.return_date = return_date;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Schedule [scheduleID=" + scheduleID + ", routeID=" + routeID + ", depature_date=" + depature_date
				+ ", return_date=" + return_date + ", price=" + price + "]";
	}
	
	
}
