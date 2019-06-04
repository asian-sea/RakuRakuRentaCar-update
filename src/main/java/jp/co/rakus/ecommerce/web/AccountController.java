package jp.co.rakus.ecommerce.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.ecommerce.service.AccountService;

@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountservice;
	
	@ModelAttribute
	public AccountForm setUpForm() {
		return new AccountForm();
	}
	
//	ユーザの新規登録画面表示
	@RequestMapping("/newAccount")
	 public String index() {
		return "NewAccount";
	}
	
//	ユーザの情報の新規登録
	@RequestMapping("/accountCreate")
	public String create(@Validated AccountForm form,
			BindingResult result,Model model) {
		try {
			if(result.hasErrors()) {
				return index();
			}
			
			AccountForm account=new AccountForm();
			
			if(!form.getPassword().equals(form.getCheckpassword())) {
				ObjectError error = new ObjectError("passworderror","入力パスワードが一致しません");
				result.addError(error);
				return index();
			}
			
		return null;
	}catch(DuplicateKeyException e){
		ObjectError error = new ObjectError("mailAddresserror", "メールアドレスは既に登録されています。");
		result.addError(error);
		return index();
	}
	
	}
}
