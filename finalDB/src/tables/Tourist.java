package tables;

public class Tourist {
	private Integer touristID;
	private Integer teamID;
	private String name;
	private Integer age;
	private String gender;
	private String IDnum;
	private String phone;
	public Tourist(Integer touristID, Integer teamID, String name, Integer age, String gender, String iDnum,
			String phone) {
		super();
		this.touristID = touristID;
		this.teamID = teamID;
		this.name = name;
		this.age = age;
		this.gender = gender;
		IDnum = iDnum;
		this.phone = phone;
	}
	public Tourist() {
		super();
	}
	public Integer getTouristID() {
		return touristID;
	}
	public void setTouristID(Integer touristID) {
		this.touristID = touristID;
	}
	public Integer getTeamID() {
		return teamID;
	}
	public void setTeamID(Integer teamID) {
		this.teamID = teamID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getIDnum() {
		return IDnum;
	}
	public void setIDnum(String iDnum) {
		IDnum = iDnum;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Tourist [touristID=" + touristID + ", teamID=" + teamID + ", name=" + name + ", age=" + age
				+ ", gender=" + gender + ", IDnum=" + IDnum + ", phone=" + phone + "]";
	}
	
	
}
