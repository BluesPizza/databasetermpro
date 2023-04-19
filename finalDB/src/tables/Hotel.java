package tables;

public class Hotel {
	private Integer hotelID;
	private String name;
	private String city;
	private Integer rank;
	private Double standard_price; 
	private String phone;
	private String address;
	
	public Hotel(Integer hotelID, String name, String city, Integer rank, Double standard_price, String phone,
			String address) {
		super();
		this.hotelID = hotelID;
		this.name = name;
		this.city = city;
		this.rank = rank;
		this.standard_price = standard_price;
		this.phone = phone;
		this.address = address;
	}

	public Hotel() {
		super();
	}

	@Override
	public String toString() {
		return "Hotel [hotelID=" + hotelID + ", name=" + name + ", city=" + city + ", rank=" + rank
				+ ", standard_price=" + standard_price + ", phone=" + phone + ", address=" + address + "]";
	}

	public Integer getHotelID() {
		return hotelID;
	}

	public void setHotelID(Integer hotelID) {
		this.hotelID = hotelID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Double getStandard_price() {
		return standard_price;
	}

	public void setStandard_price(Double standard_price) {
		this.standard_price = standard_price;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
