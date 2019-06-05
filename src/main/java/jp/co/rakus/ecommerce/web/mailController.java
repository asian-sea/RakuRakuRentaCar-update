package jp.co.rakus.ecommerce.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.ecommerce.domain.User;
import jp.co.rakus.ecommerce.service.UserService;


@Controller
@RequestMapping("/mail")
public class mailController {
		
	@Autowired
	private UserService userservice;
	
	@Autowired
	private MailSender sender;
	
	

	//ここでメールを送信
	@RequestMapping("/send")
	public String sendMail(LoginForm form) {

		/* User user=new User(); */
		
		SimpleMailMessage msg=new SimpleMailMessage();
		
		msg.setFrom("m01133870c@gmail.com"); //送信元
		msg.setTo("m01133870c@gmail.com");	//送信先
		msg.setSubject("楽々レンタカーでの予約確定");  //件名
		msg.setText("ユーザーさん予約が完了しました");  //メッセージ内容
		
		this.sender.send(msg);
		
		return "reservationCompletion";
	
	}
	
	@RequestMapping("/page")
	public String index() {
		return "mailTest";
	}
	
	
}
