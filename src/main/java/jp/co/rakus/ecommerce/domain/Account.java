package jp.co.rakus.ecommerce.domain;

public class Account {
	private Integer id;
	
	private String name;
	
	private String address;
	
	private String telephone;
	
	private String email;
	
	private String password;
	
	private String checkpassword;
	
	public Account() {}
	public Account(Integer id,String name,String address,String telephone,String email,String password,String checkpassword) {
	super();
	this.id=id;
	this.name=name;
	this.address=address;
	this.telephone=telephone;
	this.email=email;
	this.checkpassword=password;
	this.checkpassword=checkpassword;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCheckpassword() {
		return checkpassword;
	}
	public void setCheckpassword(String checkpassword) {
		this.checkpassword = checkpassword;
	}
	
	
}
