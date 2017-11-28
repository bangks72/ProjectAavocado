package project.avocado.vo;

public class MemberVO {

	private String id;
	private String pwd;
	private String nick;
	private String tel;
	private int ssn;
	private String email;

	public MemberVO(String id, String pwd, String nick, String tel, int ssn, String email) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.nick = nick;
		this.tel = tel;
		this.ssn = ssn;
		this.email = email;
	}

	public MemberVO() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
