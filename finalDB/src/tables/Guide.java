package tables;

public class Guide {
	 	private Integer GuideID;
	    private String Name;
	    private Integer Age;
	    private String Gender;
	    private String IDnum;
	    private String Phone;
	    private Integer Rank;
	    
	    
		public Guide() {
			super();
		}

//构造函数
		public Guide(Integer guideID, String name, Integer age, String gender, String iDnum, String phone,
				Integer rank) {
			super();
			GuideID = guideID;
			Name = name;
			Age = age;
			Gender = gender;
			IDnum = iDnum;
			Phone = phone;
			Rank = rank;
		}


		
		//get set 方法
		public Integer getGuideID() {
			return GuideID;
		}


		public void setGuideID(Integer guideID) {
			GuideID = guideID;
		}


		public String getName() {
			return Name;
		}


		public void setName(String name) {
			Name = name;
		}


		public Integer getAge() {
			return Age;
		}


		public void setAge(Integer age) {
			Age = age;
		}


		public String getGender() {
			return Gender;
		}


		public void setGender(String gender) {
			Gender = gender;
		}


		public String getIDnum() {
			return IDnum;
		}


		public void setIDnum(String iDnum) {
			IDnum = iDnum;
		}


		public String getPhone() {
			return Phone;
		}


		public void setPhone(String phone) {
			Phone = phone;
		}


		public Integer getRank() {
			return Rank;
		}


		public void setRank(Integer rank) {
			Rank = rank;
		}


		@Override
		public String toString() {
			return "Guide [GuideID=" + GuideID + ", Name=" + Name + ", Age=" + Age + ", Gender=" + Gender + ", IDnum="
					+ IDnum + ", Phone=" + Phone + ", Rank=" + Rank + "]";
		}
		
		
	  
}
