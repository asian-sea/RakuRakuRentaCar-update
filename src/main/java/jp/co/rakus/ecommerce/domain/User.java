package jp.co.rakus.ecommerce.domain;

public class User {
	private Integer id;
	
	private String name;
	
	private String email;
	
	private String address;
	
	private String password;
	
	private String telephone;
	

	public User() {}
	public User(Integer id, String name, String email, String address, String password, String telephone) {
		super();
		this.id=id;
		this.name=name;
		this.email=email;
		this.address=address;
		this.password=password;
		this.telephone=telephone;
	}
	
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
	
	
}
