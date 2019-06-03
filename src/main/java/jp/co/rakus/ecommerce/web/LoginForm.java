package jp.co.rakus.ecommerce.web;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class LoginForm {

	@Email(message="Eメールの形式で入力してください")
	private String email;
	
	@Size(min=4,max=12,message="パスワードは4文字以上12文字以内で入力してください")
	private String password;

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
