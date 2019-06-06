package jp.co.rakus.ecommerce.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.rakus.ecommerce.domain.Car;
import jp.co.rakus.ecommerce.domain.Option;
import jp.co.rakus.ecommerce.domain.ReservationCar;
import jp.co.rakus.ecommerce.repository.ReservationCarRepository;

@Service

public class ReservationCarService {
	@Autowired
	private ReservationCarRepository reservationCarRepository;

	@Autowired
	private CarService carService;

	//キープに追加
	public int addCar(ReservationCar reservationCar) {
		return reservationCarRepository.save(reservationCar);
	}

	//オプション内容
	public void addOption(int optionId, int reservationCarId) {
		reservationCarRepository.saveOption(optionId, reservationCarId);
	}

	//キープを表示
	public List<ReservationCar> findAll(int id){
		return reservationCarRepository.findAll(id);
	}
	
	//キープを表示
	public List<Option> findAllOption(int id){
		return reservationCarRepository.findAllOption(id);
	}

	//キープを削除
	public void delete(int id) {
		reservationCarRepository.delete(id);
	}

	// 必要なもの
	// ・price
	// ・時間の差分
	// ・オプション
	public int calcTotalPrice(ReservationCar reservationCar) {
		int id = reservationCar.getCarId();
		LocalDateTime startDate = reservationCar.getStartDate();
		LocalDateTime endDate = reservationCar.getEndDate();
		List<Integer> optionList = reservationCar.getOptionList();

		Car car = carService.findOne(id);
		// (1)
		int price = car.getGrade().getPrice();

		Duration duration = Duration.between(startDate, endDate);
		// (2)
		int durationHours = (int) duration.toHours();

		// (3)
		int optionPrice = 0;
		for (Integer optionId : optionList) {
			optionPrice += reservationCarRepository.findOneOption(optionId);
		}

		int totalPrice = price * durationHours + optionPrice;

		return totalPrice;
	}

}
