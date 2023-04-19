package tables;

public class Insurance {
	private Integer insuranceID;
	private Integer teamID;
	private Double premium;
	private String date;
	
	public Insurance(Integer insuranceID, Integer teamID, Double premium, String date) {
		super();
		this.insuranceID = insuranceID;
		this.teamID = teamID;
		this.premium = premium;
		this.date = date;
	}

	public Insurance() {
		super();
	}

	public Integer getInsuranceID() {
		return insuranceID;
	}

	public void setInsuranceID(Integer insuranceID) {
		this.insuranceID = insuranceID;
	}

	public Integer getTeamID() {
		return teamID;
	}

	public void setTeamID(Integer teamID) {
		this.teamID = teamID;
	}

	public Double getPremium() {
		return premium;
	}

	public void setPremium(Double premium) {
		this.premium = premium;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Insurance [insuranceID=" + insuranceID + ", teamID=" + teamID + ", premium=" + premium + ", date="
				+ date + "]";
	}
	
	
	
}
