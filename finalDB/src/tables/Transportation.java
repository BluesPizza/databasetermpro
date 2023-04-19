package tables;

public class Transportation {
	private Integer scheduleID1;
	private String depature_trans;
	private String depature_time;
	private String return_trans;
	private String return_time;
	public Transportation(Integer scheduleID1, String depature_trans, String depature_time, String return_trans,
			String return_time) {
		super();
		this.scheduleID1 = scheduleID1;
		this.depature_trans = depature_trans;
		this.depature_time = depature_time;
		this.return_trans = return_trans;
		this.return_time = return_time;
	}
	public Transportation() {
		super();
	}
	public Integer getScheduleID1() {
		return scheduleID1;
	}
	public void setScheduleID1(Integer scheduleID1) {
		this.scheduleID1 = scheduleID1;
	}
	public String getDepature_trans() {
		return depature_trans;
	}
	public void setDepature_trans(String depature_trans) {
		this.depature_trans = depature_trans;
	}
	public String getDepature_time() {
		return depature_time;
	}
	public void setDepature_time(String depature_time) {
		this.depature_time = depature_time;
	}
	public String getReturn_trans() {
		return return_trans;
	}
	public void setReturn_trans(String return_trans) {
		this.return_trans = return_trans;
	}
	public String getReturn_time() {
		return return_time;
	}
	public void setReturn_time(String return_time) {
		this.return_time = return_time;
	}
	@Override
	public String toString() {
		return "Transportation [scheduleID1=" + scheduleID1 + ", depature_trans=" + depature_trans + ", depature_time="
				+ depature_time + ", return_trans=" + return_trans + ", return_time=" + return_time + "]";
	}
	
	
}
