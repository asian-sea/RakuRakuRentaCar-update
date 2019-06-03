package jp.co.rakus.ecommerce.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.rakus.ecommerce.domain.ReservationCar;
import jp.co.rakus.ecommerce.service.CarService;
import jp.co.rakus.ecommerce.service.ReservationCarService;

@Controller
@RequestMapping("keep")

public class ReservationCarController {
	@Autowired
	ReservationCarService reservationCarService;

	@Autowired
	CarService carService;

	@Autowired
	HttpSession session;

	//キープに追加.keep.jspを呼出
	@RequestMapping(value="/add")
	public String addCar(ReservationCarForm reservationCarForm) {
		ReservationCar reservationCar = new ReservationCar();
		reservationCar.setId(reservationCarForm.getId());
		reservationCar.setCarId(reservationCarForm.getCarId());
		reservationCarService.addCar(reservationCar);
		return "redirect:/show";
	}

	//キープを表示
	@RequestMapping(value="/show")
	public String showCars(ReservationCarForm reservationCarForm) {
		List<ReservationCar> reservationCarList = reservationCarService.findAll(1);
		session.setAttribute("reservationCarList", reservationCarList);
		return "keep";
	}


	//キープを予約
	@RequestMapping(value="/reservation")
	public void save() {

	}

	//キープを削除
	@RequestMapping(value="/delete")
	public String delete(@RequestParam int deleteId) {
		reservationCarService.delete(deleteId);
		return "redirect:/keep/show";
	}

}
