package project.avocado.vo;

public class PersonalVO {

	private String id;
	private String ticket;

	public PersonalVO(String id, String ticket) {
		super();
		this.id = id;
		this.ticket = ticket;
	}

	public PersonalVO() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

}
