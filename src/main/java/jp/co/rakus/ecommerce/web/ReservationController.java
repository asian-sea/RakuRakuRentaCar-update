package jp.co.rakus.ecommerce.web;

import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.rakus.ecommerce.domain.Car;
import jp.co.rakus.ecommerce.domain.ReservationCar;
import jp.co.rakus.ecommerce.domain.User;
import jp.co.rakus.ecommerce.service.CarService;
import jp.co.rakus.ecommerce.service.ReservationService;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	private ReservationService service;

	@Autowired
	private CarService carService;

	@Autowired
	private MailSender sender;


	@Autowired
	HttpSession session;


	@RequestMapping("/")
	public String reservation(Model model, @ModelAttribute ReservationForm form, @RequestParam("status") int id) {
		ReservationCar reservationCar = service.findOne(id);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 H時mm分");
		reservationCar.setStartDateStr(dtf.format(reservationCar.getStartDate()));
		reservationCar.setEndDateStr(dtf.format(reservationCar.getEndDate()));
		Car car = carService.findOne(reservationCar.getCarId());
		model.addAttribute("car", car);
		model.addAttribute("reservationCar", reservationCar);
		service.addRadioButton(model);
		return "reservation";
	}

	@RequestMapping("/fix")
	public String fix(@RequestParam("id") int id, ReservationForm form) {
		int settlementId = form.getSettlement();
		service.save(id, settlementId);
		return "redirect:/reservation/fix2";
	}

	@RequestMapping("/fix2")
	public String sendMail() {
		User user = (User)session.getAttribute("user"); //＊セッションでユーザ情報を保持


		SimpleMailMessage msg = new SimpleMailMessage();

		msg.setFrom("m01133870c@gmail.com"); // 送信元
		msg.setTo(user.getEmail()); // 送信先
		msg.setSubject("楽々レンタカーでの予約確定"); // 件名
		msg.setText(user.getName()+"さんの予約が完了しました"); // メッセージ内容

		this.sender.send(msg);

		return "redirect:/reservation/completion";
	}


	@RequestMapping("/completion")
	public String completion() {
		return "reservationCompletion";
	}
}
