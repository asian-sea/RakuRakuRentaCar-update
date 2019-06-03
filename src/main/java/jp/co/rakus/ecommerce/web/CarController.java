package jp.co.rakus.ecommerce.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.ecommerce.domain.Car;
import jp.co.rakus.ecommerce.service.CarService;

@Controller
@RequestMapping("/car")
public class CarController {

	@Autowired
	private CarService service;

	@RequestMapping("/detail")
	public String showDetail(Model model, @ModelAttribute ReservationCarForm form) {
		Car car = service.findOne(1);
		model.addAttribute("car", car);
		service.addRadioButton(model);
		return "carDetail";
	}
}
