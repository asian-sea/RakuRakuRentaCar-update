package jp.co.rakus.ecommerce.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.rakus.ecommerce.domain.User;
import jp.co.rakus.ecommerce.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private UserService userservice;
	
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
			System.out.println("loginform:"+form.getPassword());
				
				String email=form.getEmail();
				String password=form.getPassword();
				User user=userservice.findOneByEmailAndPassword(email,password);
				System.out.println(user);
				if(result.hasErrors()) {
					return index();
				}
				
				if(user == null) {
					System.out.println("loginform.if.null:"+password);
					ObjectError error=new ObjectError("login error","メールアドレスもしくはパスワードが違います");
					result.addError(error);
					return index();
				}
				session.setAttribute("user", user);
				return "redirect:/car/";
			}
	
	

}
