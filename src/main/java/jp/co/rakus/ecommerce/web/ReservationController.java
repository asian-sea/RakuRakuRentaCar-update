package jp.co.rakus.ecommerce.web;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("reservation")
public class ReservationController {

	@RequestMapping("/")
	public String reservation(Model model, @ModelAttribute ReservationForm form) {
		Map<Integer, String> settlementMap = new LinkedHashMap<>();
		settlementMap.put(0, "代金引換");
		settlementMap.put(1, "クレジットカード決済");
		model.addAttribute("settlementMap", settlementMap);
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
