package jp.co.rakus.ecommerce.web;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginForm {

	@Email(message="Eメールの形式で入力してください")
	@NotBlank(message="Eメールの入力は必須です")
	private String email;
	
	@Size(min=4,max=12,message="パスワードは4文字以上12文字以内で入力してください")
	@NotBlank(message="パスワードの入力は必須です")
	private String password;

	private String name;
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
