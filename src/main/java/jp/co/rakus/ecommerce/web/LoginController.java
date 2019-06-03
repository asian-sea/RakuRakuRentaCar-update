package jp.co.rakus.ecommerce.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.rakus.ecommerce.service.UserService;

@RestController
@RequestMapping("/")
public class LoginController {
	@Autowired
	private UserService userservice;
	
//	@RequestMapping("/top")
	

}
