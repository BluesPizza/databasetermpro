package tables;

public class Team {
	private Integer teamID;
	private Integer scheduleID;
	private String name;
	private Integer count;
	private String leader;
	private String phone;
	public Team(Integer teamID, Integer scheduleID, String name, Integer count, String leader, String phone) {
		super();
		this.teamID = teamID;
		this.scheduleID = scheduleID;
		this.name = name;
		this.count = count;
		this.leader = leader;
		this.phone = phone;
	}
	public Team() {
		super();
	}
	public Integer getTeamID() {
		return teamID;
	}
	public void setTeamID(Integer teamID) {
		this.teamID = teamID;
	}
	public Integer getScheduleID() {
		return scheduleID;
	}
	public void setScheduleID(Integer scheduleID) {
		this.scheduleID = scheduleID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getLeader() {
		return leader;
	}
	public void setLeader(String leader) {
		this.leader = leader;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Team [teamID=" + teamID + ", scheduleID=" + scheduleID + ", name=" + name + ", count=" + count
				+ ", leader=" + leader + ", phone=" + phone + "]";
	}
	
	
}
