package jp.co.rakus.ecommerce.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("reservation")
public class ReservationController {

	@RequestMapping("/")
	public String reservation() {
		return "reservation";
	}
}
