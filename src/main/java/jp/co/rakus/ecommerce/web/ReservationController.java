package jp.co.rakus.ecommerce.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.rakus.ecommerce.domain.Car;
import jp.co.rakus.ecommerce.domain.ReservationCar;
import jp.co.rakus.ecommerce.service.CarService;
import jp.co.rakus.ecommerce.service.ReservationService;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	private ReservationService service;

	@Autowired
	private CarService carService;

	@RequestMapping("/")
	public String reservation(Model model, @ModelAttribute ReservationForm form, @RequestParam("reservationId") int id) {
		ReservationCar reservationCar = service.findOne(id);
		Car car = carService.findOne(reservationCar.getCarId());
		model.addAttribute("car", car);
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
