package jp.co.rakus.ecommerce.web;

import jp.co.rakus.ecommerce.domain.Grade;
import jp.co.rakus.ecommerce.domain.Shop;

public class CarForm {

	private int id;
	private String name;
	private Grade grade;
	private Shop shop;
	private String imagePath;
	private int settlement;
	private int settlement1;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public int getSettlement() {
		return settlement;
	}
	public void setSettlement(int settlement) {
		this.settlement = settlement;
	}
	public int getSettlement1() {
		return settlement1;
	}
	public void setSettlement1(int settlement1) {
		this.settlement1 = settlement1;
	}
	
	
}
