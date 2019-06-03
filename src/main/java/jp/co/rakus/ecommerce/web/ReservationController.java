package jp.co.rakus.ecommerce.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.ecommerce.domain.ReservationCar;
import jp.co.rakus.ecommerce.service.ReservationService;

@Controller
@RequestMapping("reservation")
public class ReservationController {

	@Autowired
	private ReservationService service;

	@RequestMapping("/")
	public String reservation(Model model, @ModelAttribute ReservationForm form) {
		ReservationCar reservationCar = service.findOne(1);
		System.out.println(reservationCar.getEndDate()); // デバッグ
		model.addAttribute("reservationCar", reservationCar);
		service.addRadioButton(model);
		return "reservation";
	}

	@RequestMapping("/fix")
	public String fix() {
		return "redirect:/reservation/completion";
	}

	@RequestMapping("/completion")
	public String completion() {
		return "reservationCompletion";
	}
}
