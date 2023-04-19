package tables;


public class Leading {
	private Integer scheduleID;
	private Integer guideID;
	private Integer guideID1;
	
	public Leading(Integer scheduleID, Integer guideID, Integer guideID1) {
		super();
		this.scheduleID = scheduleID;
		this.guideID = guideID;
		this.guideID1= guideID1;
	}

	public Integer getGuideID1() {
		return guideID1;
	}

	public void setGuideID1(Integer guideID1) {
		this.guideID1 = guideID1;
	}

	public Leading() {
		super();
	}

	public Integer getScheduleID() {
		return scheduleID;
	}

	public void setScheduleID(Integer scheduleID) {
		this.scheduleID = scheduleID;
	}

	public Integer getGuideID() {
		return guideID;
	}

	public void setGuideID(Integer guideID) {
		this.guideID = guideID;
	}

	@Override
	public String toString() {
		return "Leading [scheduleID=" + scheduleID + ", guideID=" + guideID + ", guideID1=" + guideID1 + "]";
	}
	
	
}
