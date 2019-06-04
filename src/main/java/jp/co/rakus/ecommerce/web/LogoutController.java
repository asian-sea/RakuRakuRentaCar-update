package jp.co.rakus.ecommerce.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import jp.co.rakus.ecommerce.domain.Account;

@Controller
@RequestMapping("/logout")
@SessionAttributes("user")
public class LogoutController {
	
//	ログアウト処理
	@RequestMapping("/logoutAccount")
	public String logout(Account account,SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:/car/";
	}
}
