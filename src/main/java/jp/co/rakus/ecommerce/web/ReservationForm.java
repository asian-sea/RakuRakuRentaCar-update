package jp.co.rakus.ecommerce.web;

public class ReservationForm {

	private int id;
	private int userId;
	private int status;
	private int settlement;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getSettlement() {
		return settlement;
	}
	public void setSettlement(int settlement) {
		this.settlement = settlement;
	}
}
