package jp.co.rakus.ecommerce.web;

import jp.co.rakus.ecommerce.domain.Option;

public class ReservationCarForm {

	private int id;
	private int carId;
	private Option option;
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
	public Option getOption() {
		return option;
	}
	public void setOption(Option option) {
		this.option = option;
	}
}
