package jp.co.rakus.ecommerce.web;

import java.sql.Timestamp;
import java.util.List;

import jp.co.rakus.ecommerce.domain.Option;

public class ReservationCarForm {

	private int id;
	private int carId;
	private Timestamp startDate;
	private Timestamp endDate;
	private List<Option> optionList;

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
}
