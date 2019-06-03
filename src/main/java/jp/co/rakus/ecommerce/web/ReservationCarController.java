package jp.co.rakus.ecommerce.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.rakus.ecommerce.domain.ReservationCar;
import jp.co.rakus.ecommerce.service.ReservationCarService;

@Controller
@RequestMapping("/")

public class ReservationCarController {
	@Autowired
	ReservationCarService reservationCarService;

	@Autowired
	HttpSession session;

	//キープに追加.keep.jspを呼出
	public String addCar(ReservationCarForm reservationCarForm) {
		ReservationCar reservationCar = new ReservationCar();
		reservationCar.setId(reservationCarForm.getId());
		reservationCar.setCarId(reservationCarForm.getCarId());
		reservationCarService.addCar(reservationCar);
		return "keep";
	}

	//キープを表示
	@RequestMapping(value="/keep")
	public String showCars(ReservationCarForm reservationCarForm) {
		List<ReservationCar> reservationCarList = reservationCarService.findAll();
		session.setAttribute("reservationCarList", reservationCarList);
		return "keep";
	}

	//キープを削除
	public void delete(@RequestParam String deleteId) {
		int id = Integer.parseInt(deleteId);
		reservationCarService.delete(id);
	}

}
