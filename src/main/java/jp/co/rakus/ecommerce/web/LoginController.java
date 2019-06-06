package jp.co.rakus.ecommerce.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.ecommerce.domain.User;
import jp.co.rakus.ecommerce.service.ReservationCarService;
import jp.co.rakus.ecommerce.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private UserService userservice;

	@Autowired
	private ReservationCarService reservationCarService;

	@ModelAttribute
	public LoginForm setUpForm() {
		return new LoginForm();
	}

	@RequestMapping("/loginpage")
	public String index() {
		return "login";
	}

	@RequestMapping("/loginform")
	public String login(@Validated LoginForm form,
			BindingResult result,HttpSession session){

				String email=form.getEmail();
				String password=form.getPassword();
				User user=userservice.findOneByEmailAndPassword(email,password);
				if(result.hasErrors()) {
					return index();
				}

				if(user == null) {
					ObjectError error=new ObjectError("loginerror","メールアドレスもしくはパスワードが違います");
					result.addError(error);
					return index();
				}
				session.setAttribute("user", user);

				// キープからの画面遷移時
				Integer dummyId =  (Integer)session.getAttribute("dummyId");
				if (dummyId != null) {
					reservationCarService.updateUserId(user.getId(), dummyId);
					session.removeAttribute("dummyId");
					return "redirect:/keep/show";
				}
				return "redirect:/car/";
			}



}
