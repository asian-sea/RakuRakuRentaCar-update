package jp.co.rakus.ecommerce.web;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.rakus.ecommerce.domain.Option;
import jp.co.rakus.ecommerce.domain.ReservationCar;
import jp.co.rakus.ecommerce.domain.User;
import jp.co.rakus.ecommerce.service.ReservationCarService;
import jp.co.rakus.ecommerce.service.ReservationHistoryService;

@Controller
@RequestMapping("history")

public class ReservationHistoryController {

	@Autowired
	ReservationHistoryService reservationHistoryService;

	@Autowired
	ReservationCarService reservationCarService;

	@Autowired
	HttpSession session;

	//予約履歴を表示
	@RequestMapping(value="/")
	public String showHistory(Model model) {
		User user = (User)session.getAttribute("user");
		List<ReservationCar> reservationHistoryList = reservationHistoryService.findHistory(user.getId());
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 H時mm分");

		reservationHistoryList.forEach(reservationCar -> {
			reservationCar.setStartDateStr(dtf.format(reservationCar.getStartDate()));
			reservationCar.setEndDateStr(dtf.format(reservationCar.getEndDate()));
		});
		List<List<Option>> optionManyList = new ArrayList<>();
		for (int i = 0; i <reservationHistoryList.size(); i++) {
			int id = reservationHistoryList.get(i).getId();
			List<Option> optionList = reservationCarService.findAllOption(id);
			optionManyList.add(optionList);
		}

//		ReservationCar reservationCar = (ReservationCar)session.getAttribute("reservationCar");
//		Car car = reservationHistoryService.findCar(reservationCar.getId());

		model.addAttribute("optionManyList", optionManyList);
		model.addAttribute("reservationHistoryList", reservationHistoryList);
//		model.addAttribute("car",car);
		return "history";
	}

	@RequestMapping(value="/cancel")
	public String delete(@RequestParam int cancelId) {
		reservationHistoryService.cancel(cancelId);
		return "redirect:/history/";
	}

}
