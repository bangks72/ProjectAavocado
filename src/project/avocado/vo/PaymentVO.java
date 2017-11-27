package project.avocado.vo;

public class PaymentVO {

	private String id;
	private String cardno;
	private String mutong;

	public PaymentVO(String id, String cardno, String mutong) {
		super();
		this.id = id;
		this.cardno = cardno;
		this.mutong = mutong;
	}

	public PaymentVO() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public String getMutong() {
		return mutong;
	}

	public void setMutong(String mutong) {
		this.mutong = mutong;
	}

}
