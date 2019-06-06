package jp.co.rakus.ecommerce.web;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.ecommerce.domain.User;

@Controller
@RequestMapping("/mail")
public class mailController {

	@Autowired
	private MailSender sender;

	
	@Autowired
	HttpSession session;

	@ModelAttribute
	public User setUpForm() {
		return new User();
	}

	// ここでメールを送信
	@RequestMapping("/send")
	public String sendMail() {
		User user = (User)session.getAttribute("user"); //＊セッションでユーザ情報を保持
		
		
		SimpleMailMessage msg = new SimpleMailMessage();

		msg.setFrom("m01133870c@gmail.com"); // 送信元
		msg.setTo(user.getEmail()); // 送信先
		msg.setSubject("楽々レンタカーでの予約確定"); // 件名
		msg.setText(user.getName()+"さんの予約が完了しました"); // メッセージ内容

		this.sender.send(msg);

		return "reservationCompletion";

	}

	@RequestMapping("/page")
	public String index() {
		return "mailTest";
	}

}
