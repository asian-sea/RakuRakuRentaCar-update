package jp.co.rakus.ecommerce.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.rakus.ecommerce.domain.ReservationCar;
import jp.co.rakus.ecommerce.domain.User;
import jp.co.rakus.ecommerce.service.ReservationHistoryService;

@Controller
@RequestMapping("history")

public class ReservationHistoryController {

	@Autowired
	ReservationHistoryService reservationHistoryService;

	@Autowired
	HttpSession session;

	//予約履歴を表示
	@RequestMapping(value="/")
	public String showHistory(ReservationCarForm reservationCarForm, User user) {
		List<ReservationCar> reservationHistoryList = reservationHistoryService.findHistory(0);
		session.setAttribute("reservationHistoryList", reservationHistoryList);
		return "history";
	}

	@RequestMapping(value="/cancel")
	public String delete(@RequestParam int cancelId) {
		reservationHistoryService.cancel(cancelId);
		return "redirect:/history/";
	}

}
