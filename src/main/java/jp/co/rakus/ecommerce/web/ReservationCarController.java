package jp.co.rakus.ecommerce.web;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.rakus.ecommerce.domain.ReservationCar;
import jp.co.rakus.ecommerce.domain.User;
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

		User user = (User)session.getAttribute("user");

		// ログインしていない場合ログイン画面に遷移
		if (user == null) {
			return "redirect:/login/loginpage";
		}

		ReservationCar reservationCar = new ReservationCar();
		BeanUtils.copyProperties(reservationCarForm, reservationCar);

		//userIdを格納
		reservationCar.setUserId(user.getId());

		// 日付をString型からLocalDateTime型に直してReservationCarFormドメインに登録
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		reservationCar.setStartDate(LocalDateTime.parse(reservationCarForm.getStartDate(), dtf));
		reservationCar.setEndDate(LocalDateTime.parse(reservationCarForm.getEndDate(), dtf));


		// totalPriceを計算して格納
		reservationCar.setTotalPrice(reservationCarService.calcTotalPrice(reservationCar));

		int reservationCarId = reservationCarService.addCar(reservationCar);

		// ReservationCarFormドメインが持っている"option_id"と自動採番される"reservation_car_id"で
		// reservaion_optionsテーブルに追加
		for(int i = 0; i < reservationCar.getOptionList().size(); i++) {
			reservationCarService.addOption(reservationCar.getOptionList().get(i), reservationCarId);
		}

		return "redirect:/keep/show";
	}

	//キープを表示
	@RequestMapping(value="/show")
	public String showCars(ReservationCarForm reservationCarForm) {
		User user = (User)session.getAttribute("user");
		List<ReservationCar> reservationCarList = reservationCarService.findAll(user.getId());
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
