package jp.co.rakus.ecommerce.domain;

import java.sql.Timestamp;
import java.util.List;

public class ReservationCar {
	private int id;	//OrderCarId
	private int carId;	//商品（車）ID
	private int reservationId; //予約ID
	private Timestamp startDate;
	private Timestamp endDate;
	private List<Option> optionList;
//	private Car car;
//	private List reservationOptionList;

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

	public Timestamp getStartDate() {
		return startDate;
	}
	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}
	public Timestamp getEndDate() {
		return endDate;
	}
	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}
	public List<Option> getOptionList() {
		return optionList;
	}
	public void setOptionList(List<Option> optionList) {
		this.optionList = optionList;
	}


//	public Car getCar() {
//		return car;
//	}
//	public void setCar(Car car) {
//		this.car = car;
//	}
//	public List getReservationOptionList() {
//		return reservationOptionList;
//	}
//	public void setReservationOptionList(List reservationOptionList) {
//		this.reservationOptionList = reservationOptionList;
//	}

}
