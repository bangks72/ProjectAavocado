package project.avocado.vo;

public class ListVO {

	private String mname;
	private String sname;
	
	public ListVO() {
	}

	public ListVO(String mname, String sname) {
		this.mname = mname;
		this.sname = sname;
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
	
}
