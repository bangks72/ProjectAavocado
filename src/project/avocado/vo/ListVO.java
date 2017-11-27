package project.avocado.vo;

public class ListVO {

	private String id;
	private String mname;
	private String sname;
	private String time;
	private int playno;

	public ListVO(String id, String mname, String sname, String time, int playno) {
		super();
		this.id = id;
		this.mname = mname;
		this.sname = sname;
		this.time = time;
		this.playno = playno;
	}

	public ListVO() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getPlayno() {
		return playno;
	}

	public void setPlayno(int playno) {
		this.playno = playno;
	}

}
