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
	private Option option;
	private String startDateStr;
	private String endDateStr;
	private LocalDateTime reservationDate;
	private String reservationId;
	private String carName;
	private String imagePath;

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
	public Option getOption() {
		return option;
	}
	public void setOption(Option option) {
		this.option = option;
	}
	public String getStartDateStr() {
		return startDateStr;
	}
	public void setStartDateStr(String startDateStr) {
		this.startDateStr = startDateStr;
	}
	public String getEndDateStr() {
		return endDateStr;
	}
	public void setEndDateStr(String endDateStr) {
		this.endDateStr = endDateStr;
	}
	public LocalDateTime getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(LocalDateTime reservationDate) {
		this.reservationDate = reservationDate;
	}
	public String getReservationId() {
		return reservationId;
	}
	public void setReservationId(String reservationId) {
		this.reservationId = reservationId;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}


}
