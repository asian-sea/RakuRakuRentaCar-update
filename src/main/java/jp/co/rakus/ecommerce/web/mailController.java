package jp.co.rakus.ecommerce.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/mail")
public class mailController {
		
	
	
	@Autowired
	private MailSender sender;

	//ここでメールを送信
	@RequestMapping("/send")
	public String sendMail() {
		SimpleMailMessage msg=new SimpleMailMessage();
		
		msg.setFrom("m01133870c@gmail.com");
		msg.setTo("yuya.95.130@gmail.com");
		msg.setSubject("楽々レンタカーでの予約確定");
		msg.setText("メール内容");
		
		this.sender.send(msg);
		
		return "redirect:/car/";
	
	}
	
	@RequestMapping("/page")
	public String index() {
		return "mailTest";
	}
	
	
}
