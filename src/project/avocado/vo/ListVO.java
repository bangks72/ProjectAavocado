package project.avocado.vo;

public class ListVO {

	private int plno;
	private int mbno;
	private String mname;
	private String sname;
	
	public ListVO() {
	}

	public ListVO(int plno, int mbno, String mname, String sname) {
		this.plno = plno;
		this.mbno = mbno;
		this.mname = mname;
		this.sname = sname;
	}

	public int getPlno() {
		return plno;
	}

	public void setPlno(int plno) {
		this.plno = plno;
	}

	public int getMbno() {
		return mbno;
	}

	public void setMbno(int mbno) {
		this.mbno = mbno;
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
