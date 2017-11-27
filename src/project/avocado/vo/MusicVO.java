package project.avocado.vo;

public class MusicVO {

	private String mname;
	private String sname;
	private String genre;
	private String rank;

	public MusicVO(String mname, String sname, String genre, String rank) {
		super();
		this.mname = mname;
		this.sname = sname;
		this.genre = genre;
		this.rank = rank;
	}

	public MusicVO() {
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

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

}
