package tables;

public class Route {
	private Integer routeID;
	private String starting;
	private String terminal;
	private Integer day;
	private String scenic_point;
	
	public Route(Integer routeID, String starting, String terminal, Integer day, String scenic_point) {
		super();
		this.routeID = routeID;
		this.starting = starting;
		this.terminal = terminal;
		this.day = day;
		this.scenic_point = scenic_point;
	}

	public Route() {
		super();
	}

	public Integer getRouteID() {
		return routeID;
	}

	public void setRouteID(Integer routeID) {
		this.routeID = routeID;
	}

	public String getStarting() {
		return starting;
	}

	public void setStarting(String starting) {
		this.starting = starting;
	}

	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public String getScenic_point() {
		return scenic_point;
	}

	public void setScenic_point(String scenic_point) {
		this.scenic_point = scenic_point;
	}

	@Override
	public String toString() {
		return "Route [routeID=" + routeID + ", starting=" + starting + ", terminal=" + terminal + ", day=" + day
				+ ", scenic_point=" + scenic_point + "]";
	}
	
	
}
