package project.avocado.vo;

public class PaymentVO {

	private String paytype;
	private String sdate;// 시작날짜 start-date
	private int tkno;// 티켓종류 0,1,2,3 순으로 없음,1개월,3개월,12개월

	public PaymentVO() {
	}

	public PaymentVO(String paytype, String sdate, int tkno) {
		this.paytype = paytype;
		this.sdate = sdate;
		this.tkno = tkno;
	}

	public String getPaytype() {
		return paytype;
	}

	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	public int getTkno() {
		return tkno;
	}

	public void setTkno(int tkno) {
		this.tkno = tkno;
	}

}
