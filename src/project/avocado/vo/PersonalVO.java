package project.avocado.vo;

public class PersonalVO {

	private String id;
	private String pwd;
	private String nick;
	private int tel;
	private int tkno;
	private int limitDate;//남은시간 DB단에서 일단위로 계산해서 가져와야함 메소드만들기
	private String sdate;//결제정보 시작일
	
	public PersonalVO() {
	}

	public PersonalVO(String id, String pwd, String nick, int tel, int tkno, int limitDate, String sdate) {
		this.id = id;
		this.pwd = pwd;
		this.nick = nick;
		this.tel = tel;
		this.tkno = tkno;
		this.limitDate = limitDate;
		this.sdate = sdate;
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

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public int getTkno() {
		return tkno;
	}

	public void setTkno(int tkno) {
		this.tkno = tkno;
	}

	public int getLimitDate() {
		return limitDate;
	}

	public void setLimitDate(int limitDate) {
		this.limitDate = limitDate;
	}

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	
	

}
