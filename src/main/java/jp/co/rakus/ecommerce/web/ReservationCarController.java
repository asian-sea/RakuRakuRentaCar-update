package jp.co.rakus.ecommerce.web;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.rakus.ecommerce.domain.Option;
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

		ReservationCar reservationCar = new ReservationCar();
		BeanUtils.copyProperties(reservationCarForm, reservationCar);

		//userIdを格納
		if (user == null) {
			Random rand = new Random();
			int randomNumber = rand.nextInt(1000000000);
			reservationCar.setUserId(randomNumber);
			session.setAttribute("dummyId", randomNumber);
		} else {
			reservationCar.setUserId(user.getId());
		}


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

		if (session.getAttribute("dummyId") != null) {
			return "redirect:/login/loginpage";
		}

		return "redirect:/keep/show";
	}

	//キープを表示
	@RequestMapping(value="/show")
	public String showCars(Model model, ReservationCarForm reservationCarForm) {
		User user = (User)session.getAttribute("user");
		List<ReservationCar> reservationCarList = reservationCarService.findAll(user.getId());
		model.addAttribute("reservationCarList", reservationCarList);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年M月d日 H:mm");
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy年M月d日");

		reservationCarList.forEach(reservationCar -> {
			reservationCar.setStartDateStr(dtf.format(reservationCar.getStartDate()));
			reservationCar.setEndDateStr(dtf.format(reservationCar.getEndDate()));
			reservationCar.setReservationDateStr(df.format(reservationCar.getReservationDate()));
		});
		List<List<Option>> optionManyList = new ArrayList<>();
		for (int i = 0; i <reservationCarList.size(); i++) {
			int id = reservationCarList.get(i).getId();
			List<Option> optionList = reservationCarService.findAllOption(id);
			optionManyList.add(optionList);
		}
		model.addAttribute("optionManyList", optionManyList);
		return "keep";
	}


	//キープを削除
	@RequestMapping(value="/delete")
	public String delete(@RequestParam int deleteId) {
		reservationCarService.delete(deleteId);
		return "redirect:/keep/show";
	}

}
