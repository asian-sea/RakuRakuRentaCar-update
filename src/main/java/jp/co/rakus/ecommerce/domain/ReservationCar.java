package jp.co.rakus.ecommerce.domain;

import java.time.LocalDateTime;
import java.util.List;

public class ReservationCar {
	private int id;
	private int status;
	private int carId;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private List<Integer> optionList;
	private int userId;
	private int settlementId;
	private int totalPrice;

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

	public LocalDateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	public LocalDateTime getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDateTime endDate) {
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getSettlementId() {
		return settlementId;
	}
	public void setSettlementId(int settlementId) {
		this.settlementId = settlementId;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}


}
