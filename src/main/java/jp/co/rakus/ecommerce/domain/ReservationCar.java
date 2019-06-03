package jp.co.rakus.ecommerce.domain;

import java.sql.Date;

public class ReservationCar {
	private int id;	//OrderCarId
	private int carId;	//商品（車）ID
	private int reservationId; //予約ID
	private Date startDate;
	private Date endDate;
	private String option;
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
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
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
