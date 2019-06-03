package jp.co.rakus.ecommerce.web;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AccountForm {
	
		private Integer id;
		
		@NotBlank(message="名前の入力は必須です")
		private String name;
		
		@NotBlank(message="住所の入力は必須です")
		private String address;
		
		@Email(message="Eメールの形式で入力してください")
		private String email;
		
		@Size(min=4,max=12,message="パスワードは4文字以上12文字以内で入力してください")
		private String password;
		
		@NotBlank(message="電話番号の入力は必須です")
		private String telephone;

		
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


