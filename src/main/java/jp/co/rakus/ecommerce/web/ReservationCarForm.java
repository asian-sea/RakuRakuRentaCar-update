package jp.co.rakus.ecommerce.web;

import java.util.List;

public class ReservationCarForm {

	private int id;
	private int carId;
	private int reservationId;
	private String startDate;
	private String endDate;
	private List<Integer> optionList;
	private int userId;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public int getReservationId() {
		return reservationId;
	}
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public List<Integer> getOptionList() {
		return optionList;
	}
	public void setOptionList(List<Integer> optionList) {
		this.optionList = optionList;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
