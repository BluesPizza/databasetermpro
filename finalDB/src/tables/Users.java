package tables;
//用户登录信息
public class Users {
	private String ID;
	private String pass;
	public Users(String iD, String pass) {
		super();
		ID = iD;
		this.pass = pass;
	}
	public Users() {
		super();
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "Users [ID=" + ID + ", pass=" + pass + "]";
	}
	
}
